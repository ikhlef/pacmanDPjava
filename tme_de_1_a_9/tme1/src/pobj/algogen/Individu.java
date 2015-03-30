package pobj.algogen;
import java.util.*;
public class Individu {
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
	
	
}
