package agent.laby.interf;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Configuration extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField taillePopC, nbrePasC, nbregeneraC;
	JLabel taillepoplabel, nbregeneratlabe, nbrepaslabel, valider;
	private JButton b;
	
	public Configuration(){
		this.setLayout(new GridLayout(4,1));
		 //ajouter la taille de la population.
		  taillePopC = new JTextField();
		 taillepoplabel = new JLabel("Taille Pop");
		 this.add(taillepoplabel);
		 this.add(taillePopC);
		 //ajouter le nbre de pas
		 nbrePasC =new JTextField();
		 nbrepaslabel = new JLabel("PAS");
		 this.add( nbrepaslabel);
		 this.add(nbrePasC);
		 //ajouter le nbre de generation.
		 nbregeneraC =new JTextField();
		 nbregeneratlabe = new JLabel("Nbre Gen");
		 this.add( nbregeneratlabe);
		 this.add( nbregeneraC);
		 valider =new JLabel("valider");
		 //ajouter un bouton pour valider les données
		 b=new JButton("ok");
		 this.add(valider);
		 this.add(b);
	}
	

	public JButton getButon(){return b;}
	public JTextField getTaillePop(){return taillePopC;}
	public JTextField getNbreGenera(){return nbregeneraC;}
	public JTextField getNbrePas(){return nbrePasC;}
	
	
}
