package configuration;

public interface Configurable {
	
	int getLongueur();

	int getLargeur();

	int getNombreDePerso();
	
	int getDensiteRochers();
	
	int getDensiteMurs();
	
	String getStrategie();

	void setLongueur(int longueur);

	void setLargeur(int largeur);

	void setNombreDePerso(int nombreDePerso);
	
	void setStrategie(String strategie);
	
	void setDensiteMurs(int densiteMurs);
	
	void setDensiteRochers(int densiteRochers);
	
}
