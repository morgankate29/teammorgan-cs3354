/**
 * Includes game attributes and methods
 */

package game;
import board.Board;
import pieces.Piece;
import utils.Position;

import java.util.List;
import java.util.Scanner;
import java.io.Serializable;

public class Game implements Serializable{
    private Board board;
    private String userTurn;

    /**
     * Constructor
     */
    public Game() {
        board = new Board();
        userTurn = "white";
    }

    /**
     * Returns the current board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Returns the current user's turn
     * @return
     */
    public String getUserTurn() {
        return userTurn;
    }

    /**
     * Main game loop
     * Handles user input and updates the board accordingly
     */
    public void play() {
        try (Scanner scnr = new Scanner(System.in)) {
            while(true) {
                board.display();

                System.out.println(userTurn + "'s move (e.g., E2, E4): ");
                String input = scnr.nextLine();

                if(input.matches("[A-H][1-8], [A-H][1-8]")) {
                    String[] parse = input.split(" ");
                    String firstPos = parse[0];
                    String newPos = parse[1];

                    System.out.println("From " + firstPos + " to " + newPos);

                    if(userTurn.equals("white")) {
                        userTurn = "black";
                    } else {
                        userTurn = "white";
                    }
                } else {
                    System.out.println("Invalid format. Try again. ");
                }
            }
        }
    }

    /**
     * Reset method to start a new game
     */
    public void reset() {
        board = new Board();
        userTurn = "white";
    }

    /**
     * Alternates between players after a valid move
     */
    private void switchTurn() {
        if(userTurn.equals("white")) {
            userTurn = "black";
        } else {
            userTurn = "white";
        }
    }

    /**
     * Helper function to find the position of the king
     * Argument: color of the king to find
     * Returns the position of the king, or null if not found
     */
    private Position findKing(String color) {
        Piece[][] b = board.getBoard();

        for(int r = 0; r < 8; r++) {
            for(int c = 0; c < 8; c++) {
                Piece p = b[r][c];
                if(p instanceof pieces.King && p.getColor().equals(color)) {
                    return new Position(r, c);
                }
            }
        }
        return null;
    }

    /**
     * Checks if the current player's king is in check
     * Returns true if king is in check, false otherwise
     */
    public boolean check(String color) {
        Position kingPos = findKing(color);
        if(kingPos == null) {
            return false;
        }

        Piece[][] b = board.getBoard();

        for(int r = 0; r < 8; r++) {
            for(int c = 0; c < 8; c++) {
                Piece p = b[r][c];
                if(p != null && !p.getColor().equals(color)) {
                    List<Position> moves = p.possibleMoves(b);
                    if(moves.contains(kingPos)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkmate(String color) {
        if(!check(color)) {
            return false;
        }

        Piece[][] b = board.getBoard();

        for(int r = 0; r < 8; r++) {
            for(int c = 0; c < 8; c++) {
                Piece p = b[r][c];

                if(p != null && p.getColor().equals(color)) {
                    List<Position> moves = p.possibleMoves(b);

                    for(int i = 0; i < moves.size(); i++) {
                        Position to = moves.get(i);
                        Position from = p.getPosition();

                        Board temp = board.copyBoard();
                        temp.movePiece(from, to);

                        Game tempGame = new Game();
                        tempGame.board = temp;

                        if(!tempGame.check(color)) {
                            return false;
                        }

                    }
                }
            }
        }
        return true;
    }
    /**
     * Move Piece Method
     * Validates the move based on the piece's possible moves and captures
     * @param firstPos
     * @param newPos
     * @return
     */
    public boolean makeMove(Position firstPos, Position newPos) {
        Piece piece = board.getPiece(firstPos);
        if(piece == null) {
            return false;
        }

        if(!piece.getColor().equals(userTurn)) {
            return false;
        }

        List<Position> validMoves = piece.possibleMoves(board.getBoard());

        if(!validMoves.contains(newPos)) {
            return false;
        }

        Piece targetPiece = board.getPiece(newPos);
        if(targetPiece != null && targetPiece.getColor().equals(piece.getColor())) {
            return false;
        }

        board.movePiece(firstPos, newPos);
        switchTurn();

        return true;
    }
}
