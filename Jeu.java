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
        Ecran.afficher("Chaque joueur dispose d'un ensemble de pièces, qui sont des polyominos(dominos, triominos, tétrominos), et qu'il place tour à tour sur un plateau (une grille rectangulaire).");
        Ecran.afficher("Il s'agit d'un jeu de blocage : le perdant est le premier joueur qui ne peut plus placer de pièce. Choix de jouer face à un autre joueur ou un ordinateuré");
    }

    public void choix() {
    }

    public void jouer() {
        joueur1.inventaire();
        joueur2.inventaire();

        while (!perdu()) {
            poser(joueur1, plateau);
            if (perdu()) {
                break;
            }
            poser(joueur2, plateau);
        }
    }

    /**
     * Vérifie si le joueur a perdu
     *
     * @return true si le joueur a perdu, false sinon
     **/
    public boolean perdu() {
        return false;
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
        int colonne = Clavier.saisirChar() - 65;
        if (plateau.poser(joueur.motif, piece, ligne, colonne)) {
            joueur.enleverPiece(piece);
        } else {
            poser(joueur, plateau);
        }

    }

}
