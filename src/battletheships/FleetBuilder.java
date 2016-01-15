package battletheships;

import java.util.ArrayList;

/**
 * Created by bears8yourface on 1/14/16.
 */
public class FleetBuilder {

    public ArrayList build() {
        ArrayList ships = new ArrayList();
        ships.add(buildAircraftCarrier());
        ships.add(buildBattleship());
        ships.add(buildSubmarine());
        ships.add(buildDestroyer());
        ships.add(buildPatrolBoat());
        return ships;
    }

    private Ship buildAircraftCarrier() {
        return new Ship("Aircraft Carrier", 5);
    }

    private Ship buildBattleship() {
        return new Ship("Battleship", 4);
    }

    private Ship buildSubmarine() {
        return new Ship("Submarine", 3);
    }

    private Ship buildDestroyer() {
        return new Ship("Destroyer", 3);
    }

    private Ship buildPatrolBoat() {
        return new Ship("Patrol Boat", 2);
    }
}
