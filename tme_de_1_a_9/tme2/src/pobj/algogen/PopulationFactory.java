package pobj.algogen;


public class PopulationFactory{
		
public static Population createRandompopulation(int size){
	     Population pop = new Population() ;
		    for( int i=0; i<size; i++){
		        pop.add (new Individu());
		       }
  return pop;
}
}
