package pw.masy.gutils.noise;

import java.util.Random;
import pw.masy.gutils.math.Vec2d;
import pw.masy.gutils.math.Vec3d;

/**
 * Voronoi noise in java.
 */
public class VoronoiNoise {

	private OpenSimplexNoise simplexNoiseX;
	private OpenSimplexNoise simplexNoiseY;
	private ValueNoise valueNoise;
	private final Vec2d cellOffset;

	/**
	 * Constructs a new voronoi noise instance
	 *
	 * @param seed the 64 bit seed of the voronoi noise
	 */
	public VoronoiNoise(long seed) {
		this.simplexNoiseX = new OpenSimplexNoise(seed);
		this.simplexNoiseY = new OpenSimplexNoise(new Random(seed).nextLong());
		this.valueNoise = new ValueNoise(seed);
		this.cellOffset = new Vec2d();
	}

	/**
	 * Evaluates the closest cell to the given coordinates.
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param gridSize the size of the grid in which the cells are arranged
	 * @param maxCellOffset the maximum offset a cell can have from the grid
	 * @param distanceScale the factor by which the distance noise will be scaled
	 * @param storage the {@link Vec2d} where the coordinates of the closest cell will be stored in
	 * @return the coordinates of the closest cell as {@link Vec2d}
	 */
	public Vec2d eval(double x, double y, double gridSize, double maxCellOffset, double distanceScale, Vec2d storage) {
		double gridX = Math.floor(x / gridSize);
		double gridZ = Math.floor(y / gridSize);

		double minDistToCell = Double.MAX_VALUE;

		// Multiply the coordinates with a "random" number because if x + y = 0 the resulting noise will be 0 as well
		// This prevents the algorithm returning 0 if y is equal to -x
		double noiseX = (this.simplexNoiseX.eval(x * distanceScale * 8329.873461221, y * distanceScale * 146563.81237577) + 1) / 2;
		double noiseY = (this.simplexNoiseY.eval(x * distanceScale * 8329.873461221, y * distanceScale * 146563.81237577) + 1) / 2;

		double closestX = 0;
		double closestY = 0;

		for (double currX = gridX - 1; currX <= gridX + 1; currX++) {
			for (double currY = gridZ - 1; currY <= gridZ + 1; currY++) {
				// Same reason as above
				this.valueNoise.eval2d2d(currX + 166861.871251, currY + 268979951.981726, this.cellOffset);
				double xPos = (currX * gridSize) + (this.cellOffset.x * maxCellOffset);
				double yPos = (currY * gridSize) + (this.cellOffset.y * maxCellOffset);
				double xDist = xPos - x;
				double yDist = yPos - y;
				// No sqrt because the actual distance is irrelevant
				double distance = (xDist * xDist * noiseX + yDist * yDist * noiseY);
				if (distance < minDistToCell) {
					minDistToCell = distance;
					closestX = xPos;
					closestY = yPos;
				}

			}
		}

		return storage.set(closestX, closestY);
	}

	/**
	 * Evaluates the closest cell to the given coordinates.
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param gridSize the size of the grid in which the cells are arranged
	 * @param maxCellOffset the maximum offset a cell can have from the grid
	 * @param distanceScale the factor by which the distance noise will be scaled
	 * @return the coordinates of the closest cell as {@link Vec2d}
	 */
	public Vec2d eval(double x, double y, double gridSize, double maxCellOffset, double distanceScale) {
		return this.eval(x, y, gridSize, maxCellOffset, distanceScale, new Vec2d());
	}

	/**
	 * Evaluates the closest cell to the given coordinates and the distance to the closest border.
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param gridSize the size of the grid in which the cells are arranged
	 * @param maxCellOffset the maximum offset a cell can have from the grid
	 * @param distanceScale the factor by which the distance noise will be scaled
	 * @param storage the {@link Vec3d} where the coordinates of the closest cell and the distance to the closest border will be stored in
	 * @return the coordinates of the closest cell and the distance to the closest border as {@link Vec3d}
	 */
	public Vec3d evalWithDistance(double x, double y, double gridSize, double maxCellOffset, double distanceScale, Vec3d storage) {
		double gridX = Math.floor(x / gridSize);
		double gridY = Math.floor(y / gridSize);

		double minDistToCell = Double.MAX_VALUE;

		double closestX = 0;
		double closestY = 0;
		double toClosestCellX = 0;
		double toClosestCellY = 0;

		// Multiply the coordinates with a "random" number because if x + y = 0 the resulting noise will be 0 as well
		// This prevents the algorithm returning 0 if y is equal to -x
		double noiseX = (this.simplexNoiseX.eval(x * distanceScale * 832.873461221, y * distanceScale * 146563.81237577) + 1) / 2;
		double noiseY = (this.simplexNoiseY.eval(x * distanceScale * 832.873461221, y * distanceScale * 146563.81237577) + 1) / 2;

		double[] xOffsets = new double[9];
		double[] yOffsets = new double[9];

		int index = 0;
		for (double currX = gridX - 1; currX <= gridX + 1; currX++) {
			for (double currY = gridY - 1; currY <= gridY + 1; currY++) {
				// Same reason as above
				this.valueNoise.eval2d2d(currX + 166861.871251, currY + 268979951.981726, this.cellOffset);
				xOffsets[index] = this.cellOffset.x * maxCellOffset;
				yOffsets[index++] = this.cellOffset.y * maxCellOffset;
				double xPos = (currX * gridSize) + (this.cellOffset.x * maxCellOffset);
				double yPos = (currY * gridSize) + (this.cellOffset.y * maxCellOffset);
				double xDist = xPos - x;
				double yDist = yPos - y;
				// No sqrt because the actual distance is irrelevant
				double distance = (xDist * xDist * noiseX + yDist * yDist * noiseY);
				if (distance < minDistToCell) {
					minDistToCell = distance;
					closestX = xPos;
					closestY = yPos;
					toClosestCellX = xDist;
					toClosestCellY = yDist;
				}
			}
		}

		double minEdgeDistance = Double.MAX_VALUE;
		index = 0;

		for (double currX = gridX - 1; currX <= gridX + 1; currX++) {
			for (double currY = gridY - 1; currY <= gridY + 1; currY++) {
				double xPos = currX + xOffsets[index];
				double yPos = currY + yOffsets[index++];
				double xDist = xPos - x;
				double yDist = yPos - y;

				double diffX = closestX - xPos;
				double diffY = closestY - yPos;
				boolean isClosestCell = (diffX + diffY) < 0.0001;

				if (!isClosestCell) {
					double toCenterX = (xDist + toClosestCellX) * 0.5;
					double toCenterY = (yDist + toClosestCellY) * 0.5;
					double cellDiffX = xDist - toClosestCellX;
					double cellDiffY = yDist - toClosestCellY;
					double length = Math.sqrt(cellDiffX * cellDiffX * noiseX + cellDiffY * cellDiffY * noiseY);
					cellDiffX /= length;
					cellDiffY /= length;

					double edgeDistance = Math.abs(toCenterX * cellDiffX * noiseX + toCenterY * cellDiffY * noiseY);
					if (edgeDistance < minEdgeDistance) minEdgeDistance = edgeDistance;
				}
			}
		}

		return storage.set(closestX, closestY, minEdgeDistance);
	}

	/**
	 * Evaluates the closest cell to the given coordinates and the distance to the closest border.
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param gridSize the size of the grid in which the cells are arranged
	 * @param maxCellOffset the maximum offset a cell can have from the grid
	 * @param distanceScale the factor by which the distance noise will be scaled
	 * @return the coordinates of the closest cell and the distance to the closest border as {@link Vec3d}
	 */
	public Vec3d evalWithDistance(double x, double y, double gridSize, double maxCellOffset, double distanceScale) {
		return this.evalWithDistance(x, y, gridSize, maxCellOffset, distanceScale, new Vec3d());
	}

}
