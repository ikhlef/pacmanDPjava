package pobj.algogen;

import pobj.arith.EnvEval;
import pobj.arith.Expressionfactory;

public class ValeurCible implements Environnement {
	private double value;
	private EnvEval env;
/**constructeur sans parametre*/ 	
	public ValeurCible(){
		value = Math.random();
		env = Expressionfactory.createRandomEnvironment();
	}
/**evaluer un individu dans un environnement, 
 * renvoie la fitness*/	
	@Override
	public double eval(Individu i) {
		  double r1= i.getValeurPropre().eval(env);
		 return 1/((value -r1)*(value-r1));
	}
	/**accesseur*/
	public double getValue(){return value;}
	/**modificateur*/
	//public void setValue(double vale){value = vale;}

	public String toString(){
		return "je cherche la valeur : " + getValue();
	}	
}
