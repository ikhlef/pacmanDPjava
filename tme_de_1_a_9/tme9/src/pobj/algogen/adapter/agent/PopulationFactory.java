package pobj.algogen.adapter.agent;

import agent.laby.Labyrinthe;
import pobj.algogen.Environnement;
import pobj.algogen.IPopulation;
import pobj.algogen.Individu;
import pobj.algogen.Population;


public class PopulationFactory {

	public static IPopulation createRandomPopulation(int size,int nbrules ){
		Population pop=new Population();
		for(int i=0;i<size;i++){
			pop.add(createIndividu(nbrules));
		}
		return pop;
	}
	
	public static Individu createIndividu(int nbre){
		return new ControleurIndividuAdapter(nbre);
	}
	public static Environnement createEnvironnement(Labyrinthe la, int nbsteps){
		return new AgentEnvironnementAdapter(la,nbsteps);
	}
}
