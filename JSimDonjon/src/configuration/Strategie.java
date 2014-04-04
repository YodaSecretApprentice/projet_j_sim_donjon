package configuration;

//
public enum Strategie {
	Fuyard,
	Groupe,
	Planque,
	Sacrifice;

	public static String descriptif(String strategie)
	{
		String descriptifStrategie;
		switch(strategie)
		{
		case ("Fuyard"):
			descriptifStrategie = "Le groupe de Fuyards n'ont pas de comportement rationnel,\n c'est chaqu'un pour sa Peau!\n "
									+ "Ils essayent de fuir dans la direction inverse du monstre\n en se dispersant les uns des autres...";
			return descriptifStrategie;
		
		case ("Groupe"):
			descriptifStrategie = "Les personnages restent groupés autour du leader et tentent de survivre ensemble\n du fait qu'ils sont nombreux ils peuvent s'échapper \nlorsqu'un des leurs se fait dévorer\n "
					+ ", Ils essayent de fuir dans la direction inverse du monstre en restant ensemble\n"
					+ "mais si le leader est mangé ils se dispersent rapidemment";
			return descriptifStrategie;
		
		case ("Planque"):
			descriptifStrategie = "Le groupe des planqués n'est pas en mouvement,\n ils se cachent et courent lorsque le monstre les trouvent !\n "
					+ ", Ils essayent de fuir dans la direction inverse du monstre\n en se dispersant les uns des autres";
			return descriptifStrategie;
		
		case ("Sacrifice"):
			descriptifStrategie = "Le groupe reste au centre du labyrinthe \net tente d'y revenir lorsque l'ogre n'y est plus\n"
					+ ",ils fuient en laissant un éclaireur à proximité du centre";
			return descriptifStrategie;
		
		default: return null;
		}
	}
	
	
}

