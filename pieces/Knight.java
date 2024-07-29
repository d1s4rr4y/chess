package pieces;
import java.util.ArrayList;

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

    public Space[] allMoves(Board board, Space start) {
        ArrayList<Space> moves = new ArrayList<>();
        for(int i = start.getX() - 2; i < start.getX() + 3; i++){
            for(int j = start.getY() - 2; j < start.getY() + 3 ; j++) {
                if(canMove(board, start, board.getSpace(i, j))) {
                    moves.add(board.getSpace(i, j));
                }
            }
        }
        
        return moves.toArray(new Space[moves.size()]);
    }
}
