package pw.masy.gutils.color;

import java.text.NumberFormat;
import pw.masy.gutils.math.MathHelper;

/**
 * Class representing a color containing red, green and blue color components.
 */
public class Color3f {

	private float red;
	private float green;
	private float blue;

	/**
	 * Constructs a new color3f.
	 *
	 * @param red   the value of the red color component. Will be clamped between 0.0 and 1.0
	 * @param green the value of the green color component. Will be clamped between 0.0 and 1.0
	 * @param blue  the value of the blue color component. Will be clamped between 0.0 and 1.0
	 */
	public Color3f(float red, float green, float blue) {
		this.red = MathHelper.clamp(red, 0.0f, 1.0f);
		this.green = MathHelper.clamp(green, 0.0f, 1.0f);
		this.blue = MathHelper.clamp(blue, 0.0f, 1.0f);
	}

	/**
	 * Constructs a new color3f.
	 *
	 * @param value the value of the red, green and blue color component. Will be clamped between 0.0 and 1.0
	 */
	public Color3f(float value) {
		this(value, value, value);
	}

	/**
	 * Constructs a new color3f.
	 *
	 * @param red   the value of the red color component. Will be clamped between 0 and 255
	 * @param green the value of the green color component. Will be clamped between 0 and 255
	 * @param blue  the value of the blue color component. Will be clamped between 0 and 255
	 */
	public Color3f(int red, int green, int blue) {
		this.red = MathHelper.clamp(red / 255.0f, 0.0f, 1.0f);
		this.green = MathHelper.clamp(green / 255.0f, 0.0f, 1.0f);
		this.blue = MathHelper.clamp(blue / 255.0f, 0.0f, 1.0f);
	}

	/**
	 * Constructs a new color3f.
	 *
	 * @param value the value of the red, green and blue color component. Will be clamped between 0 and 255
	 */
	public Color3f(int value) {
		this(value, value, value);
	}

	/**
	 * Constructs a new color3f.
	 *
	 * @param copy the {@link Color3f} the color components will be copied from
	 */
	public Color3f(Color3f copy) {
		this.red = copy.red;
		this.green = copy.green;
		this.blue = copy.blue;
	}

	/**
	 * Constructs a new color3f.
	 *
	 * @param copy the {@link Color4f} the red, green and blue color components will be copied from
	 */
	public Color3f(Color4f copy) {
		this.red = copy.getRed();
		this.green = copy.getGreen();
		this.blue = copy.getBlue();
	}

	/**
	 * Gets the value of the red color component as float.
	 *
	 * @return the value of the red color component as float
	 */
	public float getRed() {
		return this.red;
	}

	/**
	 * Gets the value of the red color component as int.
	 *
	 * @return the value of the red color component as int
	 */
	public int getRedAsInt() {
		return (int) (this.red * 255);
	}

	/**
	 * Sets the value of the red color component.
	 *
	 * @param newRed the new value of the red color component. Will be clamped between 0.0 and 1.0
	 * @return the instance of the color
	 */
	public Color3f setRed(float newRed) {
		this.red = MathHelper.clamp(newRed, 0.0f, 1.0f);
		return this;
	}

	/**
	 * Sets the value of the red color component.
	 *
	 * @param newRed the new value of the red color component. Will be clamped between 0 and 255
	 * @return the instance of the color
	 */
	public Color3f setRed(int newRed) {
		return this.setRed(newRed / 255.0f);
	}

	/**
	 * Gets the value of the green color component as float.
	 *
	 * @return the value of the green color component as float
	 */
	public float getGreen() {
		return this.green;
	}

	/**
	 * Gets the value of the green color component as int.
	 *
	 * @return the value of the green color component as int
	 */
	public int getGreenAsInt() {
		return (int) (this.green * 255);
	}

	/**
	 * Sets the value of the green color component.
	 *
	 * @param newGreen the new value of the green color component. Will be clamped between 0.0 and 1.0
	 * @return the instance of the color
	 */
	public Color3f setGreen(float newGreen) {
		this.green = MathHelper.clamp(newGreen, 0.0f, 1.0f);
		return this;
	}

	/**
	 * Sets the value of the green color component.
	 *
	 * @param newGreen the new value of the green color component. Will be clamped between 0 and 255
	 * @return the instance of the color
	 */
	public Color3f setGreen(int newGreen) {
		return this.setGreen(newGreen / 255.0f);
	}

	/**
	 * Gets the value of the blue color component as float.
	 *
	 * @return the value of the blue color component as float
	 */
	public float getBlue() {
		return this.blue;
	}

	/**
	 * Gets the value of the blue color component as int.
	 *
	 * @return the value of the blue color component as int
	 */
	public int getBlueAsInt() {
		return (int) (this.blue * 255);
	}

	/**
	 * Sets the value of the blue color component.
	 *
	 * @param newBlue the new value of the blue color component. Will be clamped between 0.0 and 1.0
	 * @return the instance of the color
	 */
	public Color3f setBlue(float newBlue) {
		this.blue = MathHelper.clamp(newBlue, 0.0f, 1.0f);
		return this;
	}

	/**
	 * Sets the value of the blue color component.
	 *
	 * @param newBlue the new value of the blue color component. Will be clamped between 0 and 255
	 * @return the instance of the color
	 */
	public Color3f setBlue(int newBlue) {
		return this.setBlue(newBlue / 255.0f);
	}

	/**
	 * Gets the value of the red, green and blue color component as int.
	 *
	 * <p>The bits are composed as following:<br>
	 * xxxxxxxx_rrrrrrrr_gggggggg_bbbbbbbb</p>
	 *
	 * @return the value of the red, green and blue color component as int
	 */
	public int getRGB() {
		return this.getRedAsInt() << 16 | this.getGreenAsInt() << 8 | this.getBlueAsInt();
	}

	/**
	 * Sets the value of the red, green and blue color components.
	 *
	 * @param newRed   the new value of the red color component. Will be clamped between 0.0 and 1.0
	 * @param newGreen the new value of the green color component. Will be clamped between 0.0 and 1.0
	 * @param newBlue  the new value of the blue color component. Will be clamped between 0.0 and 1.0
	 * @return the instance of the color
	 */
	public Color3f set(float newRed, float newGreen, float newBlue) {
		this.red = MathHelper.clamp(newRed, 0.0f, 1.0f);
		this.green = MathHelper.clamp(newGreen, 0.0f, 1.0f);
		this.blue = MathHelper.clamp(newBlue, 0.0f, 1.0f);
		return this;
	}

	/**
	 * Sets the value of the red, green and blue color components.
	 *
	 * @param newRGB the {@link Color4f} the red, green and blue color components will be copied from
	 * @return the instance of the color
	 */
	public Color3f set(Color4f newRGB) {
		this.red = newRGB.getRed();
		this.green = newRGB.getGreen();
		this.blue = newRGB.getBlue();
		return this;
	}

	/**
	 * Sets the value of the red, green and blue color component.
	 *
	 * @param newRGB the {@link Color3f} the red, green and blue color components will be copied from
	 * @return the instance of the color
	 */
	public Color3f set(Color3f newRGB) {
		this.red = newRGB.red;
		this.green = newRGB.green;
		this.blue = newRGB.blue;
		return this;
	}

	/**
	 * Sets the value of the red, green and blue color component.
	 *
	 * @param newValue the new value of the red, green and blue color component. Will be clamped between 0.0 and 1.0
	 * @return the instance of the color
	 */
	public Color3f set(float newValue) {
		return this.set(newValue, newValue, newValue);
	}

	/**
	 * Sets the value of the red, green and blue color components.
	 *
	 * @param newRed   the new value of the red color component. Will be clamped between 0 and 255
	 * @param newGreen the new value of the green color component. Will be clamped between 0 and 255
	 * @param newBlue  the new value of the blue color component. Will be clamped between 0 and 255
	 * @return the instance of the color
	 */
	public Color3f set(int newRed, int newGreen, int newBlue) {
		return this.set(newRed / 255.0f, newGreen / 255.0f, newBlue / 255.0f);
	}

	/**
	 * Sets the value of the red, green and blue color component.
	 *
	 * @param newValue the new value of the red, green and blue color component. Will be clamped between 0 and 255
	 * @return the instance of the color
	 */
	public Color3f set(int newValue) {
		return this.set(newValue, newValue, newValue);
	}

	/**
	 * Creates a copy of this color.
	 *
	 * @return the copy of this color
	 */
	public Color3f copy() {
		return new Color3f(this);
	}

	/**
	 * Linearly interpolates between this and the given color and stores the result in the given {@link Color3f}.
	 *
	 * @param other   the {@link Color3f} that will be interpolated with
	 * @param t       the factor of the interpolation. Should be between 0.0 and 1.0
	 * @param storage the {@link Color3f} the interpolated color will be stored in
	 * @return the interpolated {@link Color3f}
	 */
	public Color3f lerp(Color3f other, float t, Color3f storage) {
		return storage.set(
				MathHelper.clamp(this.red + (other.red - this.red) * t, 0.0f, 1.0f),
				MathHelper.clamp(this.green + (other.green - this.green) * t, 0.0f, 1.0f),
				MathHelper.clamp(this.blue + (other.blue - this.blue) * t, 0.0f, 1.0f)
		);
	}

	/**
	 * Linearly interpolates between this and the given color and stores the result in this color.
	 *
	 * @param other the {@link Color3f} that will be interpolated with
	 * @param t     the factor of the interpolation. Should be between 0.0 and 1.0
	 * @return the interpolated {@link Color3f}
	 */
	public Color3f lerp(Color3f other, float t) {
		return this.lerp(other, t, this);
	}

	@Override
	public int hashCode() {
		int hash = 137;
		hash *= this.getRedAsInt() * 17;
		hash *= this.getGreenAsInt() * 101;
		hash *= this.getBlueAsInt() * 67;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Color3f)) return false;

		Color3f other = (Color3f) obj;

		return other.red == this.red && other.green == this.green && other.blue == this.blue;
	}

	@Override
	public String toString() {
		return "(" + this.red + ", " + this.green + ", " + this.blue + ")";
	}

	/**
	 * Converts the color to a string with the given number format.
	 *
	 * @param format the {@link NumberFormat} that formats the color components
	 * @return the color as string
	 */
	public String toString(NumberFormat format) {
		return "(" + format.format(this.red) + ", " + format.format(this.green) + ", " + format.format(this.blue) + ")";
	}

}
