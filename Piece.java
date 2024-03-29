/**
 * Classe Piece
 **/
public class Piece {
    /**
     * Nom de la pièce
     **/
    String nom;

    /**
     * Motif de la pièce
     **/
    boolean[][] forme;

    /**
     * Taille de la pièce
     **/
    int taille;

    /**
     * Crée une pièce avec le nom et la forme donnée
     *
     * @param nom   Nom de la pièce
     * @param forme Forme de la pièce
     **/
    public Piece(String nom, boolean[][] forme) {
        this.nom = nom;
        this.forme = forme;
    }

    /**
     * Effectue une rotation de 90 degrés sens horaire de la pièce
     **/
    public void rotation() {
        int nbLigne = forme.length;
        int nbColonne = forme[0].length;
        boolean[][] formeRotation = new boolean[nbColonne][nbLigne];
        for (int i = 0; i < nbLigne; i++) {
            for (int j = 0; j < nbColonne; j++) {
                formeRotation[j][nbLigne - 1 - i] = forme[i][j];
            }
        }
        forme = formeRotation;
    }
    
   /**
     * Afficher les polyominos
     **/    
    public void afficher(String motif) {
        int nbLigne = forme.length;
        int nbColonne = forme[0].length;
        for (int i = 0; i < nbLigne; i++) {
            for (int j = 0; j < nbColonne; j++) {
                if (forme[i][j])
                    Ecran.afficher(motif);
                else
                    Ecran.afficher(". ");
            }
            Ecran.afficherln();
        }
    }
    /**
     * Affiche toutes les rotations de la pièce
     **/
    public void afficherRotation(String motif){
        Ecran.afficherln("1.");
        afficher(motif);
        Ecran.afficherln("\n2.");
        rotation();
        afficher(motif);
        Ecran.afficherln("\n3.");
        rotation();
        afficher(motif);
        Ecran.afficherln("\n4.");
        rotation();
        afficher(motif);
    }

    /**
     * Crée une pièce par default
     **/
    public Piece() {
        this("Piece", new boolean[1][1]);
    }

    /**
     * Initialise la pièce à la forme d'un domino
     **/
    public void dominos() {
        forme = new boolean[][]{{true}, {true}};
        taille = 2;
    }

    /**
     * Initialise la pièce à la forme d'un triominos en L
     **/
    public void triominos_L() {
        forme = new boolean[][]{{true, true}, {false, true}};
        taille = 3;
    }

    /**
     * Initialise la pièce à la forme d'un triominos en I
     **/
    public void triominos_I() {
        forme = new boolean[][]{{true}, {true}, {true}};
        taille = 3;

    }

    /**
     * Initialise la pièce à la forme d'un tetrominos en
     **/
    public void tetrominos_O() {
        forme = new boolean[][]{{true, true}, {true, true}};
        taille = 4;
    }

    /**
     * Initialise la pièce à la forme d'un tetrominos en I
     **/
    public void tetrominos_I() {
        forme = new boolean[][]{{true}, {true}, {true}, {true}};
        taille = 4;

    }

    /**
     * Initialise la pièce à la forme d'un tetrominos en T
     **/
    public void tetrominos_T() {
        forme = new boolean[][]{{false, true, false}, {true, true, true}};
        taille = 4;
    }

    /**
     * Initialise la pièce à la forme d'un tetrominos en L
     **/
    public void tetrominos_L() {
        forme = new boolean[][]{{true, false}, {true, false}, {true, true}};
        taille = 4;
    }

    /**
     * Initialise la pièce à la forme d'un tetrominos en J
     **/
    public void tetrominos_J() {
        forme = new boolean[][]{{false, true}, {false, true}, {true, true}};
        taille = 4;
    }

    /**
     * Initialise la pièce à la forme d'un tetrominos en S
     **/
    public void tetrominos_S() {
        forme = new boolean[][]{{false, true, true}, {true, true, false}};
        taille = 4;
    }

    /**
     * Initialise la pièce à la forme d'un tetrominos en Z
     **/
    public void tetrominos_Z() {
        forme = new boolean[][]{{true, true, false}, {false, true, true}};
        taille = 4;
    }


}
