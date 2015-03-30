package pobj.algogen;

public abstract class AbstractIndividu implements Individu {
	private double fitness = 0.0;
	
	@Override
	public double getFitness() {
		return fitness;
	}

	@Override
	public void setFitness(double fit) {
		fitness=fit;
	}
	
	@Override
	public int compareTo(Individu o) {
		return Double.compare(getFitness(), o.getFitness());
	}
	@Override
	public abstract AbstractIndividu clone();

}
