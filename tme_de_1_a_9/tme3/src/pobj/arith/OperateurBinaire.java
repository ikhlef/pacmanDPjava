package pobj.arith;

public class OperateurBinaire implements Expression {
	/**
	 *les variables
	 *@param type, type de l'operande
	 *@param left, right, operande gauche et droite
	 **/
	Operator type;
	private Expression left,right;
	/**
	 * constructeur
	 * */
	public OperateurBinaire (Operator op, Expression exp0, Expression exp1){
			type = op;
			left= exp0;
			right = exp1;	
	}
	/**renvoie l'expression gauche*/
public Expression getLeft(){
		return left;
		}
	/**renvoie l'expression droite*/
public Expression getRight(){
		return right;
	}
	/**renvoie le type*/
public Operator getType(){
		return type;
	}
	/**l'evaluation de l'expression */
	@Override
public double eval(EnvEval env) {

		switch (type){
		case PLUS :
					 return getLeft().eval(env) + getRight().eval(env);
		case DIV :
					 return getLeft().eval(env) / getRight().eval(env);
		case MINUS :
				     return getLeft().eval(env) - getRight().eval(env);
		case MULT :
			         return getLeft().eval(env) * getRight().eval(env);
		default :
				     System.out.println("blablablabla");
		
		}
		return 0;
	}
	/**
	 * affichage d'une expression 
	 */
	public String toString(){
		StringBuilder chaine = new StringBuilder( "("+ left);
			switch (type){
			case PLUS :
				chaine.append(" + ");
				break;
			case MINUS : 
				chaine.append(" - ");
				break;
			case MULT :
				chaine.append(" * ");
				break;
			default :
				chaine.append(" / ");
				break;			
			}
			
			chaine.append(right + ")");
		
		return chaine.toString();
	}
}
