package pobj.arith;

import java.util.Random;

public class Expressionfactory {
	
	private static int MAXVARIABLE = 2;
	private static Random generateur= new Random();
	/**
	 * Un constructeur pour des expressions binaires usuelles: +,-,*,/
	 * @param op le type de l'opérande, {@link Operator}, PLUS,MOINS,MULT,DIV
	 * @param left operande gauche
	 * @param right operande droite
	 * @return une expression binaire
	 */

	public static Expression createOperateurbinaire(Operator op, Expression ex, Expression exp){
			return new OperateurBinaire(op,ex,exp);
	}
	/**
	 * Un constructeur d'expressions constantes.
	 * @param constant sa valeur
	 * @return une constante
	 */
	public static Expression createConstant(double constant){
		return new Constante(constant);
	}
	/**
	 * Un constructeur de variables, identifiées par un entier compris entre 0 et MAXVARIABLES.
	 * La demande de création de variables d'indice plus grand entraine un accroissement de
	 * MAXVARIABLE (attribut static).
	 * @param id l'indice de la variable
	 * @return une Variable
	 */
	public static Expression createVariable(int id){
		if(id > MAXVARIABLE)
			MAXVARIABLE+= 1;
		return new Variable(id);
	}
	
	
	public static Expression createRandomExpression(){
		return createRandomExpression(3);
	}
	
	/**
	 * creation d'une expression aleatoire avec limitation de la profondeur
	 * @param profondeur
	 * */
	public static Expression createRandomExpression(int profondeur){
		int type =0;
		if(profondeur == 0){
			type= generateur.nextInt(2);
		}else{
			type= generateur.nextInt(3);
			}
		switch(type){
		case 0:
			return createVariable(generateur.nextInt(MAXVARIABLE));
		case 1 : 
			return createConstant(generateur.nextDouble());
		default :
			Expression left = createRandomExpression(profondeur-1);
			Expression right = createRandomExpression(profondeur-1);
			
			return createOperateurbinaire(Operator.values()[type],left,right);
		}
	}
	
	/**
	 * Génère un environnement d'évaluation aléatoire, en supposant qu'il n'y
	 * a pas plus de MAXVARIABLES.
	 * @return Un environnement généré aléatoirement.
	 */

	public static EnvEval createRandomEnvironment(){
		EnvEval env = new EnvEval( MAXVARIABLE);
		for(int i=0;i< MAXVARIABLE; i++)
			env.setVariable(i, generateur.nextDouble());
		return env;
		
	}
}
