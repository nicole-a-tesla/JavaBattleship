package battletheships;

import java.util.HashMap;

/**
 * Created by bears8yourface on 1/13/16.
 */
public class PrintKey {
    public static final HashMap dictionary = new HashMap<SpaceState, String>() {
        {
            put(SpaceState.WATER, "~");
            put(SpaceState.SHIP, "^");
            put(SpaceState.MISS, "0");
            put(SpaceState.HIT, "X");
        }
    };
}
