package battletheships;

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

    private Player humanPlayer;
    private Player computerPlayer;

    public Game(Ui ui) {
        this.ui = ui;
    }

    public void welcomeUser() {
        ui.welcomeUser();
    }

    public void setupBoard(Player player) {
        ui.promptBoardSetup();
        // ship = ui.whichShip
        // player.playerBoard.setShip(ship)
    }



}
