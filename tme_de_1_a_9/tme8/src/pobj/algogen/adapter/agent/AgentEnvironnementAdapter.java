package pobj.algogen.adapter.agent;

import agent.Simulation;
import agent.control.IControleur;
import agent.laby.Labyrinthe;
import pobj.algogen.Environnement;
import pobj.algogen.Individu;

public class AgentEnvironnementAdapter implements Environnement {
	
	private Labyrinthe laby=null;
	public int nbSteps =0;
	
	public AgentEnvironnementAdapter(Labyrinthe l, int nb){
		this.laby=l;
		this.nbSteps=nb;
	}
	
	@Override
	public double eval(Individu i) {
		IControleur ctrl= ((ControleurIndividuAdapter)i).getValeurPropre();
		Simulation s =new Simulation(laby.clone(),ctrl);
		
		return s.mesurePerf(nbSteps);
	}
}
