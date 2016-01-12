package battletheships.test;
import battletheships.Board;
import battletheships.Ship;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by bears8yourface on 1/11/16.
 */

public class BoardTest {
    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testBoardHas10Rows() {
        assertEquals(10, board.spaces().length);
    }

    @Test
    public void testBoardHas10Columns() {
        assertEquals(10, board.spaces()[0].length);
    }

    @Test
    public void boardCanPlaceShipVertically() {
        Ship ship = new Ship("test ship", 2);
        board.placeShipVertically(ship, 0, 0);
        assertEquals(ship, board.getContents(0,0));
    }


}
