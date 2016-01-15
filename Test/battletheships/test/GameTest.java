package battletheships.test;
import battletheships.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by bears8yourface on 1/11/16.
 */


public class GameTest {
    Player humanPlayer = new Player();
    Game game;
    Printer consolePrinter = new ConsolePrinter();
    Ui ui = new Ui(consolePrinter);
//
//    @Before
//    public void setUp(){
//        game = new Game(ui);
//    }

    @Test
    public void gameWelcomesPlayer() {
        Ui mockUi = mock(Ui.class);
        Game game = new Game(mockUi);

        game.welcomeUser();
        verify(mockUi).welcomeUser();
    }

    @Test
    public void asksHumanPlayerToSetUpBoard() {
        Ui mockUi = mock(Ui.class);
        Game game = new Game(mockUi);

        game.setupBoard(humanPlayer);
        verify(mockUi).promptBoardSetup();
    }

    // human sets up board
        // generates opponent board for computer
    // computer player sets up board
        // generates opponent board for human
    // tell first player its turn
    // gets shot from player
    // tells


}
