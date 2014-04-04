package mapGenerator;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Case implements PlateauCase {
	protected Image image = null;
	protected char dessin;
	protected Boolean vide;

	public Case(final String image, final Boolean vide) {
		this.vide = vide;
		try {
			this.image = ImageIO.read(new File("images/" + image));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	public Boolean estVide() {
		return this.vide;
	}

	public char getDessin() {
		return this.dessin;
	}

	public Image getImage() {
		return this.image;
	}

}