package board;

import pieces.Piece;
import player.Player;

public class Move {
    private Player player;
    private Space start;
    private Space end;
    private Piece pieceMoved;
    private Piece killedPiece;
    private boolean castlingMove = false;

    public Move(Player player, Space start, Space end) {
        this.player = player;
        this.start = start;
        this.end = end;
        this.pieceMoved = start.getPiece();
    }

    public boolean isCastlingMove() {
        return this.castlingMove;
    }

    public void setCastlingMove(boolean c){
        this.castlingMove = c;
    }

    public Space getStart(){
        return this.start;
    }

    public Space getEnd() {
        return this.end;
    }

    public void setPieceKilled(Piece p){
        this.killedPiece = p;
    }
}
