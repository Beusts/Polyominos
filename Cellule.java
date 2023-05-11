/**
 * Classe Cellule
 */
public class Cellule{
	/**
	 * Motif de la cellule
	 */
	String motif;
	/**
	 * Etat de la cellule
	 */
	boolean occupe;

	/**
	 * Crée une cellule avec le motif et l'état donné
	 * @param motif Motif de la cellule
	 * @param occupe Etat de la cellule
	 */
	public Cellule(String motif,  boolean occupe){
		this.motif = motif;
		this.occupe = occupe;
	}
	/**
	 * Crée une cellule par default
	 */
	public Cellule(){
		this("X ", false);
	}

	/**
	 * Renvoie le motif de la cellule si elle est occupée sinon renvoie ". "
	 * @return motif de la cellule
	 */
	public String estLibre(){
		if (occupe)
			return motif;
		else
			return ". ";
	}
	
}