package pobj.algogen.adapter.arith;

import pobj.algogen.Environnement;
import pobj.algogen.IPopulation;
import pobj.algogen.Population;



public class PopulationFactory{
		
public static IPopulation createRandompopulation(int size){
	     Population pop = new Population() ;
		    for( int i=0; i<size; i++){
		        pop.add (new IndividuExpression());
		       }
  return pop;
}
public static Environnement createEnvironnement(){
	return new ValeurCible();
}
}
