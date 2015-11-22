package fr.deoliveira.exercices.carres;

/**
 * MalFormedPointException is a custom Exception thrown during reading a file
 * which contains points.
 * 
 * @see Exception
 * @see PointsFeeder
 * @author De Oliveira Romain
 *
 */
public class MalFormedPointException extends Exception {

	private static final long serialVersionUID = 506285743284741596L;

	public MalFormedPointException(String message) {
		super(message);
	}

}
