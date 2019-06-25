package pw.masy.gutils.math;

import lombok.Getter;

@Getter
public class AABBf {

	private float minX;
	private float minY;
	private float minZ;
	private float maxX;
	private float maxY;
	private float maxZ;
	private float width;
	private float height;
	private float depth;

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
	public AABBf(float minX, float minY, float minZ, float width, float height, float depth) {
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
	 * @param position the position of the bounding box as {@link Vec3f}
	 * @param size     the size of the bounding box as {@link Vec3f}
	 */
	public AABBf(Vec3f position, Vec3f size) {
		this(position.x, position.y, position.z, size.x, size.y, size.z);
	}

	/**
	 * Constructs a new axis aligned bounding box.
	 *
	 * @param other the {@link AABBf} the position and dimensions will be copied from
	 */
	public AABBf(AABBf other) {
		this.set(other);
	}

	/**
	 * Checks if the bounding box collides with the other bounding box.
	 *
	 * @param other the other {@link AABBf} that will be checked for collision
	 * @return <i>true</i> if the two bounding boxes collide with each other
	 */
	public boolean intersects(AABBf other) {
		return (this.maxX > other.minX && this.maxY > other.minY && this.maxZ > other.minZ &&
				this.minX < other.maxX && this.minY < other.maxY && this.minZ < other.maxZ);
	}

	/**
	 * Sets this axis aligned bounding box the the position and dimensions of the other.
	 *
	 * @param other the {@link AABBf} that will be copied
	 * @return the instance of this bounding box
	 */
	public AABBf set(AABBf other) {
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
	public AABBf setSize(float width, float height, float depth) {
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
	 * @param size the new size of the bounding box as {@link Vec3f}
	 * @return the instance of this bounding box
	 */
	public AABBf setSize(Vec3f size) {
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
	public AABBf setPosition(float posX, float posY, float posZ) {
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
	 * @param position the new position of the bounding box as {@link Vec3f}
	 * @return the instance of this bounding box
	 */
	public AABBf setPosition(Vec3f position) {
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
	public AABBf setCenterXZ(float centerX, float posY, float centerZ) {
		float halfWidth = this.width * 0.5f;
		float halfDepth = this.depth * 0.5f;

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
	 * @param position the new position of the bounding box as {@link Vec3f}
	 * @return the instance of the bounding box
	 */
	public AABBf setCenterXZ(Vec3f position) {
		return this.setCenterXZ(position.x, position.y, position.z);
	}

	@Override
	public String toString() {
		return "[AABB: (" + this.minX + ", " + this.minY + ", " + this.minZ + ") - (" + this.maxX + ", " + this.maxY + ", " + this.maxZ + ")]";
	}

}
