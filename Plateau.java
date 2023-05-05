public class Plateau{
	int nbLigne;
	int nbColonne;
	//Cellule [][]tab;
	
	public Plateau(int nbLigne, int nbColonne){
		if (nbLigne < 1 || nbLigne > 99 || nbColonne < 1 || nbColonne > 26 ){
			Ecran.afficherln("valeur non valide les valeur sont mis par defaut");
			this.nbLigne = 10;
			this.nbColonne = 12;
		}else{
			this.nbLigne = nbLigne;
			this.nbColonne = nbColonne;
			
		}
		Cellule[][] tab = new Cellule[this.nbLigne][this.nbColonne];
		//Cellule c = new Cellule();
		
		/*
		for (int i = 0; i < this.nbLigne; i++){
			for (int j = 0; j < this.nbColonne; j++){
				tab[i][j] = c;
		}
		}
		*/
		
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 12; j++){
				tab[i][j] = new Cellule();
			}
		}
	}
	
	public Plateau(){
		this(10,12);
	}
	/*
	public void afficherVide(){
		Ecran.afficher("  +");
		for (int i =0; i < nbColonne; i++){
			Ecran.afficher("- ");
		}
		Ecran.afficher("+\n");
		for (int i = 1; i <= this.nbLigne; i++){
			if (i >= 10)
				Ecran.afficher(i, "|");
			else
				Ecran.afficher("0", i, "|");
			for (int j = 0; j < this.nbColonne; j++){
				Ecran.afficher(". ");
				}
			Ecran.afficher("|\n");
		}
		Ecran.afficher("  +");
		for (int i =0; i < nbColonne; i++){
			Ecran.afficher("- ");
		}
		Ecran.afficher("+\n   ");
		for (int i =0; i < nbColonne; i++){
			Ecran.afficher((char)(i+65), " ");
		}
		Ecran.afficher("\n");
	}
	
	public void afficher(){
		Ecran.afficher("  +");
		for (int i =0; i < nbColonne; i++){
			Ecran.afficher("- ");
		}
		Ecran.afficher("+\n");
		for (int i = 0; i < this.nbLigne; i++){
			if (i + 1 >= 10)
				Ecran.afficher(i + 1, "|");
			else
				Ecran.afficher("0", i + 1, "|");
			for (int j = 0; j < this.nbColonne; j++){
				Ecran.afficher(this.tab[i][j].estLibre());
				}
			Ecran.afficher("|\n");
		}
		Ecran.afficher("  +");
		for (int i =0; i < nbColonne; i++){
			Ecran.afficher("- ");
		}
		Ecran.afficher("+\n   ");
		for (int i =0; i < nbColonne; i++){
			Ecran.afficher((char)(i+65), " ");
		}
		Ecran.afficher("\n");
	}
	*/
}