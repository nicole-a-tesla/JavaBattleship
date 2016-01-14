package battletheships;

import java.util.ArrayList;

/**
 * Created by bears8yourface on 1/14/16.
 */
public class PrintManager {
    private BoardParser parser;
    private BoardPrintFormatter formatter;
    private Printer printer;

    public PrintManager(BoardParser parser, BoardPrintFormatter formatter, Printer printer) {
        this.parser = parser;
        this.formatter = formatter;
        this.printer = printer;
    }

    public void printBoard(Board board) {
        ArrayList parsedBoard = parser.parse(board);
        ArrayList<String> formattedBoard = formatter.format(parsedBoard);

        for (String row: formattedBoard) {
            printLine(row);
        }
    }

    public void printLine(String line) {
        printer.print(line);
    }
}
