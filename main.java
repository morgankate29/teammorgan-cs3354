import game.Game;
import gui.ChessFrame;

public class main {
    public static void main(String[] args) {
        Game game = new Game();

        new ChessFrame(game);
    }
}
