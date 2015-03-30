package pobj.util;

import java.util.Random;

public class Generateur {
	private static Generateur generateur;
	private Random random;
	@SuppressWarnings("unused")
	private long graine;
	
	public Generateur(long graine){
		this.graine=graine;
		random= new Random(graine);
		random.setSeed(graine);
	}
	
	public static Generateur getGenerateur(long graine){
		if(generateur==null){
				generateur= new Generateur(graine);
		}	
		return generateur;
	}
	public void setSeed(long a){random.setSeed(a);}
	public double nextDouble(){ return random.nextDouble();}
	public int nextInt(){return random.nextInt();}
	public Random getRandom(){
		return random;
	}
	
}
