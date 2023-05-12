/**
 * Classe Joueur
 */
public class Joueur {
    /**
     * Nom du joueur
     */
    String nom;
    /**
     * Motif du joueur
     */
    String motif;
    /**
     * Inventaire du joueur
     */
    Piece[] piece;

    /**
     * Crée un joueur avec le nom et le motif donné
     *
     * @param nom   Nom du joueur
     * @param motif Motif du joueur
     */
    public Joueur(String nom, String motif, int nbPiece) {
        this.nom = nom;
        this.motif = motif;
        piece = new Piece[nbPiece];
    }

    /**
     * Crée un joueur par default
     */
    public Joueur() {
        this("Joueur", "X ", 10);
    }

    /**
     * initialise l'inventaire du joueur
     */
    public void inventaire() {
        piece[0] = new Piece("Carre", new boolean[2][2]);
        piece[0].carre();
    }
}
