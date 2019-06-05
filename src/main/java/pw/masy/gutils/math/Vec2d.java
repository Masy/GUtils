package pw.masy.gutils.math;

import java.text.NumberFormat;

/**
 * Class representing a 2 dimensional vector storing doubles.
 */
public class Vec2d {

	public double x;
	public double y;

	/**
	 * Constructs a new 2 dimensional vector.
	 *
	 * @param x the x coordinate of the vector
	 * @param y the y coordinate of the vector
	 */
	public Vec2d(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Constructs a new 2 dimensional vector.
	 *
	 * @param value the value of the x and y coordinate of the vector
	 */
	public Vec2d(double value) {
		this(value, value);
	}

	/**
	 * Constructs a new 2 dimensional vector.
	 */
	public Vec2d() {
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
	 * Sets the x coordinate of the vector.
	 *
	 * @param newX the new x coordinate of the vector
	 * @return the instance of the 2 dimensional vector
	 */
	public Vec2d setX(double newX) {
		this.x = newX;
		return this;
	}

	/**
	 * Sets the y coordinate of the vector.
	 *
	 * @param newY the new y coordinate of the vector
	 * @return the instance of the 2 dimensional vector
	 */
	public Vec2d setY(double newY) {
		this.y = newY;
		return this;
	}

	/**
	 * Sets the x and y coordinate of the vector.
	 *
	 * @param newX the new x coordinate of the vector
	 * @param newY the new y coordinate of the vector
	 * @return the instance of the 2 dimensional vector
	 */
	public Vec2d set(double newX, double newY) {
		this.x = newX;
		this.y = newY;
		return this;
	}

	/**
	 * Sets the x and y coordinate of the vector.
	 *
	 * @param newValue the new value of the x and y coordinate of the vector
	 * @return the instance of the 2 dimensional vector
	 */
	public Vec2d set(double newValue) {
		return this.set(newValue, newValue);
	}

	@Override
	public int hashCode() {
		int hash = 37;
		hash *= this.x * 401;
		hash *= this.y * 173;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Vec2d))
			return false;

		Vec2d other = (Vec2d) obj;

		return other.x == this.x && other.y == this.y;
	}

	@Override
	public String toString() {
		return "[" + this.x + ", " + this.y + "]";
	}

	/**
	 * Converts the vector to a string using the given {@link NumberFormat}.
	 *
	 * @param format the {@link NumberFormat} used to format the coordinates of the vector
	 * @return the 2 dimensional vector as string
	 */
	public String toString(NumberFormat format) {
		return "[" + format.format(this.x) + ", " + format.format(this.y) + "]";
	}

}
