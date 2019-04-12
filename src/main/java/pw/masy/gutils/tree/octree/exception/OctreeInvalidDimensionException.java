package pw.masy.gutils.tree.octree.exception;

/**
 * Class representing an exception that gets thrown when an octree is constructed with invalid dimensions.
 */
public class OctreeInvalidDimensionException extends RuntimeException {

	/**
	 * Constructs a new invalid dimension exception.
	 *
	 * @param message the message of the exception
	 */
	public OctreeInvalidDimensionException(String message) {
		super(message);
	}

}
