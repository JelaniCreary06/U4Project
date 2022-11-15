import java.util.Scanner;
public class GameRunner {
    public static void main(String[] args) {
       WindowRenders window = new WindowRenders();
       final GameInitializer GAME = new GameInitializer();

       GAME.gameInit(window.playerSelectionScreen(), window);
       System.out.println(GAME.getCurrentPlayers());

       GAME.gameStart();
    }
}
