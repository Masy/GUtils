package pw.masy.gutils.noise;

import pw.masy.gutils.math.Vec2d;

/**
 * Class for generating seed based value noise.
 */
public class ValueNoise {

	private long seed;

	/**
	 * Constructs a new value noise instance.
	 *
	 * @param seed the seed of the value noise.
	 */
	public ValueNoise(long seed) {
		this.seed = seed;
	}

	/**
	 * Evaluates a noise value based on the 2 coordinates between -1 and 1.
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @return the noise value at the given coordinates
	 */
	public double eval2d1d(double x, double y) {
		return this.eval2d1d(x, y, 53.98988321, 79.233176519);
	}

	/**
	 * Evaluates a noise value based on the 2 coordinates and a dot vector between -1 and 1.
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param dotX the x coordinate of the dot vector
	 * @param dotY the y coordinate of the dot vector
	 * @return the noise value at the given coordinates
	 */
	public double eval2d1d(double x, double y, double dotX, double dotY) {
		double noise = x * dotX + y * dotY + this.seed;
		noise = Math.sin(noise) * 8271365.23645;
		noise -= Math.floor(noise);
		return 2 * noise - 1;
	}

	/**
	 * Evaluates a 2 dimensional noise value based on the 2 coordinates between -1 and 1.
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @return the 2 dimensional noise value at the given coordinates as {@link Vec2d}
	 */
	public Vec2d eval2d2d(double x, double y) {
		return new Vec2d(this.eval2d1d(x, y), this.eval2d1d(x, y, 107.652431, 503.32476512));
	}

	/**
	 * Evaluates a 2 dimensional noise value based on the 2 coordinates between -1 and 1.
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param storage the {@link Vec2d} where the noise is stored
	 * @return the 2 dimensional noise value at the given coordinates as {@link Vec2d}
	 */
	public Vec2d eval2d2d(double x, double y, Vec2d storage) {
		return storage.set(this.eval2d1d(x, y), this.eval2d1d(x, y, 107.652431, 503.32476512));
	}

}
