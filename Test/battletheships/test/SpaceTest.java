package battletheships.test;

import battletheships.Ship;
import battletheships.Space;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bears8yourface on 1/12/16.
 */
public class SpaceTest {

    @Test
    public void itHasAccessableContents() {
        Space s = new Space();
        s.getContents();
    }

    @Test
    public void itCanTellWhetherItsEmpty() {
        Space s = new Space();
        assertEquals(true, s.isEmpty());
    }

    @Test
    public void contentsCanBeSet() {
        Space space = new Space();
        Ship ship = new Ship("test ship", 2);
        space.setContents(ship);
        assertEquals(ship, space.getContents());
    }
}
