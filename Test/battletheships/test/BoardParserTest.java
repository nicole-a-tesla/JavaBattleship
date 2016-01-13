package battletheships.test;

import battletheships.*;
import org.junit.Before;
import org.junit.Test;

import javax.swing.plaf.nimbus.State;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by bears8yourface on 1/13/16.
 */
public class BoardParserTest {
    BoardParser parser;
    StateTranslator translator;
    Space space;
    Space space2;
    List<StateTranslator> expected;
    Ship ship;

    @Before
    public void setup() {
        parser = new BoardParser(translator);
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

    @Before
    public void setupSpace() {
        space = new Space();
    }

    @Test
    public void parseSpaceTranslatesWATER() {
        StateTranslator water = StateTranslator.WATER;
        assertEquals(water, parser.parseSpace(space));
    }

    @Test
    public void parseSpaceTranslatesSHIP() {
        space.setShip(new Ship("test ship", 2));
        StateTranslator ship = StateTranslator.SHIP;
        assertEquals(ship, parser.parseSpace(space));
    }

    @Test
    public void parseSpaceTranslatesHIT() {
        space.setShip(new Ship("test ship", 2));
        space.logHit();
        StateTranslator hit = StateTranslator.HIT;
        assertEquals(hit, parser.parseSpace(space));
    }

    @Test
    public void parseSpaceTranslatesMISS() {
        space.logHit();
        StateTranslator miss = StateTranslator.MISS;
        assertEquals(miss, parser.parseSpace(space));
    }

    @Before
    public void setupVarsForRowParser() {
        space = new Space();
        space2 = new Space();
        expected = new ArrayList<>();
        ship = new Ship("test ship", 2);
    }

    @Test
    public void parsesRowOfEmptySpaces() {
        Space[] spaces = {space, space2};
        expected.add(StateTranslator.WATER);
        expected.add(StateTranslator.WATER);

        List parsed = parser.parseRow(spaces);

        assertEquals(expected, parsed);
    }

    @Test
    public void parsesRowOfShips() {
        space.setShip(ship);
        space2.setShip(ship);
        Space[] spaces = {space, space2};
        expected.add(StateTranslator.SHIP);
        expected.add(StateTranslator.SHIP);

        List parsed = parser.parseRow(spaces);

        assertEquals(expected, parsed);

    }

    @Test
    public void parsesRowOfHitShips() {
        space.setShip(ship);
        space2.setShip(ship);
        space.logHit();
        space2.logHit();

        Space[] spaces = {space, space2};
        expected.add(StateTranslator.HIT);
        expected.add(StateTranslator.HIT);

        List parsed = parser.parseRow(spaces);

        assertEquals(expected, parsed);

    }

    @Test
    public void parsesRowOfMISSES() {
        space.logHit();
        space2.logHit();

        Space[] spaces = {space, space2};
        expected.add(StateTranslator.MISS);
        expected.add(StateTranslator.MISS);

        List parsed = parser.parseRow(spaces);

        assertEquals(expected, parsed);

    }

    @Test
    public void parseRowMaintainsOrder() {
        space.setShip(ship);
        Space[] spaces = {space, space2};
        expected.add(StateTranslator.SHIP);
        expected.add(StateTranslator.WATER);

        List parsed = parser.parseRow(spaces);

        assertEquals(expected, parsed);
    }

    private ArrayList generateExpectedEmptyRow() {
        ArrayList expectedRow = new ArrayList();
        for (int i=0; i<10; i++) {
            expectedRow.add(StateTranslator.WATER);
        }
        return expectedRow;
    }

    private ArrayList<ArrayList> generateExpectedEmptyBoard() {
        ArrayList<ArrayList> expectedBoard = new ArrayList<ArrayList>();
        for (int i=0; i<10; i++) {
            expectedBoard.add(generateExpectedEmptyRow());
        }
        return expectedBoard;
    }

    @Test
    public void parseBoardCorrectlyParsesBoard() {
        ArrayList<ArrayList> expectedEmptyBoard = generateExpectedEmptyBoard();

        Board board = new Board();
        ArrayList<ArrayList> parsedEmptyBoard = parser.parse(board);

        assertEquals(expectedEmptyBoard, parsedEmptyBoard);

    }

}
