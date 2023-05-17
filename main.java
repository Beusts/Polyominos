public class main {
    public static void main(String[] args) {
        Piece piece = new Piece();
        piece.tetrominos_L();
        piece.afficher("X ");
        piece.rotation();
        Ecran.afficherln();
        piece.afficher("X ");

    }
}