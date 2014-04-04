package mapGenerator;
import java.awt.Color;
import java.awt.GridLayout;


import java.util.Hashtable;

import javax.swing.*;
import javax.swing.event.*;

public class AfficheOptions extends JFrame {	
	
	private static final long serialVersionUID = 7603819019149456132L;
	private JLabel vieMonstre;
    private static int SPEED_MIN = 0;
    private static int SPEED_MAX = 10;
    private static int SPEED_INIT = 2;
    private int vitesseDefilement = 2;
    
	public AfficheOptions()
	{	
		// Création de la fenêtre principale
		this.setTitle("Fenêtre status jeu");
		this.setSize(300,800);
		// Création du panel principal qui contiendra le layout pour les stats à afficher
		JPanel mainPanel = new JPanel (new GridLayout(12,1));
		// Création de la fenêtre d'info sur le monstre
		JPanel statMonstre = new JPanel();
		statMonstre.setBackground(Color.white);
		this.vieMonstre = new JLabel();
		this.vieMonstre.setText("100");
		statMonstre.add(this.vieMonstre);
		statMonstre.setBorder(BorderFactory.createTitledBorder("Vie Du Monstre"));
		mainPanel.add(statMonstre);
		
		JPanel statusPerso1 = new JPanel();
		statusPerso1.setBackground(Color.white);
		this.vieMonstre = new JLabel();
		this.vieMonstre.setText("Vivant");
		statusPerso1.add(this.vieMonstre);
		statusPerso1.setBorder(BorderFactory.createTitledBorder("Status du personnage 1"));
		mainPanel.add(statusPerso1);
		
		JPanel statusPerso2 = new JPanel();
		statusPerso2.setBackground(Color.white);
		this.vieMonstre = new JLabel();
		this.vieMonstre.setText("Mort");
		statusPerso2.add(this.vieMonstre);
		statusPerso2.setBorder(BorderFactory.createTitledBorder("Status du personnage 2"));
		mainPanel.add(statusPerso2);
		
		final JSlider speed = new JSlider(JSlider.HORIZONTAL,SPEED_MIN,SPEED_MAX,SPEED_INIT);
		speed.setMajorTickSpacing(5);
		speed.setMinorTickSpacing(1);
		speed.setPaintTicks(true);
		speed.setPaintLabels(true);
		speed.setBorder(BorderFactory.createTitledBorder("Vitesse du jeu"));
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put( new Integer (0), new JLabel("Lent") );
		labelTable.put( new Integer (10), new JLabel("Rapide") );
		speed.setLabelTable(labelTable);
		speed.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int vitesseDefilement = speed.getModel().getValue();
                AfficheOptions.this.vitesseDefilement = vitesseDefilement;
            	}
            });
		
		mainPanel.add(speed);
		
		this.add(mainPanel);
		
		this.setVisible(true);
		
	}
	
	public int getVitesse()
	{	
		return this.vitesseDefilement;
	}
}
