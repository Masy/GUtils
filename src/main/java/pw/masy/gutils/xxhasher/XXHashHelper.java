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

	/**
	 * Creates a 32bit hasher with the given seed.
	 *
	 * @param seed the seed of the hasher
	 * @return a {@link StreamingXXHash32} initialized with the given seed
	 */
	public static StreamingXXHash32 get32BitHasher(int seed) {
		return FACTORY.newStreamingHash32(seed);
	}

	/**
	 * Creates a 64bit hasher with the given seed.
	 *
	 * @param seed the seed of the hasher
	 * @return a {@link StreamingXXHash64} initialized with the given seed
	 */
	public static StreamingXXHash64 init64(long seed) {
		return FACTORY.newStreamingHash64(seed);
	}

	/**
	 * Hashes the given byte array to a 32bit hash.
	 *
	 * @param hasher the {@link StreamingXXHash32} that will be used to generate the hash
	 * @param data the bytes that gets hashed
	 * @return the 32bit hash of the byte array
	 */
	public static int getHash32(StreamingXXHash32 hasher, byte[] data) {
		hasher.reset();
		hasher.update(data, 0, data.length);
		return hasher.getValue();
	}

	/**
	 * Hashes the given byte array to a 32bit hash.
	 *
	 * @param hasher the {@link StreamingXXHash64} that will be used to generate the hash
	 * @param data the bytes that gets hashed
	 * @return the 64bit hash of the byte array
	 */
	public static long getHash64(StreamingXXHash64 hasher, byte[] data) {
		hasher.reset();
		hasher.update(data, 0, data.length);
		return hasher.getValue();
	}

}
