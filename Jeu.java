/**
 * La classe Jeu permet de jouer au jeu
 */
public class Jeu {
    Plateau plateau;

    //affichage des règles
    public void regle() {
        Ecran.afficher("Chaque joueur dispose d'un ensemble de pièces, qui sont des polyominos(dominos, triominos, tétrominos), et qu'il place tour à tour sur un plateau (une grille rectangulaire).");
        Ecran.afficher("Il s'agit d'un jeu de blocage : le perdant est le premier joueur qui ne peut plus placer de pièce. Choix de jouer face à un autre joueur ou un ordinateuré");
    }

    /**
     * Crée un jeu
     */
    public Jeu() {
        plateau = new Plateau();
    }

    //on doit pouvoir choisir son mode de jeu
    public void Choix() {
    }

    //on code les tours faient par les joueurs pour qu'ils puissent jouer
    public void Jouer() {
    }

    /**
     * Vérifie si le joueur a perdu
     * @return true si le joueur a perdu, false sinon
     **/
    public boolean Perdu() {
        return true;
    }

    /**
     * Permet à un joueur de poser une pièce sur le plateau
     * @param joueur Joueur qui pose la pièce
     * @param plateau Plateau sur lequel la pièce est posée
     */
    public void poser(Joueur joueur, Plateau plateau){
        Ecran.afficher("Choisissez une pièce à poser : ");
        joueur.afficherPieces();
    }

}
