package battletheships.test;

import battletheships.Ship;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bears8yourface on 1/11/16.
 */
public class ShipTest {
    public Ship ship;

    @Before
    public void setUp() {
        ship = new Ship("Thomas", 3);
    }

    @Test
    public void itHasAName() {
        assertEquals("Thomas", ship.getName());
    }

    @Test
    public void itHasASize() {
        assertEquals(3, ship.getSize());
    }

}
