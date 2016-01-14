package battletheships.test;

import battletheships.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by bears8yourface on 1/14/16.
 */
public class PrintManagerTest {
    @Before
    public void setup() {

    }

    @Test
    public void FormatsParsedBoard() {
        Board board = new Board();
        BoardParser parser = new BoardParser();
        Printer printer = new ConsolePrinter();

        BoardPrintFormatter mockFormatter = mock(BoardPrintFormatter.class);

        PrintManager printManager = new PrintManager(parser, mockFormatter, printer);
        printManager.printBoard(board);

        ArrayList<ArrayList> parsedBoard = parser.parse(board);

        verify(mockFormatter).format(parsedBoard);
    }

    @Test
    public void sendsFormattedRowsToPrinter() {
        Board board = new Board();
        BoardParser parser = new BoardParser();
        PrintKey printKey = new PrintKey();
        BoardPrintFormatter formatter = new BoardPrintFormatter(printKey.dictionary);

        Printer mockPrinter = mock(ConsolePrinter.class);

        PrintManager printManager = new PrintManager(parser, formatter, mockPrinter);
        printManager.printBoard(board);

        ArrayList<ArrayList> parsedBoard = parser.parse(board);
        ArrayList formattedBoard = formatter.format(parsedBoard);

        verify(mockPrinter).print((String) formattedBoard.get(0));

    }


}
