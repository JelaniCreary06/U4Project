import java.util.*;

public class Player {
    Hashtable<String, Integer> dataTable = new Hashtable<>(
            Map.of(
                    "PlayerNumber", 0,
                    "Points", 0,
                    "KeysPressed", 0
            )
    );

    String charArray[];

    public Player(int playerNumber, String charArray[]) {

        this.charArray = charArray;
        dataTable.replace("PlayerNumber", playerNumber);
    }

    public Hashtable<String, Integer> getData() {
        return dataTable;
    }
}
