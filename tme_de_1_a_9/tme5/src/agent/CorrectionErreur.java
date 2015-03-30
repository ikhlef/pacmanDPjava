package agent;

import java.io.IOException;
import exception.LabyErroneException;

import exception.VerificationLaby;

import agent.control.ControlFactory;
import agent.control.IControleur;
import agent.laby.ChargeurLabyrinthe;
import agent.laby.Labyrinthe;


public class CorrectionErreur {
	/**
	 * @param args[0] : nom du fichier contenant le labyrinthe
	 * @param args[1] : nombre de pas d'évaluation
	 * @param args[2] : nombre de règles par controleur
	 * @throws LabyErroneException 
	 * @throws IOException 
	 */
	public static void main(String[] args){
		
		String labyFile = "foufi.mze"; // args[0];
		String labyFile1 = "foufi1.mze";
		int nbSteps = 50; // Integer.parseInt(args[1]);
		int nbRules = 10; // Integer.parseInt(args[2]);
		try {
			int i;
			System.out.println("exemple erreur pour le fichier foufi");
			Labyrinthe laby = ChargeurLabyrinthe.chargerLabyrinthe(labyFile);
			i=VerificationLaby.corrigerLabyrinthe(laby);
			System.out.println("le nbre d'erreur est : " +i);
			ChargeurLabyrinthe.sauverLabyrinthe("fouficorrectionlaby.mze", laby);
			System.out.println("exemple erreur pour le fichier foufi1");
			Labyrinthe laby1 = ChargeurLabyrinthe.chargerLabyrinthe(labyFile1);
			i=VerificationLaby.corrigerLabyrinthe(laby1);
			System.out.println("le nbre d'erreur est : " +i);
			ChargeurLabyrinthe.sauverLabyrinthe("foufi1correctionlaby.mze", laby);
			
			IControleur sc = ControlFactory.createControleur(nbRules);
			Simulation sim = new Simulation(laby, sc);
			System.out.println(sim.mesurePerf(nbSteps));
			System.out.println(sc);
			

		} catch (IOException e) {
			System.out.println("Problème de chargement du labyrinthe"+e);
			System.exit(1);
		}catch (LabyErroneException e) {
			System.out.println("ops, y a des erreurs , tkt, je corrige"+e);
			e.printStackTrace();
		}
	}
}