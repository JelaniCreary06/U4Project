import java.awt.*;
import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       final WindowRenders windowRenders = new WindowRenders();
       final GameSetup GAME = new GameSetup(windowRenders);

       /*
       boolean gameFinished = false;

       while(!gameFinished) {

       }
       */
        Dimension size
                = Toolkit.getDefaultToolkit().getScreenSize();
        // width will store the width of the screen
        int width = (int)size.getWidth();

        // height will store the height of the screen
        int height = (int)size.getHeight();

        System.out.println("Current Screen resolution : "
                + "width : " + width
                + " height : " + height);

        System.out.print("This is a reaction test!\nPress the corresponding letter that will appear on your screen."
        + "\n Scores and an interactive tutorial, and a timer will be added next, just have fun for now!"
        + "\n The game will start in 5 seconds.");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            GAME.init();
            GAME.start();

            System.out.println(GAME.getCurrentPlayers());
        }


    }
}
