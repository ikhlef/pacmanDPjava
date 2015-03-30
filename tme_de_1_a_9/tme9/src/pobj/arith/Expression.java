package pobj.arith;

public interface Expression {
	public double eval(EnvEval env); 
	public Expression clone();
	public Expression simplifier();
}
