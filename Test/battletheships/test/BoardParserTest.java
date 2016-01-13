package battletheships.test;

import battletheships.Board;
import battletheships.BoardParser;
import battletheships.Space;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bears8yourface on 1/13/16.
 */
public class BoardParserTest {
    BoardParser parser;
    @Before
    public void setup() {
        parser = new BoardParser();
    }

    @Test
    public void parseTakesBoardAsArgument() {
        Board board = new Board();
        parser.parse(board);
    }

    @Test
    public void parseRowTakesArrayOfSpaces() {
        Space[] fakeRow = {new Space(), new Space(), new Space()};
        parser.parseRow(fakeRow);
    }

}
