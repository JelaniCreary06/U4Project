import java.util.*;
public class Player {
    Hashtable<String, Integer> dataTable = new Hashtable<>(
            Map.of(
                    "PlayerNumber", 0,
                    "Points", 0,
                    "KeysPressed", 0
            )
    );

    public Player(int playerNumber, String cArray[]) {
        dataTable.replace("PlayerNumber", playerNumber);
    }

    public Hashtable<String, Integer> toReturn() {

        return dataTable;
    }
}
