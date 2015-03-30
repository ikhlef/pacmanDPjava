package exception;

import java.awt.Point;


public class CaseDepartNonVideException extends LabyErroneException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CaseDepartNonVideException(Point p) {
		super(p, "la case depart de labyrinthe doit etre vide.merci");
		// TODO Auto-generated constructor stub
	}

}
