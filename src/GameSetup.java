import java.util.*;

public class GameSetup {
    private WindowRenders winRender;
    private ArrayList<String> charAssignment = new ArrayList<>(
            Arrays.asList(
                    "wasd", "ijkl", "tfgh"
                    /*
                    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                    "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
                    */
            )
    );

    private ArrayList<Integer> locationList1 = new ArrayList<>(
            Arrays.asList(
                    700, 0
            )
    );
    private ArrayList<Player> playerList = new ArrayList<Player>();

    protected final String COLOR_RED = "\u001B[31m";
    protected final int MAX_PLAYERS = charAssignment.size();
    protected int activePlayers;

    protected boolean activeGame = false;

    public GameSetup(WindowRenders winRender) {
        this.winRender = winRender;
    }

    public GameSetup() {

    }

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

    public void start() {
        for (Player player : playerList) {
            winRender.display(player);
        }
    }

    public int maxPlayers() {
        return this.MAX_PLAYERS;
    }

    public ArrayList<Player> getCurrentPlayers() {
        return playerList;
    }


}
