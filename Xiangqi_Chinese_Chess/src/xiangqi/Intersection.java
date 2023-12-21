package xiangqi;

public class Intersection {

    private Piece piece;


    public Intersection(Piece piece) {
        this.piece = piece;
    }


    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }


    public boolean isEmpty() {
        return piece == null;
    }
}
