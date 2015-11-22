package fr.deoliveira.exercices.carres;

public class SquareSearch {

	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		if (args.length != 0) {
			System.out.println("Start searching for squares ...");
			System.out.println("File to load :" + args[0]);
			PointsFeeder fp = new PointsFeeder(args[0]);
			if (fp.readFromFile()) {
				SquareManager sm = new SquareManager(fp);
				sm.calculateSquares();
				System.out.println("Number of squares found: " + sm.getNumberOfSquares());
				long end = System.currentTimeMillis() - begin;
				System.out.println("Time elapsed : " + end + " Ms");
				System.out.println("End of search.");
			} else {
				System.out.println("Search canceled.");
			}
		} else {
			System.err.println("Incorrect number of arguments. Usage : SquareSearch <FilePath>");
		}

	}
}
