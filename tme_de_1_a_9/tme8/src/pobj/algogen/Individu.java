package pobj.algogen;

public interface Individu extends Comparable<Individu>{
/**
 * @param valeur propre de type Expression pour chaque individu*/
	//private Expression valeurPropre;

//	private double fitness = 0;
///** valeur propre aleatoire de individu*/	
//	public Individu(){
//		this(Expressionfactory.createRandomExpression());
//	}
///** constructeur avec parametre*/
//	public Individu(Expression in){
//		valeurPropre=in;
//	}
///** accesseur*/
//	public Expression getValeurPropre(){return valeurPropre;}
//
///** modificateur*/
//	public void setValeurPropre(Expression valeur){
//                   valeurPropre= valeur;
//	}
///**accesseur*/
//	public double getfitness(){return fitness;}
///**modificateur*/
//	public void setFitness(double fit){
//	 fitness = fit;
//	}
///** methode toString de individu*/
//	public String toString(){
//	 return "[ "+ valeurPropre +", " + fitness + "]";
//	}
///**methode compareTo*/
//	public int compareTo(Individu o){
//		if(this.getfitness()>o.getfitness()){
//		return 1;
//		}else if(this.getfitness()<o.getfitness()){
//			return -1;
//			}else{ 
//				return 0;
//			}
//	}
///**croiser l'objet courant, l individu, avec l objet (individu) passé en paramettre */	
//	public Individu croiser(Individu autre){
//		if(this.valeurPropre.equals(autre.valeurPropre)){
//			return new Individu(this.valeurPropre);
//		}
//		return new Individu(
//				 Expressionfactory.createOperateurbinaire(Operator.DIV,
//						 Expressionfactory.createOperateurbinaire(Operator.PLUS,
//								 this.getValeurPropre(),autre.getValeurPropre()),Expressionfactory.createConstant(2)).simplifier());
//	}
//	
///** muter l'objet courant avec 5%, changer sa valeur propre, et garder la meme fitness*/	
//	public void muter(){
//		this.valeurPropre = Expressionfactory.createRandomExpression();
//		this.fitness = getfitness();
//	}
///**cloner un individu, j ai choisi juste de doublé ses valeurs.*/	
//	public Individu clone(){
//		return new Individu(getValeurPropre());
//		}
	public void muter();
	public Individu croiser(Individu autre);
	public double getFitness();
	public void setFitness(double fit);
	public Individu clone();
}
