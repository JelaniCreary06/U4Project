import java.awt.*;
import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
       final GameRendering gameRendering = new GameRendering();
       final GameSetup GAME = new GameSetup(gameRendering);

       /*
       boolean gameFinished = false;

       while(!gameFinished) {

       }
       */

        System.out.print("This is a reaction test!\nPress the corresponding letter that will appear on your screen."
        + "\n Scores and an interactive tutorial, and a timer will be added next, just have fun for now!"
        + "\n The game will start in 5 seconds.");


            GAME.init();
            GAME.start();

            System.out.println(GAME.getCurrentPlayers());



    }
}
