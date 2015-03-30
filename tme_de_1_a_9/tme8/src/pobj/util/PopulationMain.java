package pobj.util;

public class PopulationMain{

	public static void main (String[] args){
	
	System.out.println("-------------------------TME8-------------------------------------------");
	
	Chrono time5_TME8 = new Chrono();       // pour le temps total 
	Chrono time1_TME8 = new Chrono();		//  le temps de la creation (declaration + allocation) d'une linkedlist
	Population popu = new Population();		
	popu =  PopulationFactory.createRandompopulation(500); 
	System.out.print("le temps necessaire pour la creation (declartion + allocation) d'une population avec une Linkedlist est :  ");
	time1_TME8.stop();
	
	Chrono time2_TME8 = new Chrono();     // le temps necessaire pour l'afficahge d'une population avec une linkedlist
	System.out.println("la population aleatoire est : " + popu);
	System.out.print("le temps necessaire pour l'affichage d'une population avec une Linkedlist est :  ");
	time2_TME8.stop();
	
	System.out.println("la valeur cible de l environnement est : " + Environnement.valeurCible);
	Environnement env = new ValeurCible();
	System.out.println("");
	System.out.println("---------evaluation  + tri decroissant + evolution (10 generations) d'une population crée avec une MyrrayList LinkedList (liste chainée)--------------");
		
	Chrono time3_TME8 = new Chrono(); // le temps necessaire pour evaluer tri decroissant et evoluer une population crée avec une linkedlist
	popu.evaluer(env);
	for (int i =1; i <=10; i++){
	popu = popu.evoluer(env);
	}
	System.out.print("le temps necessaire pour evaluer, tri decroissant et evoluer une population avec une Linkedlist est :  ");
	time3_TME8.stop();
	System.out.println(popu.toString());
	System.out.print("le temps final d'une population avec une Linkedlist est :  ");
	time5_TME8.stop();
	

	}
}
