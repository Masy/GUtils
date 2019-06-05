package pw.masy.gutils.loader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.io.IOUtils;

/**
 * Helper class for loading files.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResourceLoader {

	/**
	 * Loads an inner-jar file into a byte array.
	 *
	 * @param path the path to the file that will be loaded
	 * @return the loaded file as byte array
	 * @throws IOException when the file could not be loaded
	 */
	public static byte[] loadInternalResource(String path) throws IOException {
		InputStream stream = ResourceLoader.class.getResourceAsStream(path);
		if (stream == null)
			throw new IOException("Could not load resource \"" + path + "\". File not found.");

		return IOUtils.toByteArray(stream);
	}

	/**
	 * Loads an outer-jar file into a byte array.
	 *
	 * @param path the path to the file that will be loaded
	 * @return the loaded file as byte array
	 * @throws IOException when the file could not be found
	 */
	public static byte[] loadExternalResource(String path) throws IOException {
		FileInputStream stream = new FileInputStream(path);
		return IOUtils.toByteArray(stream);
	}

	/**
	 * Loads an inner-jar file as a string.
	 *
	 * @param path the path to the file that will be loaded
	 * @param charset the charset of the string
	 * @return the loaded file as string
	 * @throws IOException when the file could not be loaded
	 */
	public static String loadInternalResourceAsString(String path, Charset charset) throws IOException {
		InputStream stream = ResourceLoader.class.getResourceAsStream(path);
		if (stream == null)
			throw new IOException("Could not load resource \"" + path + "\". File not found.");

		return IOUtils.toString(stream, charset);
	}

	/**
	 * Loads an outer-jar file as a string.
	 *
	 * @param path the path to the file that will be loaded
	 * @param charset the charset of the string
	 * @return the loaded file as string
	 * @throws IOException when the file could not be loaded
	 */
	public static String loadExternalResourceAsString(String path, Charset charset) throws IOException {
		FileInputStream stream = new FileInputStream(path);
		return IOUtils.toString(stream, charset);
	}

}
