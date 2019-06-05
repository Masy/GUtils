package pw.masy.gutils.math;

import java.text.NumberFormat;

public class Vec2d {

	public double x;
	public double y;

	public Vec2d(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vec2d(double value) {
		this(value, value);
	}

	public Vec2d() {
		this(0.0);
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public Vec2d setX(double newX) {
		this.x = newX;
		return this;
	}

	public Vec2d setY(double newY) {
		this.y = newY;
		return this;
	}

	public Vec2d set(double newX, double newY) {
		this.x = newX;
		this.y = newY;
		return this;
	}

	public Vec2d set(double newValue) {
		return this.set(newValue, newValue);
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

	public String toString(NumberFormat format) {
		return "[" + format.format(this.x) + ", " + format.format(this.y) + "]";
	}

}
