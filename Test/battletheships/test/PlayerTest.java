package battletheships.test;
import battletheships.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bears8yourface on 1/11/16.
 */
public class PlayerTest {
    public Player player;

    @Before
    public void setUp() {
        player = new Player();
    }

    @Test
    public void playerHasABoard() {
        player.board();
    }

    @Test
    public void playerHasFiveShips(){
        String[][] ships = player.ships();
        int howManyShips = ships.length;
        assertEquals(5, howManyShips);
    }
}
