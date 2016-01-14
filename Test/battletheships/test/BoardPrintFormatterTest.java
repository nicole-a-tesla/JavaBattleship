package battletheships.test;

import battletheships.BoardPrintFormatter;
import battletheships.PrintKey;
import battletheships.Space;
import battletheships.SpaceState;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by bears8yourface on 1/13/16.
 */

public class BoardPrintFormatterTest {
    private HashMap printDictionary = new PrintKey().dictionary;
    private BoardPrintFormatter formatter = new BoardPrintFormatter(printDictionary);

    @Test
    public void formatsBoardOfWater() {
        ArrayList<ArrayList> parsedBoard = generateParsedBoardOf(SpaceState.WATER);
        ArrayList expected = generateFormattedBoardOf(SpaceState.WATER);
        ArrayList formatted = formatter.format(parsedBoard);

        assertEquals(expected, formatted);
    }

    @Test
    public void formatsBoardOfMisses() {
        ArrayList<ArrayList> parsedBoard = generateParsedBoardOf(SpaceState.MISS);
        ArrayList expected = generateFormattedBoardOf(SpaceState.MISS);
        ArrayList formatted = formatter.format(parsedBoard);

        assertEquals(expected, formatted);
    }


    private ArrayList<ArrayList> generateParsedBoardOf(SpaceState state) {
        ArrayList<ArrayList> board = new ArrayList<>();

        for (int i=0; i<10; i++)
            board.add(generateParsedRowOf(state));
        return board;
    }

    private ArrayList generateParsedRowOf(SpaceState state) {
        ArrayList row = new ArrayList();

        for (int i=0; i<10; i++)
            row.add(state);
        return row;
    }

    private ArrayList generateFormattedBoardOf(SpaceState state) {
        ArrayList board = new ArrayList<>();
        board.add(getXAxis());

        for (int i=0; i<10; i++) {
            board.add("\n");
            board.add(generateFormattedRowOf(state, i));
        }
        return board;
    }

    private String generateFormattedRowOf(SpaceState state, int y_coord) {
        StringBuilder formattedRow = new StringBuilder();
        String formattedYCoord = formatSpace(new Integer(y_coord).toString());
        formattedRow.append(formattedYCoord);

        for (int i=0; i<10; i++)
            formattedRow.append((generateSpace(state)));

        return formattedRow.toString();
    }

    private String generateSpace(SpaceState state) {
        String stateString = spaceStateToString(state);
        return formatSpace(stateString);
    }

    private String spaceStateToString(SpaceState state) {
        return (String) printDictionary.get(state);
    }

    private String formatSpace(String spaceContents) {
        return "| " + spaceContents + " ";
    }

    private String getXAxis() {
        StringBuffer axis = new StringBuffer();
        axis.append(formatSpace(" "));

        for (Integer i=0; i<10; i++) {
            axis.append(formatSpace(i.toString()));
        }

        return axis.toString();
    }
}
