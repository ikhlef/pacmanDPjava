package pobj.algogen.adapter.arith;

import pobj.algogen.Environnement;
import pobj.algogen.Individu;
import pobj.arith.EnvEval;
import pobj.arith.Expressionfactory;
import pobj.util.Generateur;

public class ValeurCible implements Environnement {
	private double cible;
	private EnvEval env;

	/**constructeur sans parametre*/ 	
	public ValeurCible(){
		cible = Generateur.getGenerateur(0).getRandom().nextDouble();
		env = Expressionfactory.createRandomEnvironment();
	}
	
/**evaluer un individu dans un environnement, 
 * renvoie la fitness*/	
	@Override
	public double eval(Individu i) {
		  double r1= ((IndividuExpression)i).getValeurPropre().eval(env);
		 return 1/((cible -r1)*(cible-r1));
	}
	public String toString(){
		return "objectif f(" +env+")=" + cible;
	}	
}
