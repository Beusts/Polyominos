public class Plateau{
	int nbLigne;
	int nbColonne;
	int [][]tab;
	
	public void Plateau(){
		this.nbLigne = 12;
		this.nbColonne = 10;
		this.tab = new int[nbLigne][nbColonne];	
	}
	
	public void Plateau(int nbLigne, int nbColonne){
		this.nbLigne = nbLigne;
		this.nbColonne = nbColonne;
		this.tab = new int[nbLigne][nbColonne];	
	}
	
	public void afficherVide(){
		Ecran.afficher("  +- - - - - - - - - - - - +\n");
		for (int i = 0; i < this.nbColonne; i++){
			Ecran.afficher("0", i, "|");
			if (i == 10)
				Ecran.afficher(i, "|");
			for (int j = 0; j < this.nbLigne; j++){
				Ecran.afficher(". ");
				}
			Ecran.afficher("|\n");
		}
		Ecran.afficher("  +- - - - - - - - - - - - +\n");
		Ecran.afficher("   A B C D E F G H I J K L\n");
	}
}