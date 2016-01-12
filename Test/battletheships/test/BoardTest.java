package battletheships.test;
import battletheships.Board;
import battletheships.Ship;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bears8yourface on 1/11/16.
 */

public class BoardTest {
    private Board board;
    private Ship ship;

    @Before
    public void setUp() {
        board = new Board();
        ship = new Ship("test ship", 2);
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
    public void boardCanSetAndGetSpaceContents() {
        board.setContents(0, 0, ship);
        assertEquals(ship, board.getContents(0,0));
    }

    @Test
    public void boardCanPlaceShipVertically() {
        board.placeShipVertically(ship, 0, 0);
        assertEquals(ship, board.getContents(0,0));
        assertEquals(ship, board.getContents(0,1));
    }




}
