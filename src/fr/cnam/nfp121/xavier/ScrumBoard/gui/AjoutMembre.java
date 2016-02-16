package fr.cnam.nfp121.xavier.ScrumBoard.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AjoutMembre extends JDialog {
	
	  private AjoutMembreInfo ajoutMembreInfo = new AjoutMembreInfo();
	  private boolean sendData;
	  private JTextField nom, prenom, addresseMail, naissance, nbTaches;
	  private JLabel nomLabel;
	
	  //Creation de l'objet contenant les infos
	  public class AjoutMembreInfo {
		  private String nom, prenom, addresseMail, naissance, nbTaches;

		  public AjoutMembreInfo(){}
		  //On dis ce qu'on récupère
		  public AjoutMembreInfo(String nom, String prenom, String addresseMail, String naissance, String nbTaches){
		    this.nom = nom;
		    this.prenom = prenom;
		    this.addresseMail = addresseMail;
		    this.nbTaches = nbTaches;
		  }

		  public String toString(){
		    String str;
		    if(this.nom != null && this.prenom != null && this.nbTaches != null && this.naissance != null && this.addresseMail != null){
		      str = "Description de l'objet InfoZDialog";
		      str += "Nom : " + this.nom + "\n";
		      str += "Prenom : " + this.prenom + "\n";
		    }
		    else{
		      str = "Aucune information !";
		    }
		    return str;
		  }
		}
	 
	//  ***************  //
	//Code de la fenetre Ajout Membre 
  public AjoutMembre(JFrame parent, String title, boolean modal){
 
    //On appelle le construteur de JDialog correspondant
    super(parent, title, modal);
    //On spécifie une taille
    this.setSize(400, 240);
    //La position
    this.setLocationRelativeTo(null);
    //La boîte ne devra pas être redimensionnable
    this.setResizable(false);
    
    //Mise en Forme
    JPanel Ligne1 = new JPanel();	
    JPanel Ligne2 = new JPanel();
    JPanel Ligne3 = new JPanel();
    JPanel Ligne4 = new JPanel();
    JPanel content = new JPanel();
    
    //Rentrer Nom
    nom = new JTextField();
    nom.setPreferredSize(new Dimension(100, 25));
    nomLabel = new JLabel("Nom :");
    Ligne1.add(nomLabel);	//affichage texte
    Ligne1.add(nom);		//Case de texte
    content.add(Ligne1);	//appartenant à la ligne1
    
    //Rentrer Prenom
    prenom = new JTextField();
    prenom.setPreferredSize(new Dimension(100, 25));
    nomLabel = new JLabel("Prenom :");
    Ligne1.add(nomLabel);	//affichage texte
    Ligne1.add(prenom);		//Case de texte
    content.add(Ligne1);	//appartenant à la ligne1
    
    //Rentrer adresse mail
    addresseMail = new JTextField();
    addresseMail.setPreferredSize(new Dimension(150, 25));
    nomLabel = new JLabel("Adresse mail :");
    Ligne2.add(nomLabel);	
    Ligne2.add(addresseMail);		
    content.add(Ligne2);	//appartenant à la ligne 2
    
    //Rentrer date de naissance
 //   JPanel text4 = new JPanel();
    nom = new JTextField();
    nom.setPreferredSize(new Dimension(110, 25));
    nomLabel = new JLabel("Date de naissance :");
    Ligne3.add(nomLabel);
    Ligne3.add(nom);		
    content.add(Ligne3);
    
    //Nombre de tâche
    nom = new JTextField();
    nom.setPreferredSize(new Dimension(110, 25));
    nomLabel = new JLabel("Nombre de tâche confiées :");
    Ligne4.add(nomLabel);
    Ligne4.add(nom);		
    content.add(Ligne4);
    
//    Mise en place des bouttons
    JPanel control = new JPanel();
    JButton okBouton = new JButton("OK");
    JButton cancelBouton = new JButton("Annuler");
    cancelBouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
      }      
    });
    control.add(okBouton);
    control.add(cancelBouton);
    
    okBouton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0) {        
          ajoutMembreInfo = new AjoutMembreInfo(nom.getText(), prenom.getText(), addresseMail.getText(),naissance.getText(), nbTaches.getText());
          setVisible(false);
        }
    });
    
    //On affiche tout le content (text) puis le control (qui contient les bouttons)
    this.getContentPane().add(content, BorderLayout.CENTER);
    this.getContentPane().add(control, BorderLayout.SOUTH);
    
    //Enfin on l'affiche
    this.setVisible(true);
  }
}