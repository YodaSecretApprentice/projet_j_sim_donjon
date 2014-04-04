package Game;


import configuration.*;
import mapGenerator.AfficheOptions;
import mapGenerator.Map;

public class JSimDonjon {

	public static int DUREE_TOUR = 250;

	public static void main(String[] args) {
		final ParametresDeConf configuration = new ParametresDeConf();
		try {
			final FenetreDeConf fdc = new FenetreDeConf(configuration);
			fdc.setVisible(true);
			if (fdc.getAnswer().equals("Ok")) {
				
				AfficheOptions status = new AfficheOptions();
				
				final Map m_map = new Map(configuration);
				
				for (;;) {
					
					m_map.affichageGraphique();	
					m_map.jouer();
					m_map.definirPause(status);
					
				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}


