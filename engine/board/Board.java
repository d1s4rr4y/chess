package board;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Queen;
import pieces.Rook;
import pieces.Pawn;

public class Board {
    Tile[][] board;

    public Board() {
        this.resetBoard();
    }

    public Tile getTile(int x, int y) throws Exception {
        if(x < 0 || x > 7 || y < 0 || y > 7) {
            throw new Exception("index out of bounds");
        }
        return board[x][y];
    }

    public void resetBoard() {
        // initialise white pieces
        board[0][0] = new Tile(0, 0, new Rook(true));
        board[0][1] = new Tile(0, 1, new Knight(true));
        board[0][2] = new Tile(0, 2, new Bishop(true));
        board[0][3] = new Tile(0, 3, new Queen(true));
        board[0][4] = new Tile(0, 4, new King(true));
        board[0][5] = new Tile(0, 5, new Bishop(true));
        board[0][6] = new Tile(0, 6, new Knight(true));
        board[0][7] = new Tile(0, 7, new Rook(true));

        for(int i = 0; i < board[1].length; i++) {
            board[1][i] = new Tile(0, i, new Pawn(true));
        }


        // initialise black pieces 
        board[7][0] = new Tile(7, 0, new Rook(false));
        board[7][1] = new Tile(7, 1, new Knight(false));
        board[7][2] = new Tile(7, 2, new Bishop(false));
        board[7][3] = new Tile(7, 3, new Queen(false));
        board[7][4] = new Tile(7, 4, new King(false));
        board[7][5] = new Tile(7, 5, new Bishop(false));
        board[7][6] = new Tile(7, 6, new Knight(false));
        board[7][7] = new Tile(7, 7, new Rook(false));

        for(int i = 0; i < board.length; i++) {
            board[6][i] = new Tile(0, i, new Pawn(false));
        }

        // set other spacces to empty (null)
        for(int i = 2; i < 6; i++) {
            for(int j = 0; j < board[1].length; j++) {
                board[i][j] = new Tile(i, j, null);
            }
        }
    }
}