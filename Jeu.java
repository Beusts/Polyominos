/**
 * La classe Jeu permet de jouer au jeu
 */
public class Jeu {
    Plateau plateau;
    Joueur joueur1;
    Joueur joueur2;

    /**
     * Crée un jeu avec le plateau, les joueurs donnés
     *
     * @param plateau Plateau de jeu
     * @param joueur1 Joueur 1
     * @param joueur2 Joueur 2
     */
    public Jeu(Plateau plateau, Joueur joueur1, Joueur joueur2) {
        this.plateau = plateau;
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }

    /**
     * Crée un jeu par default
     */
    public Jeu() {
        this(new Plateau(), new Joueur("joueur1", "X ", 10), new Joueur("joueur2", "O ", 10));
    }

    public void regle() {
        Ecran.afficherln("Chaque joueur dispose d'un ensemble de pièces, qui sont des polyominos(dominos, triominos, tétrominos), et qu'il place tour à tour sur un plateau (une grille rectangulaire).");
        Ecran.afficherln("Il s'agit d'un jeu de blocage : le perdant est le premier joueur qui ne peut plus placer de pièce. Choix de jouer face à un autre joueur ou un ordinateuré");
        Ecran.afficherln("Les piece sont placer en fonction du coin supérieure gauche de la piece");
    }

    public void choix() {
    }

    public void jouer() {
        joueur1.inventaire();
        joueur2.inventaire();

        while (!perdu(joueur1) && !perdu(joueur2)) {
            plateau.afficher();
            poser(joueur1, plateau);
            plateau.afficher();

            if (!perdu(joueur2)) {
                poser(joueur2, plateau);
            }
        }
        if (perdu(joueur1)) {
            Ecran.afficherln("Le joueur 1 a perdu");
        } else {
            Ecran.afficherln("Le joueur 2 a perdu");
        }
    }

    /**
     * Vérifie si le joueur a perdu donc ne peut pas poser de pièce
     *
     * @param joueur Joueur à vérifier
     * @return true si le joueur a perdu, false sinon
     **/
    public boolean perdu(Joueur joueur) {
        int taille = joueur.piece.length;
        for (int i = 0; i < taille; i++) {
            if (joueur.piece[i] != null) {
                for (int j = 0; j < 4; j++) {
                    for (int k = 1; k <= plateau.nbLigne; k++) {
                        for (int l = 1; l <= plateau.nbColonne; l++) {
                            if (plateau.poser(joueur.motif, joueur.piece[i], k, l, false)) {
                                return false;
                            }
                        }
                    }
                    joueur.piece[i].rotation();
                }
            }
        }
        return true;

    }

    /**
     * Permet à un joueur de poser une pièce sur le plateau
     *
     * @param joueur  Joueur qui pose la pièce
     * @param plateau Plateau sur lequel la pièce est posée
     */
    public void poser(Joueur joueur, Plateau plateau) {
        Ecran.afficherln("Choisissez une pièce à poser : ");
        joueur.afficherPieces();
        int choix = Clavier.saisirInt();
        Piece piece = joueur.piece[choix - 1];
        Ecran.afficherln("Choisissez une position : ");
        piece.afficherRotation(joueur.motif);
        int rotation = Clavier.saisirInt();
        for (int i = 0; i < rotation; i++) {
            piece.rotation();
        }
        Ecran.afficherln("Choisissez une ligne : ");
        int ligne = Clavier.saisirInt();
        Ecran.afficherln("Choisissez une colonne : ");
        int colonne = Clavier.saisirChar() - 64;
        if (plateau.poser(joueur.motif, piece, ligne, colonne, true)) {
            joueur.enleverPiece(piece);
        } else {
            poser(joueur, plateau);
        }

    }

}
