package pobj.algogen;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Population {

  /** liste d individu*/
  ArrayList<Individu> individus;
 
  /** la taille de la population*/
  @SuppressWarnings("unused")
private int size = 0;

  /** instancier une population*/
 public Population() {
         individus = new ArrayList<Individu>();  
  }
  
  public int size () {
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
/** methode supplementaire, juste pour mieux voir l'evaluation sans tri*/
  public void evaluer_sans_tri(Environnement cible){		 
	  for(int i =0;i<individus.size();i++){
		  individus.get(i).setFitness(cible.eval(individus.get(i)));
	  }
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
  @SuppressWarnings("unused")
private void muter(double m){
	  for(int i=0; i< individus.size(); i++)
	 individus.get(i).setFitness(individus.get(i).getfitness()+individus.get(i).getfitness()*m);
  }
  /**reproduire une population*/ 
  private Population reproduire(){
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
		 i1 = individus.get(new Random().nextInt(taille20prcent));		
		 i2 =individus.get(new Random().nextInt(taille20prcent));
		 i3=i1.croiser(i2);
		 i3.muter(); 
		 nouvpop.add(i3);
	 }
	 /** renvoie de la nouvelle generation*/
	 return nouvpop;
  }
 /**evolution d'une population dans un environnement*/ 
  public Population evoluer(Environnement cible){
	   this.evaluer(cible);
	  Population pp = new Population();
	  pp = reproduire();
	  return pp;
  }
}
