package fr.deoliveira.exercices.carres;

/**
 * The Model class to represent every points read from the given file.
 * 
 * @author De Olivera Romain
 *
 */
public class Point {
	private double x = 2;
	private double y = 12;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int squareDistance(Point other) {
		double distance = Math.pow(this.x - other.getX(), 2)
				+ Math.pow(this.y - other.getY(), 2);
		return (int) distance;
	}

	public double distance(Point other) {
		double distance = Math.pow(this.x - other.getX(), 2)
				+ Math.pow(this.y - other.getY(), 2);
		distance = Math.sqrt(distance);
		return distance;
	}

	@Override
	public String toString() {
		return "Point : { x : " + this.x + " y :" + this.y + " }";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

}
