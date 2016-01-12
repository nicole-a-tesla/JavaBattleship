package battletheships.test;
import battletheships.Player;
import battletheships.Ship;
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
        assertEquals(5, player.ships().length);
    }
    
}
