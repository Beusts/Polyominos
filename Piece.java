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

    /**
     * Cree une tetraminos carré
     */
    void carre() {
        forme = new boolean[2][2];
        forme[0][0] = true;
        forme[0][1] = true;
        forme[1][0] = true;
        forme[1][1] = true;
        this.forme = forme;
    }

    public void dominos() {
		matrice[0][0] = 1;
		matrice[][] = 1;
		}
	
	
	
	public void triominos_L() {
		matrice[][] = 1;
		matrice[][] = 1;
		matrice[][] = 1;
		}
	
	public void triominos_I() {
		matrice[][] = 1;
		matrice[][] = 1;
		matrice[][] = 1;
		}
	
	
	
	
	public void tétrominos_O() {
        matrice[][] = 1;
		matrice[][] = 1;
		matrice[][] = 1;
        matrice[][] = 1;
		}
	
	public void tétrominos_I() {
		matrice[][] = 1;
		matrice[][] = 1;
		matrice[][] = 1;
        matrice[][] = 1;
			}
		
	public void tétrominos_T() {
	    matrice[][] = 1;
        matrice[][] = 1;
        matrice[][] = 1;
		matrice[][] = 1;
		}
			
	public void tétrominos_J() {
		matrice[][] = 1;
		matrice[][] = 1;
		matrice[][] = 1;
		matrice[][] = 1;		
		}
			
	public void tétrominos_S() {
		matrice[][] = 1;
		matrice[][] = 1;
		matrice[][] = 1;
		matrice[][] = 1;
	    }
		
	public void tétrominos_Z() {
		matrice[][] = 1;
		matrice[][] = 1;
		matrice[][] = 1;
		matrice[][] = 1;
		}
		
	public void tétrominos_I() {
		matrice[][] = 1;
		matrice[][] = 1;
		matrice[][] = 1;
		matrice[][] = 1;		
		}

    
    
}
