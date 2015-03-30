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
//		int imax = l.Xsize()-1;
//		int jmax = l.Ysize()-1;
//		for(int i=0; i<imax;i++){
//			Point p=new Point(i,0);
//			if(l.getContenuCase(p)!=ContenuCase.VIDE)
//				throw new LabyMalEntoureException(p);
//			p.y = jmax;
//			if(l.getContenuCase(p)!=ContenuCase.VIDE)
//				throw new LabyMalEntoureException(p);
//		}
//		for(int j=0; j<imax;j++){
//			Point p=new Point(imax,j);
//			if(l.getContenuCase(p)!=ContenuCase.VIDE)
//				throw new LabyMalEntoureException(p);
//			p.x = 0;
//			if(l.getContenuCase(p)!=ContenuCase.VIDE)
//				throw new LabyMalEntoureException(p);
//		}

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
