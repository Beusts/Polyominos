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
        piece[0] = new Piece("dominos", new boolean[2][2]);
        piece[0].dominos();
        piece[1] = new Piece("triominos_L", new boolean[3][2]);
        piece[1].triominos_L();
        piece[2] = new Piece("triominos_I", new boolean[3][2]);
        piece[2].triominos_I();
        piece[3] = new Piece("tétrominos_O", new boolean[4][2]);
        piece[3].tetrominos_O();
        piece[4] = new Piece("tétrominos_I", new boolean[4][2]);
        piece[4].tetrominos_I();
        piece[5] = new Piece("tétrominos_T", new boolean[4][2]);
        piece[5].tetrominos_T();
        piece[6] = new Piece("tétrominos_L", new boolean[4][2]);
        piece[6].tetrominos_L();
        piece[7] = new Piece("tétrominos_S", new boolean[4][2]);
        piece[7].tetrominos_S();
        piece[8] = new Piece("tétrominos_Z", new boolean[4][2]);
        piece[8].tetrominos_Z();
        piece[9] = new Piece("tétrominos_J", new boolean[4][2]);
        piece[9].tetrominos_J();


    }
}
