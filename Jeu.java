/**
 * La classe Jeu permet de jouer au jeu
 */
public class Jeu {
    Plateau plateau;

//affichage des règles
public void regle(){
		Ecran.afficher("Chaque joueur dispose d'un ensemble de pièces, qui sont des polyominos(dominos, triominos, tétrominos), et qu'il place tour à tour sur un plateau (une grille rectangulaire).");
		Ecran.afficher("Il s'agit d'un jeu de blocage : le perdant est le premier joueur qui ne peut plus placer de pièce. Choix de jouer face à un autre joueur ou un ordinateuré");	
	}
    
   
    /**
     * Crée un jeu
     */
    public Jeu(){
        plateau = new Plateau();
    }

//on doit pouvoir choisir son mode de jeu
public void Choix(){
}

//on code les tours faient par les joueurs pour qu'ils puissent jouer 
public void Jouer(){
}

//permettre au meilleur de gagner
//si l'adversaire ne peut plus placer de piece
public boolean Gagner(){
    return true;
}

}
