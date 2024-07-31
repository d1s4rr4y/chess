package pieces;

import board.Board;
import board.Space;

public class King extends Piece {
    private boolean castled = false;

    public King(boolean white) {
        super(white, Integer.MAX_VALUE);
    }

    public boolean hasCastled() {
        return this.castled;
    }

    public void setCastled(boolean c) {
        this.castled = c;
    }

    public boolean canMove(Board board, Space start, Space end) {
        if (end.getPiece().isWhite() == this.isWhite()) return false;
        
        // validate move (x + y == 1 and new space is not under attack)
        
        /* 
         * Move from (x1, y1) -> (x2, y2) is valid iff |x2 - x1| <= 1 and |y2 - y1| <= 1
        */

        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        if( x <= 1 && y <= 1 && !isCastlingMove(start, end)) return true;
        else if (isValidCastle(board, start, end)) return true;
        else return false;
    }

    private boolean isValidCastle(Board board, Space start, Space end) {
        if (this.hasCastled()) return false;

        // validate 
        return true;
    }

    public boolean isCastlingMove(Space start, Space end) {
        // validate/check start and end positions
        return true; 
    }
}
