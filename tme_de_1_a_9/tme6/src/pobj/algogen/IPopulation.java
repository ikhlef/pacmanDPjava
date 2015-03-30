package pobj.algogen;

public interface IPopulation extends Iterable<Individu> {
	
	public abstract IPopulation evoluer(Environnement cible);
	
	public void add(Individu individu);
}
