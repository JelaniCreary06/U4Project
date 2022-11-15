import javax.naming.SizeLimitExceededException;
import java.awt.*;
import java.util.*;

public class GameCreator {
    private CreateWindow window;
    private ArrayList<String> charAssignment = new ArrayList<>(
            Arrays.asList(
                    "wasd", "ijkl", "tfgh"
                    /*
                    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                    "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
                    */
            )
    );

    private ArrayList<Player> playerList = new ArrayList<Player>();

    private final String COLOR_RED = "\u001B[31m";
    private final int MAX_PLAYERS = charAssignment.size();
    private int activePlayers;

    public GameCreator(int currentPlayers)  {
        if (currentPlayers > this.MAX_PLAYERS)
            throw new ArithmeticException("Too many players!\nThe max is: " + this.MAX_PLAYERS
                    + ", " + currentPlayers + " players were inputted!\n");

        for (int i = 0; i < currentPlayers; i++) {
            int toGet = (int) Math.random() * charAssignment.size();

            String toParse = charAssignment.get(toGet);
            String charArray[] = new String[toParse.length()];

            charAssignment.remove(toGet);

            for (int ai = 0; ai < toParse.length(); ai++) {
                charArray[ai] = toParse.charAt(ai)+"";
            }

            Player newPlayer = new Player(i, charArray);
            playerList.add(newPlayer);
        }

        this.activePlayers = playerList.size();
    }

    public GameCreator(String emptyString) {
       //This is used so we can initalize GameCreator without starting a game.
    }

    public GameCreator() {

    }

    public int maxPlayers() {
        return this.MAX_PLAYERS;
    }

    public ArrayList<Player> getCurrentPlayers() {
        return playerList;
    }

    public static void main(String[] args) {

        GameCreator gc = new GameCreator(5);
        System.out.print(gc.getCurrentPlayers());
    }


}
