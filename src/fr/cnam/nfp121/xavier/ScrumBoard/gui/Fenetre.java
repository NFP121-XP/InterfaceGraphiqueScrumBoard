package fr.cnam.nfp121.xavier.ScrumBoard.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane; //Boite de dialogue
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;


public class Fenetre extends JFrame {
  private JMenuBar menuBar = new JMenuBar();
  
  private JMenu fichier = new JMenu("Fichier");
  private JMenuItem sauvegarder = new JMenuItem("Sauvegarder");
  private JMenuItem quitter = new JMenuItem("Quitter");
  
  private JMenu equipe = new JMenu("Equipe");
  private JMenuItem membre1 = new JMenuItem("Xavier SIAUD");
  private JMenuItem ajoutMembre = new JMenuItem("Ajouter un nouveau membre");
  
  private JMenu taches = new JMenu("Tâches");
  private JMenuItem NouvFonctionnalite = new JMenuItem("Nouvelle fonctionnalité");
  private JMenuItem NouvAmelioration = new JMenuItem("Nouvelle amélioration");
  private JMenuItem NouvBug = new JMenuItem("Nouveau bug");
  private JMenuItem NouvSpike = new JMenuItem("Nouveau Spike");
  
  private JMenu aPropos = new JMenu("A propos");
  private JButton bouton = new JButton("Push !");
 
  // Pour le tableau
  //CTRL + SHIFT + O pour générer les imports

  public Fenetre(){

	this.setTitle("Projet Scrum board");  //titre
    this.setSize(1608, 1000); //taille de la fenetre  en fonction des colones
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //Position de la fenetre
    this.setLocationRelativeTo(null);

    //On initialise nos menus 
    this.menuBar.add(fichier);
    this.fichier.add(sauvegarder);
    this.fichier.add(quitter);
    
    this.menuBar.add(equipe);
    this.equipe.add(membre1);
    this.equipe.add(ajoutMembre);
    
    this.menuBar.add(taches);
    this.taches.add(NouvFonctionnalite);
    this.taches.add(NouvAmelioration);
    this.taches.add(NouvBug);
    this.taches.add(NouvSpike);
   
    this.menuBar.add(aPropos);
    
    //Action quitter
    quitter.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        System.exit(0);
      }        
    });
    
    //Action Ajouter Membre
    ajoutMembre.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent arg0) {
    		AjoutMembre ajout1 = new AjoutMembre(null, "Ajouter un nouveau membre", true);
    	}
    });
    
    //APROPOS
      aPropos.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent arg0) {
          JOptionPane jop = new JOptionPane();
    
          String mess = "Projet Scrum Board \n" +
          "\n Version 1.1 "+
          "Réalisé  le 01/02/2016 \n"+
          "\n Créé par Pascal et Xavier";        
          jop.showMessageDialog(null, mess, "À propos", JOptionPane.INFORMATION_MESSAGE);        
        }            
      });

      //Création du ContentPane
      getContentPane().setLayout(null);
      
      //Appel à ma class PostIt avant les colones pour avoir les PostIt dessus.
      PostIt postIt1 = new PostIt(0, 0, "Réussir NFP121", 0);
      getContentPane().add(postIt1);
      PostIt postIt2 = new PostIt(0, 0, "Codage Java", 400);
      getContentPane().add(postIt2);
      PostIt postIt3 = new PostIt(0, 0, "Mettre le reveil", 800);
      getContentPane().add(postIt3);
      PostIt postIt4 = new PostIt(0, 0, "Manger des pâtes", 1200);
      getContentPane().add(postIt4);

      
      //Appel à ma classe Colonne pour générer mes colones
      Colonne toDo = new Colonne(0, 0, "To do");
      getContentPane().add(toDo);
      Colonne InProcess = new Colonne(400, 0, "In Process");
      getContentPane().add(InProcess);
      Colonne ToVerify = new Colonne(800, 0, "To Verify");
      getContentPane().add(ToVerify);
      Colonne Done = new Colonne(1200, 0, "Done");
      getContentPane().add(Done);

      
    this.setJMenuBar(menuBar);		//On lance la barre de menu
    this.setVisible(true);		//On affiche le tout
  }
}
