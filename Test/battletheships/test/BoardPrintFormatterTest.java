package battletheships.test;

import battletheships.BoardPrintFormatter;
import battletheships.PrintKey;
import battletheships.SpaceState;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by bears8yourface on 1/13/16.
 */

public class BoardPrintFormatterTest {
    private PrintKey printKey = new PrintKey();

    private ArrayList generateParsedRowOf(SpaceState state) {
        ArrayList row = new ArrayList();

        for (int i=0; i<10; i++)
            row.add(state);
        return row;
    }

    private ArrayList<ArrayList> generateParsedBoardOf(SpaceState state) {
        ArrayList<ArrayList> board = new ArrayList<>();

        for (int i=0; i<10; i++)
            board.add(generateParsedRowOf(state));
        return board;
    }

    private ArrayList generateFormattedRowOf(SpaceState state) {
        ArrayList row = new ArrayList();

        for (int i=0; i<10; i++)
            row.add(printKey.dictionary.get(state));
        return row;
    }

    private ArrayList<ArrayList> generateFormattedBoardOf(SpaceState state) {
        ArrayList<ArrayList> board = new ArrayList<>();

        for (int i=0; i<10; i++)
            board.add(generateFormattedRowOf(state));
        return board;
    }

    @Test
    public void formatsBoardOfWater() {
        ArrayList<ArrayList> parsedBoard = generateParsedBoardOf(SpaceState.WATER);
        BoardPrintFormatter formatter = new BoardPrintFormatter(printKey);
        ArrayList expected = generateFormattedBoardOf(SpaceState.WATER);
        ArrayList formatted = formatter.format(parsedBoard);

        assertEquals(expected, formatted);
    }
}
