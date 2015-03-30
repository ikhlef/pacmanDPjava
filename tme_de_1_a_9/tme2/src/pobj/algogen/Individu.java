package pobj.algogen;
import java.util.*;

public class Individu implements Comparable<Individu>{
/**valeur propre pour chaque individu*/
	private double valeurPropre;

	private double fitness = 0;
/** valeur propre aleatoire de individu*/	
	public Individu(){
		Random r = new Random();
		valeurPropre = r.nextInt(100);
	}
/** constructeur avec parametre*/
	public Individu(double in){
		valeurPropre=in;
	}
/** accesseur*/
	public double getValeurPropre(){return valeurPropre;}

/** modificateur*/
	public void setValeurPropre(double valeur){
                   valeurPropre= valeur;
	}
/**accesseur*/
	public double getfitness(){return fitness;}
/**modificateur*/
	public void setFitness(double fit){
	 fitness = fit;
	}
/** methode toString de individu*/
	public String toString(){
	 return "[ "+ valeurPropre +", " + fitness + "]";
	}
/**methode compareTo*/
	public int compareTo(Individu o){
		if(this.getfitness()>o.getfitness()){
		return 1;
		}else if(this.getfitness()<o.getfitness()){
			return -1;
			}else{ 
				return 0;
			}
	}
/**croiser l'objet courant, l individu, avec l objet (individu) passé en paramettre */	
	public Individu croiser(Individu autre){
		Individu nouvelIndividu = new Individu((this.getValeurPropre()+autre.getValeurPropre())/2);
		nouvelIndividu.fitness=this.getfitness();
		return nouvelIndividu;
	}
/** muter l'objet courant avec 5%, changer sa valeur propre, et garder la meme fitness*/	
	public void muter(){
		this.valeurPropre = getValeurPropre() * 1.05;
		this.fitness = getfitness();
	}
/**cloner un individu, j ai choisi juste de doublé ses valeurs.*/	
	public Individu clone(){
		
		return new Individu(valeurPropre) ;
		}
}
