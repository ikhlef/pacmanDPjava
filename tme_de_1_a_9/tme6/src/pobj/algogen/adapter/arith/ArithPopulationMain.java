package pobj.algogen.adapter.arith;

import pobj.algogen.Environnement;
import pobj.algogen.IPopulation;

public class ArithPopulationMain {
	public static void main(String[] args) {
	
		int taille_pop = 10;
		IPopulation pop = PopulationFactory.createRandompopulation(taille_pop);
		System.out.println("evoluer la population pop ");
		
		Environnement env= PopulationFactory.createEnvironnement();
		for(int i=0;i<10;i++){
			System.out.println("generation : " + i);
			System.out.println(pop);
			pop=pop.evoluer(env);	
		}
		System.out.println();
		System.out.println("resultat pop finale est : " + pop);
	}
}