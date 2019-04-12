package pw.masy.gutils.tuple;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class representing a tuple with three values.
 *
 * @param <A> the type of the first value
 * @param <B> the type of the second value
 * @param <C> the type of the third value
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TriTuple<A, B, C> {

	private A a;
	private B b;
	private C c;

	@Override
	public String toString() {
		return "<" + this.a + ", " + this.b + ", " + this.c + ">";
	}

}
