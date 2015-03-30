package pobj.algogen.adapter.agent;

import pobj.algogen.Environnement;
import pobj.algogen.Individu;
import agent.laby.Labyrinthe;

public class LabyEnvironnementAdapter implements Environnement {
@SuppressWarnings("unused")
private Labyrinthe laby=null;
@SuppressWarnings("unused")
private int nbSteps =0; 
public LabyEnvironnementAdapter(Labyrinthe l, int nb){
	laby=l;
	nbSteps=nb;
}
	@Override
	public double eval(Individu i) {
		return 0;
	}
}
