package battletheships.test;

import battletheships.ConsolePrinter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by bears8yourface on 1/12/16.
 */
public class ConsolePrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void printsToTheConsole() {
        ConsolePrinter printer = new ConsolePrinter();
        printer.print("I printed!");
        assertEquals("I printed!", outContent.toString());
    }

    @After
    public void cleanupStreams() {
        System.setOut((null));
    }
}
