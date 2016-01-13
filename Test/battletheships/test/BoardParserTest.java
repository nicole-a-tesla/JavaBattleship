package battletheships.test;

import battletheships.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bears8yourface on 1/13/16.
 */
public class BoardParserTest {
    BoardParser parser;
    StateTranslator translator;
    Space space;

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
    public void parseSpaceTranslatesEMPTY() {
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

}
