package battletheships.test;
import battletheships.Board;
import battletheships.Ship;
import org.junit.Before;
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
        assertEquals(ship, board.getShip(0,0));
    }

    @Test
    public void boardCanPlaceShipVertically() {
        board.placeShipVertically(ship, 0, 0);
        assertEquals(ship, board.getShip(0,0));
        assertEquals(ship, board.getShip(0,1));
    }

    @Test
    public void testClearsBoard() {
        assertEquals(null, board.getShip(0,0));
    }

    @Test
    public void boardCanPlaceShipHorizontally() {
        board.placeShipHorizontally(ship, 5, 5);
        assertEquals(ship, board.getShip(5, 5));
        assertEquals(ship, board.getShip(6, 5));
    }

    @Test
    public void placesShipDiagonallyLTR() {
        board.placeShipDiagonallyLTR(ship, 1, 2);
        assertEquals(ship, board.getShip(1,2));
        assertEquals(ship, board.getShip(2,3));
    }

    @Test
    public void placeShipsDiagonallyRTL() {
        board.placeShipDiagonallyRTL(ship, 6, 7);
        assertEquals(ship, board.getShip(6,7));
        assertEquals(ship, board.getShip(5,8));
    }

    @Test
    public void placesLongShipDiagonallyRTL() {
        Ship s = new Ship("test boat", 5);
        board.placeShipDiagonallyRTL(s, 4, 5);
        assertEquals(s, board.getShip(3,6));
        assertEquals(s, board.getShip(2,7));
        assertEquals(s, board.getShip(1,8));
        assertEquals(s, board.getShip(0,9));
    }

    @Test
    public void logsStrikes(){
        board.logStrike(0,0);
        assertEquals(true, board.spaces()[0][0].isHit());
    }

}
