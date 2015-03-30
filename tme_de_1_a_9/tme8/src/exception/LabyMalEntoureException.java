package exception;

import java.awt.Point;


public class LabyMalEntoureException extends LabyErroneException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LabyMalEntoureException(Point p) {
		super(p,"labyrinthe mal entouré, le point doit representer un mur");
	}
}
