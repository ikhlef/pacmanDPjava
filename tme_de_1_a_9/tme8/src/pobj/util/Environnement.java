package pobj.util;

public interface Environnement {
	double valeurCible = Math.random();
	public double eval(Individu i);
}
