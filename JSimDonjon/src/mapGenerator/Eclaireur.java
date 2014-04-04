package mapGenerator;

import java.util.Random;


class Eclaireur extends ElementMobile {
	private Boolean vivant;

	public Eclaireur(final Map map) {
		super(map, "pikatchu.jpg", "Eclaireur");
		this.vivant = true;
	}

	@Override
	protected void changerDirection() {

		this.direction = new Random().nextInt(4);
	}

	public void mourir() {
		this.vivant = false;
		this.setImage("tombe.jpg");
		this.espece="Personnage Mort";
	}

	@Override
	public void deplacerPersonnages() {
		if (!this.vivant) {
			return;
		}
		super.deplacerPersonnages();
	}
}
