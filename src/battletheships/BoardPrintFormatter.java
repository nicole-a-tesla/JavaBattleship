package battletheships;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bears8yourface on 1/13/16.
 */
public class BoardPrintFormatter {
    private HashMap printDictionary;

    public BoardPrintFormatter(HashMap printDictionary){
        this.printDictionary = printDictionary;
    }

    public ArrayList format(ArrayList<ArrayList> parsedBoard) {
        ArrayList formatted = new ArrayList<>();

        ArrayList row1 = parsedBoard.get(0);
        String xAxis = getXAxis(row1);
        formatted.add(xAxis);

        for (Integer i=0; i<parsedBoard.size(); i++) {
            Integer y_coord = i;
            ArrayList row = parsedBoard.get(i);

            formatted.add("\n");
            formatted.add(formatRow(row, y_coord));

        }
        return formatted;
    }

    private String formatRow(ArrayList row, Integer y_coord) {
        StringBuilder formattedRow = new StringBuilder();
        String formattedYCoord = formatSpace(y_coord.toString());
        formattedRow.append(formattedYCoord);

        for (Object spaceState : row) {
            String stateString = spaceStateToString((SpaceState) spaceState);
            formattedRow.append(formatSpace(stateString));
        }
        return formattedRow.toString();
    }

    private String formatSpace(String spaceContents) {
        return "| " + spaceContents + " ";
    }

    private String spaceStateToString(SpaceState spaceState) {
        return (String) printDictionary.get(spaceState);
    }

    private String getXAxis(ArrayList row) {
        int size = row.size();
        StringBuffer axis = new StringBuffer();
        axis.append(formatSpace(" "));

        for (Integer i=0; i<size; i++) {
            axis.append(formatSpace(i.toString()));
        }

        return axis.toString();
    }

}