package pieces;
import board.Board;
import board.Space;

public class Pawn extends Piece {
    public Pawn(boolean white){
        super(white, 1);
    }

    public boolean canMove(Board board, Space start, Space end) {
        if (end.getPiece().isWhite() == this.isWhite()) return false;

        // validate move
        /*
         * (x1, y1) -> (x2, y2) is valid iff x2 = x1 and y2 - y1 = 1 (apart from first move, where y2 - y1 <= 2)
         */

        if(start.getX() == end.getX() && end.getY() - start.getY() == 1) return true; // For a white pawn, reverse for a black pawn 
        else return false;
    }

    public String getDisplay() {
        if (this.isWhite()) return "P";
        else return "p";
    }
}
