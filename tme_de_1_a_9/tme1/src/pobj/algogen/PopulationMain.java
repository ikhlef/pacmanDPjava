package pobj.algogen;

public class PopulationMain{

	public static void main (String[] args){
			int i = 10; 	
		System.out.println("le nombre d'individu a creer est : " + i);
	System.out.println("la population aleatoire est : " + PopulationFactory.createRandompopulation(i).toString()); 
       }
}
