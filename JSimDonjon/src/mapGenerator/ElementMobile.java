package mapGenerator;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

abstract class ElementMobile implements PlateauPiece {
	public final static int NORD = 0;
	public final static int EST = 1;
	public final static int SUD = 2;
	public final static int OUEST = 3;

	protected int x;
	protected int y;
	protected int direction;
	protected Image image = null;
	protected Map map;
	protected String espece;

	public ElementMobile(final Map map, final String image, final int x,
			final int y, final int direction, final String espece) {
		this.map = map;
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.espece = espece;
		this.setImage(image);
	}

	public ElementMobile(final Map map, final String image,
			final String espece) {
		this(map, image, 0, 0, NORD, espece);
	}

	protected int calculerNouveauX() {
		switch (this.direction) {
		case EST:
			if (this.x < (this.map.getConfiguration().getLargeur() - 1)) {
				return this.x + 1;
			}
		case OUEST:
			if (this.x > 0) {
				return this.x - 1;
			}
		default:
			return this.x;
		}
	}

	protected int calculerNouveauY() {
		switch (this.direction) {
		case NORD:
			if (this.y > 0) {
				return this.y - 1;
			}
		case SUD:
			if (this.y < (this.map.getConfiguration().getLongueur() - 1)) {
				return this.y + 1;
			}
		default:
			return this.y;
		}
	}

	protected abstract void changerDirection();


	public String getEspece() {
		return this.espece;
	}

	@Override
	public Image getImage() {
		return this.image;
	}

	@Override
	public int getPositionHorizontale() {
		return this.getX();
	}

	@Override
	public int getPositionVerticale() {
		return this.getY();
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void deplacerMonstre(){	//Le déplacement du monstre

		this.changerDirection();
	}
	
	public void deplacerPersonnages() {
		this.changerDirection();

		final int x = this.calculerNouveauX();
		final int y = this.calculerNouveauY();

		if (this.map.getXY(x, y).estVide()) {
			this.x = x;
			this.y = y;
		}
	}

	public void setImage(final String image) {
		try {
			this.image = ImageIO.read(new File("images/" + image));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	public void setX(final int x) {
		this.x = x;
	}

	public void setY(final int y) {
		this.y = y;
	}

}
