import java.security.cert.PolicyQualifierInfo;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import board.Board;
import board.Chessboard;
import board.Move;
import board.Space;
import pieces.Piece;
import player.ComputerPlayer;
import player.HumaPlayer;
import player.Player;
import pieces.King;

public class Game {
    private Player[] players;
    private Board board;
    private Player currentTurn;
    private GameStatus status;
    private List<Move> movesPlayed;

    public void initialise(Player p1, Player p2) {
        players[0] = p1;
        players[1] = p2;

        board.resetBoard();
        this.currentTurn = (p1.isWhite()) ? p1 : p2;
        movesPlayed.clear();
        board.printBoard();
    }

    public boolean isEnd() {
        return this.getStatus() != GameStatus.ACTIVE;
    }

    public GameStatus getStatus() {
        return this.status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public boolean playerMove(Player player, int startX, int startY, int endX, int endY) {
        Space startSpace = board.getSpace(startX, startY);
        Space endSpace = board.getSpace(endX, endY);

        Move move = new Move(player, startSpace, endSpace);
        return this.makeMove(move, player);
    }

    public boolean makeMove(Move move, Player player) {
        Piece sourcePiece = move.getStart().getPiece();
        if(sourcePiece == null 
            || player != currentTurn
            || sourcePiece.isWhite() != player.isWhite()
            || !sourcePiece.canMove(board, move.getStart(), move.getEnd())) 
            return false;

        Piece destPiece = move.getEnd().getPiece();
        if(destPiece != null) {
            destPiece.setKilled(true);
            move.setPieceKilled(destPiece);
        }

        if(sourcePiece instanceof King && ((King) sourcePiece).isCastlingMove(move.getStart(), move.getEnd()))
            move.setCastlingMove(true);
        
            movesPlayed.add(move);

            move.getEnd().setPiece(move.getStart().getPiece());
            move.getStart().setPiece(null);

            if(destPiece instanceof King) {
                if(player.isWhite()) this.setStatus(GameStatus.WHITE_WIN);
                else this.setStatus(GameStatus.BLACK_WIN);
            }

            this.currentTurn = this.currentTurn == players[0] ? players[1] : players[0];
            board.printBoard();
            return true;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Chessboard cb = new Chessboard();

                JFrame f = new JFrame("Chess");
                f.add(cb.getGui());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);
                f.pack();
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}