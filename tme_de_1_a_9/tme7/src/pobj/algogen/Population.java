package pobj.algogen;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Population implements IPopulation{

  /** liste d individu*/
  ArrayList<Individu> individus = new ArrayList<Individu>();
 
  /** la taille de la population*/
  //private int size = 0;
  
  public int size () {
         //return size;
         return individus.size();
  }
 /**ajouter un individu*/ 
  public void add (Individu individu) {
        individus.add(individu);
  }
  @Override
/** renvoie de la population*/
  public String toString() {
         return Arrays.toString(individus.toArray());
  }
  /** evaluer une population, */
  public void evaluer(Environnement cible){
	  for(int i =0;i<individus.size();i++){
		  individus.get(i).setFitness(cible.eval(individus.get(i)));
	  }
	  for(int i =0;i<individus.size();i++){
		  for(int j =i+1;j<individus.size();j++){
			  if(individus.get(i).compareTo(individus.get(j))<0){
				  Collections.swap(individus, i, j);
			  }
		  }		  
	  }
  }
  /**muter la population, avec une valeur en parametre*/
  public void muter(double m){
	  for(int i=0; i< individus.size(); i++)
	 individus.get(i).setFitness(individus.get(i).getFitness()+individus.get(i).getFitness()*m);
  }
  /**reproduire une population*/ 
  private Population reproduire(){
	  Random r = new Random();
	  /** evaluer la population dans l'environnement cible*/
	 Population nouvpop =new Population();
	 int taille20prcent = individus.size()/5;
	 /** recuperation et clonage des 20% individus  */
	 for(int i =0; i<taille20prcent;i++){
		 Individu i2 =individus.get(i).clone();
		 nouvpop.add(i2);
	 }
	 /** reproduction, croiser et muter les 80% individus*/
	 for(int j=0; j<individus.size()-taille20prcent; j++){
          Individu i1, i2, i3;
         
		 i1 = individus.get(r.nextInt(taille20prcent));		
		 i2 =individus.get(r.nextInt(taille20prcent));
		 i3=i1.croiser(i2);
		 i3.muter(); 
		 nouvpop.add(i3);
	 }
	 /** renvoie de la nouvelle generation*/
	 return nouvpop;
  }
 /**evolution d'une population dans un environnement*/ 
  public IPopulation evoluer(Environnement cible){
	  this.evaluer(cible);
	  Population pp = reproduire();
	  pp.evaluer(cible);
	  return pp;
  }

@Override
public Iterator<Individu> iterator() {
	return individus.iterator();
}
public Individu get(int i){
	return individus.get(i);
	}
}
