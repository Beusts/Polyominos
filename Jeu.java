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
     * Crée un jeu avec le plateau, les joueurs entrés par l'utilisateur
     **/
    public void personnalisee() {
        Ecran.afficherln("Entrez le nom du joueur 1");
        String nomJoueur1 = Clavier.saisirString();
        Ecran.afficherln("Entrez le nom du joueur 2");
        String nomJoueur2 = Clavier.saisirString();
        Ecran.afficherln("Entrez le motif du joueur 1");
        String motifJoueur1 = Clavier.saisirString();
        Ecran.afficherln("Entrez le motif du joueur 2");
        String motifJoueur2 = Clavier.saisirString();
        Ecran.afficherln("Entrez le nombre de pièces");
        int nbPiece = Clavier.saisirInt();
        this.joueur1 = new Joueur(nomJoueur1, motifJoueur1 + " ", nbPiece);
        this.joueur2 = new Joueur(nomJoueur2, motifJoueur2 + " ", nbPiece);
        Ecran.afficherln("Le plateau est créé en fonction des piece choisies aléatoirement");

        int[] alea = new int[nbPiece];
        for (int i = 0; i < nbPiece; i++) {
            alea[i] = (int) (Math.random() * 10);
        }
        joueur1.inventaireAlea(alea);
        joueur2.inventaireAlea(alea);
        int nbCarre = joueur1.nbCarre();
        int cote = (int) Math.sqrt(nbCarre * 2);
        Ecran.afficherln("Le plateau est de " + cote + "x" + cote);
        this.plateau = new Plateau(cote, cote);
    }

    /**
     * Crée un jeu par default
     */
    public Jeu() {
        this(new Plateau(), new Joueur("joueur1", "O ", 10), new Joueur("joueur2", "X ", 10));
    }

    public void regle() {
        Ecran.afficherln("Chaque joueur dispose d'un ensemble de pièces, qui sont des polyominos(dominos, triominos, tétrominos), et qu'il place tour à tour sur un plateau (une grille rectangulaire).");
        Ecran.afficherln("Il s'agit d'un jeu de blocage : le perdant est le premier joueur qui ne peut plus placer de pièce. Choix de jouer face à un autre joueur ou un ordinateur");
        Ecran.afficherln("Les piece sont placer en fonction du coin supérieure gauche de la piece");
        Ecran.afficherln();
    }

    /**
     * Permet de choisir comment veut jouer
     */
    public void jouer() {
        Ecran.afficherln("Bienvenu dans le Jeu de blocage avec polyominos");
        Ecran.afficherln("1 : Jouer");
        Ecran.afficherln("2 : Règle");
        Ecran.afficherln("3 : Quitter");
        int choix = Clavier.saisirInt();
        switch (choix) {
            case 1:
                parametrage();
                modeDeJeu();
                break;
            case 2:
                regle();
                jouer();
                break;
            case 3:
                Ecran.afficherln("Au revoir");
                break;
            default:
                Ecran.afficherln("Erreur : choix incorrect");
                jouer();
                break;
        }
    }

    public void parametrage() {
        Ecran.afficherln("1 : Plateau par default");
        Ecran.afficherln("2 : Plateau personnalisée");
        int choix = Clavier.saisirInt();
        switch (choix) {
            case 1:
                this.joueur1 = new Joueur("joueur1", "O ", 20);
                this.joueur1.inventaire();
                this.joueur2 = new Joueur("joueur2", "X ", 20);
                this.joueur2.inventaire();
                this.plateau = new Plateau();
                break;
            case 2:
                personnalisee();
                break;
            default:
                Ecran.afficherln("Erreur : choix incorrect");
                parametrage();
                break;
        }
    }

    /**
     * Permet de choisir contre qui jouer
     */
    public void modeDeJeu() {
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
                modeDeJeu();
                break;
        }
    }

    /**
     * Lance une partie de joueur contre joueur
     */
    public void jouerJCJ() {
        plateau.afficher();
        while (true) {
            if (!perdu(joueur1)) {
                Ecran.afficherln("Au tour de " + joueur1.nom);
                poser(joueur1, plateau);
                plateau.afficher();
            } else {
                Ecran.afficherln(joueur1.nom, " a perdu");
                break;
            }
            if (!perdu(joueur2)) {
                Ecran.afficherln("Au tour de ", joueur2.nom);
                poser(joueur2, plateau);
                plateau.afficher();
            } else {
                Ecran.afficherln(joueur1.nom, " a perdu");
                break;
            }
        }
    }

    /**
     * Lance une partie de joueur contre IA
     **/
    public void jouerJCI() {
        plateau.afficher();
        while (true) {
            if (!perdu(joueur1)) {
                Ecran.afficherln("Au tour de " + joueur1.nom);
                poser(joueur1, plateau);
                plateau.afficher();
            } else {
                Ecran.afficherln(joueur1.nom, " a perdu");
                break;
            }
            if (!perdu(joueur2)) {
                Ecran.afficherln("Au tour de ", joueur2.nom);
                poserIA(joueur2, plateau);
                plateau.afficher();
            } else {
                Ecran.afficherln(joueur1.nom, " a perdu");
                break;
            }
        }
    }

    /**
     * Lance une partie d'IA contre IA
     **/
    public void jouerICI() {
        plateau.afficher();
        while (true) {
            if (!perdu(joueur1)) {
                Ecran.afficherln("Au tour de " + joueur1.nom);
                poserIA(joueur1, plateau);
                plateau.afficher();
            } else {
                Ecran.afficherln(joueur1.nom, " a perdu");
                break;
            }
            if (!perdu(joueur2)) {
                Ecran.afficherln("Au tour de ", joueur2.nom);
                poserIA(joueur2, plateau);
                plateau.afficher();
            } else {
                Ecran.afficherln(joueur2.nom, " a perdu");
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
        Ecran.afficherln("Choisissez une rotation : ");
        piece.afficherRotation(joueur.motif);
        int rotation = Clavier.saisirInt();
        for (int i = 0; i < rotation; i++) {
            piece.rotation();
        }
        plateau.afficher();
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
