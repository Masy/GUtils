package pw.masy.gutils.math;

import lombok.Getter;

@Getter
public class AABBd {

	private double minX;
	private double minY;
	private double minZ;
	private double maxX;
	private double maxY;
	private double maxZ;
	private double width;
	private double height;
	private double depth;

	/**
	 * Constructs a new axis aligned bounding box.
	 *
	 * @param minX   the x coordinate of the bounding box
	 * @param minY   the y coordinate of the bounding box
	 * @param minZ   the z coordinate of the bounding box
	 * @param width  the width of the bounding box
	 * @param height the height of the bounding box
	 * @param depth  the depth of the bounding box
	 */
	public AABBd(double minX, double minY, double minZ, double width, double height, double depth) {
		this.minX = minX;
		this.maxX = minX + width;
		this.width = width;
		this.minY = minY;
		this.maxY = minY + height;
		this.height = height;
		this.minZ = minZ;
		this.maxZ = minZ + depth;
		this.depth = depth;
	}

	/**
	 * Constructs a new axis aligned bounding box.
	 *
	 * @param position the position of the bounding box as {@link Vec3d}
	 * @param size     the size of the bounding box as {@link Vec3d}
	 */
	public AABBd(Vec3d position, Vec3d size) {
		this(position.x, position.y, position.z, size.x, size.y, size.z);
	}

	/**
	 * Constructs a new axis aligned bounding box.
	 *
	 * @param other the {@link AABBd} the position and dimensions will be copied from
	 */
	public AABBd(AABBd other) {
		this.set(other);
	}

	/**
	 * Checks if the bounding box collides with the other bounding box.
	 *
	 * @param other the other {@link AABBd} that will be checked for collision
	 * @return <i>true</i> if the two bounding boxes collide with each other
	 */
	public boolean intersects(AABBd other) {
		return (this.maxX > other.minX && this.maxY > other.minY && this.maxZ > other.minZ &&
				this.minX < other.maxX && this.minY < other.maxY && this.minZ < other.maxZ);
	}

	/**
	 * Sets this axis aligned bounding box the the position and dimensions of the other.
	 *
	 * @param other the {@link AABBd} that will be copied
	 * @return the instance of this bounding box
	 */
	public AABBd set(AABBd other) {
		this.minX = other.minX;
		this.minY = other.minY;
		this.minZ = other.minZ;
		this.maxX = other.maxX;
		this.maxY = other.maxY;
		this.maxZ = other.maxZ;
		this.width = other.width;
		this.height = other.height;
		this.depth = other.depth;
		return this;
	}

	/**
	 * Sets the size of the axis aligned bounding box.
	 *
	 * @param width  the new width of the bounding box
	 * @param height the new height of the bounding box
	 * @param depth  the new depth of the bounding box
	 * @return the instance of this bounding box
	 */
	public AABBd setSize(double width, double height, double depth) {
		this.width = width;
		this.maxX = this.minX + width;
		this.height = height;
		this.maxY = this.minY + height;
		this.depth = depth;
		this.maxZ = this.minZ + depth;
		return this;
	}

	/**
	 * Sets the size of the axis aligned bounding box.
	 *
	 * @param size the new size of the bounding box as {@link Vec3d}
	 * @return the instance of this bounding box
	 */
	public AABBd setSize(Vec3d size) {
		return this.setSize(size.x, size.y, size.z);
	}

	/**
	 * Sets the position of the axis aligned bounding box.
	 *
	 * @param posX the new x coordinate of the bounding box
	 * @param posY the new y coordinate of the bounding box
	 * @param posZ the new z coordinate of the bounding box
	 * @return the instance of this bounding box
	 */
	public AABBd setPosition(double posX, double posY, double posZ) {
		this.minX = posX;
		this.maxX = posX + this.width;
		this.minY = posY;
		this.maxY = posY + this.height;
		this.minZ = posZ;
		this.maxZ = posZ + this.depth;
		return this;
	}

	/**
	 * Sets the position of the axis aligned bounding box.
	 *
	 * @param position the new position of the bounding box as {@link Vec3d}
	 * @return the instance of this bounding box
	 */
	public AABBd setPosition(Vec3d position) {
		return this.setPosition(position.x, position.y, position.z);
	}

	/**
	 * Sets the position of the axis aligned bounding box but centered horizontally.
	 *
	 * @param centerX the new center x coordinate of the bounding box
	 * @param posY    the new y coordinate of the bounding box
	 * @param centerZ the new center z coordinate of the bounding box
	 * @return the instance of the bounding box
	 */
	public AABBd setCenterXY(double centerX, double posY, double centerZ) {
		double halfWidth = this.width * 0.5;
		double halfDepth = this.depth * 0.5;

		this.minX = centerX - halfWidth;
		this.maxX = centerX + halfWidth;
		this.minY = posY;
		this.maxY = posY + this.height;
		this.minZ = centerZ - halfDepth;
		this.maxZ = centerZ + halfDepth;
		return this;
	}

	/**
	 * Sets the position of the axis aligned bounding box but centered horizontally.
	 *
	 * @param position the new position of the bounding box as {@link Vec3d}
	 * @return the instance of the bounding box
	 */
	public AABBd setCenterXZ(Vec3d position) {
		return this.setCenterXY(position.x, position.y, position.z);
	}

	@Override
	public String toString() {
		return "[AABB: (" + this.minX + ", " + this.minY + ", " + this.minZ + ") - (" + this.maxX + ", " + this.maxY + ", " + this.maxZ + ")]";
	}

}
