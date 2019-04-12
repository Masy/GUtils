package pw.masy.gutils.tree.octree;

import lombok.Getter;
import pw.masy.gutils.consumer.TriConsumer;
import pw.masy.gutils.tree.octree.exception.OctreeIndexOutOfBoundsException;
import pw.masy.gutils.tree.octree.exception.OctreeInvalidDimensionException;

/**
 * Non thread-safe implementation of the {@link IOctree} interface.
 *
 * @param <T> the type of the object which is stored in the octree.
 */
public class Octree<T> implements IOctree<T> {

	/**
	 * The dimensions of the node in the octree.
	 */
	private int dimension;
	/**
	 * Half of the dimensions of the node in the octree.
	 */
	private int halfDimension;
	/**
	 * The layer of the node in the graph of the octree.
	 */
	private int layer = 0;
	/**
	 * The octant of the node in the graph of the octree.
	 */
	private int octant = 0;
	/**
	 * The value of the node.
	 */
	@Getter private T value = null;
	/**
	 * The parent of the node.
	 */
	private Octree<T> parent = null;
	/**
	 * An array containing all children of the node. Will be null if the dimensions of the node are 1.
	 */
	private final Octree<T>[] children;
	/**
	 * Boolean whether or not the node has children or not.
	 */
	@Getter private boolean hasChildren = false;

	/**
	 * Constructs a new child of an octree with the given parent, dimensions and value.
	 *
	 * @param parent    the parent this octree will be a child of
	 * @param dimension the dimensions of the octree (half the dimension of the parent node)
	 * @param layer     the layer of the octree in the tree diagram with 0 being the root of the tree
	 * @param octant    the octant index of the octree in the parent node
	 * @param value     the value of the octree, can be null
	 */
	private Octree(Octree<T> parent, int dimension, int layer, int octant, T value) {
		this(dimension);
		this.parent = parent;
		this.layer = layer;
		this.octant = octant;
		this.value = value;
	}

	/**
	 * Constructs a new root of an Octree with the given dimensions.
	 *
	 * <p>If the dimension is greater than 1 the {@link #children} array will be initialized with the size of 8, otherwise it will be set to null.</p>
	 *
	 * @param dimension the dimensions of the root. Must be a potency of two to avoid errors when splitting an octant into 8 children
	 */
	public Octree(int dimension) {
		if (!this.isDimensionValid(dimension))
			throw new OctreeInvalidDimensionException("Error while creating Octree! The dimensions have to be a potency of two but were not: " + dimension);

		this.dimension = dimension;
		this.halfDimension = dimension / 2;

		if (dimension == 1) {
			this.children = null;
		} else {
			@SuppressWarnings("unchecked")
			final Octree<T>[] array = (Octree<T>[]) new Octree[8];
			this.children = array;
		}
	}

	/**
	 * Checks if the given dimension is valid.
	 *
	 * <p>The dimension has to be greater than 0 and a potency of two to avoid floating point numbers when dividing an octant into 8 children.
	 * Since the java math library doesn't have an implementation of a logarithm with a basis of 2 the dimension is checked
	 * by looping through every bit of the integer. If more than 1 bit is set to 1 the number is not a potency of two.
	 * To avoid unnecessary looping over bits that will not be set there is a counter variable to ensure to only check until
	 * the currently checked potency is greater than the actual value of the checked dimension.</p>
	 *
	 * @param dimension the dimension that wil be checked
	 * @return <i>true</i> if the given dimension is valid
	 */
	private boolean isDimensionValid(int dimension) {
		if (dimension <= 0)
			return false;
		else {
			int potency = 1;
			int bits = 0;

			for (int n = 0; n < 31; n++) {
				if (((dimension >> n) & 1) >= 1) bits++;
				if (bits > 1) return false;

				potency *= 2;
				if (dimension < potency) break;
			}
			return true;
		}
	}

	@Override
	public void insert(int x, int y, int z, T value) {
		if (x < 0 || x >= this.dimension || y < 0 || y >= this.dimension || z < 0 || z >= this.dimension)
			throw new OctreeIndexOutOfBoundsException("Error while setting value of octree. "
					+ "The given coordinate is not inside this octree! (" + x + ", " + y + ", " + z + ")");

		if (this.dimension != 1) {
			int newX = x;
			int newY = y;
			int newZ = z;
			int index = OCTANTS - 1;

			// This is some advanced magic to calculate the correct octant and local coordinates inside that octant
			// based on the coordinate and dimension of the current node
			if (y < this.halfDimension) {
				index -= 4;
			} else {
				newY -= this.halfDimension;
			}

			if (x < this.halfDimension) {
				index -= 1;
			} else {
				newX -= this.halfDimension;
			}

			if (z < this.halfDimension) {
				index -= 2;
			} else {
				newZ -= this.halfDimension;
			}

			if (!this.hasChildren) {
				if (this.value == null) {
					if (value == null) return;
				} else if (this.value.equals(value)) {
					return;
				}

				this.split();
			}

			this.children[index].insert(newX, newY, newZ, value);
		} else {
			this.value = value;
			if (this.parent.areChildrenEqual()) {
				this.parent.merge();
			}
		}
	}

	/**
	 * Checks all children of this node recursively for equality.
	 *
	 * @return <i>true</i> if all children have the same value
	 */
	private boolean areChildrenEqual() {
		boolean ret = true;

		if (this.hasChildren) {
			T checksum = null;
			boolean set = false;
			for (int index = 0; index < OCTANTS; index++) {
				if (this.children[index] == null) {
					return false;
				}

				if (this.children[index].hasChildren) {
					ret &= this.children[index].areChildrenEqual();
				} else {
					if (!set) {
						checksum = this.children[index].value;
						set = true;
					} else {
						boolean equal;
						if (checksum == null) {
							equal = this.children[index].value == null;
						} else {
							equal = checksum.equals(this.children[index].value);
						}
						ret &= equal;

					}
				}
			}
		}

		return ret;
	}

	@Override
	public T get(int x, int y, int z) {
		if (x < 0 || x >= this.dimension || y < 0 || y >= this.dimension || z < 0 || z >= this.dimension)
			throw new OctreeIndexOutOfBoundsException("Error while setting value of octree. The given coordinate is not inside this octree!");

		if (this.dimension != 1) {
			if (!this.hasChildren)
				return this.value;

			int newX = x;
			int newY = y;
			int newZ = z;
			int index = OCTANTS - 1;

			// This is some advanced magic to calculate the correct octant and local coordinates inside that octant
			// based on the coordinate and dimension of the current node
			if (y < this.halfDimension) {
				index -= 4;
			} else {
				newY -= this.halfDimension;
			}

			if (x < this.halfDimension) {
				index -= 1;
			} else {
				newX -= this.halfDimension;
			}

			if (z < this.halfDimension) {
				index -= 2;
			} else {
				newZ -= this.halfDimension;
			}

			return this.children[index].get(newX, newY, newZ);
		}

		return this.value;
	}

	/**
	 * Merges the children of this node into this one.
	 *
	 * <p>First the value of this node is set to the value of the first child, then all children are merged into this one.
	 * Since the value of this node has changed from null to the new value of the children, another equality check is performed on the parent of this node,
	 * and if true merges this node into the parent node with the other children of the parent.</p>
	 *
	 * @see #deleteChildren(Octree)
	 * @see #areChildrenEqual()
	 * @see #merge()
	 */
	private void merge() {
		for (int index = 0; index < OCTANTS; index++) {
			if (this.children[index] != null) {
				this.value = this.children[index].getValue();
				break;
			}
		}

		this.deleteChildren(this);
		if (this.parent != null && this.parent.areChildrenEqual()) {
			this.parent.merge();
		}
	}

	/**
	 * Splits the node into 8 children.
	 */
	private void split() {
		for (int n = 0; n < OCTANTS; n++) {
			@SuppressWarnings("unchecked")
			final Octree<T> node = (Octree<T>) new Octree(this, this.halfDimension, this.layer + 1, n, this.value);
			this.children[n] = node;
		}
		this.value = null;
		this.hasChildren = true;
	}

	/**
	 * Deletes all children of a node recursively.
	 *
	 * @param node the node of which all children will be deleted
	 * @see #deleteChildren(Octree)
	 */
	private void deleteChildren(Octree node) {
		if (node.hasChildren) {
			for (int n = 0; n < OCTANTS; n++) {
				if (node.children[n] != null) {
					this.deleteChildren(node.children[n]);
				}
				node.children[n] = null;
			}
		}

		this.hasChildren = false;
	}

	/**
	 * Turns the octree into a human readable string.
	 *
	 * @param builder the {@link StringBuilder} the string will be appended to
	 * @return the finished {@link StringBuilder}
	 * @see #toString(StringBuilder)
	 */
	private StringBuilder toString(StringBuilder builder) {
		if (this.hasChildren) {
			builder.append("\n");
			for (int layer = 0; layer < this.layer; layer++) {
				builder.append("\t");
			}
			builder.append("Octant ").append(this.calcParentOctant() + this.octant).append(":");

			for (int n = 0; n < OCTANTS; n++) {
				if (this.children[n] != null) {
					this.children[n].toString(builder);
				}
			}
		} else {
			if (this.value != null) {
				builder.append("\n");
				for (int layer = 0; layer < this.layer; layer++) {
					builder.append("\t");
				}
				builder.append("Octant ").append(this.calcParentOctant() + this.octant).append(": ").append(this.value.toString());
			}
		}

		return builder;
	}

	@Override
	public void forEach(TriConsumer<Integer, Integer, ? super T> action) {
		if (this.dimension != 1 && this.hasChildren) {
			for (int index = 0; index < OCTANTS; index++) {
				if (this.children[index] != null) {
					this.children[index].forEach(action);
				}
			}
		}

		if (!this.hasChildren) action.accept(this.layer, this.octant, this.value);
	}

	/**
	 * Calculates the global index of the parent octant in the octree.
	 *
	 * @return the global octant of the parent in the octree
	 */
	private int calcParentOctant() {
		return this.parent == null ? -1 : this.parent.octant * (OCTANTS * this.parent.layer);
	}

	@Override
	public String toString() {
		return this.toString(new StringBuilder()).toString();
	}
}
