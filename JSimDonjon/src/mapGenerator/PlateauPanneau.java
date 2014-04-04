package mapGenerator;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;



class PlateauPanneau extends JPanel
{

    private static final long serialVersionUID = 0xcdc821a9b0532c80L;
    private final Case[][] plateauCases;
    private final ArrayList<PlateauPiece> pieces = new ArrayList<PlateauPiece>();
    private final int largeur;
    private final int hauteur;

    public PlateauPanneau(int largeur, int hauteur, Case[][] m_case)
    {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.plateauCases = m_case;
    }

    public void paintComponent(Graphics g)
    {
        int tailleLargeur = getWidth() / largeur;
        int tailleHauteur = getHeight() / hauteur;
        for(int i = 0; i < largeur; i++)
        {
            for(int j = 0; j < hauteur; j++)
            {
                g.drawImage(plateauCases[i][j].getImage(), tailleLargeur * i, tailleHauteur * j, tailleLargeur, tailleHauteur, this);
            }

        }

        PlateauPiece piece;
        for(Iterator<PlateauPiece> iterator = pieces.iterator(); iterator.hasNext(); g.drawImage(piece.getImage(), tailleLargeur * piece.getPositionHorizontale(), tailleHauteur * piece.getPositionVerticale(), tailleLargeur, tailleHauteur, this))
        {
            piece = (PlateauPiece)iterator.next();
        }

    }

    public void placerPiece(PlateauPiece piece)
    {
        pieces.add(piece);
    }
}
