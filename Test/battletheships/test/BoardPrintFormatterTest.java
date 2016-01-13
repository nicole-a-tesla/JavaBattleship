package battletheships.test;

import battletheships.BoardPrintFormatter;
import battletheships.StateTranslator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by bears8yourface on 1/13/16.
 */

public class BoardPrintFormatterTest {

    public static final HashMap map = new HashMap<StateTranslator, String>() {
        {
            put(StateTranslator.WATER, "~");
            put(StateTranslator.SHIP, "^");
            put(StateTranslator.MISS, "0");
            put(StateTranslator.HIT, "X");
        }
    };



    private ArrayList generateParsedRowOf(StateTranslator state) {
        ArrayList row = new ArrayList();

        for (int i=0; i<10; i++)
            row.add(state);
        return row;
    }

    private ArrayList<ArrayList> generateParsedBoardOf(StateTranslator state) {
        ArrayList<ArrayList> board = new ArrayList<>();

        for (int i=0; i<10; i++)
            board.add(generateParsedRowOf(state));
        return board;
    }

    private ArrayList generateFormattedRowOf(StateTranslator state) {
        ArrayList row = new ArrayList();

        for (int i=0; i<10; i++)
            row.add(map.get(state));
        return row;
    }

    private ArrayList<ArrayList> generateFormattedBoardOf(StateTranslator state) {
        ArrayList<ArrayList> board = new ArrayList<>();

        for (int i=0; i<10; i++)
            board.add(generateFormattedRowOf(state));
        return board;
    }

    @Test
    public void formatsBoardOfWater() {
        ArrayList<ArrayList> parsedBoard = generateParsedBoardOf(StateTranslator.WATER);
        BoardPrintFormatter formatter = new BoardPrintFormatter();
        ArrayList expected = generateFormattedBoardOf(StateTranslator.WATER);
        ArrayList formatted = formatter.format(parsedBoard);

        assertEquals(expected, formatted);
    }
}
