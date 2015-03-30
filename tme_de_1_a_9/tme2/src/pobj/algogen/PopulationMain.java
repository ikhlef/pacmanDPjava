package pobj.algogen;

public class PopulationMain{

	public static void main (String[] args){
		System.out.println("-------------------------TME2-------------------------------------------");
		
		Chrono time5_TME2 = new Chrono();       // pour le temps total 
		Chrono time1_TME2 = new Chrono();		//  le temps de la creation (declaration + allocation) d'une ArrayList
		Population popTME2 = new Population();		
		popTME2 =  PopulationFactory.createRandompopulation(10); 
		System.out.print("le temps necessaire pour la creation (declartion + allocation) d'une population avec une ArrayList est :  ");
		time1_TME2.stop();
		
		Chrono time2_TME2 = new Chrono();     // le temps necessaire pour l'afficahge d'une population avec une ArrayList
		System.out.println("la population aleatoire est : " + popTME2);
		System.out.print("le temps necessaire pour l'affichage d'une population avec une ArrayList est :  ");
		time2_TME2.stop();
		
		Environnement env = new ValeurCible();
		
		System.out.println("");
		System.out.println("---------evaluation  + tri decroissant + evolution (10 generations) d'une population crée avec une ArrayList--------------");
			
		Chrono time3_TME2 = new Chrono(); // le temps necessaire pour evaluer tri decroissant et evoluer une population crée avec une ArrayList
		popTME2.evaluer(env);
		for (int i =1; i <=10; i++){
		popTME2 = popTME2.evoluer(env);
		}
		System.out.print("le temps necessaire pour evaluer, tri decroissant et evoluer une population avec une ArrayList est :  ");
		time3_TME2.stop();
		System.out.println(popTME2);
		System.out.print("le temps final d'une population avec une ArrayList est :  ");
		time5_TME2.stop();
		
		}
	}
