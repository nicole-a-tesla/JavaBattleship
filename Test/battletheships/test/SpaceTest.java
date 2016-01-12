package battletheships.test;

import battletheships.Ship;
import battletheships.Space;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bears8yourface on 1/12/16.
 */
public class SpaceTest {
    Ship ship = new Ship("test ship", 2);
    Space space = new Space();

    @Test
    public void shipIsAccessable() {
        space.getShip();
    }

    @Test
    public void itCanTellWhetherItsEmpty() {
        assertEquals(true, space.isEmpty());
    }

    @Test
    public void shipCanBeSet() {
        space.setShip(ship);
        assertEquals(ship, space.getShip());
    }

    @Test
    public void isNotEmptyAfterShipSet() {
        space.setShip(ship);
        assertEquals(false, space.isEmpty());
    }

    @Test
    public void initializesAsNotHit() {
        assertEquals(false, space.isHit());
    }

    @Test
    public void logsHits() {
        space.logHit();
        assertEquals(true, space.isHit());
    }

    @Test
    public void passesHitOnToShipIfHoldingOne() {
        space.setShip(ship);
        space.logHit();

        assertEquals(1, ship.hitCount());
    }
}
