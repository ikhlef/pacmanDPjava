package agent.laby.interf;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

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
import agent.Simulationobs;
import agent.control.IControleur;
import agent.laby.ChargeurLabyrinthe;
import agent.laby.ContenuCase;
import agent.laby.Labyrinthe;


public class LabyViewer extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel sidePanel;
	public  Configuration configuration  ;
	private IControleur controleur ;
	private Labyrinthe laby; 
	private LabyActivePanel centerPanel;
	//private static final int COLS = 15, LIGNES = 10;
	int nbRules = 10;
	int nbPas, taille_pop, nbgeneration; 
	IPopulation pop ;
	IControleur contr=null;
	Environnement envir;
	/**
	
 * Constructeur
	 */
	public LabyViewer(Labyrinthe lab, IControleur ctrl, int nb) {
		super("Laby Viewer");
		//laby = new Labyrinthe(COLS, LIGNES);
		laby = lab;
		controleur = ctrl;
		nbPas=nb;
		configuration = new Configuration();
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
		//sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		sidePanel.setLayout(new GridLayout(3,1));
		
		JTextArea instructions = new JTextArea();
		instructions.setText("Cliquez sur play pour\n lancer le jeu\n de labyrinthe!\n");
		instructions.setEditable(false);
		sidePanel.add(instructions);
		
		configuration.getButon().addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					try{
					 
					 setPas(Integer.parseInt((configuration.getNbrePas()).getText()));
					 taille_pop=Integer.parseInt((configuration.getTaillePop()).getText());
					 nbgeneration=Integer.parseInt((configuration.getNbreGenera()).getText());
					
					
					}catch(NumberFormatException e1){
						System.out.println("je veux des entiers merci.");
					}
					
					pop =(Population) PopulationFactory.createRandomPopulation(taille_pop, nbRules);
					
					System.out.println("evolution de la population : ");
					
					Environnement env = PopulationFactory.createEnvironnement(laby, nbPas);
					for(int i=0;i< nbgeneration;i++){
						pop =(Population) pop.evoluer(env);
					}
					envir = new AgentEnvironnementAdapter(laby,nbPas);
						
					//recuperer le meilleur controleur
					int meilleurscore=0;
					for (int i = 0; i< taille_pop;i++){
						Individu in = ((Population)pop).get(i);
						if(envir.eval(in)>meilleurscore){
							 meilleurscore=(int) envir.eval(in);
							 contr = ((ControleurIndividuAdapter)((Population)pop).get(i)).getValeurPropre();
						}
					}
					setControl(contr);
					System.out.println("le meilleur Controleur est : "+contr);
					System.out.println("la taille de la population est : "+taille_pop);
					System.out.println("le meilleur score est : "+meilleurscore);
			
				}
		});
		
		sidePanel.add(configuration);
		
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

	/**
	 * Méthode principale
	 * 
	 * @param args
	 *            : non utilisé
	 */
	public static void main(String[] args) {
		
		String labyFile = "goal.mze"; // nom du fichier, args[0];
		//int taille_pop= 500; // la taille de popolation. 
		int nbPas = 0; // le nbre de pas,Integer.parseInt(args[1]);
		Labyrinthe laby =null; // environnement.
		IControleur contr=null; //controleur.
		
		try {	
			 laby = ChargeurLabyrinthe.chargerLabyrinthe(labyFile);
			 laby.setContenuCase(laby.getPositionInitiale().x,laby.getPositionInitiale().y, ContenuCase.AGENT);
		} catch (IOException e) {
			System.out.println("Problème de chargement du labyrinthe"+e);
			System.exit(1);
		}
				
		new LabyViewer(laby, contr, nbPas);
		
		System.out.println("---------------------------");	
		System.out.println("le labyrinthe apres simulation Observer");
		System.out.println(laby.toString());	
	}
}