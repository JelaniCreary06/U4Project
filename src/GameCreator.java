import java.awt.*;
import java.util.*;

public class GameCreator {
    protected final String COLOR_RED = "\u001B[31m";
    protected final int MAX_PLAYERS = 2;
    protected int currentPlayers;

    ArrayList<String> charAssignment = new ArrayList<String>(
            Arrays.asList(
                    "wasd", "ijkl", "tfgh"
                    /*
                    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                    "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
                    */
            )
    );

    ArrayList<Player> playerList = new ArrayList<Player>();

    public GameCreator(int currentPlayers) {
        for (int i = 1; i < currentPlayers+1; i++) {
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
    }

    public int maxPlayers() {
        return this.MAX_PLAYERS;
    }

    public static void main(String[] args) {
        GameCreator gc = new GameCreator(4);
    }


}
