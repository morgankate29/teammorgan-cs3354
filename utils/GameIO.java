/**
 * GameIO class
 * Handles saves and loads of game state using Java serialization
 */
package utils;

import java.io.*;

import game.Game;

public class GameIO {
    /**
     * Save game method
     * Serializes the Game object to a file "chess_save.dat"
     * 
     * @param game
     */
    public static void saveGame(Game game) {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("chess_save.dat"))) {
            out.writeObject(game);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Load game method
     * Deserializes the Game object from the file "chess_save.dat"
     * @return
     */
    public static Game loadGame() {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("chess_save.dat"))) {
            return (Game) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
