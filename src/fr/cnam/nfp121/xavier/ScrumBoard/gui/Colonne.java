package fr.cnam.nfp121.xavier.ScrumBoard.gui;

import java.awt.Color;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Colonne extends JPanel {

	private int x, y;
	private String Titre;
	private JLabel nomTache;
	private static final int largeurColonne = 400, hauteurColonne = 1000;
	private JLabel label = new JLabel();
	public Colonne(int x, int y, String Titre) {
		
		this.x = x;
		this.y = y;
		this.Titre = Titre;
	
		// Appel de ma méthode
		disposerColonne(Titre);
	}

	//Méthode permetant de créer des cadres
	private void disposerColonne(String Titre)
	{
		this.setBackground(Color.WHITE);
		this.setBounds(x, y, largeurColonne, hauteurColonne);			//position et taille
		this.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	    label.setText(Titre);
	    this.add(label);
	}
	
	public List<PostIt> postsIt;

	public Colonne() {
		//recupération des paramètres de la classe fille
		super();
		disposerColonne(Titre);
	}

	public void afficher() {
		this.setVisible(true);
	}
}
