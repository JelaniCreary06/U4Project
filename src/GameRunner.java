public class GameRunner {
    public static void main(String[] args) {
       final WindowRenders windowRenders = new WindowRenders();
       final GameSetup GAME = new GameSetup(windowRenders);

       /*
       boolean gameFinished = false;

       while(!gameFinished) {

       }
       */
        GAME.init();
        GAME.start();

       System.out.println(GAME.getCurrentPlayers());


    }
}
