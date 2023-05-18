import java.util.Objects;

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
        this("Joueur", "X ", 20);
    }

    /**
     * Initialise l'inventaire du joueur
     */
    public void inventaire() {
        piece[0] = new Piece("dominos", new boolean[2][2]);
        piece[0].dominos();
        piece[1] = new Piece("triominos_L", new boolean[3][2]);
        piece[1].triominos_L();
        piece[2] = new Piece("triominos_I", new boolean[3][2]);
        piece[2].triominos_I();
        piece[3] = new Piece("tetrominos_O", new boolean[4][2]);
        piece[3].tetrominos_O();
        piece[4] = new Piece("tetrominos_I", new boolean[4][2]);
        piece[4].tetrominos_I();
        piece[5] = new Piece("tetrominos_T", new boolean[4][2]);
        piece[5].tetrominos_T();
        piece[6] = new Piece("tetrominos_L", new boolean[4][2]);
        piece[6].tetrominos_L();
        piece[7] = new Piece("tetrominos_J", new boolean[4][2]);
        piece[7].tetrominos_J();
        piece[8] = new Piece("tetrominos_S", new boolean[4][2]);
        piece[8].tetrominos_S();
        piece[9] = new Piece("tetrominos_Z", new boolean[4][2]);
        piece[9].tetrominos_Z();
        piece[10] = new Piece("dominos", new boolean[2][2]);
        piece[10].dominos();
        piece[11] = new Piece("triominos_L", new boolean[3][2]);
        piece[11].triominos_L();
        piece[12] = new Piece("triominos_I", new boolean[3][2]);
        piece[12].triominos_I();
        piece[13] = new Piece("tetrominos_O", new boolean[4][2]);
        piece[13].tetrominos_O();
        piece[14] = new Piece("tetrominos_I", new boolean[4][2]);
        piece[14].tetrominos_I();
        piece[15] = new Piece("tetrominos_T", new boolean[4][2]);
        piece[15].tetrominos_T();
        piece[16] = new Piece("tetrominos_L", new boolean[4][2]);
        piece[16].tetrominos_L();
        piece[17] = new Piece("tetrominos_J", new boolean[4][2]);
        piece[17].tetrominos_J();
        piece[18] = new Piece("tetrominos_S", new boolean[4][2]);
        piece[18].tetrominos_S();
        piece[19] = new Piece("tetrominos_Z", new boolean[4][2]);
        piece[19].tetrominos_Z();
    }

    /**
     * Initialise l'inventaire du joueur avec des pièces aléatoires
     */
    public void inventaireAlea(int [] alea){
        int taille = piece.length;
        for (int i = 0; i < taille; i++) {
            switch (alea[i]) {
                case 0:
                    piece[i] = new Piece("dominos", new boolean[2][2]);
                    piece[i].dominos();
                    break;
                case 1:
                    piece[i] = new Piece("triominos_L", new boolean[3][2]);
                    piece[i].triominos_L();
                    break;
                case 2:
                    piece[i] = new Piece("triominos_I", new boolean[3][2]);
                    piece[i].triominos_I();
                    break;
                case 3:
                    piece[i] = new Piece("tetrominos_O", new boolean[4][2]);
                    piece[i].tetrominos_O();
                    break;
                case 4:
                    piece[i] = new Piece("tetrominos_I", new boolean[4][2]);
                    piece[i].tetrominos_I();
                    break;
                case 5:
                    piece[i] = new Piece("tetrominos_T", new boolean[4][2]);
                    piece[i].tetrominos_T();
                    break;
                case 6:
                    piece[i] = new Piece("tetrominos_L", new boolean[4][2]);
                    piece[i].tetrominos_L();
                    break;
                case 7:
                    piece[i] = new Piece("tetrominos_J", new boolean[4][2]);
                    piece[i].tetrominos_J();
                    break;
                case 8:
                    piece[i] = new Piece("tetrominos_S", new boolean[4][2]);
                    piece[i].tetrominos_S();
                    break;
                case 9:
                    piece[i] = new Piece("tetrominos_Z", new boolean[4][2]);
                    piece[i].tetrominos_Z();
                    break;
            }
        }
    }

    /**
     * Affiche l'inventaire du joueur à la suite en ligne
     */
    public void afficherPieces(){
        int taille = piece.length;
        for (int i = 0; i < taille; i++) {
            if (piece[i] != null) {
                Ecran.afficherln(i + 1 + " : ");
                piece[i].afficher(this.motif);
                Ecran.afficherln();
            }

        }
    }

    public void enleverPiece(Piece piece){
        int taille = this.piece.length;
        for (int i = 0; i < taille; i++) {
            if (this.piece[i] != null) {
                if (Objects.equals(this.piece[i].nom, piece.nom)) {
                    this.piece[i] = null;
                    break;
                }
            }
        }
    }

    public int nbCarre(){
        int taille = piece.length;
        int nbCarre = 0;
        for (int i = 0; i < taille; i++) {
            if (piece[i] != null) {
                nbCarre += piece[i].taille;
            }
        }
        return nbCarre;

    }


}
