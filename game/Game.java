/**
 * Includes game attributes and methods
 */

package game;
import board.Board;
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

    public void reset() {
        board = new Board();
        userTurn = "white";
    }
}
