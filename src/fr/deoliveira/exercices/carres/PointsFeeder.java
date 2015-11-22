package fr.deoliveira.exercices.carres;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashSet;
import java.util.Set;

/**
 * PointsFeeder allows to retrieve every points contained in a file given by its
 * filePath.
 * 
 * @author De Oliveira Romain
 *
 */
public class PointsFeeder {

	// A set to be sure that there is no duplicated points.
	private Set<Point> listPoints;
	// The path to the given file to read points from.
	private String filePath;

	public PointsFeeder(String filePath) {
		this.filePath = filePath;
		this.listPoints = new HashSet<>();
	}

	/**
	 * readFromFile reads file given by {@link #filePath}
	 * 
	 * @return <true> if file well read, <false> if error occurs.
	 */
	public boolean readFromFile() {
		try (FileReader fr = new FileReader(this.filePath); LineNumberReader lr = new LineNumberReader(fr)) {
			String ligne = null;
			while ((ligne = lr.readLine()) != null) {
				try {
					readPoint(ligne, lr.getLineNumber());
				} catch (MalFormedPointException e) {
					System.err.println(e.getMessage());
					e.printStackTrace();
					return false;
				} catch (NumberFormatException e1) {
					System.err.println(e1.getMessage());
					e1.printStackTrace();
					return false;
				}
			}
			return true;
		} catch (FileNotFoundException e) {
			System.err.println("File not found ... " + e.getMessage());
			e.printStackTrace();
			return false;
		} catch (IOException e1) {
			System.err.println("Error closing file ... " + e1.getMessage());
			e1.printStackTrace();
			return false;
		}

	}

	/**
	 * readPoint reads a specific line of file and if succeed adds this line to
	 * {@link #listPoints}
	 * 
	 * @param line
	 *            the line to read
	 * @param lineNumber
	 *            the number of the read line.
	 * @throws MalFormedPointException
	 *             if a line is not well formed.
	 */
	private void readPoint(String line, int lineNumber) throws MalFormedPointException {
		String[] splited = line.split("\\s+");
		if (splited.length != 2) {
			throw new MalFormedPointException("The line " + lineNumber + " Doesn't contains valid Point");
		}
		String nb1 = splited[0];
		String nb2 = splited[1];
		if (nb1 == null || nb1.isEmpty() || nb2 == null || nb2.isEmpty()) {
			throw new MalFormedPointException("The line " + lineNumber + " Doesn't contains valid Point");
		}
		int x = Integer.parseInt(nb1);
		int y = Integer.parseInt(nb2);
		this.listPoints.add(new Point(x, y));
	}

	/**
	 * getter for {@link #listPoints}
	 * 
	 * @return {@link #listPoints}
	 */
	public Set<Point> getListPoints() {
		return listPoints;
	}
}
