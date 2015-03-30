package pobj.algogen;
import java.util.Arrays;
import java.util.ArrayList;

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
}
