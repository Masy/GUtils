package pw.masy.gutils.xxhasher;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.jpountz.xxhash.StreamingXXHash32;
import net.jpountz.xxhash.StreamingXXHash64;
import net.jpountz.xxhash.XXHashFactory;

/**
 * Helper class providing methods to hash byte arrays.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class XXHashHelper {

	private static final XXHashFactory FACTORY = XXHashFactory.fastestInstance();
	private static StreamingXXHash32 HASHER_32;
	private static StreamingXXHash64 HASHER_64;

	/**
	 * Initializes the 32bit hasher with the given seed.
	 *
	 * @param seed the seed of the hasher
	 */
	public static void init32(int seed) {
		HASHER_32 = FACTORY.newStreamingHash32(seed);
	}

	/**
	 * Initializes the 64bit hasher.
	 *
	 * @param seed the seed of the hasher
	 */
	public static void init64(long seed) {
		HASHER_64 = FACTORY.newStreamingHash64(seed);
	}

	/**
	 * Hashes the given byte array to a 32bit hash.
	 *
	 * @param data the bytes that gets hashed
	 * @return the 32bit hash of the byte array
	 */
	public static int getHash32(byte[] data) {
		HASHER_32.reset();
		HASHER_32.update(data, 0, data.length);
		return HASHER_32.getValue();
	}

	/**
	 * Hashes the given byte array to a 64bit hash.
	 *
	 * @param data the bytes that gets hashed
	 * @return the 64bit hash of the byte array
	 */
	public static long getHash64(byte[] data) {
		HASHER_64.reset();
		HASHER_64.update(data, 0, data.length);
		return HASHER_64.getValue();
	}

}
