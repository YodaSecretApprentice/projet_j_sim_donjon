package mapGenerator;

import javax.swing.JFrame;



class PlateauFenetre extends JFrame
{

 private static final long serialVersionUID = 0xa4e975e5eb08987dL;
 private final PlateauPanneau plateauPanneau;

 public PlateauFenetre(int largeur, int hauteur, Case[][] m_case)
 {
     setTitle("Plateau de jeu");
     setSize(700, 700);
     setLocationRelativeTo(null);
     setDefaultCloseOperation(3);
     plateauPanneau = new PlateauPanneau(largeur, hauteur, m_case);
     setContentPane(plateauPanneau);
     setVisible(true);
 }

 public void placerPiece(PlateauPiece piece)
 {
     plateauPanneau.placerPiece(piece);
 }

 public void rafraichir()
 {
     plateauPanneau.repaint();
 }
}
