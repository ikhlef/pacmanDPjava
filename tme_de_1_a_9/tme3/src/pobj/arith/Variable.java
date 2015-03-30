package pobj.arith;

public class Variable implements Expression {
    /**
     *  rang de la variable dans la liste 
     */
	private int rang;
	/**
	 * constructeur
	 */
	public Variable (int a){
		rang = a;
	}
	
	@Override
	public double eval(EnvEval env) {
		return env.getValue(rang) ;
	}
	
	public String toString(){
		return "X" + rang;
	}
}
