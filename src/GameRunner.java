import java.util.Scanner;
public class GameRunner {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
       CreateWindow window = new CreateWindow();
       GameCreator nG = new GameCreator(window.startScreen());
       window.gameScreen();
       System.out.println(nG.getCurrentPlayers());
    }
}
