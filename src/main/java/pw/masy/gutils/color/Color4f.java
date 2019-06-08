package pw.masy.gutils.color;

import java.text.NumberFormat;
import pw.masy.gutils.math.MathHelper;

/**
 * Class representing a color containing red, green, blue and alpha color components.
 */
public class Color4f {

	private float red;
	private float green;
	private float blue;
	private float alpha;

	/**
	 * Constructs a new color4f.
	 *
	 * @param red   the value of the red color component. Will be clamped between 0.0 and 1.0
	 * @param green the value of the green color component. Will be clamped between 0.0 and 1.0
	 * @param blue  the value of the blue color component. Will be clamped between 0.0 and 1.0
	 * @param alpha the value of the alpha color component. Will be clamped between 0.0 and 1.0
	 */
	public Color4f(float red, float green, float blue, float alpha) {
		this.red = MathHelper.clamp(red, 0.0f, 1.0f);
		this.green = MathHelper.clamp(green, 0.0f, 1.0f);
		this.blue = MathHelper.clamp(blue, 0.0f, 1.0f);
		this.alpha = MathHelper.clamp(alpha, 0.0f, 1.0f);
	}

	/**
	 * Constructs a new color4f.
	 *
	 * @param rgb   the {@link Color3f} the values for the red, green and blue color components will be copied from
	 * @param alpha the value of the alpha color component. Will be clamped between 0.0 and 1.0
	 */
	public Color4f(Color3f rgb, float alpha) {
		this.red = rgb.getRed();
		this.green = rgb.getGreen();
		this.blue = rgb.getBlue();
		this.alpha = MathHelper.clamp(alpha, 0.0f, 1.0f);
	}

	/**
	 * Constructs a new color4f.
	 *
	 * @param value the value of the red, green and blue color components. Will be clamped between 0.0 and 1.0
	 * @param alpha the value of the alpha color component. Will be clamped between 0.0 and 1.0
	 */
	public Color4f(float value, float alpha) {
		this(value, value, value, alpha);
	}

	/**
	 * Constructs a new color4f with an alpha value of 1.0.
	 *
	 * @param red   the value of the red color component. Will be clamped between 0.0 and 1.0
	 * @param green the value of the green color component. Will be clamped between 0.0 and 1.0
	 * @param blue  the value of the blue color component. Will be clamped between 0.0 and 1.0
	 */
	public Color4f(float red, float green, float blue) {
		this(red, green, blue, 1.0f);
	}

	/**
	 * Constructs a new color4f with an alpha value of 1.0.
	 *
	 * @param rgb the {@link Color3f} the values for the red, green and blue color components will be copied from
	 */
	public Color4f(Color3f rgb) {
		this.red = rgb.getRed();
		this.green = rgb.getGreen();
		this.blue = rgb.getBlue();
		this.alpha = 1.0f;
	}

	/**
	 * Constructs a new color4f with an alpha value of 1.0.
	 *
	 * @param value the value of the red, green and blue color components. Will be clamped between 0.0 and 1.0
	 */
	public Color4f(float value) {
		this(value, value, value);
	}

	/**
	 * Constructs a new color4f.
	 *
	 * @param red   the value of the red color component. Will be clamped between 0 and 255
	 * @param green the value of the green color component. Will be clamped between 0 and 255
	 * @param blue  the value of the blue color component. Will be clamped between 0 and 255
	 * @param alpha the value of the alpha color component. Will be clamped between 0 and 255
	 */
	public Color4f(int red, int green, int blue, int alpha) {
		this.red = MathHelper.clamp(red / 255.0f, 0.0f, 1.0f);
		this.green = MathHelper.clamp(green / 255.0f, 0.0f, 1.0f);
		this.blue = MathHelper.clamp(blue / 255.0f, 0.0f, 1.0f);
		this.alpha = MathHelper.clamp(alpha / 255.0f, 0.0f, 1.0f);
	}

	/**
	 * Constructs a new color4f.
	 *
	 * @param rgb   the {@link Color3f} the values for the red, green and blue color components will be copied from
	 * @param alpha the value of the alpha color component. Will be clamped between 0 and 255
	 */
	public Color4f(Color3f rgb, int alpha) {
		this.red = rgb.getRed();
		this.green = rgb.getGreen();
		this.blue = rgb.getBlue();
		this.alpha = MathHelper.clamp(alpha / 255.0f, 0.0f, 1.0f);
	}

	/**
	 * Constructs a new color4f.
	 *
	 * @param value the value of the red, green and blue color components. Will be clamped between 0 and 255
	 * @param alpha the value of the alpha color component. Will be clamped between 0 and 255
	 */
	public Color4f(int value, int alpha) {
		this(value, value, value, alpha);
	}

	/**
	 * Constructs a new color4f with an alpha value of 255.
	 *
	 * @param red   the value of the red color component. Will be clamped between 0 and 255
	 * @param green the value of the green color component. Will be clamped between 0 and 255
	 * @param blue  the value of the blue color component. Will be clamped between 0 and 255
	 */
	public Color4f(int red, int green, int blue) {
		this(red, green, blue, 255);
	}

	/**
	 * Constructs a new color4f with an alpha value of 255.
	 *
	 * @param value the value of the red, green and blue color components. Will be clamped between 0 and 255
	 */
	public Color4f(int value) {
		this(value, value, value);
	}

	/**
	 * Constructs a new color4f.
	 *
	 * @param copy the {@link Color4f} the values for the red, green, blue and alpha components will be copied from
	 */
	public Color4f(Color4f copy) {
		this.red = copy.red;
		this.green = copy.green;
		this.blue = copy.blue;
		this.alpha = copy.alpha;
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
	public Color4f setRed(float newRed) {
		this.red = MathHelper.clamp(newRed, 0.0f, 1.0f);
		return this;
	}

	/**
	 * Sets the value of the red color component.
	 *
	 * @param newRed the new value of the red color component. Will be clamped between 0 and 255
	 * @return the instance of the color
	 */
	public Color4f setRed(int newRed) {
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
	public Color4f setGreen(float newGreen) {
		this.green = MathHelper.clamp(newGreen, 0.0f, 1.0f);
		return this;
	}

	/**
	 * Sets the value of the green color component.
	 *
	 * @param newGreen the new value of the green color component. Will be clamped between 0 and 255
	 * @return the instance of the color
	 */
	public Color4f setGreen(int newGreen) {
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
	public Color4f setBlue(float newBlue) {
		this.blue = MathHelper.clamp(newBlue, 0.0f, 1.0f);
		return this;
	}

	/**
	 * Sets the value of the blue color component.
	 *
	 * @param newBlue the new value of the blue color component. Will be clamped between 0 and 255
	 * @return the instance of the color
	 */
	public Color4f setBlue(int newBlue) {
		return this.setBlue(newBlue / 255.0f);
	}

	/**
	 * Gets the value of the alpha color component as float.
	 *
	 * @return the value of the alpha color component as float
	 */
	public float getAlpha() {
		return this.alpha;
	}

	/**
	 * Gets the value of the alpha color component as int.
	 *
	 * @return the value of the alpha color component as int
	 */
	public int getAlphaAsInt() {
		return (int) (this.alpha * 255);
	}

	/**
	 * Sets the value of the alpha color component.
	 *
	 * @param newAlpha the new value of the alpha color component. Will be clamped between 0.0 and 1.0
	 * @return the instance of the color
	 */
	public Color4f setAlpha(float newAlpha) {
		this.alpha = MathHelper.clamp(newAlpha, 0.0f, 1.0f);
		return this;
	}

	/**
	 * Sets the value of the alpha color component.
	 *
	 * @param newAlpha the new value of the alpha color component. Will be clamped between 0 and 255
	 * @return the instance of the color
	 */
	public Color4f setAlpha(int newAlpha) {
		return this.setAlpha(newAlpha / 255.0f);
	}

	/**
	 * Gets the value of the red, green, blue and alpha color component as int.
	 *
	 * <p>The bits are composed as following:<br>
	 * rrrrrrrr_gggggggg_bbbbbbbb_aaaaaaaa</p>
	 *
	 * @return the value of the red, green, blue and alpha color component as int
	 */
	public int getRGBA() {
		return this.getRedAsInt() << 24 | this.getGreenAsInt() << 16 | this.getBlueAsInt() << 8 | this.getAlphaAsInt();
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
	 * Sets the value of the red, green, blue and alpha components.
	 *
	 * @param newRed   the new value of the red color component. Will be clamped between 0.0 and 1.0
	 * @param newGreen the new value of the green color component. Will be clamped between 0.0 and 1.0
	 * @param newBlue  the new value of the blue color component. Will be clamped between 0.0 and 1.0
	 * @param newAlpha the new value of the alpha component. Will be clamped between 0.0 and 1.0
	 * @return the instance of the color
	 */
	public Color4f set(float newRed, float newGreen, float newBlue, float newAlpha) {
		this.red = MathHelper.clamp(newRed, 0.0f, 1.0f);
		this.green = MathHelper.clamp(newGreen, 0.0f, 1.0f);
		this.blue = MathHelper.clamp(newBlue, 0.0f, 1.0f);
		this.alpha = MathHelper.clamp(newAlpha, 0.0f, 1.0f);
		return this;
	}

	/**
	 * Sets the value of the red, green, blue and alpha components.
	 *
	 * @param newRGBA the {@link Color4f} the values for the red, green, blue and alpha components will be copied from
	 * @return the instance of the color
	 */
	public Color4f set(Color4f newRGBA) {
		this.red = newRGBA.red;
		this.green = newRGBA.green;
		this.blue = newRGBA.blue;
		this.alpha = newRGBA.alpha;
		return this;
	}

	/**
	 * Sets the value of the red, green, blue and alpha components.
	 *
	 * @param newRGB   the {@link Color4f} the values for the red, green and blue color components will be copied from
	 * @param newAlpha the new value of the alpha component. Will be clamped between 0.0 and 1.0
	 * @return the instance of the color
	 */
	public Color4f set(Color3f newRGB, float newAlpha) {
		this.red = newRGB.getRed();
		this.green = newRGB.getGreen();
		this.blue = newRGB.getBlue();
		this.alpha = MathHelper.clamp(newAlpha, 0.0f, 1.0f);
		return this;
	}

	/**
	 * Sets the value of the red, green, blue and alpha components.
	 *
	 * @param newValue the new value of the red, green and blue color component. Will be clamped between 0.0 and 1.0
	 * @param newAlpha the new value of the alpha component. Will be clamped between 0.0 and 1.0
	 * @return the instance of the color
	 */
	public Color4f set(float newValue, float newAlpha) {
		return this.set(newValue, newValue, newValue, newAlpha);
	}

	/**
	 * Sets the value of the red, green and blue color components.
	 *
	 * @param newRed   the new value of the red color component. Will be clamped between 0.0 and 1.0
	 * @param newGreen the new value of the green color component. Will be clamped between 0.0 and 1.0
	 * @param newBlue  the new value of the blue color component. Will be clamped between 0.0 and 1.0
	 * @return the instance of the color
	 */
	public Color4f set(float newRed, float newGreen, float newBlue) {
		this.red = MathHelper.clamp(newRed, 0.0f, 1.0f);
		this.green = MathHelper.clamp(newGreen, 0.0f, 1.0f);
		this.blue = MathHelper.clamp(newBlue, 0.0f, 1.0f);
		return this;
	}

	/**
	 * Sets the value of the red, green and blue color components.
	 *
	 * @param newRGB the {@link Color4f} the values for the red, green and blue color components will be copied from
	 * @return the instance of the color
	 */
	public Color4f set(Color3f newRGB) {
		this.red = newRGB.getRed();
		this.green = newRGB.getGreen();
		this.blue = newRGB.getBlue();
		return this;
	}

	/**
	 * Sets the value of the red, green and blue color components.
	 *
	 * @param newValue the new value of the red, green and blue color component. Will be clamped between 0.0 and 1.0
	 * @return the instance of the color
	 */
	public Color4f set(float newValue) {
		this.red = MathHelper.clamp(newValue, 0.0f, 1.0f);
		this.green = MathHelper.clamp(newValue, 0.0f, 1.0f);
		this.blue = MathHelper.clamp(newValue, 0.0f, 1.0f);
		return this;
	}

	/**
	 * Sets the value of the red, green, blue and alpha components.
	 *
	 * @param newRed   the new value of the red color component. Will be clamped between 0 and 255
	 * @param newGreen the new value of the green color component. Will be clamped between 0 and 255
	 * @param newBlue  the new value of the blue color component. Will be clamped between 0 and 255
	 * @param newAlpha the new value of the alpha component. Will be clamped between 0 and 255
	 * @return the instance of the color
	 */
	public Color4f set(int newRed, int newGreen, int newBlue, int newAlpha) {
		return this.set(newRed / 255.0f, newGreen / 255.0f, newBlue / 255.0f, newAlpha / 255.0f);
	}

	/**
	 * Sets the value of the red, green, blue and alpha components.
	 *
	 * @param newRGB   the {@link Color4f} the values for the red, green and blue color components will be copied from
	 * @param newAlpha the new value of the alpha component. Will be clamped between 0 and 255
	 * @return the instance of the color
	 */
	public Color4f set(Color3f newRGB, int newAlpha) {
		this.red = newRGB.getRed();
		this.green = newRGB.getGreen();
		this.blue = newRGB.getBlue();
		this.alpha = MathHelper.clamp(newAlpha / 255.0f, 0.0f, 1.0f);
		return this;
	}

	/**
	 * Sets the value of the red, green, blue and alpha components.
	 *
	 * @param newValue the new value of the red, green and blue color component. Will be clamped between 0 and 255
	 * @param newAlpha the new value of the alpha component. Will be clamped between 0 and 255
	 * @return the instance of the color
	 */
	public Color4f set(int newValue, int newAlpha) {
		return this.set(newValue, newValue, newValue, newAlpha);
	}

	/**
	 * Sets the value of the red, green and blue color components.
	 *
	 * @param newRed   the new value of the red color component. Will be clamped between 0 and 255
	 * @param newGreen the new value of the green color component. Will be clamped between 0 and 255
	 * @param newBlue  the new value of the blue color component. Will be clamped between 0 and 255
	 * @return the instance of the color
	 */
	public Color4f set(int newRed, int newGreen, int newBlue) {
		return this.set(newRed / 255.0f, newGreen / 255.0f, newBlue / 255.0f);
	}

	/**
	 * Sets the value of the red, green and blue color components.
	 *
	 * @param newValue the new value of the red, green and blue color component. Will be clamped between 0 and 255
	 * @return the instance of the color
	 */
	public Color4f set(int newValue) {
		return this.set(newValue, newValue, newValue);
	}

	/**
	 * Creates a copy of this color.
	 *
	 * @return the copy of this color
	 */
	public Color4f copy() {
		return new Color4f(this);
	}

	/**
	 * Linearly interpolates between this and the given color and stores the result in the given {@link Color4f}.
	 *
	 * @param other   the {@link Color4f} that will be interpolated with
	 * @param t       the factor of the interpolation. Should be between 0.0 and 1.0
	 * @param storage the {@link Color4f} the interpolated color will be stored in
	 * @return the interpolated {@link Color4f}
	 */
	public Color4f lerp(Color4f other, float t, Color4f storage) {
		return storage.set(
				MathHelper.clamp(this.red + (other.red - this.red) * t, 0.0f, 1.0f),
				MathHelper.clamp(this.green + (other.green - this.green) * t, 0.0f, 1.0f),
				MathHelper.clamp(this.blue + (other.blue - this.blue) * t, 0.0f, 1.0f),
				MathHelper.clamp(this.alpha + (other.alpha - this.alpha) * t, 0.0f, 1.0f)
		);
	}

	/**
	 * Linearly interpolates between this and the given color and stores the result in this color.
	 *
	 * @param other the {@link Color4f} that will be interpolated with
	 * @param t     the factor of the interpolation. Should be between 0.0 and 1.0
	 * @return the interpolated {@link Color4f}
	 */
	public Color4f lerp(Color4f other, float t) {
		return this.lerp(other, t, this);
	}

	@Override
	public int hashCode() {
		int hash = 97;
		hash *= this.getRedAsInt() * 59;
		hash *= this.getGreenAsInt() * 37;
		hash *= this.getBlueAsInt() * 71;
		hash *= this.getAlphaAsInt() * 13;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Color4f)) return false;

		Color4f other = (Color4f) obj;

		return other.red == this.red && other.green == this.green && other.blue == this.blue && other.alpha == this.alpha;
	}

	@Override
	public String toString() {
		return "(" + this.red + ", " + this.green + ", " + this.blue + ", " + this.alpha + ")";
	}

	/**
	 * Converts the color to a string with the given number format.
	 *
	 * @param format the {@link NumberFormat} that formats the color components
	 * @return the color as string
	 */
	public String toString(NumberFormat format) {
		return "(" + format.format(this.red) + ", " + format.format(this.green) + ", " + format.format(this.blue) + ", " + format.format(this.alpha) + ")";
	}

}
