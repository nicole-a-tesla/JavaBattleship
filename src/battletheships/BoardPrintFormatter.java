package battletheships;

import java.util.ArrayList;

/**
 * Created by bears8yourface on 1/13/16.
 */
public class BoardPrintFormatter {
    private PrintKey printKey;

    public BoardPrintFormatter(PrintKey printKey){
        this.printKey = printKey;
    }

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
            formattedRow.add(formatSpace((SpaceState) spaceState));
        }

        return formattedRow;
    }

    public String formatSpace(SpaceState spaceState) {
        return (String) printKey.dictionary.get(spaceState);
    }

}