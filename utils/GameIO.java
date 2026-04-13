package utils;

import java.io.*;

import game.Game;

public class GameIO {
    public static void saveGame(Game game) {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("chess_save.dat"))) {
            out.writeObject(game);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static Game loadGame() {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("chess_save.dat"))) {
            return (Game) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
