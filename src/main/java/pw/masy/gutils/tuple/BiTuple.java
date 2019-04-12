package pw.masy.gutils.tuple;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class representing a tuple with two values.
 *
 * @param <A> the type of the first value
 * @param <B> the type of the second value
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BiTuple<A, B> {

	private A a;
	private B b;

	@Override
	public String toString() {
		return "<" + this.a + ", " + this.b + ">";
	}

}
