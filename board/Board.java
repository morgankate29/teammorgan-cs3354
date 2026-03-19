package board;
import CS3354_Prog1.pieces.Bishop;
import CS3354_Prog1.pieces.King;
import CS3354_Prog1.pieces.Knight;
import CS3354_Prog1.pieces.Pawn;
import CS3354_Prog1.pieces.Queen;
import CS3354_Prog1.pieces.Rook;
import pieces.Piece;
import utils.Position;

public class Board {
    private Piece [][] board;

    public Board() {
        board = new Piece[8][8];
        initializeBoard();
    }
    /**
    * Initialization method
    */
    private void initializeBoard() {
        /**
         * Initialize pawn positions, both black and white
         */
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn("black", new Position(1, i));
            board[6][i] = new Pawn("white", new Position(6, i));
        }

        /** 
         * Rooks
         */
        board[0][0] = new Rook("black", new Position(0, 0));
        board[0][7] = new Rook("black", new Position(0, 7));
        board[7][0] = new Rook("white", new Position(7, 0));
        board[7][6] = new Rook("white", new Position(7, 7));

        /** 
         * Knights
         */
        board[0][1] = new Knight("black", new Position(0, 1));
        board[0][6] = new Knight("black", new Position(0, 7));
        board[7][1] = new Knight("white", new Position(7, 0));
        board[7][6] = new Knight("white", new Position(7, 7));

        /** 
         * Bishops
         */
        board[0][2] = new Bishop("black", new Position(0, 2));
        board[0][5] = new Bishop("black", new Position(0, 5));
        board[7][2] = new Bishop("white", new Position(7, 2));
        board[7][5] = new Bishop("white", new Position(7, 5));

        /** 
         * Queens
         */
        board[0][3] = new Queen("black", new Position(0, 3));
        board[7][3] = new Queen("white", new Position(7, 3));

        /** 
         * Kings
         */
        board[0][4] = new King("black", new Position(0, 4));
        board[7][4] = new King("white", new Position(7, 4));
    }

    public Piece getPiece(Position pos) {
        return board[pos.getRow()][pos.getCol()];
    }

    public void setPiece(Position pos, Piece piece) {
        board[pos.getRow()][pos.getCol()] = piece;
    }

    /**
    * public boolean movePiece(Position from, Position to) {
    */

    /**
     * Display method
     */

    public void display() {
        System.out.println("  A B C D E F G H");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < 8; j++) {
                //Each element should store a reference to a Piece or be null if the square is empty
                if (board[i][j] == null) {
                    System.out.print("## ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
