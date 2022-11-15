import java.util.*;

public class Player {
    private int playerNumber, playerPoints = 0, keysPressed = 0;

    String charArray[];

    public Player(int playerNumber, String charArray[]) {

        this.playerNumber = playerNumber;
        this.charArray = charArray;
    }

    public Hashtable<String, Integer> playerData() {
        return new Hashtable<>(
                Map.of(
                        "Player Position", this.playerNumber,
                        "Points", this.playerPoints,
                        "Keys Pressed", this.keysPressed
                )
        );
    }

   public String toString() {
        String toReturn = "Player " + this.playerNumber +
                "\nPoints: " + this.playerPoints +
                "Keys Pressed: " + this.keysPressed;

        return toReturn;
   }
}
