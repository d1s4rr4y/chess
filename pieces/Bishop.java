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
        
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());

        if (x == y) return true;
        else return false;
    }

    public Space[] allMoves(Board board, Space start) {
        ArrayList<Space> moves = new ArrayList<>();
        int x = start.getX();
        int y = start.getY();
        boolean blocked = false;
        while(!blocked) {
            if(canMove(board, start, board.getSpace(x++, y++))) {
                moves.add(board.getSpace(x++, y++));
                x++;
                y++;
            } else {
                blocked = true;
            }
        }

        x = start.getX();
        y = start.getY();
        blocked = false;
        while(!blocked) {
            if(canMove(board, start, board.getSpace(x++, y--))) {
                moves.add(board.getSpace(x++, y--));
                x++;
                y--;
            } else {
                blocked = true;
            }
        }

        x = start.getX();
        y = start.getY();
        blocked = false;
        while(!blocked) {
            if(canMove(board, start, board.getSpace(x--, y++))) {
                moves.add(board.getSpace(x--, y++));
                x--;
                y++;
            } else {
                blocked = true;
            }
        }

        x = start.getX();
        y = start.getY();
        blocked = false;
        while(!blocked) {
            if(canMove(board, start, board.getSpace(x--, y--))) {
                moves.add(board.getSpace(x--, y--));
                x--;
                y--;
            } else {
                blocked = true;
            }
        }
        
        return moves.toArray(new Space[moves.size()]);
    }
}
