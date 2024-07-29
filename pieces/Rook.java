package pieces;

import board.Board;
import board.Space;

public class Rook extends Piece{
    public Rook(boolean white) {
        super(white, 5);
    }

    public boolean canMove(Board board, Space start, Space end) {
        if (end.getPiece().isWhite() == this.isWhite()) return false;

        // validate move
        /*
         * (x1, y1) -> (x2, y2) is valid iff x2 == x1 or y2 == y1
         */

        if(start.getX() == end.getX() || start.getY() == end.getY()) return true;
        else return false; 
    }

    public String getDisplay() {
        if (this.isWhite()) return "R";
        else return "r";
    }
}
