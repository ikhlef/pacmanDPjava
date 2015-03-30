package pobj.algogen;

public class ValeurCible implements Environnement {
	private double value;
/**constructeur sans parametre*/ 	
	public ValeurCible(){
		value = Math.random();
	}
	/** constructeur avec parametre*/
	public ValeurCible(double val){
		value = val;
	}
/**evaluer un individu dans un environnement, renvoie la fitness*/	
	@Override
	public double eval(Individu i) {
		 i.setFitness(1/(Math.pow(getValue() -i.getValeurPropre(),2)));
		 return i.getfitness();
	}
	/**accesseur*/
	public double getValue(){return value;}
	/**modificateur*/
	public void setValue(double vale){value = vale;}

	public String toString(){
		return "la valeur cible est " + getValue();
	}
	
}
