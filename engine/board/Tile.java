package board;
import pieces.Piece;

public class Space {
    private Piece piece;
    private int x, y;

    public Space(int x, int y, Piece p) {
        this.piece = p;
        this.x = x;
        this.y = y;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setPiece(Piece p) {
        this.piece = p;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}
