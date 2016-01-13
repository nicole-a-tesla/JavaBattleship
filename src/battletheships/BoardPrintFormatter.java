package battletheships;

import java.util.ArrayList;

/**
 * Created by bears8yourface on 1/13/16.
 */
public class BoardPrintFormatter {

    public ArrayList<ArrayList> format(ArrayList<ArrayList> parsedBoard) {
        ArrayList<ArrayList> formatted = new ArrayList<ArrayList>();

        for (ArrayList row : parsedBoard) {
            formatted.add(formatRow(row));
        }

        return formatted;
    }

    public ArrayList<String> formatRow(ArrayList row) {
        ArrayList formattedRow = new ArrayList();

        for (Object spaceState : row) {
            formattedRow.add(formatSpace((StateTranslator) spaceState));
        }

        return formattedRow;
    }

    public String formatSpace(StateTranslator spaceState) {
        String formatted = "";

        switch (spaceState) {
            case WATER:
                formatted = "~";
                break;
            case SHIP:
                formatted = "^";
                break;
            case HIT:
                formatted = "X";
                break;
            case MISS:
                formatted = "0";
                break;
        }
        return formatted;
    }
}