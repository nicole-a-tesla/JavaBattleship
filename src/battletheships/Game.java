package battletheships;

import java.util.ArrayList;

/**
 * Created by bears8yourface on 1/11/16.
 */
public class Game {
    private PrintKey printKey = new PrintKey();
    private BoardPrintFormatter formatter = new BoardPrintFormatter(printKey.dictionary);
    private BoardParser parser = new BoardParser();
    private Printer printer = new ConsolePrinter();

    private Ui ui = new Ui(printer);
    private BoardPrintManager boardPrintManager = new BoardPrintManager(parser, formatter, printer);

    private HumanPlayer humanPlayer;
    private ComputerPlayer computerPlayer;
    private Player activePlayer;

    public Game(Ui ui) {
        this.ui = ui;
        this.computerPlayer = new ComputerPlayer();
        this.humanPlayer = new HumanPlayer();
        activePlayer = humanPlayer;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void welcomeUser() {
        ui.welcomeUser();
    }

    public Board setupBoard(Player player) {
        if (player.getClass() == ComputerPlayer.class) {
            player.setupBoard();

        } else {
            ui.promptBoardSetup();

            ArrayList<Ship> playerShips = player.ships();

            for (Ship ship: playerShips) {
                getAndSetShipCoord(player, ship);
            }

        }
        return player.getPlayerBoard();
    }

    public void getAndSetShipCoord(Player player, Ship ship) {
        int[] shipCoords = ui.getShipPlacementCoordinates(ship);
        // temporarily defaults to horizontal placement
        player.setShipAt(ship, shipCoords);
    }

}
