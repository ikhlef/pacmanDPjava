package pobj.arith;

import java.util.Arrays;

public class EnvEval {
	
	private double variables[];
	
	public EnvEval(int taille){
		variables = new double[taille];
	}
	
	public void setVariable(int indexVariable, double nouvellevaleur){
		variables[indexVariable] =nouvellevaleur;
	}
	@Override
	public String toString(){
		return Arrays.toString(variables);
	}
	
	public double getValue(int indexVariable){
		return variables[indexVariable];
	}
}
