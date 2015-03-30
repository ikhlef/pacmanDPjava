package pobj.util;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;




public class Configuration implements AlgoGenParameter {
	Map<String,String> map;
	private static Configuration instance;
	
	
	private Configuration(String fileName){
		map = new HashMap<String, String>();
		try {
			chargerParameters(fileName);
		} catch (IOException e) {
			System.out.println("Probleme au chargement des parametres");
			e.printStackTrace();
		}
	}
	
	public static Configuration getInstance(String fileName){
		if (instance == null)
			instance = new Configuration(fileName);
		return instance;
	}
	
	public String getParameterValue(String parameter){
		return map.get(parameter);
	}
	
	public void setParameterValue(String parameter,String value){
		map.put(parameter, value);
	}
	
	public void chargerParameters(String file) throws IOException{
		BufferedReader fileIn = new BufferedReader(new FileReader(file));
		String []buffer;
		String line;
		while(fileIn.ready()){
			line = fileIn.readLine();
			buffer = line.split(":");
			String parameter = buffer[0];//le parametre
			String value = buffer[1];//la valeur associ�e 
			if (parameter.equals(TAILLE_POP))
				setParameterValue(parameter, value);
			if (parameter.equals(NB_PAS))
				setParameterValue(parameter, value);
			if (parameter.equals(NB_RULES))
				setParameterValue(parameter, value);
			if (parameter.equals(NB_GENES))
				setParameterValue(parameter, value);
		}
	}
	
	public static void sauverParameters(String fileOut,Configuration confi) throws IOException{
		FileOutputStream fos = new FileOutputStream(fileOut);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(confi);
		oos.close();
		
	}
	
}
