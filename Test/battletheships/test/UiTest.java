package battletheships.test;

import battletheships.ConsolePrinter;
import battletheships.Printer;
import battletheships.Ui;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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

    @Test
    public void canPrintToConsole() {
        String printMe = "Print me!";
        ConsolePrinter fakePrinter = mock(ConsolePrinter.class);
        Ui fakePrinterUi = new Ui(fakePrinter);

        fakePrinterUi.print(printMe);

        verify(fakePrinter).print(printMe);
    }

}
