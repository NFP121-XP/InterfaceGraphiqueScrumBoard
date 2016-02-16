package fr.cnam.nfp121.xavier.ScrumBoard.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PostIt extends JPanel{
	
	private int x, y, Appartenance;
	private String TextPostIt;
	private JLabel nomTache, srcLib, src;
	private JLabel label = new JLabel();
	  
	public PostIt(int x, int y, String TextPostIt,int Appartenance) {
	
		this.x = x;
		this.y = y;
		this.TextPostIt = TextPostIt;
		//Appartenance à une colonne qui peut prendre que 4 valeurs:
		// 0; 400; 800; 1200
		this.Appartenance = Appartenance;
		// Appel de ma méthode
		disposerPostIt(TextPostIt, Appartenance);
	}

	private void disposerPostIt(String TexPostIt, int Appartenance)
	{
		if (Appartenance==0){
			this.setBackground(Color.CYAN);
		}
		if (Appartenance==400){
			this.setBackground(Color.MAGENTA);
		}
		if (Appartenance==800){
			this.setBackground(Color.GREEN);
		}
		if (Appartenance==1200){
			this.setBackground(Color.ORANGE);
		}
		this.setBounds(Appartenance+25, y+50, 350, 100);			//position et taille
		this.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	    label.setText(TextPostIt);
	    this.add(label);
	}

	public PostIt() {
		//recupération des paramètres de la classe fille
		super();
		disposerPostIt(TextPostIt, Appartenance);
	}

	public void afficher() {
		this.setVisible(true);
	}
}