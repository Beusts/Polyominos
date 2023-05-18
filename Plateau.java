/**
 * Classe Plateau
 */
public class Plateau {
    /**
     * Nombre de lignes
     */
    int nbLigne;

    /**
     * Nombre de colonnes
     */
    int nbColonne;

    /**
     * Tableau de cellules
     */
    Cellule[][] plateau;

    /**
     * Crée un plateau de nbLigne lignes et nbColonne colonnes
     */
    public Plateau(int nbLigne, int nbColonne) {
        if (nbLigne < 0 || nbLigne > 99 || nbColonne < 0 || nbColonne > 26) {
            Ecran.afficherln("Erreur : nombre de lignes ou de colonnes incorrect taille par default");
            nbLigne = 10;
            nbColonne = 12;
        }
        this.nbLigne = nbLigne;
        this.nbColonne = nbColonne;
        plateau = new Cellule[nbLigne][nbColonne];
        for (int i = 0; i < nbLigne; i++) {
            for (int j = 0; j < nbColonne; j++) {
                plateau[i][j] = new Cellule();
            }
        }
    }

    /**
     * Crée un plateau de 10 lignes et 12 colonnes par default
     */
    public Plateau() {
        this(10, 12);
    }

    /**
     * Affiche le plateau de jeu
     */
    public void afficher() {

        String s = "  +";
        for (int j = 0; j < nbColonne; j++) {
            s = s + "- ";
        }
        s = s + "+" + "\n";
        Ecran.afficher(s);
        for (int i = 0; i < nbLigne; i++) {
            if (i < 9)
                Ecran.afficher('0', i + 1, '|');
            else
                Ecran.afficher(i + 1, '|');
            for (int j = 0; j < nbColonne; j++) {
                Ecran.afficher(plateau[i][j].toString());
            }
            Ecran.afficherln('|');
        }
        Ecran.afficher(s);
        Ecran.afficher("   ");
        for (int j = 0; j < nbColonne; j++) {
            Ecran.afficher((char) (j + 65), ' ');
        }
    }

    /**
     * Permet de poser une pièce sur le plateau
     *
     * @param piece   une piece
     * @param ligne   nombre de lignes
     * @param colonne nombre de colonnes
     * @param motif   motif de la pièce
     * @return true si la pièce a été posée, false sinon
     */
    public boolean poser(String motif, Piece piece, int ligne, int colonne) {
        int nbLigne = piece.forme.length;
        int nbColonne = piece.forme[0].length;
        if (ligne < 1 || colonne < 1 || ligne > this.nbLigne || colonne > this.nbColonne || ligne + nbLigne - 1 > this.nbLigne || colonne + nbColonne - 1 > this.nbColonne) {
            Ecran.afficherln("Erreur : position incorrecte");
            return false;
        } else {
            for (int i = 0; i < nbLigne; i++) {
                for (int j = 0; j < nbColonne; j++) {
                    if (piece.forme[i][j]) {
                        if (plateau[ligne + i - 1][colonne + j - 1].occupe) {
                            Ecran.afficherln("Erreur : position déjà occupée");
                            return false;
                        }
                    }
                }
            }
            for (int i = 0; i < nbLigne; i++) {
                for (int j = 0; j < nbColonne; j++) {
                    if (piece.forme[i][j]) {
                        plateau[ligne + i - 1][colonne + j - 1].occupe = true;
                        plateau[ligne + i - 1][colonne + j - 1].motif = motif;
                    }
                }
            }
        }
        return true;

    }

}