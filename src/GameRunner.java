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

        System.out.print("The game kind of broke, and dosent work as intended\nso this is a spam test"
                + " get as many points as possible!\nAim to beat your score!\nYou have 3 minutes.");


            GAME.init();
            GAME.start();

            System.out.println(GAME.getCurrentPlayers());

            try {
                Thread.sleep(180000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("\n\nScore: " + gameRendering.score());
            }


    }
}
