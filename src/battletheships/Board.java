package battletheships;

import java.util.HashMap;

/**
 * Created by bears8yourface on 1/11/16.
 */
public class Board {
    private HashMap spaces = new HashMap(100);

    public Board() {
        for (int i=0; i<100; i++) {
            spaces.put(i, "");
        }
    }

    public HashMap spaces() {
        return spaces;
    }
}
