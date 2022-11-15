import java.util.Scanner;
public class GameRunner {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        WindowRenders window = new WindowRenders();
        GameInitializer gameClient = new GameInitializer();

        GameInitializer gc = new GameInitializer();
        gc.gameInit(window.playerWindowAndValue(), window);
        gc.gameStart();
        System.out.print(gc.getCurrentPlayers());
    }
}
