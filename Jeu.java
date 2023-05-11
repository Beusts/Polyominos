/**
 * La classe Jeu permet de jouer au jeu
 */
public class Jeu {
    Plateau plateau;

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
