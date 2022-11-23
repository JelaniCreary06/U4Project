import java.util.*;

public class Player {
    int playerNumber, playerPoints = 0, keysPressed = 0;

    String charArray[];

    /**
     * Initialize a new Player Object.
     * @param playerNumber The players position.
     * @param charArray The keys the player has to press.
     */
    public Player(int playerNumber, String charArray[]) {

        this.playerNumber = playerNumber;
        this.charArray = charArray;
    }

    /**
     *
     * @return Returns the player data as a Hashtable.
     */
    public Hashtable<String, Integer> playerData() {
        return new Hashtable<>(
                Map.of(
                        "Player Position", this.playerNumber,
                        "Points", this.playerPoints,
                        "Keys Pressed", this.keysPressed
                )
        );
    }

    /**
     * @return Returns the player position [player number].
     */
    public int playerPosition() {
        return this.playerNumber;
    }

    /*
   public String toString() {
        String toReturn = "Player " + this.playerNumber +
                "\nPoints: " + this.playerPoints +
                "Keys Pressed: " + this.keysPressed;

        return toReturn;
   }

     */
}
