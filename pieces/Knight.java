package pieces;
import board.Board;
import board.Space;

public class Knight extends Piece{
    public Knight(boolean white) {
        super(white, 3);
    }

    public boolean canMove(Board board, Space start, Space end) {
        if (end.getPiece().isWhite() == this.isWhite()) return false;

        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());

        return x * y == 2;
    }

    public String getDisplay() {
        if (this.isWhite()) return "N";
        else return "n";
    }
}
