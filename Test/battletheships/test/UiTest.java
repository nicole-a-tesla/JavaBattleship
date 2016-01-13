package battletheships.test;

import battletheships.ConsolePrinter;
import battletheships.Printer;
import battletheships.Ui;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bears8yourface on 1/12/16.
 */
public class UiTest {
    Printer consolePrinter = new ConsolePrinter();
    Ui ui = new Ui(consolePrinter);

    @Test
    public void hasAPrinter() {
        assertEquals(consolePrinter, ui.getPrinter());
    }

}
