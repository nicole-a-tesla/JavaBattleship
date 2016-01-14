package battletheships.test;

import battletheships.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by bears8yourface on 1/13/16.
 */
public class BoardParserTest {
    BoardParser parser;
    Space space;
    Space space2;
    List<SpaceState> expected;
    Ship ship;
    Board board;

    @Before
    public void setup() {
        parser = new BoardParser();
        board = new Board();
    }

    @Test
    public void parseTakesSpacesAsArgument() {
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
        SpaceState water = SpaceState.WATER;
        assertEquals(water, parser.parseSpace(space));
    }

    @Test
    public void parseSpaceTranslatesSHIP() {
        space.setShip(new Ship("test ship", 2));
        SpaceState ship = SpaceState.SHIP;
        assertEquals(ship, parser.parseSpace(space));
    }

    @Test
    public void parseSpaceTranslatesHIT() {
        space.setShip(new Ship("test ship", 2));
        space.logHit();
        SpaceState hit = SpaceState.HIT;
        assertEquals(hit, parser.parseSpace(space));
    }

    @Test
    public void parseSpaceTranslatesMISS() {
        space.logHit();
        SpaceState miss = SpaceState.MISS;
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
        expected.add(SpaceState.WATER);
        expected.add(SpaceState.WATER);

        List parsed = parser.parseRow(spaces);

        assertEquals(expected, parsed);
    }

    @Test
    public void parsesRowOfShips() {
        space.setShip(ship);
        space2.setShip(ship);
        Space[] spaces = {space, space2};
        expected.add(SpaceState.SHIP);
        expected.add(SpaceState.SHIP);

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
        expected.add(SpaceState.HIT);
        expected.add(SpaceState.HIT);

        List parsed = parser.parseRow(spaces);

        assertEquals(expected, parsed);

    }

    @Test
    public void parsesRowOfMISSES() {
        space.logHit();
        space2.logHit();

        Space[] spaces = {space, space2};
        expected.add(SpaceState.MISS);
        expected.add(SpaceState.MISS);

        List parsed = parser.parseRow(spaces);

        assertEquals(expected, parsed);

    }

    @Test
    public void parseRowMaintainsOrder() {
        space.setShip(ship);
        Space[] spaces = {space, space2};
        expected.add(SpaceState.SHIP);
        expected.add(SpaceState.WATER);

        List parsed = parser.parseRow(spaces);

        assertEquals(expected, parsed);
    }

    private ArrayList generateExpectedEmptyRow() {
        ArrayList expectedRow = new ArrayList();

        for (int i=0; i<10; i++)
            expectedRow.add(SpaceState.WATER);

        return expectedRow;
    }

    private ArrayList<ArrayList> generateExpectedEmptyBoard() {
        ArrayList<ArrayList> expectedBoard = new ArrayList();

        for (int i=0; i<10; i++)
            expectedBoard.add(generateExpectedEmptyRow());

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
