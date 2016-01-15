package battletheships.test;
import battletheships.Player;
import battletheships.Ship;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by bears8yourface on 1/11/16.
 */
public class PlayerTest {
    public Player player;
    ArrayList<Ship> ships;

    @Before
    public void setUp() {
        player = new Player();
        ships = player.ships();
    }

    @Test
    public void playerHasPlayerBoard() {
        player.getPlayerBoard();
    }

    @Test
    public void playerHasOpponentBoard() {
        player.getOpponentBoard();
    }

    @Test
    public void playerHasFiveShips(){
        assertEquals(5, player.ships().size());
    }

    public int foundShipOfSize(ArrayList<Ship> ships, int size) {
        ArrayList<Ship> shipsOfSize = new ArrayList();

        for (Ship ship : ships) {
            if (ship.getSize() == size) {
                shipsOfSize.add(ship);
            }
        }
        return shipsOfSize.size();
    }

    @Test
    public void playerHasOneShipOfSize5() {
        int foundShipsCount = foundShipOfSize(ships, 5);
        assertEquals(1, foundShipsCount);
    }

    @Test
    public void playerHasOneShipOfSize4() {
        int foundShipsCount = foundShipOfSize(ships, 4);
        assertEquals(1, foundShipsCount);
    }

    @Test
    public void playerHasTwoShipsOfSize3() {
        int foundShipsCount = foundShipOfSize(ships, 3);
        assertEquals(2, foundShipsCount);
    }

    @Test
    public void playerHasOneShipOfSize2() {
        int foundShipsCount = foundShipOfSize(ships, 2);
        assertEquals(1, foundShipsCount);
    }

}
