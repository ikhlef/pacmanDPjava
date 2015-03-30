package agent;

import java.awt.Point;
import java.io.IOException;
import exception.LabyErroneException;

import agent.control.ControlFactory;
import agent.control.IControleur;
import agent.laby.ChargeurLabyrinthe;
import agent.laby.Labyrinthe;

/**
 * Classe principale pour tester le comportement des agents dans
 *         le labyrinthe.
 *  @author sigaud 
 */
public class SimuMain {

	/**
	 * @param args[0] : nom du fichier contenant le labyrinthe
	 * @param args[1] : nombre de pas d'évaluation
	 * @param args[2] : nombre de règles par controleur
	 * @throws LabyErroneException 
	 * @throws IOException 
	 */
	public static void main(String[] args){
		
		String labyFile = "goal.mze"; // args[0];
		int nbSteps = 50; // Integer.parseInt(args[1]); le nbre de pas,
		int nbRules = 10; // Integer.parseInt(args[2]); le nbre de regles,
		try {	
			Labyrinthe laby = ChargeurLabyrinthe.chargerLabyrinthe(labyFile);
			IControleur sc = ControlFactory.createControleur(nbRules);
			Simulation sim = new Simulation(laby, sc);
			System.out.println(laby.toString());
			System.out.println("");
			sim.setAgent( new Agent(sc, new Point(7,5)));
			for(int d=0;d<5;d++){
				sim.mesurePerf (nbSteps);
				System.out.println(sim.getLaby().toString());
				System.out.println("\n");
				System.out.println(sim.getScore());
			}
			//System.out.println(sim.mesurePerf(nbSteps));
			System.out.println(sim.mesurePerf(20));    // le nbre de case libre est de 12
			System.out.println(sc);
			

		} catch (IOException e) {
			System.out.println("Problème de chargement du labyrinthe"+e);
			System.exit(1);
		}
	}
}
