package pobj.algogen;

public interface Individu extends Comparable<Individu>{
	public void muter();
	public Individu croiser(Individu autre);
	public double getFitness();
	public void setFitness(double fit);
	public Individu clone();
}
