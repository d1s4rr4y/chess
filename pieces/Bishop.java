package pieces;

import java.util.ArrayList;

import board.Board;
import board.Space;

public class Bishop extends Piece {
    public Bishop(boolean white) {
        super(white, 3);   
    }

    public boolean canMove(Board board, Space start, Space end) {
        if (end.getPiece().isWhite() == this.isWhite()) return false;

        // validate move 
        /*
         * (x1, y1) -> (x2, y2) is valid iff |x2 - x1| == |y2 - y1|
         */
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());

        if (x == y) return true;
        else return false;
    }
}
