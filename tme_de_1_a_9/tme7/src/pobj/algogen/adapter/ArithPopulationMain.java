package pobj.algogen.adapter;

import pobj.algogen.Environnement;
import pobj.algogen.IPopulation;
import pobj.algogen.adapter.arith.PopulationFactory;
import pobj.algogen.adapter.arith.ValeurCible;

public class ArithPopulationMain {
	public static void main(String[] args) {
	
		int taille_pop = 20;
		System.out.println("j'utilise une population de taille : " + taille_pop);
		IPopulation pop = PopulationFactory.createRandompopulation(taille_pop);
		System.out.println("evoluer la population pop ");
		Environnement env= new ValeurCible();
		
		for(int i=0;i<10;i++){
			System.out.println("generation : " + i);
			System.out.println(pop);
			pop=pop.evoluer(env);	
		}
		System.out.println();
		System.out.println("resultat pop finale est : " + pop);
	}
}