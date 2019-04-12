package pw.masy.gutils.buffer;

import org.junit.Assert;
import org.junit.Test;

public class AdvancedByteBufferTest {

	@Test
	public void testResizing() {
		AdvancedByteBuffer buffer = new AdvancedByteBuffer(12);
		buffer.ensureSpace(45);
		Assert.assertEquals(57, buffer.getCapacity());
	}

	@Test
	public void testByte() {
		AdvancedByteBuffer buffer = new AdvancedByteBuffer(1);
		buffer.writeByte((byte) 23);
		buffer.rewind();
		Assert.assertEquals((byte) 23, buffer.readByte());

		byte[] array = new byte[]{21, 34, 17, 1, 124};
		byte[] section = new byte[]{34, 17, 1};

		AdvancedByteBuffer buffer2 = new AdvancedByteBuffer(5);
		buffer2.writeByteArrayRaw(array);
		buffer2.rewind();
		byte[] result = buffer2.readByteArray(5);
		Assert.assertArrayEquals(array, result);
		buffer2.rewind();
		byte[] result2 = new byte[5];
		buffer2.readByteArray(result2);
		Assert.assertArrayEquals(array, result2);

		AdvancedByteBuffer buffer3 = new AdvancedByteBuffer(3);
		buffer3.writeByteArrayRaw(array, 1, 3);
		buffer3.rewind();
		byte[] result3 = buffer3.readByteArray(3);
		Assert.assertArrayEquals(section, result3);
		byte[] result4 = new byte[3];
		buffer3.rewind();
		buffer3.readByteArray(result4);
		Assert.assertArrayEquals(section, result4);

		AdvancedByteBuffer buffer4 = new AdvancedByteBuffer(5);
		buffer4.writeByteArray(array);
		buffer4.rewind();
		Assert.assertArrayEquals(array, buffer4.readByteArray());

		AdvancedByteBuffer buffer5 = new AdvancedByteBuffer(3);
		buffer5.writeByteArray(array, 1, 3);
		buffer5.rewind();
		Assert.assertArrayEquals(section, buffer5.readByteArray());
	}

	@Test
	public void testBoolean() {
		AdvancedByteBuffer buffer = new AdvancedByteBuffer(1);
		buffer.writeBoolean(false);
		buffer.rewind();
		Assert.assertFalse(buffer.readBoolean());

		boolean[] array = new boolean[]{true, true, false, true, false};
		boolean[] section = new boolean[]{true, false, true};

		AdvancedByteBuffer buffer2 = new AdvancedByteBuffer(5);
		buffer2.writeBooleanArrayRaw(array);
		buffer2.rewind();
		boolean[] result = buffer2.readBooleanArray(5);
		Assert.assertArrayEquals(array, result);
		buffer2.rewind();
		boolean[] result2 = new boolean[5];
		buffer2.readBooleanArray(result2);
		Assert.assertArrayEquals(array, result2);

		AdvancedByteBuffer buffer3 = new AdvancedByteBuffer(3);
		buffer3.writeBooleanArrayRaw(array, 1, 3);
		buffer3.rewind();
		boolean[] result3 = buffer3.readBooleanArray(3);
		Assert.assertArrayEquals(section, result3);
		boolean[] result4 = new boolean[3];
		buffer3.rewind();
		buffer3.readBooleanArray(result4);
		Assert.assertArrayEquals(section, result4);

		AdvancedByteBuffer buffer4 = new AdvancedByteBuffer(9);
		buffer4.writeBooleanArray(array);
		buffer4.rewind();
		Assert.assertArrayEquals(array, buffer4.readBooleanArray());

		AdvancedByteBuffer buffer5 = new AdvancedByteBuffer(7);
		buffer5.writeBooleanArray(array, 1, 3);
		buffer5.rewind();
		Assert.assertArrayEquals(section, buffer5.readBooleanArray());
	}

	@Test
	public void testShort() {
		AdvancedByteBuffer buffer = new AdvancedByteBuffer(4);
		buffer.writeShort((short) 23472);
		buffer.rewind();
		Assert.assertEquals((short) 23472, buffer.readShort());

		short[] array = new short[]{12332, 21421, -21421, 134, -12344};
		short[] section = new short[]{21421, -21421, 134};

		AdvancedByteBuffer buffer2 = new AdvancedByteBuffer(10);
		buffer2.writeShortArrayRaw(array);
		buffer2.rewind();
		short[] result = buffer2.readShortArray(5);
		Assert.assertArrayEquals(array, result);
		Assert.assertArrayEquals(array, result);
		buffer2.rewind();
		short[] result2 = new short[5];
		buffer2.readShortArray(result2);
		Assert.assertArrayEquals(array, result2);

		AdvancedByteBuffer buffer3 = new AdvancedByteBuffer(6);
		buffer3.writeShortArrayRaw(array, 1, 3);
		buffer3.rewind();
		short[] result3 = buffer3.readShortArray(3);
		Assert.assertArrayEquals(section, result3);
		short[] result4 = new short[3];
		buffer3.rewind();
		buffer3.readShortArray(result4);
		Assert.assertArrayEquals(section, result4);

		AdvancedByteBuffer buffer4 = new AdvancedByteBuffer(14);
		buffer4.writeShortArray(array);
		buffer4.rewind();
		Assert.assertArrayEquals(array, buffer4.readShortArray());

		AdvancedByteBuffer buffer5 = new AdvancedByteBuffer(10);
		buffer5.writeShortArray(array, 1, 3);
		buffer5.rewind();
		Assert.assertArrayEquals(section, buffer5.readShortArray());
	}

	@Test
	public void testInt() {
		AdvancedByteBuffer buffer = new AdvancedByteBuffer(4);
		buffer.writeInt(234562235);
		buffer.rewind();
		Assert.assertEquals(234562235, buffer.readInt());

		int[] array = new int[]{324235235, -235235235, 235235235, -1276512462, -23897634};
		int[] section = new int[]{-235235235, 235235235, -1276512462};

		AdvancedByteBuffer buffer2 = new AdvancedByteBuffer(20);
		buffer2.writeIntArrayRaw(array);
		buffer2.rewind();
		int[] result = buffer2.readIntArray(5);
		Assert.assertArrayEquals(array, result);
		buffer2.rewind();
		int[] result2 = new int[5];
		buffer2.readIntArray(result2);
		Assert.assertArrayEquals(array, result2);

		AdvancedByteBuffer buffer3 = new AdvancedByteBuffer(12);
		buffer3.writeIntArrayRaw(array, 1, 3);
		buffer3.rewind();
		int[] result3 = buffer3.readIntArray(3);
		Assert.assertArrayEquals(section, result3);
		int[] result4 = new int[3];
		buffer3.rewind();
		buffer3.readIntArray(result4);
		Assert.assertArrayEquals(section, result4);

		AdvancedByteBuffer buffer4 = new AdvancedByteBuffer(24);
		buffer4.writeIntArray(array);
		buffer4.rewind();
		Assert.assertArrayEquals(array, buffer4.readIntArray());

		AdvancedByteBuffer buffer5 = new AdvancedByteBuffer(16);
		buffer5.writeIntArray(array, 1, 3);
		buffer5.rewind();
		Assert.assertArrayEquals(section, buffer5.readIntArray());
	}

	@Test
	public void testLong() {
		AdvancedByteBuffer buffer = new AdvancedByteBuffer(8);
		buffer.writeLong(2345622332345345L);
		buffer.rewind();
		Assert.assertEquals(2345622332345345L, buffer.readLong());

		long[] array = new long[]{87234876348675L, -872376523765L, -2376534275234L, 187364L, 123243222224L};
		long[] section = new long[]{-872376523765L, -2376534275234L, 187364L};

		AdvancedByteBuffer buffer2 = new AdvancedByteBuffer(40);
		buffer2.writeLongArrayRaw(array);
		buffer2.rewind();
		long[] result = buffer2.readLongArray(5);
		Assert.assertArrayEquals(array, result);
		buffer2.rewind();
		long[] result2 = new long[5];
		buffer2.readLongArray(result2);
		Assert.assertArrayEquals(array, result2);

		AdvancedByteBuffer buffer3 = new AdvancedByteBuffer(24);
		buffer3.writeLongArrayRaw(array, 1, 3);
		buffer3.rewind();
		long[] result3 = buffer3.readLongArray(3);
		Assert.assertArrayEquals(section, result3);
		long[] result4 = new long[3];
		buffer3.rewind();
		buffer3.readLongArray(result4);
		Assert.assertArrayEquals(section, result4);

		AdvancedByteBuffer buffer4 = new AdvancedByteBuffer(44);
		buffer4.writeLongArray(array);
		buffer4.rewind();
		Assert.assertArrayEquals(array, buffer4.readLongArray());

		AdvancedByteBuffer buffer5 = new AdvancedByteBuffer(28);
		buffer5.writeLongArray(array, 1, 3);
		buffer5.rewind();
		Assert.assertArrayEquals(section, buffer5.readLongArray());
	}

	@Test
	public void testFloat() {
		AdvancedByteBuffer buffer = new AdvancedByteBuffer(4);
		buffer.writeFloat(123876234.234876f);
		buffer.rewind();
		Assert.assertEquals(123876234.234876f, buffer.readFloat(), 0);

		float[] array = new float[]{21.123f, 1211.12f, -12314.123123f, -12897324.032f, -0.1111111111111111111111f};
		float[] section = new float[]{1211.12f, -12314.123123f, -12897324.032f};

		AdvancedByteBuffer buffer2 = new AdvancedByteBuffer(20);
		buffer2.writeFloatArrayRaw(array);
		buffer2.rewind();
		float[] result = buffer2.readFloatArray(5);
		Assert.assertArrayEquals(array, result, 0);
		buffer2.rewind();
		float[] result2 = new float[5];
		buffer2.readFloatArray(result2);
		Assert.assertArrayEquals(array, result2, 0);

		AdvancedByteBuffer buffer3 = new AdvancedByteBuffer(12);
		buffer3.writeFloatArrayRaw(array, 1, 3);
		buffer3.rewind();
		float[] result3 = buffer3.readFloatArray(3);
		Assert.assertArrayEquals(section, result3, 0);
		float[] result4 = new float[3];
		buffer3.rewind();
		buffer3.readFloatArray(result4);
		Assert.assertArrayEquals(section, result4, 0);

		AdvancedByteBuffer buffer4 = new AdvancedByteBuffer(24);
		buffer4.writeFloatArray(array);
		buffer4.rewind();
		Assert.assertArrayEquals(array, buffer4.readFloatArray(), 0);

		AdvancedByteBuffer buffer5 = new AdvancedByteBuffer(16);
		buffer5.writeFloatArray(array, 1, 3);
		buffer5.rewind();
		Assert.assertArrayEquals(section, buffer5.readFloatArray(), 0);
	}

	@Test
	public void testDouble() {
		AdvancedByteBuffer buffer = new AdvancedByteBuffer(8);
		buffer.writeDouble(123876234.234876);
		buffer.rewind();
		Assert.assertEquals(123876234.234876, buffer.readDouble(), 0);

		double[] array = new double[]{21.123, 1211.12, -12314.123123, -12897324.032, -0.1111111111111111111111};
		double[] section = new double[]{1211.12, -12314.123123, -12897324.032};

		AdvancedByteBuffer buffer2 = new AdvancedByteBuffer(40);
		buffer2.writeDoubleArrayRaw(array);
		buffer2.rewind();
		double[] result = buffer2.readDoubleArray(5);
		Assert.assertArrayEquals(array, result, 0);
		buffer2.rewind();
		double[] result2 = new double[5];
		buffer2.readDoubleArray(result2);
		Assert.assertArrayEquals(array, result2, 0);

		AdvancedByteBuffer buffer3 = new AdvancedByteBuffer(24);
		buffer3.writeDoubleArrayRaw(array, 1, 3);
		buffer3.rewind();
		double[] result3 = buffer3.readDoubleArray(3);
		Assert.assertArrayEquals(section, result3, 0);
		double[] result4 = new double[3];
		buffer3.rewind();
		buffer3.readDoubleArray(result4);
		Assert.assertArrayEquals(section, result4, 0);

		AdvancedByteBuffer buffer4 = new AdvancedByteBuffer(44);
		buffer4.writeDoubleArray(array);
		buffer4.rewind();
		Assert.assertArrayEquals(array, buffer4.readDoubleArray(), 0);

		AdvancedByteBuffer buffer5 = new AdvancedByteBuffer(28);
		buffer5.writeDoubleArray(array, 1, 3);
		buffer5.rewind();
		Assert.assertArrayEquals(section, buffer5.readDoubleArray(), 0);
	}

}
