package pobj.algogen.adapter.arith;

import pobj.algogen.AbstractIndividu;
import pobj.algogen.Individu;
import pobj.arith.Expression;
import pobj.arith.Expressionfactory;
import pobj.arith.Operator;

public class IndividuExpression extends AbstractIndividu implements Individu {
	private Expression valeurPropre;
	public IndividuExpression(){
		this(Expressionfactory.createRandomExpression());
	}
	public IndividuExpression(Expression e){
		valeurPropre=e;
	}
	public Expression getValeurPropre(){
		return valeurPropre;
	}
	public String toString(){
		return "valeurpropre =" + getValeurPropre() + ", fitness = " + getFitness();
	}
	public IndividuExpression croiser(Individu ind){
		return new IndividuExpression(Expressionfactory.createOperateurbinaire(Operator.DIV, 
				Expressionfactory.createOperateurbinaire(Operator.PLUS, getValeurPropre(), 
						((IndividuExpression)ind).getValeurPropre()),Expressionfactory.createConstant(2)).simplifier());
	}
	
	public void muter(){
		this.valeurPropre=Expressionfactory.createRandomExpression();
	}
	public IndividuExpression clone(){
		return new IndividuExpression(valeurPropre.clone());
	}
}
