public class Cellule{
	String motif;
	boolean occupe;
	
	public Cellule(String motif,  boolean estLibre){
		this.motif = motif;
		this.occupe = occupe;
	}
	
	public Cellule(){
		this("X ", false);
	}
	
	public String estLibre(){
		if (occupe)
			return motif;
		else
			return ". ";
	}
	
}