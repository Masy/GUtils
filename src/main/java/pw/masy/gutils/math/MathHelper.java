package pw.masy.gutils.math;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Helper class providing various mathematical functions and variables.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MathHelper {

	/**
	 * 180° in radians.
	 */
	public static final double PI = Math.PI;
	/**
	 * 90° in radians.
	 */
	public static final double HALF_PI = PI * 0.5;
	/**
	 * 45° in radians.
	 */
	public static final double QUARTER_PI = PI * 0.25;
	/**
	 * 22.5° in radians.
	 */
	public static final double EIGHT_PI = PI * 0.125;
	/**
	 * 360° in radians.
	 */
	public static final double TWO_PI = PI * 2.0;
	/**
	 * -180° in radians.
	 */
	public static final double NEG_PI = 0.0 - PI;
	/**
	 * -90° in radians.
	 */
	public static final double NEG_HALF_PI = 0.0 - HALF_PI;
	/**
	 * -45° in radians.
	 */
	public static final double NEG_QUARTER_PI = 0.0 - QUARTER_PI;
	/**
	 * -22.5° in radians.
	 */
	public static final double NEG_EIGHT_PI = 0.0 - EIGHT_PI;
	/**
	 * -360° in radians.
	 */
	public static final double NEG_TWO_PI = 0.0 - TWO_PI;

	/**
	 * Clamps a byte between the given boundaries.
	 *
	 * @param value the value that will be clamped
	 * @param min   the minimum boundary
	 * @param max   the maximum boundary
	 * @return the clamped byte
	 * @throws IllegalArgumentException when the min boundary is greater than the max boundary
	 * @see #clampUnsafe(byte, byte, byte)
	 */
	public static byte clamp(byte value, byte min, byte max) {
		if (min >= max)
			throw new IllegalArgumentException("Error while clamping byte. Min boundary can not be greater than max boundary! " + min + " < " + max);

		return clampUnsafe(value, min, max);
	}

	/**
	 * Clamps a byte between the given boundaries.<br>
	 * This method will not check if the min boundary is smaller than the max boundary.
	 *
	 * @param value the value that will be clamped
	 * @param min   the minimum boundary
	 * @param max   the maximum boundary
	 * @return the clamped byte
	 */
	public static byte clampUnsafe(byte value, byte min, byte max) {
		return value < min ? min : (value > max ? max : value);
	}

	/**
	 * Clamps a short between the given boundaries.
	 *
	 * @param value the value that will be clamped
	 * @param min   the minimum boundary
	 * @param max   the maximum boundary
	 * @return the clamped short
	 * @throws IllegalArgumentException when the min boundary is greater than the max boundary
	 * @see #clampUnsafe(short, short, short)
	 */
	public static short clamp(short value, short min, short max) {
		if (min >= max)
			throw new IllegalArgumentException("Error while clamping short. Min boundary can not be greater than max boundary! " + min + " < " + max);

		return clampUnsafe(value, min, max);
	}

	/**
	 * Clamps a short between the given boundaries.<br>
	 * This method will not check if the min boundary is smaller than the max boundary.
	 *
	 * @param value the value that will be clamped
	 * @param min   the minimum boundary
	 * @param max   the maximum boundary
	 * @return the clamped short
	 */
	public static short clampUnsafe(short value, short min, short max) {
		return value < min ? min : (value > max ? max : value);
	}

	/**
	 * Clamps an int between the given boundaries.
	 *
	 * @param value the value that will be clamped
	 * @param min   the minimum boundary
	 * @param max   the maximum boundary
	 * @return the clamped int
	 * @throws IllegalArgumentException when the min boundary is greater than the max boundary
	 * @see #clampUnsafe(int, int, int)
	 */
	public static int clamp(int value, int min, int max) {
		if (min >= max)
			throw new IllegalArgumentException("Error while clamping int. Min boundary can not be greater than max boundary! " + min + " < " + max);

		return clampUnsafe(value, min, max);
	}

	/**
	 * Clamps a int between the given boundaries.<br>
	 * This method will not check if the min boundary is smaller than the max boundary.
	 *
	 * @param value the value that will be clamped
	 * @param min   the minimum boundary
	 * @param max   the maximum boundary
	 * @return the clamped int
	 */
	public static int clampUnsafe(int value, int min, int max) {
		return value < min ? min : (value > max ? max : value);
	}

	/**
	 * Clamps a long between the given boundaries.
	 *
	 * @param value the value that will be clamped
	 * @param min   the minimum boundary
	 * @param max   the maximum boundary
	 * @return the clamped long
	 * @throws IllegalArgumentException when the min boundary is greater than the max boundary
	 * @see #clampUnsafe(long, long, long)
	 */
	public static long clamp(long value, long min, long max) {
		if (min >= max)
			throw new IllegalArgumentException("Error while clamping long. Min boundary can not be greater than max boundary! " + min + " < " + max);

		return clampUnsafe(value, min, max);
	}

	/**
	 * Clamps a long between the given boundaries.<br>
	 * This method will not check if the min boundary is smaller than the max boundary.
	 *
	 * @param value the value that will be clamped
	 * @param min   the minimum boundary
	 * @param max   the maximum boundary
	 * @return the clamped long
	 */
	public static long clampUnsafe(long value, long min, long max) {
		return value < min ? min : (value > max ? max : value);
	}

	/**
	 * Clamps a float between the given boundaries.
	 *
	 * @param value the value that will be clamped
	 * @param min   the minimum boundary
	 * @param max   the maximum boundary
	 * @return the clamped float
	 * @throws IllegalArgumentException when the min boundary is greater than the max boundary
	 * @see #clampUnsafe(float, float, float)
	 */
	public static float clamp(float value, float min, float max) {
		if (min >= max)
			throw new IllegalArgumentException("Error while clamping float. Min boundary can not be greater than max boundary! " + min + " < " + max);

		return clampUnsafe(value, min, max);
	}

	/**
	 * Clamps a float between the given boundaries.<br>
	 * This method will not check if the min boundary is smaller than the max boundary.
	 *
	 * @param value the value that will be clamped
	 * @param min   the minimum boundary
	 * @param max   the maximum boundary
	 * @return the clamped float
	 */
	public static float clampUnsafe(float value, float min, float max) {
		return value < min ? min : (value > max ? max : value);
	}

	/**
	 * Clamps a double between the given boundaries.
	 *
	 * @param value the value that will be clamped
	 * @param min   the minimum boundary
	 * @param max   the maximum boundary
	 * @return the clamped double
	 * @throws IllegalArgumentException when the min boundary is greater than the max boundary
	 * @see #clampUnsafe(double, double, double)
	 */
	public static double clamp(double value, double min, double max) {
		if (min >= max)
			throw new IllegalArgumentException("Error while clamping double. Min boundary can not be greater than max boundary! " + min + " < " + max);

		return clampUnsafe(value, min, max);
	}

	/**
	 * Clamps a double between the given boundaries.<br>
	 * This method will not check if the min boundary is smaller than the max boundary.
	 *
	 * @param value the value that will be clamped
	 * @param min   the minimum boundary
	 * @param max   the maximum boundary
	 * @return the clamped double
	 */
	public static double clampUnsafe(double value, double min, double max) {
		return value < min ? min : (value > max ? max : value);
	}

	/**
	 * Loops a byte between the given boundaries.
	 *
	 * @param value the value that will be looped
	 * @param min   the minimum boundary
	 * @param max   the maximum boundary
	 * @return the looped byte
	 * @throws IllegalArgumentException when the min boundary is greater than the max boundary
	 * @see #loopUnsafe(byte, byte, byte)
	 */
	public static byte loop(byte value, byte min, byte max) {
		if (min >= max)
			throw new IllegalArgumentException("Error while looping byte. Min boundary can not be greater than max boundary! " + min + " < " + max);

		return loopUnsafe(value, min, max);
	}

	/**
	 * Loops a byte between the given boundaries.<br>
	 * This method will not check if the min boundary is smaller than the max boundary.
	 *
	 * @param value the value that will be looped
	 * @param min   the minimum boundary
	 * @param max   the maximum boundary
	 * @return the looped byte
	 */
	public static byte loopUnsafe(byte value, byte min, byte max) {
		if (value < min) {
			int distance = Math.abs(max - min);
			while (value < min) {
				value += distance;
			}
		} else if (value > max) {
			int distance = Math.abs(max - min);
			while (value > max) {
				value -= distance;
			}
		}
		return value;
	}

	/**
	 * Loops a short between the given boundaries.
	 *
	 * @param value the value that will be looped
	 * @param min   the minimum boundary
	 * @param max   the maximum boundary
	 * @return the looped short
	 * @throws IllegalArgumentException when the min boundary is greater than the max boundary
	 * @see #loopUnsafe(short, short, short)
	 */
	public static short loop(short value, short min, short max) {
		if (min >= max)
			throw new IllegalArgumentException("Error while looping short. Min boundary can not be greater than max boundary! " + min + " < " + max);

		return loopUnsafe(value, min, max);
	}

	/**
	 * Loops a short between the given boundaries.<br>
	 * This method will not check if the min boundary is smaller than the max boundary.
	 *
	 * @param value the value that will be looped
	 * @param min   the minimum boundary
	 * @param max   the maximum boundary
	 * @return the looped short
	 */
	public static short loopUnsafe(short value, short min, short max) {
		if (value < min) {
			int distance = Math.abs(max - min);
			while (value < min) {
				value += distance;
			}
		} else if (value > max) {
			int distance = Math.abs(max - min);
			while (value > max) {
				value -= distance;
			}
		}
		return value;
	}

	/**
	 * Loops an int between the given boundaries.
	 *
	 * @param value the value that will be looped
	 * @param min   the minimum boundary
	 * @param max   the maximum boundary
	 * @return the looped int
	 * @throws IllegalArgumentException when the min boundary is greater than the max boundary
	 * @see #loopUnsafe(int, int, int)
	 */
	public static int loop(int value, int min, int max) {
		if (min >= max)
			throw new IllegalArgumentException("Error while looping int. Min boundary can not be greater than max boundary! " + min + " < " + max);

		return loopUnsafe(value, min, max);
	}

	/**
	 * Loops a int between the given boundaries.<br>
	 * This method will not check if the min boundary is smaller than the max boundary.
	 *
	 * @param value the value that will be looped
	 * @param min   the minimum boundary
	 * @param max   the maximum boundary
	 * @return the looped int
	 */
	public static int loopUnsafe(int value, int min, int max) {
		if (value < min) {
			int distance = Math.abs(max - min);
			while (value < min) {
				value += distance;
			}
		} else if (value > max) {
			int distance = Math.abs(max - min);
			while (value > max) {
				value -= distance;
			}
		}
		return value;
	}

	/**
	 * Loops a long between the given boundaries.
	 *
	 * @param value the value that will be looped
	 * @param min   the minimum boundary
	 * @param max   the maximum boundary
	 * @return the looped long
	 * @throws IllegalArgumentException when the min boundary is greater than the max boundary
	 * @see #loopUnsafe(long, long, long)
	 */
	public static long loop(long value, long min, long max) {
		if (min >= max)
			throw new IllegalArgumentException("Error while looping long. Min boundary can not be greater than max boundary! " + min + " < " + max);

		return loopUnsafe(value, min, max);
	}

	/**
	 * Loops a long between the given boundaries.<br>
	 * This method will not check if the min boundary is smaller than the max boundary.
	 *
	 * @param value the value that will be looped
	 * @param min   the minimum boundary
	 * @param max   the maximum boundary
	 * @return the looped long
	 */
	public static long loopUnsafe(long value, long min, long max) {
		if (value < min) {
			long distance = Math.abs(max - min);
			while (value < min) {
				value += distance;
			}
		} else if (value > max) {
			long distance = Math.abs(max - min);
			while (value > max) {
				value -= distance;
			}
		}
		return value;
	}

	/**
	 * Loops a float between the given boundaries.
	 *
	 * @param value the value that will be looped
	 * @param min   the minimum boundary
	 * @param max   the maximum boundary
	 * @return the looped float
	 * @throws IllegalArgumentException when the min boundary is greater than the max boundary
	 * @see #loopUnsafe(float, float, float)
	 */
	public static float loop(float value, float min, float max) {
		if (min >= max)
			throw new IllegalArgumentException("Error while looping float. Min boundary can not be greater than max boundary! " + min + " < " + max);

		return loopUnsafe(value, min, max);
	}

	/**
	 * Loops a float between the given boundaries.<br>
	 * This method will not check if the min boundary is smaller than the max boundary.
	 *
	 * @param value the value that will be looped
	 * @param min   the minimum boundary
	 * @param max   the maximum boundary
	 * @return the looped float
	 */
	public static float loopUnsafe(float value, float min, float max) {
		if (value < min) {
			float distance = Math.abs(max - min);
			while (value < min) {
				value += distance;
			}
		} else if (value > max) {
			float distance = Math.abs(max - min);
			while (value > max) {
				value -= distance;
			}
		}
		return value;
	}

	/**
	 * Loops a double between the given boundaries.
	 *
	 * @param value the value that will be looped
	 * @param min   the minimum boundary
	 * @param max   the maximum boundary
	 * @return the looped double
	 * @throws IllegalArgumentException when the min boundary is greater than the max boundary
	 * @see #loopUnsafe(double, double, double)
	 */
	public static double loop(double value, double min, double max) {
		if (min >= max)
			throw new IllegalArgumentException("Error while looping double. Min boundary can not be greater than max boundary! " + min + " < " + max);

		return loopUnsafe(value, min, max);
	}

	/**
	 * Loops a double between the given boundaries.<br>
	 * This method will not check if the min boundary is smaller than the max boundary.
	 *
	 * @param value the value that will be looped
	 * @param min   the minimum boundary
	 * @param max   the maximum boundary
	 * @return the looped double
	 */
	public static double loopUnsafe(double value, double min, double max) {
		if (value < min) {
			double distance = Math.abs(max - min);
			while (value < min) {
				value += distance;
			}
		} else if (value > max) {
			double distance = Math.abs(max - min);
			while (value > max) {
				value -= distance;
			}
		}
		return value;
	}

}
