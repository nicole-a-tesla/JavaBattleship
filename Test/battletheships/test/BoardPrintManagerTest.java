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
public class BoardPrintManagerTest {
    Board board;
    BoardParser parser;

    @Before
    public void setup() {
        board = new Board();
        parser = new BoardParser();
    }

    @Test
    public void FormatsParsedBoard() {
        Printer printer = new ConsolePrinter();
        BoardPrintFormatter mockFormatter = mock(BoardPrintFormatter.class);

        ArrayList<ArrayList> parsedBoard = parser.parse(board);

        BoardPrintManager boardPrintManager = new BoardPrintManager(parser, mockFormatter, printer);
        boardPrintManager.printBoard(board);

        verify(mockFormatter).format(parsedBoard);
    }

    @Test
    public void sendsFormattedRowsToPrinter() {
        PrintKey printKey = new PrintKey();
        BoardPrintFormatter formatter = new BoardPrintFormatter(printKey.dictionary);
        Printer mockPrinter = mock(ConsolePrinter.class);

        ArrayList<ArrayList> parsedBoard = parser.parse(board);
        ArrayList formattedBoard = formatter.format(parsedBoard);

        BoardPrintManager boardPrintManager = new BoardPrintManager(parser, formatter, mockPrinter);
        boardPrintManager.printBoard(board);

        verify(mockPrinter).print((String) formattedBoard.get(0));

    }


}
