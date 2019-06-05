package pw.masy.gutils.math;

import java.text.NumberFormat;

/**
 * Class representing a 3 dimensional vector storing doubles.
 */
public class Vec3d {

	public double x;
	public double y;
	public double z;

	/**
	 * Constructs a new 3 dimensional vector.
	 *
	 * @param x the x coordinate of the vector
	 * @param y the y coordinate of the vector
	 * @param z the z coordinate of the vector
	 */
	public Vec3d(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Constructs a new 3 dimensional vector.
	 *
	 * @param value the value of the x, y and z coordinate of the vector
	 */
	public Vec3d(double value) {
		this(value, value, value);
	}

	/**
	 * Constructs a new 3 dimensional vector.
	 */
	public Vec3d() {
		this(0.0);
	}

	/**
	 * Gets the x coordinate of the vector.
	 *
	 * @return the x coordinate of the vector
	 */
	public double getX() {
		return this.x;
	}

	/**
	 * Gets the y coordinate of the vector.
	 *
	 * @return the y coordinate of the vector
	 */
	public double getY() {
		return this.y;
	}

	/**
	 * Gets the z coordinate of the vector.
	 *
	 * @return the z coordinate of the vector
	 */
	public double getZ() {
		return this.z;
	}

	/**
	 * Sets the x coordinate of the vector.
	 *
	 * @param newX the new x coordinate of the vector
	 * @return the instance of the 3 dimensional vector
	 */
	public Vec3d setX(double newX) {
		this.x = newX;
		return this;
	}

	/**
	 * Sets the y coordinate of the vector.
	 *
	 * @param newY the new y coordinate of the vector
	 * @return the instance of the 3 dimensional vector
	 */
	public Vec3d setY(double newY) {
		this.y = newY;
		return this;
	}

	/**
	 * Sets the z coordinate of the vector.
	 *
	 * @param newZ the new z coordinate of the vector
	 * @return the instance of the 3 dimensional vector
	 */
	public Vec3d setZ(double newZ) {
		this.z = newZ;
		return this;
	}

	/**
	 * Sets the x, y and z coordinate of the vector.
	 *
	 * @param newX the new x coordinate of the vector
	 * @param newY the new y coordinate of the vector
	 * @param newZ the new z coordinate of the vector
	 * @return the instance of the 2 dimensional vector
	 */
	public Vec3d set(double newX, double newY, double newZ) {
		this.x = newX;
		this.y = newY;
		this.z = newZ;
		return this;
	}

	/**
	 * Sets the x, y and z coordinate of the vector.
	 *
	 * @param newValue the new value of the x, y and z coordinate of the vector
	 * @return the instance of the 3 dimensional vector
	 */
	public Vec3d set(double newValue) {
		return this.set(newValue, newValue, newValue);
	}

	@Override
	public int hashCode() {
		int hash = 17;
		hash *= this.x * 991;
		hash *= this.y * 277;
		hash *= this.z * 619;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Vec3d))
			return false;

		Vec3d other = (Vec3d) obj;

		return other.x == this.x && other.y == this.y && other.z == this.z;
	}

	@Override
	public String toString() {
		return "[" + this.x + ", " + this.y + ", " + this.z + "]";
	}

	/**
	 * Converts the vector to a string using the given {@link NumberFormat}.
	 *
	 * @param format the {@link NumberFormat} used to format the coordinates of the vector
	 * @return the 3 dimensional vector as string
	 */
	public String toString(NumberFormat format) {
		return "[" + format.format(this.x) + ", " + format.format(this.y) + ", " + format.format(this.z) + "]";
	}

}
