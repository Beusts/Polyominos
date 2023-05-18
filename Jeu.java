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
        this(new Plateau(5,5), new Joueur("joueur1", "O ", 10), new Joueur("joueur2", "X ", 10));
    }

    public void regle() {
        Ecran.afficherln("Chaque joueur dispose d'un ensemble de pièces, qui sont des polyominos(dominos, triominos, tétrominos), et qu'il place tour à tour sur un plateau (une grille rectangulaire).");
        Ecran.afficherln("Il s'agit d'un jeu de blocage : le perdant est le premier joueur qui ne peut plus placer de pièce. Choix de jouer face à un autre joueur ou un ordinateuré");
        Ecran.afficherln("Les piece sont placer en fonction du coin supérieure gauche de la piece");
    }

    /**
     * Permet de choisir le mode de jeu
     */
    public void choix() {
        Ecran.afficherln("Choix du mode de jeu : ");
        Ecran.afficherln("1 : Joueur contre Joueur");
        Ecran.afficherln("2 : Joueur contre IA");
        Ecran.afficherln("3 : IA contre IA");
        int choix = Clavier.saisirInt();
        switch (choix) {
            case 1:
                jouerJCJ();
                break;
            case 2:
                jouerJCI();
                break;
            case 3:
                jouerICI();
                break;
            default:
                Ecran.afficherln("Erreur : choix incorrect");
                choix();
                break;
        }
    }

    /**
     * Lance une partie de joueur contre joueur
     */
    public void jouerJCJ() {
        joueur1.inventaire();
        joueur2.inventaire();
        while (true) {
            if (!perdu(joueur1)) {
                Ecran.afficherln("Au tour du joueur 1");
                poser(joueur1, plateau);
                plateau.afficher();
            }else {
                Ecran.afficherln("Le joueur 1 a perdu");
                break;
            }
            if (!perdu(joueur2)) {
                Ecran.afficherln("Au tour du joueur 2");
                poser(joueur2, plateau);
                plateau.afficher();
            } else {
                Ecran.afficherln("Le joueur 2 a perdu");
                break;
            }
        }
    }

    /**
     * Lance une partie de joueur contre IA
     **/
    public void jouerJCI() {
        joueur1.inventaire();
        joueur2.inventaire();

        while (true) {
            if (!perdu(joueur1)) {
                Ecran.afficherln("Au tour du joueur 1");
                poser(joueur1, plateau);
                plateau.afficher();
            }else {
                Ecran.afficherln("Le joueur 1 a perdu");
                break;
            }
            if (!perdu(joueur2)) {
                Ecran.afficherln("Au tour du joueur 2");
                poserIA(joueur2, plateau);
                plateau.afficher();
            } else {
                Ecran.afficherln("Le joueur 2 a perdu");
                break;
            }
        }
    }

    /**
     * Lance une partie d'IA contre IA
     **/
    public void jouerICI() {
        joueur1.inventaire();
        joueur2.inventaire();
        int i = 0;
        plateau.afficher();
        while (true) {
            if (!perdu(joueur1)) {
                Ecran.afficherln("Au tour du joueur 1");
                joueur1.motif = (char) (65 + i) + " ";
                poserIA(joueur1, plateau);
                plateau.afficher();
                i++;
            }else {
                Ecran.afficherln("Le joueur 1 a perdu");
                break;
            }
            if (!perdu(joueur2)) {
                Ecran.afficherln("Au tour du joueur 2");
                joueur2.motif = (char) (96 + i) + " ";
                poserIA(joueur2, plateau);
                plateau.afficher();
            } else {
                Ecran.afficherln("Le joueur 2 a perdu");
                break;
            }
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
                            if (plateau.peutPoser(joueur.piece[i], k, l, false)) {
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
        if (plateau.peutPoser(piece, ligne, colonne, true)) {
            plateau.poser(joueur.motif, piece, ligne, colonne);
            joueur.enleverPiece(piece);
        } else {
            poser(joueur, plateau);
        }
    }

    /**
     * Permet à un joueurIA de poser une pièce sur le plateau
     *
     * @param joueurIA JoueurIA qui pose la pièce
     * @param plateau  Plateau sur lequel la pièce est posée
     */
    public void poserIA(Joueur joueurIA, Plateau plateau) {
        boolean go = true;
        int nbLigne, nbColonne, numPiece;
        while (go) {
            nbLigne = (int) (Math.random() * plateau.nbLigne) + 1;
            nbColonne = (int) (Math.random() * plateau.nbColonne) + 1;

            numPiece = (int) (Math.random() * joueurIA.piece.length);
            Piece piece = joueurIA.piece[numPiece];
            while (piece == null) {
                numPiece = (int) (Math.random() * joueurIA.piece.length);
                piece = joueurIA.piece[numPiece];
            }
            int rotation = (int) (Math.random() * 4);
            for (int i = 0; i < rotation; i++) {
                piece.rotation();
            }
            if (plateau.peutPoser(piece, nbLigne, nbColonne, false)) {
                plateau.poser(joueurIA.motif, piece, nbLigne, nbColonne);
                joueurIA.enleverPiece(piece);
                go = false;
            }
        }

    }

}
