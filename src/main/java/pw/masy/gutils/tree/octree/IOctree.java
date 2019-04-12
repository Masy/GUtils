package pw.masy.gutils.tree.octree;

import pw.masy.gutils.consumer.TriConsumer;
import pw.masy.gutils.tree.octree.exception.OctreeIndexOutOfBoundsException;

/**
 * Interface for a coordinate based implementation of an octree.
 *
 * <p>The octree will be programmed to have octants of the same width, height and depth and therefore only one dimension has to be passed when creating an octree.
 * This dimension however should be a potency of two to ensure that no floating point values occur when dividing an octant into 8 sub-octants.</p>
 *
 * <p>When the values of all children of an octant are the same they will be merged into the parent and then deleted to ensure space efficiency and for
 * more optimized handling. When a value inside this octant is changed to a different one then that octant is divided into 8 sub-octants again.</p>
 *
 * <p>The octants of the octree are indexed like this:<br>
 * Bottom Layer:<br>
 * +---+---+<br>
 * | 2 | 3 |<br>
 * +---+---+<br>
 * | 0 | 1 |<br>
 * +---+---+<br>
 * Top Layer:<br>
 * +---+---+<br>
 * | 6 | 7 |<br>
 * +---+---+<br>
 * | 4 | 5 |<br>
 * +---+---+<br>
 * and have a right bound coordinate system.</p>
 *
 * @param <T> the type of the object which is stored in the octree
 */
public interface IOctree<T> {

	/**
	 * Number of octants a node can have.
	 */
	int OCTANTS = 8;

	/**
	 * Inserts the given value at the given coordinates into the octree.
	 *
	 * <p>When inserting into the octree, first the coordinates are checked to be within the dimensions of the node. If not, an
	 * {@link OctreeIndexOutOfBoundsException} is thrown.</p>
	 *
	 * <p>Then the value will be inserted by recursively going through all children of the node until either the dimension is 1 or
	 * a node is reached with no children and the same value. If a node with no children and a value of <code>null</code> or a different
	 * one than the one being currently inserted is found, the node will be split into 8 children by the <code>split()</code> method.</p>
	 *
	 * <p>After inserting the value into the node, every child of the parent is checked for equality. If all children are equal
	 * they will be merged into the parent and the children will be deleted.</p>
	 *
	 * @param x     the x coordinate where to insert the value
	 * @param y     the y coordinate where to insert the value
	 * @param z     the z coordinate where to insert the value
	 * @param value the value that will be inserted into the octree, can be null
	 * @throws OctreeIndexOutOfBoundsException when the given coordinates are not inside this node of the octree
	 * @see #insert(int, int, int, Object)
	 */
	void insert(int x, int y, int z, T value);

	/**
	 * Gets the value at the given coordinates.
	 *
	 * <p>First the coordinates are checked to be within the dimensions of the node. If not, an {@link OctreeIndexOutOfBoundsException} is thrown.
	 * Then the method navigates recursively into the correct octant to get the value from.</p>
	 *
	 * @param x the x coordinate of the value to get
	 * @param y the y coordinate of the value to get
	 * @param z the z coordinate of the value to get
	 * @return the value at the given coordinate
	 * @throws OctreeIndexOutOfBoundsException when the given coordinates are not inside this node of the octree
	 * @see #get(int, int, int)
	 */
	T get(int x, int y, int z);

	/**
	 * Performs the given action on each node without any children.
	 * The actions are performed bottom to top, meaning the values in the lower layers are processed before the others.
	 *
	 * <p>The first value of the consumer will be the layer of the node, the second value the octant and the third the actual value of the node.
	 * Since the value of a node can be null, performing operations directly on the third argument of the consumer
	 * might produce null pointer exceptions.</p>
	 *
	 * <p>This method does not check the action parameter for null. Because the method is recursively calling itself,
	 * doing so would be an unnecessary operation after the first recursion and therefore an unnecessary performance decreasement.</p>
	 *
	 * @param action the action to be performed for each entry
	 */
	void forEach(TriConsumer<Integer, Integer, ? super T> action);

}
