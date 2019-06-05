package pw.masy.gutils.noise;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import pw.masy.gutils.math.Vec2d;
import pw.masy.gutils.math.Vec3d;

public class VoronoiTest {

	@Test
	public void testConsistency() {
		VoronoiNoise noise1 = new VoronoiNoise(1337L);
		VoronoiNoise noise2 = new VoronoiNoise(89734L);
		VoronoiNoise noise3 = new VoronoiNoise(1337L);
		VoronoiNoise noise4 = new VoronoiNoise(89734L);

		Vec2d cell1 = noise1.eval(1503.0, -8654.0, 16384.0, 4096.0, 0.0005);
		Vec2d cell2 = noise2.eval(1503.0, -8654.0, 16384.0, 4096.0, 0.0005);
		Vec2d cell3 = noise3.eval(1503.0, -8654.0, 16384.0, 4096.0, 0.0005);
		Vec2d cell4 = noise4.eval(1503.0, -8654.0, 16384.0, 4096.0, 0.0005);

		Assert.assertEquals(cell1, cell3);
		Assert.assertEquals(cell2, cell4);
		Assert.assertNotEquals(cell1, cell2);
		Assert.assertNotEquals(cell1, cell4);
	}

	@Ignore
	@Test
	public void testCell() {
		VoronoiNoise noise = new VoronoiNoise(1337);

		Vec3d cell1 = noise.evalWithDistance(123, 342, 16384, 4096, 0.0005);
		System.out.println(cell1.toString());
		Vec3d cell2 = noise.evalWithDistance(1435, 334, 16384, 4096, 0.0005);
		System.out.println(cell2.toString());
		Vec3d cell3 = noise.evalWithDistance(12345, -2435, 16384, 4096, 0.0005);
		System.out.println(cell3.toString());
		Vec3d cell4 = noise.evalWithDistance(342, 5342, 16384, 4096, 0.0005);
		System.out.println(cell4.toString());
	}

}
