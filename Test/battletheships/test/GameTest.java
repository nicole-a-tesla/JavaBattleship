package battletheships.test;
import battletheships.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bears8yourface on 1/11/16.
 */


public class GameTest {
    Game game;
    Printer consolePrinter = new ConsolePrinter();
    Ui ui = new Ui(consolePrinter);
    Player player1 = new Player();
    Player player2 = new Player();

    @Before
    public void setUp(){
        game = new Game(player1, player2, ui);
    }

    @Test
    public void player1Exists() {
        Player player = game.player1;
    }

    @Test
    public void player2Exists() {
        Player player = game.player2;
    }

    @Test
    public void uiExists() { Ui ui = game.ui; }


}
