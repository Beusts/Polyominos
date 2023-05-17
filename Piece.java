public class Piece {
    /**
     * Nom de la pièce
     */
    String nom;

    /**
     * Motif de la pièce
     */
    boolean[][] forme;

    /**
     * Taille de la pièce
     */
    int taille;

    /**
     * Crée une pièce avec le nom et la forme donnée
     *
     * @param nom   Nom de la pièce
     * @param forme Forme de la pièce
     */
    public Piece(String nom, boolean[][] forme) {
        this.nom = nom;
        this.forme = forme;
    }

    /**
     * Crée une pièce par default
     */
    public Piece() {
        this("Piece", new boolean[1][1]);
    }

    public void dominos() {
        forme = new boolean[][]{{true, false}, {true, false}};
        taille = 2;
    }

    public void triominos_L() {
        forme = new boolean[][]{{true, true}, {false, true}};
        taille = 3;
    }

    public void triominos_I() {
        forme = new boolean[][]{{true, false}, {true, false}, {true, false}};
        taille = 3;

    }

    public void tétrominos_O() {
        forme = new boolean[][]{{true, true}, {true, true}};
        taille = 4;
    }

    public void tétrominos_I() {
        forme = new boolean[][]{{true, false}, {true, false}, {true, false}, {true, false}};
        taille = 4;

    }

    public void tétrominos_T() {
        forme = new boolean[][]{{false, true, false}, {true, true, true}};
        taille = 4;
    }

    public void tétrominos_J() {
        forme = new boolean[][]{{false, true}, {false, true}, {true, true}};
        taille = 4;
    }

    public void tétrominos_L() {
        forme = new boolean[][]{{true, false}, {true, false}, {true, true}};
        taille = 4;
    }

    public void tétrominos_S() {
        forme = new boolean[][]{{false, true, true}, {true, true, false}};
        taille = 4;
    }

    public void tétrominos_Z() {
        forme = new boolean[][]{{true, true, false}, {false, true, true}};
        taille = 4;
    }


}
