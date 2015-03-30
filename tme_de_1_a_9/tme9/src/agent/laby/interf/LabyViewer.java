package agent.laby.interf;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import pobj.algogen.Environnement;
import pobj.algogen.IPopulation;
import pobj.algogen.Individu;
import pobj.algogen.Population;
import pobj.algogen.adapter.agent.AgentEnvironnementAdapter;
import pobj.algogen.adapter.agent.ControleurIndividuAdapter;
import pobj.algogen.adapter.agent.PopulationFactory;
import pobj.util.AlgoGenParameter;
import pobj.util.Chrono;
import pobj.util.Configuration;
import pobj.util.Generateur;
import agent.Simulationobs;
import agent.control.IControleur;
import agent.laby.ChargeurLabyrinthe;
import agent.laby.ContenuCase;
import agent.laby.Labyrinthe;


public class LabyViewer extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel sidePanel;
	private IControleur controleur ;
	private Labyrinthe laby; 
	private LabyActivePanel centerPanel;
	IPopulation pop ;
	IControleur contr=null;
	Environnement envir;
	int nbPas;
	/**
	
 * Constructeur
	 * @throws IOException 
	 */
	public LabyViewer(int nbpas, int taille_pop, int nbrules,int nbgeneration) throws IOException {
		     super("Laby Viewer");		
    	nbPas=nbpas;
		     laby = ChargeurLabyrinthe.chargerLabyrinthe("goal.mze");
	    laby.setContenuCase(laby.getPositionInitiale().x,laby.getPositionInitiale().y, ContenuCase.AGENT);
		System.out.println(laby.toString());
		envir = new AgentEnvironnementAdapter(laby,nbpas);
		pop =(Population) PopulationFactory.createRandomPopulation(taille_pop, nbrules);
		 meilleurAgent( nbgeneration, taille_pop);
		 controleur = contr;
		 createCenterPanel();
		createSidePanel();
		setSize(800, 658);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	

	/**
	 * Crée le panneau latéral, ses boutons et associe les actions appropriées aux boutons.
	 */
	public void createSidePanel() {
		sidePanel = new JPanel();
		sidePanel.setLayout(new GridLayout(3,1));
		
		JTextArea instructions = new JTextArea();
		instructions.setText("Cliquez sur play pour\n lancer le jeu\n de labyrinthe!\n");
		instructions.setEditable(false);
		sidePanel.add(instructions);
		JButton jouer = new JButton("Play");
		jouer.setIcon(null);
		sidePanel.add(jouer);
		
			 
		jouer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable(){
					public void run(){
						Labyrinthe lab= laby.clone();
						System.out.println(lab);
						Simulationobs sim = new Simulationobs(lab,controleur);
						centerPanel.setLaby(sim.getLaby());
						sim.addOvserver(centerPanel);
						sim.mesurePerf(getnbPas());
						System.out.println(sim.getLaby());
					}
		
				}).start();
			}
		});
		
		getContentPane().add(sidePanel, BorderLayout.EAST);	
	}
	public void meilleurAgent(int nbGen,int taille){
		for(int i=0;i< nbGen;i++){
			pop =(Population) pop.evoluer(envir);
		}	
		//recuperer le meilleur controleur
		int meilleurscore=0;
		for (int i = 0; i< taille;i++){
			Individu in = ((Population)pop).get(i);
			if(envir.eval(in)>meilleurscore){
				 meilleurscore=(int) envir.eval(in);
				 contr = ((ControleurIndividuAdapter)((Population)pop).get(i)).getValeurPropre();
			}
		}
		setControl(contr);
	}
	
	public void setControl(IControleur d){controleur=contr;}
	public void setPas(int a ){nbPas=a;}
	public int getnbPas(){return nbPas;}
	
	
	/**
	 * Crée le MazePanel responsable d'afficher le Maze courant.
	 */
	
	private void createCenterPanel() {
		centerPanel = new LabyActivePanel(laby);
		getContentPane().add(centerPanel, BorderLayout.CENTER);

	}

	/**
	 * Export du labyrinthe par la sérialisation
	 * 
	 * @throws IOException
	 */
	public void exportMazeData() throws IOException {
		// Force la remise à jour de l'état du labyrinthe en fonction des boutons
		// affichés dans l'interface graphique de dessin
		// What You See Is What You Get
		centerPanel.modifLaby();

		String fileName = JOptionPane
				.showInputDialog("Please enter a file name to save this maze (extension .mze).");
		ChargeurLabyrinthe.sauverLabyrinthe(fileName, laby);
	}

	/**
	 * Import du labyrinthe sauvé par la sérialisation
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void chargerLabyrinthe() throws IOException {

		// / Code pris directement dans la doc de JFileChooser.
		// L'argument "./" permet de démarrer directement dans le repertoire
		// courant
		// La version par défaut JFilechooser() démarre dans le $home.
		JFileChooser chooser = new JFileChooser(new File("./"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Maze files", "mze");
		chooser.setFileFilter(filter);
		chooser.setDialogTitle("Entrez un nom de fichier .mze (avec l'extension");
		int returnVal = chooser.showOpenDialog(this);
		String fileName;
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			fileName = chooser.getSelectedFile().getName();
		} else {
		
			return;
		}

		laby = ChargeurLabyrinthe.chargerLabyrinthe(fileName);
		centerPanel.setLaby(laby);
	}

	/**
	 * Export du labyrinthe au format xml
	 * 
	 * @throws IOException
	 */
	public void sauverLabyrintheEnXML() throws IOException {
		centerPanel.modifLaby();
		ChargeurLabyrinthe.sauverLabyrintheEnXML("maze_xml.txt", laby);
	}

	/**
	 * Getter
	 * 
	 * @return : le labyrinthe
	 */
	public Labyrinthe getLaby() {
		return laby;
	}

	public static void importParameter(Configuration configuration){
		int tailleP = 0;
		int nbpas=0;
		int nbregles=0;
		int nbgen=0;
		
		tailleP = Integer.parseInt(configuration.getParameterValue(AlgoGenParameter.TAILLE_POP)); 
		nbpas = Integer.parseInt(configuration.getParameterValue(AlgoGenParameter.NB_PAS));
		nbregles = Integer.parseInt(configuration.getParameterValue(AlgoGenParameter.NB_RULES));
		nbgen = Integer.parseInt(configuration.getParameterValue(AlgoGenParameter.NB_GENES));
		
		try {
			new LabyViewer(nbpas,tailleP,nbregles,nbgen);
		} catch (IOException e) {
			System.out.println("Probleme de chargement du labyrinthe");
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Méthode principale
	 * 
	 * @param args
	 *            : non utilisé
	 */
	
	public static void main(String[] args) {
		 Generateur g= Generateur.getGenerateur(3);
		 System.out.println(g.nextDouble());
		 g.setSeed(3);
		 System.out.println(g.nextDouble());
		 
		Chrono chrono = new Chrono();
		Configuration config = Configuration.getInstance("foufa.txt");
		importParameter(config);
		System.out.println("le temps nécessaire pour une simulation est : ");
		chrono.stop();
		
		
		
	}
}