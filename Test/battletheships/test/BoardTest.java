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

    @Test
    public void testClearsBoard() {
        assertEquals(null, board.getContents(0,0));
    }

    @Test
    public void boardCanPlaceShipHorizontally() {
        board.placeShipHorizontally(ship, 5, 5);
        assertEquals(ship, board.getContents(5, 5));
        assertEquals(ship, board.getContents(6, 5));
    }

    @Test
    public void placesShipDiagonallyLTR() {
        board.placeShipDiagonallyLTR(ship, 1, 2);
        assertEquals(ship, board.getContents(1,2));
        assertEquals(ship, board.getContents(2,3));
    }

    @Test
    public void placeShipsDiagonallyRTL() {
        board.placeShipDiagonallyRTL(ship, 6, 7);
        assertEquals(ship, board.getContents(6,7));
        assertEquals(ship, board.getContents(5,8));
    }

}
