package pobj.algogen.adapter.agent;

import java.io.IOException;
import pobj.algogen.Environnement;
import pobj.algogen.IPopulation;
import agent.laby.ChargeurLabyrinthe;
import agent.laby.Labyrinthe;
public class EvolutionAgentMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
			String labyFile = "goal.mze"; // nom du fichier, args[0];
			int taille_pop= 10; // la taille de popolation.
			int nbSteps = 100; // le nbre de pas,Integer.parseInt(args[1]);
			int nbRules = 10; // nbre de regles par controleur, Integer.parseInt(args[2]);
			int nbregeneration =10; // le nbre de genertion pour chaque evaluation.
			Labyrinthe laby = null; // environnement.
			try {	
				 laby = ChargeurLabyrinthe.chargerLabyrinthe(labyFile);
			} catch (IOException e) {
				System.out.println("Problème de chargement du labyrinthe"+e);
				System.exit(1);
			}
			System.out.println("j'utilise une population de taille : " + taille_pop);
			IPopulation pop = PopulationFactory.createRandomPopulation(taille_pop, nbRules );
			System.out.println(pop);
			System.out.println("evolution de la population : ");
			Environnement env = PopulationFactory.createEnvironnement(laby, nbSteps);
			
			for(int i=0;i<nbregeneration;i++){
				System.out.println("evolution de la generation : " +i);
				System.out.println(pop);
				pop.evoluer(env);
			}
			System.out.println("la meilleur Individu de la derniere generation est : " +pop.iterator().next());
	}

}
