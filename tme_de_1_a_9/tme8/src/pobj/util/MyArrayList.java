package pobj.util;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class MyArrayList<T extends Comparable<T>> extends java.util.AbstractList<T> implements Iterable<T>{
	
	private static int tailleMAX =5;

	private LinkedList<Vector<T>> list;

	public  MyArrayList(){
		list= new LinkedList< Vector<T> >();
	}
	
	public MyArrayList(int t){
		tailleMAX = t;
		//Vector<T> v = new Vector<T>(tailleMAX); 
		
		list = new LinkedList<Vector<T>>();
	}
	@SuppressWarnings("unchecked")
	public MyArrayList(Collection<T> c){
		list = new LinkedList<Vector<T>>();
		for(int i=0; i< c.toArray().length; i++){
			 this.add((T)c.toArray()[i]);
			 
		}
	}
	/**
	 * ajout d'un objet de type T a la liste
	 */
	public boolean add(T object){	
		if(list.isEmpty()){
			Vector<T> v = new Vector<T>(tailleMAX);
			v.add(object);
			return list.add(v);
		}else if(list.getLast().size()==tailleMAX){
				Vector<T> v = new Vector<T>(tailleMAX);
				v.add(object);
				return list.add(v);
			}else{
				return list.getLast().add(object);
			}
		}

	/**renvoie de l'element a la position location dans la liste*/
	public T get(int location){
		return list.get(location/tailleMAX).get(location % tailleMAX) ;
	}
	/**remplacer l'objet a la position location pas l'objet passé en parametre*/
	public T set(int location, T object){ 
		return list.get(location/tailleMAX).set(location % tailleMAX, object) ;
	}
	/**renvoie la taille de la liste chainée*/
	public int size(){ 
		int size=0;
		for(int i=0; i<list.size(); i++){
			size+=list.get(i).size();
		}
		return size;
	}
	/**accesseur, renvoie la liste chainée*/
	public LinkedList<Vector<T>> getList() {
		return list;
	}
	/**modficateur, remplacer la liste par la liste passé en parametre*/
	public void setList(LinkedList<Vector<T>> list) {
		this.list = list;
	}
	/**renvoie la chaine de caractere de la liste*/
	public String toString(){
		return list.toString();
	}
	/**un iterator sur la MyArrayList*/
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new MyIterator<T>(list);
		
	}
}
	/*
	 * la classe MyIterator definie les deux iterateurs de MyArrayList, un iterateur sur la liste, 
	 * et un autre iterateur sur chaque elements de la liste, c est a dire sur les elements de chaque Vector
	 */
	class MyIterator<T> implements Iterator<T>{   //implements ListIterator<T>
	/**iterateur sur la liste globale de MyArrayList*/
		private Iterator<Vector<T>> listIT ;
	/**iterateur sur chaque vecteur local de la liste*/	
		private Iterator<T> vectIT ;
		
		public MyIterator(List<Vector<T>> it){
			listIT = (Iterator<Vector<T>>)it.iterator();
			vectIT = (Iterator<T>) Collections.EMPTY_LIST.iterator();
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (listIT.hasNext() || vectIT.hasNext());
		}
		@Override
		public T next() {
			if( !vectIT.hasNext()){	
				vectIT=listIT.next().iterator();
			}else {
				return vectIT.next();
			}
			 return vectIT.next();
		}
		
		
		
		
		@Override
		public void remove() throws UnsupportedOperationException {
			// TODO Auto-generated method stub	
		}
	
	
	public Iterator<Vector<T>> getListIT() {
		return listIT;
	}
	
	public void setListIT(Iterator<Vector<T>> listIT) {
		this.listIT = listIT;
	}
	
	public Iterator<T> getVectIT() {
		return vectIT;
	}
	public void setVectIT(Iterator<T> vectIT) {
		this.vectIT = vectIT;
	}
	
}