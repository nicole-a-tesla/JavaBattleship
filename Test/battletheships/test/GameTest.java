package battletheships.test;
import battletheships.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Created by bears8yourface on 1/11/16.
 */


public class GameTest {
    HumanPlayer humanPlayer = new HumanPlayer();
    ComputerPlayer computerPlayer= new ComputerPlayer();
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
    public void activePlayerDefaultsHuman() {
        Game game = new Game(ui);
        Class humanPlayerClass = HumanPlayer.class;
        Class activePlayerClass = game.getActivePlayer().getClass();
        assertEquals(humanPlayerClass, activePlayerClass);
    }

    @Test
    public void asksHumanPlayerToSetUpBoard() {
        Ui mockUi = mock(Ui.class);
        Game game = new Game(mockUi);

        game.setupBoard(humanPlayer);
        verify(mockUi).promptBoardSetup();
    }

    @Test
    public void asksHumanPlayerToGetShipCoordinates() {
        Ui mockUi = mock(Ui.class);
        Game game = new Game(mockUi);

        game.setupBoard(humanPlayer);
        Ship firstShip = (Ship) humanPlayer.ships().get(0);
        verify(mockUi).getShipPlacementCoordinates(firstShip);
    }

    @Test
    public void doesntAskComputerPlayerAnythingOnBoardSetup() {
        Ui mockUi = mock(Ui.class);
        Game game = new Game(mockUi);

        game.setupBoard(computerPlayer);
        verify(mockUi, never()).promptBoardSetup();
    }



}
