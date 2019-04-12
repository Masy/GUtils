package pw.masy.gutils.tree.octree;

import org.junit.Assert;
import org.junit.Test;

public class OctreeTest {

	@Test
	public void testInsertAndGet() {
		IOctree<Integer> tree = new Octree<>(4);

		tree.insert(0, 0, 0, 23);
		tree.insert(1, 0, 0, 17);
		tree.insert(0, 1, 1, 14);
		tree.insert(1, 3, 0, 7);
		tree.insert(2, 0, 0, 3);
		tree.insert(3, 3, 3, 29);
		tree.insert(3, 1, 3, 37);
		tree.insert(0, 3, 1, -5);

		Assert.assertEquals(23, (int) tree.get(0, 0, 0));
		Assert.assertEquals(17, (int) tree.get(1, 0, 0));
		Assert.assertEquals(14, (int) tree.get(0, 1, 1));
		Assert.assertEquals(7, (int) tree.get(1, 3, 0));
		Assert.assertEquals(3, (int) tree.get(2, 0, 0));
		Assert.assertEquals(29, (int) tree.get(3, 3, 3));
		Assert.assertEquals(37, (int) tree.get(3, 1, 3));
		Assert.assertEquals(-5, (int) tree.get(0, 3, 1));
	}

	@Test
	public void testMerging() {
		IOctree<Integer> tree = new Octree<>(4);

		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				for (int z = 0; z < 4; z++) {
					tree.insert(x, y, z, 17);
				}
			}
		}

		tree.forEach((layer, octant, value) -> {
			Assert.assertEquals(0, (int) layer);
			Assert.assertEquals(0, (int) octant);
			Assert.assertEquals(17, (int) value);
		});
	}

}
