package pw.masy.gutils.math;

import java.text.NumberFormat;

public class Vec3d {

	public double x;
	public double y;
	public double z;

	public Vec3d(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vec3d(double value) {
		this(value, value, value);
	}

	public Vec3d() {
		this(0.0);
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getZ() {
		return this.z;
	}

	public Vec3d setX(double newX) {
		this.x = newX;
		return this;
	}

	public Vec3d setY(double newY) {
		this.y = newY;
		return this;
	}

	public Vec3d setZ(double newZ) {
		this.z = newZ;
		return this;
	}

	public Vec3d set(double newX, double newY, double newZ) {
		this.x = newX;
		this.y = newY;
		this.z = newZ;
		return this;
	}

	public Vec3d set(double newValue) {
		return this.set(newValue, newValue, newValue);
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

	public String toString(NumberFormat format) {
		return "[" + format.format(this.x) + ", " + format.format(this.y) + ", " + format.format(this.z) + "]";
	}

}
