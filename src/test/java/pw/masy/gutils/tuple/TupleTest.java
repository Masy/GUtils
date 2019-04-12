package pw.masy.gutils.tuple;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.junit.Assert;
import org.junit.Test;

public class TupleTest {

	@Test
	public void testBiTuple() {
		int valueA = 13;
		String valueB = "This is a string";
		BiTuple<Integer, String> tuple = new BiTuple<>(valueA, valueB);

		Assert.assertEquals(valueA, (int) tuple.getA());
		Assert.assertEquals(valueB, tuple.getB());
	}

	@Test
	public void testTriTuple() {
		int valueA = 1337;
		String valueB = "This is another string";
		DecimalFormat valueC = new DecimalFormat("#.#####");
		TriTuple<Integer, String, NumberFormat> tuple = new TriTuple<>(valueA, valueB, valueC);

		Assert.assertEquals(valueA, (int) tuple.getA());
		Assert.assertEquals(valueB, tuple.getB());
		Assert.assertEquals(valueC, tuple.getC());
	}

}
