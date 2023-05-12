public class Piece {
    /**
     * Nom de la pièce
     */
    String nom;

    /**
     * Motif de la pièce
     */
    boolean [][] forme;

    /**
     * Crée une pièce avec le nom et la forme donnée
     * @param nom Nom de la pièce
     * @param forme Forme de la pièce
     */
    Piece(String nom, boolean [][] forme){
        this.nom = nom;
        this.forme = forme;
    }

    /**
     * Crée une pièce par default
     */
    Piece() {
        this("Piece", new boolean[1][1]);
    }

    /**
     * Cree une tetraminos carré
     */
    void carre(){
        forme = new boolean[2][2];
        forme[0][0] = true;
        forme[0][1] = true;
        forme[1][0] = true;
        forme[1][1] = true;
        this.forme = forme;
    }

}
