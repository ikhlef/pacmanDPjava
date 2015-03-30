package pobj.util;

import java.util.Iterator;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		MyArrayList<Integer> maliste= new MyArrayList<Integer>(5);
		
		for(int i= 0; i<=23;i++){
		maliste.add(i);
		}
		System.out.println(maliste.toString());
		System.out.println(maliste.get(10));
		System.out.println(maliste.size());
		maliste.set(20, 50);
		System.out.println(maliste.toString());
		maliste.set(13, 333333);
		System.out.println(maliste.toString());
		
		for(Integer a : maliste){
				System.out.println(a);
		}
		for(Iterator<Integer> it = maliste.iterator(); it.hasNext();){
			System.out.print(it.next() + " ");
		}
	}

}
