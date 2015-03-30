package exception;

import java.awt.Point;
import agent.laby.ContenuCase;
import agent.laby.Labyrinthe;


public class VerificationLaby {
	
	public static void verifierconditions(Labyrinthe l)throws LabyErroneException{
		estCaseInitialevide(l);
		estEntoureDeMurs(l);
	}
	
	/** verifier si la case depart est bien vide, sinon lever une exception*/
	public static void estCaseInitialevide(Labyrinthe l)throws CaseDepartNonVideException{
		Point p = l.getPositionInitiale();
		if (l.getContenuCase(p) != ContenuCase.VIDE)
			throw new CaseDepartNonVideException(p);
	}
	
    public static void estEntoureDeMurs(Labyrinthe l)throws LabyMalEntoureException{
    	Point p = l.estEntoureDeMurs();
		if (p != null)
			throw new LabyMalEntoureException(p);
	}
   
    public static int corrigerLabyrinthe(Labyrinthe l) throws LabyErroneException{
    	int nbrerr = 0;
	 while(true){
		 
		try{
			verifierconditions(l);
			 return  nbrerr;
		}catch(CaseDepartNonVideException e){
			nbrerr++;
			l.setContenuCase(e.getPoint(), ContenuCase.VIDE);
			System.out.println(e.getPoint());
		}catch(LabyMalEntoureException e){
			nbrerr++;
			l.setContenuCase(e.getPoint(), ContenuCase.MUR);
			System.out.println(e.getPoint());
		} 
	}
 }
}
