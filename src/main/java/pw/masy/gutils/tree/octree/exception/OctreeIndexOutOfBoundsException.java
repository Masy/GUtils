package pw.masy.gutils.tree.octree.exception;

/**
 * Class representing an exception that gets thrown when a given coordinate is not inside the current octant.
 */
public class OctreeIndexOutOfBoundsException extends RuntimeException {

	/**
	 * Constructs a new index out of bounds exception
	 *
	 * @param message the message of the exception
	 */
	public OctreeIndexOutOfBoundsException(String message) {
		super(message);
	}

}
