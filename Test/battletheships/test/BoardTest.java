package battletheships.test;
import battletheships.Board;
import org.junit.Before;
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

}
