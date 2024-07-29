package pieces;

import board.Board;
import board.Space;

public class Queen extends Piece {
    public Queen(boolean white) {
        super(white, 9);
    }

    public boolean canMove(Board board, Space start, Space end) {
        if (end.getPiece().isWhite() == this.isWhite()) return false;

        // Validate move
        /* Valid if it is either a bishop or a rook move */

        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());

        if(start.getX() == end.getX() || start.getY() == end.getY() || x == y) return true;
        else return false;
    }
}
