package battletheships.test;
import battletheships.Game;
import battletheships.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bears8yourface on 1/11/16.
 */


public class GameTest {
    Game game;

    @Before
    public void setUp(){
        game = new Game();
    }

    @Test
    public void player1Exists() {
        Player player = game.player1;
    }

    @Test
    public void player2Exists() {
        Player player = game.player2;
    }

}
