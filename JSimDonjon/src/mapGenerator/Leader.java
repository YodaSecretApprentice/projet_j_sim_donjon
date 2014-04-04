package mapGenerator;

import java.util.Random;


class Leader extends ElementMobile {
	private Boolean vivant;

	public Leader(final Map map) {
		super(map, "tux_albator.jpg", "Leader");
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
