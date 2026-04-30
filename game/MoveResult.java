/**
 * MoveResult class to encapsulate the result of a move
 * Includes whether the move was successful, if it resulted in check or checkmate, and the winner if applicable
 * Used in Game makeMove to return info about the outcome of a move
 */
package game;

public class MoveResult {
    public boolean moved;
    public boolean check;
    public boolean checkmate;
    public String winner;
    
    public MoveResult(boolean moved, boolean check, boolean checkmate, String winner) {
        this.moved = moved;
        this.check = check;
        this.checkmate = checkmate;
        this.winner = winner;
    }
}
