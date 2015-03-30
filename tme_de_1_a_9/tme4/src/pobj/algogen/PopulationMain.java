package pobj.algogen;

public class PopulationMain{

	public static void main (String[] args){
	Population popu =  PopulationFactory.createRandompopulation(20);
	
		Environnement a = new ValeurCible();
		popu.evaluer_sans_tri(a);
		System.out.println("-----------------------------population sans tri---------------------------------------");
		System.out.println("la population des individus [valeurPropre, fitness] apres evaluation,sans tri decroissant par fitness ,  : " );
		System.out.println(popu.toString());
		System.out.println("");
		popu.evaluer(a);
		System.out.println("-----------------------------population avec tri decroissant---------------------------------------");
		System.out.println("la population des individus [valeurPropre, fitness] apres evaluation,tri decroissant par fitness ,  : " );
		System.out.println(popu.toString()); 
		System.out.println("");
		for (int i =1; i <=10; i++){
		System.out.println("-----------------------------population evoluer, generation  : " +i + "-----------------------------------");
		popu = popu.evoluer(a);
		System.out.println(popu);
		popu = popu.evoluer(a);
		}
	}
}
