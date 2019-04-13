package pw.masy.gutils.buffer;

import java.nio.ByteBuffer;
import lombok.Getter;
import lombok.Setter;

/**
 * Advanced implementation of a byte buffer with the ability to read and write all primitive data types.
 */
public class AdvancedByteBuffer {

	@Getter private byte[] data;
	@Getter private int position;
	@Getter @Setter private int threshold;
	@Getter private int limit;
	@Getter private final int initialCapacity;

	/**
	 * Constructs a new advanced byte buffer with the capacity 0 and threshold 16.
	 */
	public AdvancedByteBuffer() {
		this(0);
	}

	/**
	 * Constructs a new advanced byte buffer with the given capacity and threshold 16.
	 *
	 * @param capacity the original capacity of the buffer
	 */
	public AdvancedByteBuffer(int capacity) {
		this(capacity, 16);
	}

	/**
	 * Constructs a new advanced byte buffer with the given capacity and threshold.
	 *
	 * @param capacity  the original capacity of the buffer
	 * @param threshold the threshold of the buffer
	 */
	public AdvancedByteBuffer(int capacity, int threshold) {
		this.data = new byte[capacity];
		this.initialCapacity = capacity;
		this.limit = capacity;
		this.threshold = threshold;
	}

	/**
	 * Constructs a new advanced byte buffer with the given data and threshold 16.
	 *
	 * @param data the data of the buffer.
	 */
	public AdvancedByteBuffer(byte[] data) {
		this(data, 16);
	}

	/**
	 * Constructs a new advanced byte buffer with the given data and threshold.
	 *
	 * @param data      the data of the buffer
	 * @param threshold the threshold of the buffer
	 */
	public AdvancedByteBuffer(byte[] data, int threshold) {
		this.data = data;
		this.initialCapacity = data.length;
		this.limit = data.length;
		this.threshold = threshold;
	}

	/**
	 * Gets the capacity of the byte buffer.
	 *
	 * @return the capacity of the byte buffer
	 */
	public int getCapacity() {
		return this.data.length;
	}

	/**
	 * Sets the position for the next operation to the given position.
	 *
	 * @param position the new position
	 * @throws IllegalArgumentException when the position is either smaller as 0 or greater than the capacity of the buffer
	 * @see #validatePosition(int)
	 */
	public void seek(int position) {
		if (!this.validatePosition(position))
			throw new IllegalArgumentException("Tried setting position of AdvancedByteBuffer to invalid value.");

		this.position = position;
	}

	/**
	 * Writes a byte into the buffer.
	 *
	 * @param data the byte that will be written.
	 * @see #ensureSpace(int)
	 */
	public void writeByte(int data) {
		this.ensureSpace(1);
		this.data[this.position++] = (byte) data;
	}

	/**
	 * Writes a byte into the buffer at the given position.
	 *
	 * @param data     the byte that will be written
	 * @param position the position where the byte will be written
	 * @throws IllegalArgumentException when the position is either smaller as 0 or greater than the capacity of the buffer.
	 * @see #validatePosition(int)
	 */
	public void writeByte(int data, int position) {
		if (!this.validatePosition(position))
			throw new IllegalArgumentException("Tried writing byte to AdvancedByteBuffer at invalid position.");

		this.data[position] = (byte) data;
	}

	/**
	 * Writes a byte array into the buffer.
	 *
	 * @param data the byte array that will be written
	 * @see #ensureSpace(int)
	 */
	public void writeByteArrayRaw(byte[] data) {
		this.ensureSpace(data.length);
		for (int n = 0; n < data.length; n++) {
			this.data[this.position++] = data[n];
		}
	}

	/**
	 * Writes the specified content of the byte array into the buffer.<br>
	 * The bytes from <code>start</code> to inclusively <code>end</code> will be written.
	 *
	 * @param data  the byte array of which the specified content will be written
	 * @param start the inclusive start index
	 * @param end   the inclusive end index
	 * @see #ensureSpace(int)
	 */
	public void writeByteArrayRaw(byte[] data, int start, int end) {
		this.ensureSpace(end - start + 1);
		for (int n = start; n <= end; n++) {
			this.data[this.position++] = data[n];
		}
	}

	/**
	 * Writes the length and the byte array itself into the buffer.
	 *
	 * @param data the byte array that will be written
	 * @see #ensureSpace(int)
	 * @see #writeInt(int)
	 * @see #writeByteArrayRaw(byte[])
	 */
	public void writeByteArray(byte[] data) {
		this.ensureSpace(4);
		this.writeInt(data.length);
		this.writeByteArrayRaw(data);
	}

	/**
	 * Writes the length and the specified content of the byte array into the buffer.<br>
	 * The bytes from <code>start</code> to inclusively <code>end</code> will be written.
	 *
	 * @param data  the byte array of which the specified content will be written
	 * @param start the inclusive start index
	 * @param end   the inclusive end index
	 * @see #ensureSpace(int)
	 * @see #writeInt(int)
	 * @see #writeByteArrayRaw(byte[], int, int)
	 */
	public void writeByteArray(byte[] data, int start, int end) {
		this.ensureSpace(4);
		this.writeInt(end - start + 1);
		this.writeByteArrayRaw(data, start, end);
	}

	/**
	 * Writes a boolean into the buffer.
	 *
	 * @param data the boolean that will be written
	 * @see #ensureSpace(int)
	 */
	public void writeBoolean(boolean data) {
		this.ensureSpace(1);
		this.data[this.position++] = data ? (byte) 1 : 0;
	}

	/**
	 * Writes a boolean into the buffer at the given position.
	 *
	 * @param data     the boolean that will be written
	 * @param position the position where the boolean will be written
	 * @throws IllegalArgumentException when the position is either smaller as 0 or greater than the capacity of the buffer
	 * @see #validatePosition(int)
	 */
	public void writeBoolean(boolean data, int position) {
		if (!this.validatePosition(position))
			throw new IllegalArgumentException("Tried writing boolean to AdvancedByteBuffer at invalid position.");

		this.data[position] = data ? (byte) 1 : 0;
	}

	/**
	 * Writes a boolean array into the buffer.
	 *
	 * @param data the boolean array that will be written
	 * @see #ensureSpace(int)
	 */
	public void writeBooleanArrayRaw(boolean[] data) {
		this.ensureSpace(data.length);
		for (int n = 0; n < data.length; n++) {
			this.data[this.position++] = data[n] ? (byte) 1 : 0;
		}
	}

	/**
	 * Writes the specified content of the boolean array into the buffer.<br>
	 * The booleans from <code>start</code> to inclusively <code>end</code> will be written.
	 *
	 * @param data  the boolean array of which the specified content will be written
	 * @param start the inclusive start index
	 * @param end   the inclusive end index
	 * @see #ensureSpace(int)
	 */
	public void writeBooleanArrayRaw(boolean[] data, int start, int end) {
		this.ensureSpace((end - start + 1));
		for (int n = start; n <= end; n++) {
			this.data[this.position++] = data[n] ? (byte) 1 : 0;
		}
	}

	/**
	 * Writes the length and the boolean array itself into the buffer.
	 *
	 * @param data the boolean array that will be written
	 * @see #ensureSpace(int)
	 * @see #writeInt(int)
	 * @see #writeBooleanArrayRaw(boolean[])
	 */
	public void writeBooleanArray(boolean[] data) {
		this.ensureSpace(4);
		this.writeInt(data.length);
		this.writeBooleanArrayRaw(data);
	}

	/**
	 * Writes the length and the specified content of the byte array into the buffer.<br>
	 * The bytes from <code>start</code> to inclusively <code>end</code> will be written.
	 *
	 * @param data  the byte array of which the specified content will be written
	 * @param start the inclusive start index
	 * @param end   the inclusive end index
	 * @see #ensureSpace(int)
	 * @see #writeInt(int)
	 * @see #writeBooleanArrayRaw(boolean[], int, int)
	 */
	public void writeBooleanArray(boolean[] data, int start, int end) {
		this.ensureSpace(4);
		this.writeInt(end - start + 1);
		this.writeBooleanArrayRaw(data, start, end);
	}

	/**
	 * Writes a short into the buffer.
	 *
	 * @param data the short that will be written
	 * @see #ensureSpace(int)
	 */
	public void writeShort(short data) {
		this.ensureSpace(2);
		this.data[this.position++] = (byte) (data >> 8);
		this.data[this.position++] = (byte) (data & 0xFF);
	}

	/**
	 * Writes a short into the buffer at the given position.
	 *
	 * @param data     the short that will be written
	 * @param position the position where the short will be written
	 * @throws IllegalArgumentException when the position is either smaller as 0 or greater than the capacity of the buffer
	 * @see #validateArea(int, int)
	 */
	public void writeShort(short data, int position) {
		if (!this.validateArea(position, 2))
			throw new IllegalArgumentException("Tried writing short to AdvancedByteBuffer at invalid position.");

		this.data[position] = (byte) (data >> 8);
		this.data[position + 1] = (byte) (data & 0xFF);
	}

	/**
	 * Writes a short array into the buffer.
	 *
	 * @param data the short array that will be written
	 * @see #ensureSpace(int)
	 */
	public void writeShortArrayRaw(short[] data) {
		this.ensureSpace(data.length * 2);
		for (int n = 0; n < data.length; n++) {
			this.data[this.position++] = (byte) (data[n] >> 8);
			this.data[this.position++] = (byte) (data[n] & 0xFF);
		}
	}

	/**
	 * Writes the specified content of the short array into the buffer.<br>
	 * The shorts from <code>start</code> to inclusively <code>end</code> will be written.
	 *
	 * @param data  the short array of which the specified content will be written
	 * @param start the inclusive start index
	 * @param end   the inclusive end index
	 * @see #ensureSpace(int)
	 */
	public void writeShortArrayRaw(short[] data, int start, int end) {
		this.ensureSpace((end - start + 1) * 2);
		for (int n = start; n <= end; n++) {
			this.data[this.position++] = (byte) (data[n] >> 8);
			this.data[this.position++] = (byte) (data[n] & 0xFF);
		}
	}

	/**
	 * Writes the length and the short array itself into the buffer.
	 *
	 * @param data the short array that will be written
	 * @see #ensureSpace(int)
	 * @see #writeInt(int)
	 * @see #writeShortArrayRaw(short[])
	 */
	public void writeShortArray(short[] data) {
		this.ensureSpace(4);
		this.writeInt(data.length);
		this.writeShortArrayRaw(data);
	}

	/**
	 * Writes the length and the specified content of the short array into the buffer.<br>
	 * The shorts from <code>start</code> to inclusively <code>end</code> will be written.
	 *
	 * @param data  the short array of which the specified content will be written
	 * @param start the inclusive start index
	 * @param end   the inclusive end index
	 * @see #ensureSpace(int)
	 * @see #writeInt(int)
	 * @see #writeShortArrayRaw(short[], int, int)
	 */
	public void writeShortArray(short[] data, int start, int end) {
		this.ensureSpace(4);
		this.writeInt(end - start + 1);
		this.writeShortArrayRaw(data, start, end);
	}

	/**
	 * Writes an int into the buffer.
	 *
	 * @param data the int that will be written
	 * @see #ensureSpace(int)
	 */
	public void writeInt(int data) {
		this.ensureSpace(4);
		this.data[this.position++] = (byte) (data >> 24);
		this.data[this.position++] = (byte) ((data >> 16) & 0xFF);
		this.data[this.position++] = (byte) ((data >> 8) & 0xFF);
		this.data[this.position++] = (byte) (data & 0xFF);
	}

	/**
	 * Writes an int into the buffer at the given position.
	 *
	 * @param data     the int that will be written
	 * @param position the position where the int will be written
	 * @throws IllegalArgumentException when the position is either smaller as 0 or greater than the capacity of the buffer
	 * @see #validatePosition(int)
	 */
	public void writeInt(int data, int position) {
		if (!this.validateArea(position, 4))
			throw new IllegalArgumentException("Tried writing int to AdvancedByteBuffer at invalid position.");

		this.data[position] = (byte) (data >> 24);
		this.data[position + 1] = (byte) ((data >> 16) & 0xFF);
		this.data[position + 2] = (byte) ((data >> 8) & 0xFF);
		this.data[position + 3] = (byte) (data & 0xFF);
	}

	/**
	 * Writes an int array into the buffer.
	 *
	 * @param data the int array that will be written
	 * @see #ensureSpace(int)
	 */
	public void writeIntArrayRaw(int[] data) {
		this.ensureSpace(data.length * 4);
		for (int n = 0; n < data.length; n++) {
			this.data[this.position++] = (byte) (data[n] >> 24);
			this.data[this.position++] = (byte) ((data[n] >> 16) & 0xFF);
			this.data[this.position++] = (byte) ((data[n] >> 8) & 0xFF);
			this.data[this.position++] = (byte) (data[n] & 0xFF);
		}
	}

	/**
	 * Writes the specified content of the int array into the buffer.<br>
	 * The ints from <code>start</code> to inclusively <code>end</code> will be written.
	 *
	 * @param data  the int array of which the specified content will be written
	 * @param start the inclusive start index
	 * @param end   the inclusive end index
	 * @see #ensureSpace(int)
	 */
	public void writeIntArrayRaw(int[] data, int start, int end) {
		this.ensureSpace((end - start + 1) * 4);
		for (int n = start; n <= end; n++) {
			this.data[this.position++] = (byte) (data[n] >> 24);
			this.data[this.position++] = (byte) ((data[n] >> 16) & 0xFF);
			this.data[this.position++] = (byte) ((data[n] >> 8) & 0xFF);
			this.data[this.position++] = (byte) (data[n] & 0xFF);
		}
	}

	/**
	 * Writes the length and the int array itself into the buffer.
	 *
	 * @param data the int array that will be written
	 * @see #ensureSpace(int)
	 * @see #writeInt(int)
	 * @see #writeIntArrayRaw(int[])
	 */
	public void writeIntArray(int[] data) {
		this.ensureSpace(4);
		this.writeInt(data.length);
		this.writeIntArrayRaw(data);
	}

	/**
	 * Writes the length and the specified content of the int array into the buffer.<br>
	 * The ints from <code>start</code> to inclusively <code>end</code> will be written.
	 *
	 * @param data  the int array of which the specified content will be written
	 * @param start the inclusive start index
	 * @param end   the inclusive end index
	 * @see #ensureSpace(int)
	 * @see #writeInt(int)
	 * @see #writeIntArrayRaw(int[], int, int)
	 */
	public void writeIntArray(int[] data, int start, int end) {
		this.ensureSpace(4);
		this.writeInt(end - start + 1);
		this.writeIntArrayRaw(data, start, end);
	}

	/**
	 * Writes a long into the buffer.
	 *
	 * @param data the long that will be written.
	 * @see #ensureSpace(int)
	 */
	public void writeLong(long data) {
		this.ensureSpace(8);
		this.data[this.position++] = (byte) ((data >> 56) & 0xFF);
		this.data[this.position++] = (byte) ((data >> 48) & 0xFF);
		this.data[this.position++] = (byte) ((data >> 40) & 0xFF);
		this.data[this.position++] = (byte) ((data >> 32) & 0xFF);
		this.data[this.position++] = (byte) ((data >> 24) & 0xFF);
		this.data[this.position++] = (byte) ((data >> 16) & 0xFF);
		this.data[this.position++] = (byte) ((data >> 8) & 0xFF);
		this.data[this.position++] = (byte) (data & 0xFF);
	}

	/**
	 * Writes a long into the buffer at the given position.
	 *
	 * @param data     the long that will be written
	 * @param position the position where the long will be written
	 * @throws IllegalArgumentException when the position is either smaller as 0 or greater than the capacity of the buffer
	 * @see #validateArea(int, int)
	 */
	public void writeLong(long data, int position) {
		if (!this.validateArea(position, 8))
			throw new IllegalArgumentException("Tried writing long to AdvancedByteBuffer at invalid position.");

		this.data[position] = (byte) ((data >> 56) & 0xFF);
		this.data[position + 1] = (byte) ((data >> 48) & 0xFF);
		this.data[position + 2] = (byte) ((data >> 40) & 0xFF);
		this.data[position + 3] = (byte) ((data >> 32) & 0xFF);
		this.data[position + 4] = (byte) ((data >> 24) & 0xFF);
		this.data[position + 5] = (byte) ((data >> 16) & 0xFF);
		this.data[position + 6] = (byte) ((data >> 8) & 0xFF);
		this.data[position + 7] = (byte) (data & 0xFF);
	}

	/**
	 * Writes a long array into the buffer.
	 *
	 * @param data the long array that will be written
	 * @see #ensureSpace(int)
	 */
	public void writeLongArrayRaw(long[] data) {
		this.ensureSpace(data.length * 8);
		for (int n = 0; n < data.length; n++) {
			this.data[this.position++] = (byte) ((data[n] >> 56) & 0xFF);
			this.data[this.position++] = (byte) ((data[n] >> 48) & 0xFF);
			this.data[this.position++] = (byte) ((data[n] >> 40) & 0xFF);
			this.data[this.position++] = (byte) ((data[n] >> 32) & 0xFF);
			this.data[this.position++] = (byte) ((data[n] >> 24) & 0xFF);
			this.data[this.position++] = (byte) ((data[n] >> 16) & 0xFF);
			this.data[this.position++] = (byte) ((data[n] >> 8) & 0xFF);
			this.data[this.position++] = (byte) (data[n] & 0xFF);
		}
	}

	/**
	 * Writes the specified content of the long array into the buffer.<br>
	 * The longs from <code>start</code> to inclusively <code>end</code> will be written.
	 *
	 * @param data  the long array of which the specified content will be written
	 * @param start the inclusive start index
	 * @param end   the inclusive end index
	 * @see #ensureSpace(int)
	 */
	public void writeLongArrayRaw(long[] data, int start, int end) {
		this.ensureSpace((end - start + 1) * 8);
		for (int n = start; n <= end; n++) {
			this.data[this.position++] = (byte) ((data[n] >> 56) & 0xFF);
			this.data[this.position++] = (byte) ((data[n] >> 48) & 0xFF);
			this.data[this.position++] = (byte) ((data[n] >> 40) & 0xFF);
			this.data[this.position++] = (byte) ((data[n] >> 32) & 0xFF);
			this.data[this.position++] = (byte) ((data[n] >> 24) & 0xFF);
			this.data[this.position++] = (byte) ((data[n] >> 16) & 0xFF);
			this.data[this.position++] = (byte) ((data[n] >> 8) & 0xFF);
			this.data[this.position++] = (byte) (data[n] & 0xFF);
		}
	}

	/**
	 * Writes the length and the long array itself into the buffer.
	 *
	 * @param data the long array that will be written
	 * @see #ensureSpace(int)
	 * @see #writeInt(int)
	 * @see #writeLongArrayRaw(long[])
	 */
	public void writeLongArray(long[] data) {
		this.ensureSpace(4);
		this.writeInt(data.length);
		this.writeLongArrayRaw(data);
	}

	/**
	 * Writes the length and the specified content of the long array into the buffer.<br>
	 * The longs from <code>start</code> to inclusively <code>end</code> will be written.
	 *
	 * @param data  the long array of which the specified content will be written
	 * @param start the inclusive start index
	 * @param end   the inclusive end index
	 * @see #ensureSpace(int)
	 * @see #writeInt(int)
	 * @see #writeLongArrayRaw(long[], int, int)
	 */
	public void writeLongArray(long[] data, int start, int end) {
		this.ensureSpace(4);
		this.writeInt(end - start + 1);
		this.writeLongArrayRaw(data, start, end);
	}

	/**
	 * Writes a float into the buffer.
	 *
	 * @param data the float that will be written.
	 * @see #writeInt(int)
	 */
	public void writeFloat(float data) {
		int floatBits = Float.floatToIntBits(data);
		this.writeInt(floatBits);
	}

	/**
	 * Writes a float into the buffer at the given position.
	 *
	 * @param data     the float that will be written
	 * @param position the position where the float will be written
	 * @throws IllegalArgumentException when the position is either smaller as 0 or greater than the capacity of the buffer
	 * @see #validateArea(int, int)
	 */
	public void writeFloat(float data, int position) {
		if (!this.validateArea(position, 4))
			throw new IllegalArgumentException("Tried writing float to AdvancedByteBuffer at invalid position.");

		int floatBits = Float.floatToIntBits(data);
		this.data[position] = (byte) (floatBits >> 24);
		this.data[position + 1] = (byte) ((floatBits >> 16) & 0xFF);
		this.data[position + 2] = (byte) ((floatBits >> 8) & 0xFF);
		this.data[position + 3] = (byte) (floatBits & 0xFF);
	}

	/**
	 * Writes a float array into the buffer.
	 *
	 * @param data the float array that will be written
	 * @see #ensureSpace(int)
	 */
	public void writeFloatArrayRaw(float[] data) {
		this.ensureSpace(data.length * 4);
		int floatBits;
		for (int n = 0; n < data.length; n++) {
			floatBits = Float.floatToIntBits(data[n]);
			this.data[this.position++] = (byte) (floatBits >> 24);
			this.data[this.position++] = (byte) ((floatBits >> 16) & 0xFF);
			this.data[this.position++] = (byte) ((floatBits >> 8) & 0xFF);
			this.data[this.position++] = (byte) (floatBits & 0xFF);
		}
	}

	/**
	 * Writes the specified content of the float array into the buffer.<br>
	 * The floats from <code>start</code> to inclusively <code>end</code> will be written.
	 *
	 * @param data  the float array of which the specified content will be written
	 * @param start the inclusive start index
	 * @param end   the inclusive end index
	 * @see #ensureSpace(int)
	 */
	public void writeFloatArrayRaw(float[] data, int start, int end) {
		this.ensureSpace((end - start + 1) * 4);
		int floatBits;
		for (int n = start; n <= end; n++) {
			floatBits = Float.floatToIntBits(data[n]);
			this.data[this.position++] = (byte) (floatBits >> 24);
			this.data[this.position++] = (byte) ((floatBits >> 16) & 0xFF);
			this.data[this.position++] = (byte) ((floatBits >> 8) & 0xFF);
			this.data[this.position++] = (byte) (floatBits & 0xFF);
		}
	}

	/**
	 * Writes the length and the float array itself into the buffer.
	 *
	 * @param data the float array that will be written
	 * @see #ensureSpace(int)
	 * @see #writeInt(int)
	 * @see #writeFloatArrayRaw(float[])
	 */
	public void writeFloatArray(float[] data) {
		this.ensureSpace(4);
		this.writeInt(data.length);
		this.writeFloatArrayRaw(data);
	}

	/**
	 * Writes the length and the specified content of the float array into the buffer.<br>
	 * The floats from <code>start</code> to inclusively <code>end</code> will be written.
	 *
	 * @param data  the float array of which the specified content will be written
	 * @param start the inclusive start index
	 * @param end   the inclusive end index
	 * @see #ensureSpace(int)
	 * @see #writeInt(int)
	 * @see #writeFloatArrayRaw(float[], int, int)
	 */
	public void writeFloatArray(float[] data, int start, int end) {
		this.ensureSpace(4);
		this.writeInt(end - start + 1);
		this.writeFloatArrayRaw(data, start, end);
	}

	/**
	 * Writes a double into the buffer.
	 *
	 * @param data the double that will be written
	 * @see #writeLong(long)
	 */
	public void writeDouble(double data) {
		long doubleBits = Double.doubleToLongBits(data);
		this.writeLong(doubleBits);
	}

	/**
	 * Writes a double into the buffer at the given position.
	 *
	 * @param data     the double that will be written
	 * @param position the position where the double will be written
	 * @throws IllegalArgumentException when the position is either smaller as 0 or greater than the capacity of the buffer
	 * @see #validateArea(int, int)
	 */
	public void writeDouble(double data, int position) {
		if (!this.validateArea(position, 8))
			throw new IllegalArgumentException("Tried writing double to AdvancedByteBuffer at invalid position.");

		long doubleBits = Double.doubleToLongBits(data);
		this.data[position] = (byte) ((doubleBits >> 56) & 0xFF);
		this.data[position + 1] = (byte) ((doubleBits >> 48) & 0xFF);
		this.data[position + 2] = (byte) ((doubleBits >> 40) & 0xFF);
		this.data[position + 3] = (byte) ((doubleBits >> 32) & 0xFF);
		this.data[position + 4] = (byte) ((doubleBits >> 24) & 0xFF);
		this.data[position + 5] = (byte) ((doubleBits >> 16) & 0xFF);
		this.data[position + 6] = (byte) ((doubleBits >> 8) & 0xFF);
		this.data[position + 7] = (byte) (doubleBits & 0xFF);
	}

	/**
	 * Writes a double array into the buffer.
	 *
	 * @param data the double array that will be written
	 * @see #ensureSpace(int)
	 */
	public void writeDoubleArrayRaw(double[] data) {
		this.ensureSpace(data.length * 8);
		long doubleBits;
		for (int n = 0; n < data.length; n++) {
			doubleBits = Double.doubleToLongBits(data[n]);
			this.data[this.position++] = (byte) ((doubleBits >> 56) & 0xFF);
			this.data[this.position++] = (byte) ((doubleBits >> 48) & 0xFF);
			this.data[this.position++] = (byte) ((doubleBits >> 40) & 0xFF);
			this.data[this.position++] = (byte) ((doubleBits >> 32) & 0xFF);
			this.data[this.position++] = (byte) ((doubleBits >> 24) & 0xFF);
			this.data[this.position++] = (byte) ((doubleBits >> 16) & 0xFF);
			this.data[this.position++] = (byte) ((doubleBits >> 8) & 0xFF);
			this.data[this.position++] = (byte) (doubleBits & 0xFF);
		}
	}

	/**
	 * Writes the specified content of the double array into the buffer.<br>
	 * The doubles from <code>start</code> to inclusively <code>end</code> will be written.
	 *
	 * @param data  the double array of which the specified content will be written
	 * @param start the inclusive start index
	 * @param end   the inclusive end index
	 * @see #ensureSpace(int)
	 */
	public void writeDoubleArrayRaw(double[] data, int start, int end) {
		this.ensureSpace((end - start + 1) * 8);
		long doubleBits;
		for (int n = start; n <= end; n++) {
			doubleBits = Double.doubleToLongBits(data[n]);
			this.data[this.position++] = (byte) ((doubleBits >> 56) & 0xFF);
			this.data[this.position++] = (byte) ((doubleBits >> 48) & 0xFF);
			this.data[this.position++] = (byte) ((doubleBits >> 40) & 0xFF);
			this.data[this.position++] = (byte) ((doubleBits >> 32) & 0xFF);
			this.data[this.position++] = (byte) ((doubleBits >> 24) & 0xFF);
			this.data[this.position++] = (byte) ((doubleBits >> 16) & 0xFF);
			this.data[this.position++] = (byte) ((doubleBits >> 8) & 0xFF);
			this.data[this.position++] = (byte) (doubleBits & 0xFF);
		}
	}

	/**
	 * Writes the length and the double array itself into the buffer.
	 *
	 * @param data the double array that will be written
	 * @see #ensureSpace(int)
	 * @see #writeInt(int)
	 * @see #writeIntArrayRaw(int[])
	 */
	public void writeDoubleArray(double[] data) {
		this.ensureSpace(4);
		this.writeInt(data.length);
		this.writeDoubleArrayRaw(data);
	}

	/**
	 * Writes the length and the specified content of the double array into the buffer.<br>
	 * The doubles from <code>start</code> to inclusively <code>end</code> will be written.
	 *
	 * @param data  the int array of which the specified content will be written
	 * @param start the inclusive start index
	 * @param end   the inclusive end index
	 * @see #ensureSpace(int)
	 * @see #writeInt(int)
	 * @see #writeDoubleArrayRaw(double[], int, int)
	 */
	public void writeDoubleArray(double[] data, int start, int end) {
		this.ensureSpace(4);
		this.writeInt(end - start + 1);
		this.writeDoubleArrayRaw(data, start, end);
	}

	/**
	 * Sets the position back to 0.
	 */
	public void rewind() {
		this.position = 0;
	}

	/**
	 * Sets the limit of the buffer to the current position and the reading position back to 0.
	 */
	public void flip() {
		this.limit = this.position;
		this.position = 0;
	}

	/**
	 * Resizes the {@link #data} array to the current number of stored values and resets the position back to 0.
	 */
	public void shrink() {
		if (this.position != this.data.length) {
			byte[] newData = new byte[this.position];
			System.arraycopy(this.data, 0, newData, 0, this.position);
			this.data = newData;
		}
		this.position = 0;
	}

	/**
	 * Reads a byte from the buffer.
	 *
	 * @return the read byte
	 */
	public byte readByte() {
		return this.data[this.position++];
	}

	/**
	 * Reads a byte array from the buffer.<br>
	 * This method assumes the next value will be the size of the array.
	 *
	 * @return the read byte array
	 * @see #readByte()
	 */
	public byte[] readByteArray() {
		byte[] array = new byte[this.readInt()];
		for (int n = 0; n < array.length; n++) {
			array[n] = this.readByte();
		}
		return array;
	}

	/**
	 * Reads a byte array with the given length from the buffer.
	 *
	 * @param length the length of the byte array
	 * @return the read byte array
	 * @see #readByte()
	 */
	public byte[] readByteArray(int length) {
		byte[] array = new byte[length];
		for (int n = 0; n < length; n++) {
			array[n] = this.readByte();
		}
		return array;
	}

	/**
	 * Reads a byte array from the buffer and writes into the given array.
	 *
	 * @param array the byte array the values will be written to.
	 * @return the read byte array
	 * @see #readByte()
	 */
	public byte[] readByteArray(byte[] array) {
		for (int n = 0; n < array.length; n++) {
			array[n] = this.readByte();
		}
		return array;
	}

	/**
	 * Reads a boolean from the buffer.
	 *
	 * @return the read boolean
	 * @see #readByte()
	 */
	public boolean readBoolean() {
		return this.readByte() != 0;
	}

	/**
	 * Reads a boolean array from the buffer.<br>
	 * This method assumes the next value will be the size of the array.
	 *
	 * @return the read boolean array
	 * @see #readBoolean()
	 */
	public boolean[] readBooleanArray() {
		boolean[] array = new boolean[this.readInt()];
		for (int n = 0; n < array.length; n++) {
			array[n] = this.readBoolean();
		}
		return array;
	}

	/**
	 * Reads a boolean array with the given length from the buffer.
	 *
	 * @param length the length of the boolean array
	 * @return the read boolean array
	 * @see #readBoolean()
	 */
	public boolean[] readBooleanArray(int length) {
		boolean[] array = new boolean[length];
		for (int n = 0; n < length; n++) {
			array[n] = this.readBoolean();
		}
		return array;
	}

	/**
	 * Reads a boolean array from the buffer and writes into the given array.
	 *
	 * @param array the boolean array the values will be written to.
	 * @return the read boolean array
	 * @see #readBoolean()
	 */
	public boolean[] readBooleanArray(boolean[] array) {
		for (int n = 0; n < array.length; n++) {
			array[n] = this.readBoolean();
		}
		return array;
	}

	/**
	 * Reads a short from the buffer.
	 *
	 * @return the read short
	 */
	public short readShort() {
		short value = 0;
		value |= (this.data[this.position++] & 0xFF) << 8;
		value |= (this.data[this.position++] & 0xFF);
		return value;
	}

	/**
	 * Reads a short array from the buffer.<br>
	 * This method assumes the next value will be the size of the array.
	 *
	 * @return the read short array
	 * @see #readShort()
	 */
	public short[] readShortArray() {
		short[] array = new short[this.readInt()];
		for (int n = 0; n < array.length; n++) {
			array[n] = this.readShort();
		}
		return array;
	}

	/**
	 * Reads a short array with the given length from the buffer.
	 *
	 * @param length the length of the short array
	 * @return the read short array
	 * @see #readShort()
	 */
	public short[] readShortArray(int length) {
		short[] array = new short[length];
		for (int n = 0; n < length; n++) {
			array[n] = this.readShort();
		}
		return array;
	}

	/**
	 * Reads a short array from the buffer and writes into the given array.
	 *
	 * @param array the short array the values will be written to.
	 * @return the read short array
	 * @see #readShort()
	 */
	public short[] readShortArray(short[] array) {
		for (int n = 0; n < array.length; n++) {
			array[n] = this.readShort();
		}
		return array;
	}

	/**
	 * Reads an int from the buffer.
	 *
	 * @return the read int.
	 */
	public int readInt() {
		int value = 0;
		value |= (this.data[this.position++] & 0xFF) << 24;
		value |= (this.data[this.position++] & 0xFF) << 16;
		value |= (this.data[this.position++] & 0xFF) << 8;
		value |= (this.data[this.position++] & 0xFF);
		return value;
	}

	/**
	 * Reads a int array from the buffer.<br>
	 * This method assumes the next value will be the size of the array.
	 *
	 * @return the read int array.
	 * @see #readInt()
	 */
	public int[] readIntArray() {
		int[] array = new int[this.readInt()];
		for (int n = 0; n < array.length; n++) {
			array[n] = this.readInt();
		}
		return array;
	}

	/**
	 * Reads a int array with the given length from the buffer.
	 *
	 * @param length The length of the int array.
	 * @return the read int array.
	 * @see #readInt()
	 */
	public int[] readIntArray(int length) {
		int[] array = new int[length];
		for (int n = 0; n < length; n++) {
			array[n] = this.readInt();
		}
		return array;
	}

	/**
	 * Reads an int array from the buffer and writes into the given array.
	 *
	 * @param array the int array the values will be written to.
	 * @return the read int array
	 * @see #readInt()
	 */
	public int[] readIntArray(int[] array) {
		for (int n = 0; n < array.length; n++) {
			array[n] = this.readInt();
		}
		return array;
	}

	/**
	 * Reads a long from the buffer.
	 *
	 * @return the read long.
	 */
	public long readLong() {
		long value = 0L;
		value |= (long) (this.data[this.position++] & 0xFF) << 56;
		value |= (long) (this.data[this.position++] & 0xFF) << 48;
		value |= (long) (this.data[this.position++] & 0xFF) << 40;
		value |= (long) (this.data[this.position++] & 0xFF) << 32;
		value |= (long) (this.data[this.position++] & 0xFF) << 24;
		value |= (long) (this.data[this.position++] & 0xFF) << 16;
		value |= (long) (this.data[this.position++] & 0xFF) << 8;
		value |= (long) (this.data[this.position++] & 0xFF);
		return value;
	}

	/**
	 * Reads a long array from the buffer.<br>
	 * This method assumes the next value will be the size of the array.
	 *
	 * @return the read long array.
	 * @see #readLong()
	 */
	public long[] readLongArray() {
		long[] array = new long[this.readInt()];
		for (int n = 0; n < array.length; n++) {
			array[n] = this.readLong();
		}
		return array;
	}

	/**
	 * Reads a long array with the given length from the buffer.
	 *
	 * @param length the length of the long array
	 * @return the read long array
	 * @see #readLong()
	 */
	public long[] readLongArray(int length) {
		long[] array = new long[length];
		for (int n = 0; n < length; n++) {
			array[n] = this.readLong();
		}
		return array;
	}

	/**
	 * Reads a long array from the buffer and writes into the given array.
	 *
	 * @param array the long array the values will be written to.
	 * @return the read long array
	 * @see #readLong()
	 */
	public long[] readLongArray(long[] array) {
		for (int n = 0; n < array.length; n++) {
			array[n] = this.readLong();
		}
		return array;
	}

	/**
	 * Reads a float from the buffer.
	 *
	 * @return the read float.
	 * @see #readInt()
	 */
	public float readFloat() {
		int floatBits = this.readInt();
		return Float.intBitsToFloat(floatBits);
	}

	/**
	 * Reads a float array from the buffer.<br>
	 * This method assumes the next value will be the size of the array.
	 *
	 * @return the read float array
	 * @see #readFloat()
	 */
	public float[] readFloatArray() {
		float[] array = new float[this.readInt()];
		for (int n = 0; n < array.length; n++) {
			array[n] = this.readFloat();
		}
		return array;
	}

	/**
	 * Reads a float array with the given length from the buffer.
	 *
	 * @param length the length of the float array
	 * @return the read float array
	 * @see #readFloat()
	 */
	public float[] readFloatArray(int length) {
		float[] array = new float[length];
		for (int n = 0; n < length; n++) {
			array[n] = this.readFloat();
		}
		return array;
	}

	/**
	 * Reads a float array from the buffer and writes into the given array.
	 *
	 * @param array the float array the values will be written to.
	 * @return the read float array
	 * @see #readFloat()
	 */
	public float[] readFloatArray(float[] array) {
		for (int n = 0; n < array.length; n++) {
			array[n] = this.readFloat();
		}
		return array;
	}

	/**
	 * Reads a double from the buffer.
	 *
	 * @return the read double
	 * @see #readLong()
	 */
	public double readDouble() {
		long doubleBits = this.readLong();
		return Double.longBitsToDouble(doubleBits);
	}

	/**
	 * Reads a double array from the buffer.<br>
	 * This method assumes the next value will be the size of the array.
	 *
	 * @return the read double array
	 * @see #readDouble()
	 */
	public double[] readDoubleArray() {
		double[] array = new double[this.readInt()];
		for (int n = 0; n < array.length; n++) {
			array[n] = this.readDouble();
		}
		return array;
	}

	/**
	 * Reads a double array with the given length from the buffer.
	 *
	 * @param length the length of the double array
	 * @return the read double array
	 * @see #readDouble()
	 */
	public double[] readDoubleArray(int length) {
		double[] array = new double[length];
		for (int n = 0; n < length; n++) {
			array[n] = this.readDouble();
		}
		return array;
	}

	/**
	 * Reads a double array from the buffer and writes into the given array.
	 *
	 * @param array the double array the values will be written to.
	 * @return the read double array
	 * @see #readDouble()
	 */
	public double[] readDoubleArray(double[] array) {
		for (int n = 0; n < array.length; n++) {
			array[n] = this.readDouble();
		}
		return array;
	}

	/**
	 * Ensures that the {@link #data} array has enough space to fit the specified bytes.<br>
	 * If there is not enough space in the array, the array will be resized by either the amount needed or the threshold (which ever is greater).
	 *
	 * @param bytesNeeded the bytes required
	 */
	public void ensureSpace(int bytesNeeded) {
		if (this.position + bytesNeeded >= this.data.length) {
			byte[] newData = new byte[this.data.length + (bytesNeeded < this.threshold ? this.threshold : bytesNeeded)];
			this.limit = this.data.length;
			System.arraycopy(this.data, 0, newData, 0, this.limit);
			this.data = newData;
		}
	}

	/**
	 * Checks if the position is valid for the {@link #data} array.
	 *
	 * @param position the position that will be checked
	 * @return <i>true</i> if the position is valid
	 */
	private boolean validatePosition(int position) {
		if (position < 0) {
			return false;
		} else {
			return position < this.data.length;
		}
	}

	/**
	 * Checks if there is enough space for the given bytes at the given position.
	 *
	 * @param position the position that will be checked
	 * @param size     the amount of bytes that will be checked
	 * @return <i>true</i> if there is enough space for the specified amount of bytes at the given position
	 */
	private boolean validateArea(int position, int size) {
		if (this.validatePosition(position)) {
			return this.validatePosition(position + size);
		} else {
			return false;
		}
	}

}
