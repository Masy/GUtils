package pw.masy.gutils.lz4;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;

/**
 * Helper class providing a compressor and decompressor of LZ4.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LZ4Helper {

	private static final LZ4Factory FACTORY = LZ4Factory.fastestInstance();
	public static final LZ4Compressor COMPRESSOR = FACTORY.fastCompressor();
	public static final LZ4FastDecompressor DECOMPRESSOR = FACTORY.fastDecompressor();

}
