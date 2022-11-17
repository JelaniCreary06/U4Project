import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

public class GameSetup  implements KeyListener{
    private WindowRenders winRender;
    private ArrayList<String> charAssignment = new ArrayList<>(
            Arrays.asList(
                    "wasd", "ijkl"
                    /*
                    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                    "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
                    */
            )
    );

    private ArrayList<Player> playerList = new ArrayList<Player>();

    protected final String COLOR_RED = "\u001B[31m";
    protected final int MAX_PLAYERS = charAssignment.size();
    protected int activePlayers;

    protected boolean activeGame = false;

    /**
     * Used to initialzie a GameSetup Class.
     * @param winRender The window object we'll use.
     */
    public GameSetup(WindowRenders winRender) {
        this.winRender = winRender;
    }

    /**
     * Not really used for much, this is used for class extensions.
     */
    public GameSetup() {

    }

    /** Initializes a game by displaying the Player Selection screen.
     */
    public void init()  {
        int currentPlayers = winRender.playerSelectionScreen();

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
            default: location = 530; toMinus = 350;
                break;
        }

        int d = 1;

        for (Player player : playerList) {

            winRender.display(player, location);
            location -= toMinus;
            d++;
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
