package battletheships;

import java.util.HashMap;

/**
 * Created by bears8yourface on 1/13/16.
 */
public class PrintKey {
    public static final HashMap dictionary = new HashMap<StateTranslator, String>() {
        {
            put(StateTranslator.WATER, "~");
            put(StateTranslator.SHIP, "^");
            put(StateTranslator.MISS, "0");
            put(StateTranslator.HIT, "X");
        }
    };
}
