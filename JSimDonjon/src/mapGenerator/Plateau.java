package mapGenerator;


public class Plateau
{

	private final PlateauFenetre plateauFenetre;

	public Plateau(int largeur, int hauteur, Case[][] m_case)
	{
		plateauFenetre = new PlateauFenetre(largeur, hauteur, m_case);
	}

	public void placerPiece(PlateauPiece piece)
	{
		plateauFenetre.placerPiece(piece);
	}

	public void rafraichir()
	{
		plateauFenetre.rafraichir();
	}
}
