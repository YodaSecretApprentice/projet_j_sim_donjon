package mapGenerator;

import java.util.Random;


class BodyGuard extends ElementMobile {
	private Boolean vivant;

	public BodyGuard(final Map map) {
		super(map, "Bodyguard.jpg", "BodyGuard");
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
