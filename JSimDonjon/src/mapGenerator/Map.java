package mapGenerator;

import configuration.*;

import java.util.ArrayList;
import java.util.Random;



public class Map {

	private ParametresDeConf configuration;
	private Case m_case[][];
	private Random m_random;
	private Plateau plateau;
	private ArrayList<ElementMobile> mobiles;

	public Map(final ParametresDeConf configuration)
	{	
		this.configuration = configuration;
		this.m_case = new Case[this.configuration.getLargeur()][this.configuration.getLongueur()];
		this.m_random = new Random();
		this.mobiles = new ArrayList<ElementMobile>();

		//CREATION DU PLATEAU AVEC LES ELEMENTS DU DECOR
		Case iCase;
		for (int i = 0; i < this.configuration.getLargeur(); i++) {
			for (int j = 0; j < this.configuration.getLongueur(); j++) {
				if ( (i == 0) || (i == this.configuration.getLargeur() - 1) || 
						(j == 0) || (j == this.configuration.getLongueur() - 1) || 
						(m_random.nextInt(this.configuration.getDensiteMurs()) == 0) )
					iCase = new Mur();
				else if (m_random.nextInt(this.configuration.getDensiteRochers()) == 0)
					iCase = new Pierre();
				else 
					iCase = new Sol();
				this.setCase(i, j, iCase);
			}
		}
		this.plateau = new Plateau(this.configuration.getLargeur(),	this.configuration.getLongueur(), this.m_case);
		this.placerLesMonstres();
		this.placerLesPersonnages();
	}

	public void setCase (int longueur, int largeur, Case iCase) {
		this.m_case[longueur][largeur] = iCase;
	}

	public void affichageGraphique() {
		this.plateau.rafraichir();
	}


	public ParametresDeConf getConfiguration() {
		return this.configuration;
	}

	public ElementMobile getElementMobile(final int x, final int y) {
		for (final ElementMobile e : this.mobiles) {
			if (e != null) {
				if ((e.getX() == x) && (e.getY() == y)) {
					return e;
				}
			}
		}
		return null;
	}

	public Case getXY(final int x, final int y) {
		return this.m_case[x][y];
	}


	public void jouer() {
		for (final ElementMobile e : this.mobiles) {
			if(e.espece=="Monstre"){	//Si c'est un ogre, il va se déplacer différemment
				e.deplacerMonstre();
			}
			else
			{
				e.deplacerPersonnages();
			}
		}
	}



	private void placerLesPersonnages() {

		//MODE FUYARD => que des personnages normaux
		//TODO deplacement

		if(this.getConfiguration().getStrategie() == "Fuyard"){
			Personnage p;
			for (int i = 0; i < this.configuration.getNombreDePerso(); i++) {
				p = new Personnage(this);
				this.mobiles.add(p);
				this.placerUnElementMobileAuHasard(p);
				this.plateau.placerPiece(p);
			}
		}
		//MODE GROUPE => un leader + 8 body guard + des eclaireurs
		//TODO FAIRE LE DEPLACEMENTS DES NORMAUX AUTOURS DU LEADER


		else if(this.getConfiguration().getStrategie() == "Groupe"){

			Leader l;
			BodyGuard b;
			Eclaireur e;

			//LE LEADER
			l = new Leader(this);
			this.mobiles.add(l);
			this.placerUnElementMobileAuHasard(l);
			this.plateau.placerPiece(l);

			//LES 8 BODYGUARD
			for (int i = 0; i < 8; i++) {
				b = new BodyGuard(this);
				this.mobiles.add(b);
				this.placerUnElementMobileAuHasard(b);
				this.plateau.placerPiece(b);
			}
			//LE RESTE SONT DES ECLAIREURS
			for (int i = 0; i < this.configuration.getNombreDePerso() - 9; i++) {
				e = new Eclaireur(this);
				this.mobiles.add(e);
				this.placerUnElementMobileAuHasard(e);
				this.plateau.placerPiece(e);
			}

		}
		//MODE Planqué => des froussards
		//TODO deplacement




		else if(this.getConfiguration().getStrategie() == "Planque"){

			GrandFroussard gf;
			for (int i = 0; i < this.configuration.getNombreDePerso(); i++) {
				gf = new GrandFroussard(this);
				this.mobiles.add(gf);
				this.placerUnElementMobileAuHasard(gf);
				this.plateau.placerPiece(gf);
			}

		}

		//MODE SACRIFICE => les persos tournent en rond
		else{

			Suicidaire s;

			for (int i = 0; i < this.configuration.getNombreDePerso(); i++) {
				s = new Suicidaire(this);
				this.mobiles.add(s);
				this.placerUnElementMobileAuHasard(s);
				this.plateau.placerPiece(s);
			}
		}

	}

	private void placerLesMonstres() {
		final Monstre monstre = new Monstre(this);
		this.mobiles.add(monstre);
		this.placerUnElementMobileAuHasard(monstre);
		this.plateau.placerPiece(monstre);
	}

	private void placerUnElementMobileAuHasard(final ElementMobile e) {
		int x = this.m_random.nextInt(this.configuration.getLargeur());
		int y = this.m_random.nextInt(this.configuration.getLongueur());
		while ((!this.getXY(x, y).estVide()) && (this.getElementMobile(x, y) == null)) {
			x = this.m_random.nextInt(this.configuration.getLargeur());
			y = this.m_random.nextInt(this.configuration.getLongueur());
		}
		e.setX(x);
		e.setY(y);
	}

	public void definirPause(AfficheOptions status)
	{
		switch (status.getVitesse())
		{
		case 0 :
			try {
				Thread.sleep(2000);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 1 :
			try {
				Thread.sleep(1800);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 2 :
			try {
				Thread.sleep(1600);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 3 :
			try {
				Thread.sleep(1400);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 4 :
			try {
				Thread.sleep(1200);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 5 :
			try {
				Thread.sleep(1000);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 6 :
			try {
				Thread.sleep(800);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 7 :
			try {
				Thread.sleep(600);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 8 :
			try {
				Thread.sleep(400);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 9 :
			try {
				Thread.sleep(200);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 10 :
			try {
				Thread.sleep(50);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
			break;
		}
	}
}
