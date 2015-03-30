package pobj.arith;

public class Constante implements Expression {
	/**
	 * valeur de la constante
	 */
	private double value;
	/**constructeur avec une valeur en parametre*/
	public Constante(double val){
		value = Double.valueOf(val);
	}
	/**renvoie la valeur de la constante*/
	public double getValue(){
		return value;
	}
	/**la methode toString de l'objet courant*/
	
	public String tostring(){
		
		String a= String.valueOf(getValue());
		return a;
	}
	@Override
	/**la methode d'evaluation de l'objet dans un envieronnement,
	 *  elle renvoie toujours la valeur de la constante qul que soit l'environnement*/
	public double eval(EnvEval env) {
		return getValue();
	}
}
