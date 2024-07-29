package pieces;
import board.Board;
import board.Space;

public abstract class Piece {
    private boolean killed = false;
    private boolean white = false;
    private int value;
    private String display;

    /* 
    Piece values: 
        - Pawn: 1
        - Knight: 3
        - Bishop: 3
        - Rook: 5
        - Queen: 9
    */

    public Piece(boolean white, int value) {
        this.white = white;
        this.value = value;
    }

    public boolean isWhite() {
        return this.white;
    }

    public boolean isKilled() {
        return this.killed;
    }

    public void setKilled(boolean k) {
        this.killed = k;
    }

    public int getValue() {
        return this.value;
    }

    public abstract boolean canMove(Board board, Space start, Space end);
}
