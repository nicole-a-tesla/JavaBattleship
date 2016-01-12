package battletheships.test;

import battletheships.Ship;
import battletheships.Space;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bears8yourface on 1/12/16.
 */
public class SpaceTest {
    Ship ship = new Ship("test ship", 2);
    Space space = new Space();

    @Test
    public void itHasAccessableContents() {
        space.getContents();
    }

    @Test
    public void itCanTellWhetherItsEmpty() {
        assertEquals(true, space.isEmpty());
    }

    @Test
    public void contentsCanBeSet() {
        space.setContents(ship);
        assertEquals(ship, space.getContents());
    }

    @Test
    public void isNotEmptyAfterContentsSet() {
        space.setContents(ship);
        assertEquals(false, space.isEmpty());
    }
}
