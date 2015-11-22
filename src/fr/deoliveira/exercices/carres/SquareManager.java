package fr.deoliveira.exercices.carres;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * SquaraManager uses a feeder {@link #pointsFeeder} and calculate the number of
 * squares which can be formed by every combinaison of points.
 * 
 * @see PointsFeeder
 * @author De Oliveira Romain
 *
 */
public class SquareManager {

	private PointsFeeder pointsFeeder;
	// Set of squares already found.
	private Set<List<Point>> listeOfSquares;

	public SquareManager(PointsFeeder pointsFeeder) {
		this.pointsFeeder = pointsFeeder;
		this.listeOfSquares = new HashSet<>();
	}

	/**
	 * calculateSquares takes a set of points (given by feeder) and, for each
	 * combination of 2 points, check if the two others vertices for each two
	 * possibles squares are present in this set of points. If they are present,
	 * a square is found.
	 * 
	 * @see #createPossiblePoints(Point, Point, boolean)
	 * @see #verifyPoints(List)
	 */
	public void calculateSquares() {
		Set<Point> pointsSet = pointsFeeder.getListPoints();
		int size = pointsSet.size();
		System.out.println("Number of distinct points : " + size);
		Point[] pointArr = new Point[pointsSet.size()];
		pointsSet.toArray(pointArr);
		for (int i = 0; i < pointsSet.size() - 1; ++i) {
			for (int j = i + 1; j < pointsSet.size(); ++j) {
				Point ptfixe1 = pointArr[i];
				Point ptfixe2 = pointArr[j];
				List<Point> ptPositive = this.createPossiblePoints(ptfixe1, ptfixe2, true);
				List<Point> ptNegative = this.createPossiblePoints(ptfixe1, ptfixe2, false);
				this.verifyPoints(ptPositive);
				this.verifyPoints(ptNegative);
			}
		}
	}



	/**
	 * createPossiblePoints creates a List<Point> which is potentially a square
	 * (depending if the two not fixed points are effectively in the set of
	 * points given in the beginning.). The deduction of the two others points
	 * is done with the calculation of the perpendicular vector to the segment
	 * formed by pt1 and pt2.
	 * 
	 * @param pt1
	 *            the first fixed point.
	 * @param pt2
	 *            the second fixed point.
	 * @param positive
	 *            gives the direction of the vector.
	 * @return
	 */
	private List<Point> createPossiblePoints(Point pt1, Point pt2, boolean positive) {
		List<Point> possiblePts = new ArrayList<>();
		Point ptPossible1 = null, ptPossible2 = null;
		double vectorX = pt2.getY() - pt1.getY();
		double vectorY = -pt2.getX() + pt1.getX();
		if (positive) {
			ptPossible1 = new Point(pt1.getX() + vectorX, pt1.getY() + vectorY);
			ptPossible2 = new Point(pt2.getX() + vectorX, pt2.getY() + vectorY);
		} else {
			ptPossible1 = new Point(pt1.getX() - vectorX, pt1.getY() - vectorY);
			ptPossible2 = new Point(pt2.getX() - vectorX, pt2.getY() - vectorY);

		}
		possiblePts.add(ptPossible1);
		possiblePts.add(ptPossible2);
		possiblePts.add(pt1);
		possiblePts.add(pt2);
		return possiblePts;
	}

	/**
	 * verifyPoints checks if the points contained in the given list are present
	 * in the set of points given in the beginning. If the two first points are
	 * contained in the set (we are sure the 2 others are in), and the square
	 * formed by the 4 points is not already discovered, this new square is
	 * added to the {@link #listeOfSquares}
	 * 
	 * @param pts
	 *            list of points to check if present if the initial set of
	 *            points.
	 */
	private void verifyPoints(List<Point> pts) {
		Set<Point> allPoints = this.pointsFeeder.getListPoints();
		if (allPoints.contains(pts.get(0)) && allPoints.contains(pts.get(1))) {
			if (!this.isSquareAlreadyPresent(pts)) {
				this.listeOfSquares.add(pts);
			}
		}
	}

	/**
	 * isSquareAlreadyPresent checks if the square formed by the 4 points is not
	 * already discovered
	 * 
	 * @param pts
	 * @return
	 */
	private boolean isSquareAlreadyPresent(List<Point> pts) {
		for (List<Point> liste : this.listeOfSquares) {
			if (liste.containsAll(pts)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * getter for {@link #listeOfSquares}.size
	 * 
	 * @return the number of squares found in the set of points.
	 */
	public long getNumberOfSquares() {
		return listeOfSquares.size();
	}

}
