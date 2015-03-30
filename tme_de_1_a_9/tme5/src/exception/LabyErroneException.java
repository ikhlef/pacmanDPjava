package exception;

import java.awt.Point;

public class LabyErroneException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Point point;
	public LabyErroneException (Point p, String message){
		super (message);
		point = p;
	}
	public Point getPoint(){
		return point;
	}
}
