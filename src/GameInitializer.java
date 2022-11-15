import java.util.*;

public class GameInitializer {
    private WindowRenders window;

    private ArrayList<String> charAssignment = new ArrayList<>(
            Arrays.asList(
                    "wasd", "ijkl", "tfgh", "8456"
                    /*
                    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                    "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
                    */
            )
    );

    private ArrayList<Player> playerList = new ArrayList<Player>();

    protected final String COLOR_RED = "\u001B[31m";
    protected final int MAX_PLAYERS = charAssignment.size();
    private int activePlayers;

    public void gameInit(int currentPlayers, WindowRenders window)  {
        if (currentPlayers > this.MAX_PLAYERS)
            throw new ArithmeticException("Too many players!\nThe max is: " + this.MAX_PLAYERS
                    + ", " + currentPlayers + " players were inputted!\n");

        this.window = window;
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

    public void gameStart() {
        if (this.activePlayers <= 0)
            throw new ArrayIndexOutOfBoundsException("No players!\n"
                    +"Initialize the player list with the gameInit method!\n\n");
    }

    public void gameClear() {

    }

    public int maxPlayers() {
        return this.MAX_PLAYERS;
    }

    public ArrayList<Player> getCurrentPlayers() {
        return playerList;
    }

    public int playerCount() {
        return this.activePlayers;
    }

    public static void main(String[] args) {


    }


}
