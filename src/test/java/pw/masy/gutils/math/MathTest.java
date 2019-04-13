package pw.masy.gutils.math;

import org.junit.Assert;
import org.junit.Test;

public class MathTest {

	@Test
	public void testClampByte() {
		Assert.assertEquals((byte) 13, MathHelper.clamp((byte) 13, (byte) -3, (byte) 15));
		Assert.assertEquals((byte) -3, MathHelper.clamp((byte) -3, (byte) -7, (byte) 15));
		Assert.assertEquals((byte) 13, MathHelper.clamp((byte) 5, (byte) 13, (byte) 15));
		Assert.assertEquals((byte) -3, MathHelper.clamp((byte) -5, (byte) -3, (byte) 15));
		Assert.assertEquals((byte) 15, MathHelper.clamp((byte) 17, (byte) -3, (byte) 15));
		Assert.assertEquals((byte) -3, MathHelper.clamp((byte) -2, (byte) -7, (byte) -3));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testClampByteException() {
		MathHelper.clamp((byte) 15, (byte) 17, (byte) 15);
	}

	@Test
	public void testClampShort() {
		Assert.assertEquals((short) 13, MathHelper.clamp((short) 13, (short) -3, (short) 15));
		Assert.assertEquals((short) -3, MathHelper.clamp((short) -3, (short) -7, (short) 15));
		Assert.assertEquals((short) 13, MathHelper.clamp((short) 5, (short) 13, (short) 15));
		Assert.assertEquals((short) -3, MathHelper.clamp((short) -5, (short) -3, (short) 15));
		Assert.assertEquals((short) 15, MathHelper.clamp((short) 17, (short) -3, (short) 15));
		Assert.assertEquals((short) -3, MathHelper.clamp((short) -2, (short) -7, (short) -3));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testClampShortException() {
		MathHelper.clamp((short) 15, (short) 17, (short) 15);
	}

	@Test
	public void testClampInt() {
		Assert.assertEquals(13, MathHelper.clamp(13, -3, 15));
		Assert.assertEquals(-3, MathHelper.clamp(-3, -7, 15));
		Assert.assertEquals(13, MathHelper.clamp(5, 13, 15));
		Assert.assertEquals(-3, MathHelper.clamp(-5, -3, 15));
		Assert.assertEquals(15, MathHelper.clamp(17, -3, 15));
		Assert.assertEquals(-3, MathHelper.clamp(-2, -7, -3));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testClampIntException() {
		MathHelper.clamp(15, 17, 15);
	}

	@Test
	public void testClampLong() {
		Assert.assertEquals(13L, MathHelper.clamp(13L, -3L, 15L));
		Assert.assertEquals(-3L, MathHelper.clamp(-3L, -7L, 15L));
		Assert.assertEquals(13L, MathHelper.clamp(5L, 13L, 15L));
		Assert.assertEquals(-3L, MathHelper.clamp(-5L, -3L, 15L));
		Assert.assertEquals(15L, MathHelper.clamp(17L, -3L, 15L));
		Assert.assertEquals(-3L, MathHelper.clamp(-2L, -7L, -3L));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testClampLongException() {
		MathHelper.clamp(15L, 17L, 15L);
	}

	@Test
	public void testClampFloat() {
		Assert.assertEquals(13.25f, MathHelper.clamp(13.25f, -3.25f, 15.25f), 0);
		Assert.assertEquals(-3.25f, MathHelper.clamp(-3.25f, -7.25f, 15.25f), 0);
		Assert.assertEquals(13.25f, MathHelper.clamp(5.25f, 13.25f, 15.25f), 0);
		Assert.assertEquals(-3.25f, MathHelper.clamp(-5.25f, -3.25f, 15.25f), 0);
		Assert.assertEquals(15.25f, MathHelper.clamp(17.25f, -3.25f, 15.25f), 0);
		Assert.assertEquals(-3.25f, MathHelper.clamp(-2.25f, -7.25f, -3.25f), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testClampFloatException() {
		MathHelper.clamp(15.25f, 17.25f, 15f);
	}

	@Test
	public void testClampDouble() {
		Assert.assertEquals(13.25, MathHelper.clamp(13.25, -3.25, 15.25), 0);
		Assert.assertEquals(-3.25, MathHelper.clamp(-3.25, -7.25, 15.25), 0);
		Assert.assertEquals(13.25, MathHelper.clamp(5.25, 13.25, 15.25), 0);
		Assert.assertEquals(-3.25, MathHelper.clamp(-5.25, -3.25, 15.25), 0);
		Assert.assertEquals(15.25, MathHelper.clamp(17.25, -3.25, 15.25), 0);
		Assert.assertEquals(-3.25, MathHelper.clamp(-2.25, -7.25, -3.25), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testClampDoubleException() {
		MathHelper.clamp(15.25, 17.25, 15.25);
	}

	@Test
	public void testLoopByte() {
		Assert.assertEquals((byte) 18, MathHelper.loop((byte) 8, (byte) 10, (byte) 20));
		Assert.assertEquals((byte) 8, MathHelper.loop((byte) -12, (byte) -10, (byte) 10));
		Assert.assertEquals((byte) -12, MathHelper.loop((byte) -32, (byte) -30, (byte) -10));
		Assert.assertEquals((byte) 12, MathHelper.loop((byte) 12, (byte) 10, (byte) 20));
		Assert.assertEquals((byte) -3, MathHelper.loop((byte) -3, (byte) -10, (byte) 10));
		Assert.assertEquals((byte) -44, MathHelper.loop((byte) -44, (byte) -55, (byte) -33));
		Assert.assertEquals((byte) 15, MathHelper.loop((byte) 55, (byte) 10, (byte) 20));
		Assert.assertEquals((byte) 3, MathHelper.loop((byte) 23, (byte) -5, (byte) 5));
		Assert.assertEquals((byte) -15, MathHelper.loop((byte) 25, (byte) -20, (byte) -10));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLoopByteException() {
		MathHelper.loop((byte) 0, (byte) 30, (byte) 25);
	}

	@Test
	public void testLoopShort() {
		Assert.assertEquals((short) 18, MathHelper.loop((short) 8, (short) 10, (short) 20));
		Assert.assertEquals((short) 8, MathHelper.loop((short) -12, (short) -10, (short) 10));
		Assert.assertEquals((short) -12, MathHelper.loop((short) -32, (short) -30, (short) -10));
		Assert.assertEquals((short) 12, MathHelper.loop((short) 12, (short) 10, (short) 20));
		Assert.assertEquals((short) -3, MathHelper.loop((short) -3, (short) -10, (short) 10));
		Assert.assertEquals((short) -44, MathHelper.loop((short) -44, (short) -55, (short) -33));
		Assert.assertEquals((short) 15, MathHelper.loop((short) 55, (short) 10, (short) 20));
		Assert.assertEquals((short) 3, MathHelper.loop((short) 23, (short) -5, (short) 5));
		Assert.assertEquals((short) -15, MathHelper.loop((short) 25, (short) -20, (short) -10));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLoopShortException() {
		MathHelper.loop((short) 0, (short) 30, (short) 25);
	}

	@Test
	public void testLoopInt() {
		Assert.assertEquals(18, MathHelper.loop(8, 10, 20));
		Assert.assertEquals(8, MathHelper.loop(-12, -10, 10));
		Assert.assertEquals(-12, MathHelper.loop(-32, -30, -10));
		Assert.assertEquals(12, MathHelper.loop(12, 10, 20));
		Assert.assertEquals(-3, MathHelper.loop(-3, -10, 10));
		Assert.assertEquals(-44, MathHelper.loop(-44, -55, -33));
		Assert.assertEquals(15, MathHelper.loop(55, 10, 20));
		Assert.assertEquals(3, MathHelper.loop(23, -5, 5));
		Assert.assertEquals(-15, MathHelper.loop(25, -20, -10));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLoopIntException() {
		MathHelper.loop(0, 30, 25);
	}

	@Test
	public void testLoopLong() {
		Assert.assertEquals(18L, MathHelper.loop(8L, 10L, 20L));
		Assert.assertEquals(8L, MathHelper.loop(-12L, -10L, 10L));
		Assert.assertEquals(-12L, MathHelper.loop(-32L, -30L, -10L));
		Assert.assertEquals(12L, MathHelper.loop(12L, 10L, 20L));
		Assert.assertEquals(-3L, MathHelper.loop(-3L, -10L, 10L));
		Assert.assertEquals(-44L, MathHelper.loop(-44L, -55L, -33L));
		Assert.assertEquals(15L, MathHelper.loop(55L, 10L, 20L));
		Assert.assertEquals(3L, MathHelper.loop(23L, -5L, 5L));
		Assert.assertEquals(-15L, MathHelper.loop(25L, -20L, -10L));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLoopLongException() {
		MathHelper.loop(0L, 30L, 25L);
	}

	@Test
	public void testLoopFloat() {
		Assert.assertEquals(18.25f, MathHelper.loop(8.25f, 10.25f, 20.25f), 0);
		Assert.assertEquals(8.25f, MathHelper.loop(-12.25f, -10.25f, 10.25f), 0);
		Assert.assertEquals(-12.25f, MathHelper.loop(-32.25f, -30.25f, -10.25f), 0);
		Assert.assertEquals(12.25f, MathHelper.loop(12.25f, 10.25f, 20.25f), 0);
		Assert.assertEquals(-3.25f, MathHelper.loop(-3.25f, -10.25f, 10.25f), 0);
		Assert.assertEquals(-44.25f, MathHelper.loop(-44.25f, -55.25f, -33.25f), 0);
		Assert.assertEquals(15.25f, MathHelper.loop(55.25f, 10.25f, 20.25f), 0);
		Assert.assertEquals(2.25f, MathHelper.loop(23.25f, -5.25f, 5.25f), 0);
		Assert.assertEquals(-14.75f, MathHelper.loop(25.25f, -20.25f, -10.25f), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLoopFloatException() {
		MathHelper.loop(0.25f, 30.25f, 25.25f);
	}

	@Test
	public void testLoopDouble() {
		Assert.assertEquals(18.25, MathHelper.loop(8.25, 10.25, 20.25), 0);
		Assert.assertEquals(8.25, MathHelper.loop(-12.25, -10.25, 10.25), 0);
		Assert.assertEquals(-12.25, MathHelper.loop(-32.25, -30.25, -10.25), 0);
		Assert.assertEquals(12.25, MathHelper.loop(12.25, 10.25, 20.25), 0);
		Assert.assertEquals(-3.25, MathHelper.loop(-3.25, -10.25, 10.25), 0);
		Assert.assertEquals(-44.25, MathHelper.loop(-44.25, -55.25, -33.25), 0);
		Assert.assertEquals(15.25, MathHelper.loop(55.25, 10.25, 20.25), 0);
		Assert.assertEquals(2.25, MathHelper.loop(23.25, -5.25, 5.25), 0);
		Assert.assertEquals(-14.75, MathHelper.loop(25.25, -20.25, -10.25), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLoopDoubleException() {
		MathHelper.loop(0.25, 30.25, 25.25);
	}

}
