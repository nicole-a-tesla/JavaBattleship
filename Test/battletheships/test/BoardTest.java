package battletheships.test;
import battletheships.Board;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bears8yourface on 1/11/16.
 */

public class BoardTest {

    @Test
    public void testBoardHas100Spaces() {
        Board board = new Board();
        assertEquals(100, board.spaces().size());
    }

}
