package configuration;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FenetreDeConf extends JDialog {

	private static final long serialVersionUID = 1823220579238313073L;



	private final JPanel pannelDesChampsDeConf = new JPanel();

	private JTextField JTextLargeur;
	private JTextField JTextlongueur;
	private JTextField JTextDensiteRochers;
	private JTextField JTextDensiteMurs;
	private JTextField JTextNombreDePerso;
	private JButton okButton;
	private JButton cancelButton;
	private String answer = "Cancel";
	public JTextArea lblDescription ; 
	public JComboBox<String> strategie;

	public FenetreDeConf(final Configurable configuration) {



		//Configuration de la fenetre
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.pack();
		this.setModalityType(ModalityType.APPLICATION_MODAL); // blocks all windows from the same application, except windows from its child hierarchy
		this.setResizable(false);
		this.setTitle("Paramètres du jeu");
		this.setSize(new Dimension(1000, 700));
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(new BorderLayout());


		//Configuration du panneau contenant les champs
		this.pannelDesChampsDeConf.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().add(this.pannelDesChampsDeConf, BorderLayout.CENTER);
		final GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 240, 240 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0 };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		this.pannelDesChampsDeConf.setLayout(gbl_contentPanel);

		// Image du panneau de contrôle 
		JLabel icon = new JLabel(new ImageIcon("images/icone.jpg"));
		this.getContentPane().add(icon, BorderLayout.WEST);

		//Jlabel pour le titre

		JLabel titre = new JLabel("CONFIGURATION SETTING...");

		titre.setPreferredSize(new Dimension(150,60));

		final GridBagConstraints gbc_titre = new GridBagConstraints();
		gbc_titre.anchor = GridBagConstraints.CENTER;
		gbc_titre.insets = new Insets(0, 0, 5, 5);
		gbc_titre.fill = GridBagConstraints.HORIZONTAL;
		gbc_titre.gridx = 0;
		gbc_titre.gridy = 0;
		gbc_titre.gridwidth = 2;
		this.pannelDesChampsDeConf.add(titre,gbc_titre);

		// LARGEUR 
		JPanel panLargeur = new JPanel();
		panLargeur.setPreferredSize(new Dimension(150,60));
		panLargeur.setBorder(BorderFactory.createTitledBorder("Largeur du plateau"));

		this.JTextLargeur = new JTextField();
		this.JTextLargeur.setText(Integer.toString(configuration.getLargeur()));

		panLargeur.add(this.JTextLargeur);

		final GridBagConstraints gbc_largeur = new GridBagConstraints();
		gbc_largeur.anchor = GridBagConstraints.EAST;
		gbc_largeur.insets = new Insets(0, 0, 5, 5);
		gbc_largeur.fill = GridBagConstraints.HORIZONTAL;
		gbc_largeur.gridx = 0;
		gbc_largeur.gridy = 1;
		this.JTextLargeur.setColumns(10);

		this.pannelDesChampsDeConf.add(panLargeur,gbc_largeur);


		//LONGUEUR
		JPanel panLongueur = new JPanel();
		panLongueur.setPreferredSize(new Dimension(150,60));
		panLongueur.setBorder(BorderFactory.createTitledBorder("Hauteur du plateau"));

		this.JTextlongueur = new JTextField();
		this.JTextlongueur.setText(Integer.toString(configuration.getLongueur()));
		this.JTextlongueur.setColumns(10);

		panLongueur.add(this.JTextlongueur);

		final GridBagConstraints gbc_longueur = new GridBagConstraints();
		gbc_largeur.anchor = GridBagConstraints.EAST;
		gbc_longueur.insets = new Insets(0, 0, 5, 5);
		gbc_longueur.fill = GridBagConstraints.HORIZONTAL;
		gbc_longueur.gridx = 1;
		gbc_longueur.gridy = 1;
		this.pannelDesChampsDeConf.add(panLongueur, gbc_longueur);



		//densite rochers

		JPanel panDensiteRochers = new JPanel();
		panDensiteRochers.setPreferredSize(new Dimension(150,60));
		panDensiteRochers.setBorder(BorderFactory.createTitledBorder("Densité des rochers"));

		this.JTextDensiteRochers = new JTextField();
		this.JTextDensiteRochers.setText(Integer.toString(configuration.getDensiteRochers()));
		this.JTextDensiteRochers.setColumns(10);

		panDensiteRochers.add(this.JTextDensiteRochers);

		final GridBagConstraints gbc_DensiteRochers = new GridBagConstraints();
		gbc_DensiteRochers.anchor = GridBagConstraints.EAST;
		gbc_DensiteRochers.insets = new Insets(0, 0, 5, 5);
		gbc_DensiteRochers.fill = GridBagConstraints.HORIZONTAL;
		gbc_DensiteRochers.gridx = 0;
		gbc_DensiteRochers.gridy = 2;
		this.pannelDesChampsDeConf.add(panDensiteRochers, gbc_DensiteRochers);


		//densite murs

		JPanel panDensiteMurs = new JPanel();
		panDensiteMurs.setPreferredSize(new Dimension(150,60));
		panDensiteMurs.setBorder(BorderFactory.createTitledBorder("Densité des murs"));

		this.JTextDensiteMurs = new JTextField();
		this.JTextDensiteMurs.setText(Integer.toString(configuration.getDensiteMurs()));
		this.JTextDensiteMurs.setColumns(10);

		panDensiteMurs.add(this.JTextDensiteMurs);

		final GridBagConstraints gbc_DensiteMurs = new GridBagConstraints();
		gbc_DensiteMurs.anchor = GridBagConstraints.EAST;
		gbc_DensiteMurs.insets = new Insets(0, 0, 5, 5);
		gbc_DensiteMurs.fill = GridBagConstraints.HORIZONTAL;
		gbc_DensiteMurs.gridx = 1;
		gbc_DensiteMurs.gridy = 2;
		this.pannelDesChampsDeConf.add(panDensiteMurs, gbc_DensiteMurs);


		//nombres de personnages

		JPanel panNbPerso = new JPanel();
		panNbPerso.setPreferredSize(new Dimension(150,60));
		panNbPerso.setBorder(BorderFactory.createTitledBorder("Nombres de personnages"));

		this.JTextNombreDePerso = new JTextField();
		this.JTextNombreDePerso.setText(Integer.toString(configuration.getNombreDePerso()));
		this.JTextNombreDePerso.setColumns(10);

		panNbPerso.add(this.JTextNombreDePerso);

		final GridBagConstraints gbc_NbPerso = new GridBagConstraints();
		gbc_NbPerso.anchor = GridBagConstraints.EAST;
		gbc_NbPerso.insets = new Insets(0, 0, 5, 5);
		gbc_NbPerso.fill = GridBagConstraints.HORIZONTAL;
		gbc_NbPerso.gridx = 0;
		gbc_NbPerso.gridy = 3;
		this.pannelDesChampsDeConf.add(panNbPerso, gbc_NbPerso);

		//LABEL DESCRIPTIF STRATEGIE

		JPanel panDescriptif = new JPanel();
		panDescriptif.setPreferredSize(new Dimension(150,60));
		panDescriptif.setBorder(BorderFactory.createTitledBorder("Strategie du groupe"));

		String strEnCours = Strategie.descriptif(configuration.getStrategie());
		lblDescription = new JTextArea(strEnCours);
		lblDescription.setAlignmentX(CENTER_ALIGNMENT);

		panDescriptif.add(this.lblDescription);


		final GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.NORTH;
		gbc_lblDescription.insets = new Insets(0, 0, 0, 0);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 4;
		gbc_lblDescription.gridwidth = 2;
		gbc_lblDescription.gridheight=10;
		this.pannelDesChampsDeConf.add(panDescriptif, gbc_lblDescription);

		//STRATEGIE

		JPanel panStrategie = new JPanel();
		panStrategie.setPreferredSize(new Dimension(150,60));
		panStrategie.setBorder(BorderFactory.createTitledBorder("Choisissez votre stratégie pour survivre "));

		String choixStrat [] = {Strategie.Fuyard.toString(), Strategie.Groupe.toString(),
				Strategie.Planque.toString(), Strategie.Sacrifice.toString()};
		this.strategie = new JComboBox<String>(choixStrat);

		panStrategie.add(this.strategie);

		final GridBagConstraints gbc_strategie = new GridBagConstraints();
		gbc_strategie.anchor = GridBagConstraints.CENTER;
		gbc_strategie.insets = new Insets(0, 0, 5, 5);
		gbc_strategie.fill = GridBagConstraints.HORIZONTAL;
		gbc_strategie.gridx = 0;
		gbc_strategie.gridy = 5;
		gbc_strategie.gridwidth = 2;
		this.pannelDesChampsDeConf.add(panStrategie, gbc_strategie);
		this.strategie.addActionListener(new ActionListener(){		

			//LISTENER POUR METTRE A JOUR LE DESCRIPTIF DE STRATEGIE			
			@Override
			public void actionPerformed(final ActionEvent e) {

				updateDescriptif();
			}
		});

		//BUTTONS OK ET CANCEL
		final JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.getContentPane().add(buttonPane, BorderLayout.SOUTH);

		this.okButton = new JButton("OK");
		this.okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				configuration.setDensiteMurs(Integer.parseInt(FenetreDeConf.this.JTextDensiteMurs.getText()));
				configuration.setDensiteRochers(Integer.parseInt(FenetreDeConf.this.JTextDensiteRochers.getText()));
				configuration.setLongueur(Integer.parseInt(FenetreDeConf.this.JTextLargeur.getText()));
				configuration.setLargeur(Integer.parseInt(FenetreDeConf.this.JTextlongueur.getText()));
				configuration.setNombreDePerso(Integer.parseInt(FenetreDeConf.this.JTextNombreDePerso.getText()));
				configuration.setStrategie(FenetreDeConf.this.strategie.getSelectedItem().toString());
				
				
				
				FenetreDeConf.this.answer = "Ok";
				FenetreDeConf.this.setVisible(false);
			}
		});
		this.okButton.setActionCommand("OK");
		buttonPane.add(this.okButton);
		this.getRootPane().setDefaultButton(this.okButton);


		this.cancelButton = new JButton("Cancel");
		this.cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				FenetreDeConf.this.answer = "Cancel";
				FenetreDeConf.this.setVisible(false);
			}
		});
		this.cancelButton.setActionCommand("Cancel");
		buttonPane.add(this.cancelButton);

	}




public void updateDescriptif(){

	String currentStrategie = this.strategie.getSelectedItem().toString();
	this.lblDescription.setText(Strategie.descriptif(currentStrategie));
}

public String getAnswer() {
	return this.answer;
}
}
