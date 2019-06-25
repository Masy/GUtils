package pw.masy.gutils.math;

import java.text.NumberFormat;

/**
 * Class representing a 2 dimensional vector storing floats.
 */
public class Vec2f {

	public float x;
	public float y;

	/**
	 * Constructs a new 2 dimensional vector.
	 *
	 * @param x the x coordinate of the vector
	 * @param y the y coordinate of the vector
	 */
	public Vec2f(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Constructs a new 2 dimensional vector.
	 *
	 * @param value the value of the x and y coordinate of the vector
	 */
	public Vec2f(float value) {
		this(value, value);
	}

	/**
	 * Constructs a new 2 dimensional vector.
	 */
	public Vec2f() {
		this(0.0f);
	}

	/**
	 * Constructs a new 2 dimensional vector.
	 *
	 * @param other the {@link Vec2f} the coordinates will be copied from
	 */
	public Vec2f(Vec2f other) {
		this.set(other);
	}

	/**
	 * Gets the x coordinate of the vector.
	 *
	 * @return the x coordinate of the vector
	 */
	public float getX() {
		return this.x;
	}

	/**
	 * Gets the y coordinate of the vector.
	 *
	 * @return the y coordinate of the vector
	 */
	public float getY() {
		return this.y;
	}

	/**
	 * Sets the x coordinate of the vector.
	 *
	 * @param newX the new x coordinate of the vector
	 * @return the instance of the 2 dimensional vector
	 */
	public Vec2f setX(float newX) {
		this.x = newX;
		return this;
	}

	/**
	 * Sets the y coordinate of the vector.
	 *
	 * @param newY the new y coordinate of the vector
	 * @return the instance of the 2 dimensional vector
	 */
	public Vec2f setY(float newY) {
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
	public Vec2f set(float newX, float newY) {
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
	public Vec2f set(float newValue) {
		return this.set(newValue, newValue);
	}

	/**
	 * Sets the x and y coordinate of the vector.
	 *
	 * @param other the {@link Vec2f} the coordinates will be copied from
	 * @return teh instance of the 2 dimensional vector
	 */
	public Vec2f set(Vec2f other) {
		return this.set(other.x, other.y);
	}

	@Override
	public int hashCode() {
		int hash = 37;
		hash *= this.x * 173;
		hash *= this.y * 97;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Vec2f))
			return false;

		Vec2f other = (Vec2f) obj;

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
