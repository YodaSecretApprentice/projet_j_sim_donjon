package configuration;

public class ParametresDeConf implements Configurable {

	private int densiteRochers;
	private int densiteMurs;
	private int longueur;
	private int largeur;
	private int nombreDePerso;
	private String strategie;

	public ParametresDeConf() {
		// Parametre de configuration par defaut

		//densite des rocher
		this.densiteRochers = 10;

		//densite des murs
		this.densiteMurs = 10;

		//longueur du plateau
		this.longueur = 100;

		//largeur du plateau
		this.largeur = 100;

		//nombre de personnages
		this.nombreDePerso = 20;

		//strategie des personnages pour survivre
		this.strategie = Strategie.Fuyard.toString();
	}


	@Override
	public int getLongueur() {
		return this.longueur;
	}

	@Override
	public int getLargeur() {
		return this.largeur;
	}

	@Override
	public int getNombreDePerso() {
		return this.nombreDePerso;
	}

	@Override
	public String getStrategie() {
		return strategie;
	}
	@Override
	public void setStrategie(String strategie) {


		if(strategie == "Fuyard")
			this.strategie = Strategie.Fuyard.toString();

		else if(strategie == "Groupe")
			this.strategie = Strategie.Groupe.toString();

		else if (strategie == "Planque")
			this.strategie = Strategie.Planque.toString();

		else  
			this.strategie = Strategie.Sacrifice.toString();




	}



	@Override
	public void setLongueur(final int longueur) {
		this.longueur = longueur;
	}

	@Override
	public void setLargeur(final int largeur) {
		this.largeur = largeur;
	}

	@Override
	public void setNombreDePerso(final int nombreDePerso) {
		this.nombreDePerso = nombreDePerso;
	}

	@Override
	public int getDensiteRochers() {
		return densiteRochers;
	}

	@Override
	public void setDensiteRochers(int densiteRochers) {
		this.densiteRochers = densiteRochers;
	}

	@Override
	public int getDensiteMurs() {
		return densiteMurs;
	}

	@Override
	public void setDensiteMurs(int densiteMurs) {
		this.densiteMurs = densiteMurs;
	}


}


