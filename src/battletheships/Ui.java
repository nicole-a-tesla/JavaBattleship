package battletheships;

/**
 * Created by bears8yourface on 1/12/16.
 */
public class Ui {
    private Printer printer;

    public Ui(Printer printer) {
        this.printer = printer;
    }

    public Printer getPrinter() {
        return printer;
    }

    public void print(String string) {
        printer.print(string);
    }

    public void welcomeUser() {

    }

    public void promptBoardSetup() {

    }

    public int[] getShipPlacementCoordinates(Ship ship) {
        return new int[]{0, 0};
    }
}
