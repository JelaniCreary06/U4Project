import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

public class GameSetup {
    private GameRendering gameRendering;
    private ArrayList<String> charAssignment = new ArrayList<>(
            Arrays.asList(
                    "wasd", "ijkl"
                    /*
                    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                    "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
                    */
            )
    );

    protected ArrayList<Player> playerList = new ArrayList<Player>();

    protected final String COLOR_RED = "\u001B[31m";
    protected final int MAX_PLAYERS = charAssignment.size();
    protected int activePlayers;

    protected boolean activeGame = false;

    /**
     * Used to initialzie a GameSetup Class.
     * @param gameRendering The window object we'll use.
     */
    public GameSetup(GameRendering gameRendering) {
        this.gameRendering = gameRendering;
    }

    /**
     * Not really used for much, this is used for class extensions.
     */
    public GameSetup() {

    }

    /** Initializes a game by displaying the Player Selection screen.
     */
    public void init()  {
        gameRendering.playerScreenExample();
        int currentPlayers = gameRendering.playerSelectionScreen();

        if (currentPlayers > this.MAX_PLAYERS)
            throw new ArithmeticException("Too many players!\nThe max is: " + this.MAX_PLAYERS
                    + ", " + currentPlayers + " players were inputted!\n");

        for (int i = 1; i <= currentPlayers; i++) {
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

    /**
     * Starts a game using WinRender methods and KeyListeners.
     */
    public void start() {
        int location = 0, toMinus = 400;

        switch (this.activePlayers) {
            case 1: location = 0;
                break;
            case 2: location = 200;
                break;
            case 3: location = 400;
                break;
            case 4: location = 530; toMinus = 350;
                break;
        }

        for (Player player : playerList) {

            gameRendering.display(player, location);
            location -= toMinus;
        }

        this.activeGame = true;
    }

    /**
     *
     * @return Returns each player Object.
     */
    public ArrayList<Player> getCurrentPlayers() {
        return playerList;
    }

}
