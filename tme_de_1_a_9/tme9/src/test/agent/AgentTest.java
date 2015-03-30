package test.agent;

import java.io.IOException;

import junit.framework.TestCase;
import agent.Simulation;
import agent.control.ControlFactory;
import agent.control.IControleur;
import agent.laby.ChargeurLabyrinthe;
import agent.laby.Labyrinthe;

public class AgentTest extends TestCase {
	Labyrinthe laby= null, laby1=null, laby2=null;
	private Simulation simuTest,simuTest1,simuTest2;
	String labyFile = "goal.mze";
	String labyFile1 = "sim1.mze";
	String labyFile2 = "sim2.mze";
protected void setUp() throws Exception {
		super.setUp();
		try{
			laby = ChargeurLabyrinthe.chargerLabyrinthe(labyFile);
			laby1 = ChargeurLabyrinthe.chargerLabyrinthe(labyFile1);
			laby2 = ChargeurLabyrinthe.chargerLabyrinthe(labyFile2);
		}catch (IOException e) {
			System.out.println(" problème de chargement du labyrinthe " + e.getMessage());
		}
		IControleur sc = ControlFactory.createControleurDroitier();
		
		simuTest=new Simulation(laby, sc);
		simuTest1=new Simulation(laby1, sc);
		simuTest2=new Simulation(laby2, sc);
		
	}

	public void testAgent() {
		System.out.println("le score est : " +simuTest.mesurePerf(20));
		System.out.println("le score est : " +simuTest1.mesurePerf(20));
		System.out.println("le score est : " +simuTest1.mesurePerf(20));
	}
	public void testMesurePerf(){
        int score = simuTest.mesurePerf(20);
        assertTrue(score == 12);    	//assertTrue(boolean condition)
        								//Affirme qu'une condition est vraie, prend la couleur verte. rouge sinon
        assertFalse(score == 9);		//assertFalse (boolean condition)
        								//Affirme qu'une condition est fausse. de meme couleur verte, rouge sinon
        
        int score1 = simuTest1.mesurePerf(20);
        assertTrue(score1 == 2); 
        assertFalse(score1 == 9);
        
        int score2 = simuTest2.mesurePerf(20);
        assertTrue(score2 == 2); 
        assertFalse(score2 == 12);
	
	}
}
