package pobj.algogen.adapter.agent;

import pobj.algogen.Environnement;
import pobj.algogen.Individu;
import agent.Simulation;
import agent.control.IControleur;
import agent.laby.Labyrinthe;

public class LabyEnvironnementAdapter implements Environnement {
private Labyrinthe laby=null;
private int nbSteps =0; 
public LabyEnvironnementAdapter(Labyrinthe l, int nb){
	laby=l;
	nbSteps=nb;
}
	@Override
	public double eval(Individu i) {
		IControleur ctrl= ((ControleurIndividuAdapter)i).getValeurPropre();
		Simulation s =new Simulation(laby.clone(),ctrl);
		
		return s.mesurePerf(nbSteps);
	}

}
