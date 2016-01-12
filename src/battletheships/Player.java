package battletheships;

/**
 * Created by bears8yourface on 1/11/16.
 */
public class Player {
    private Ship[] ships = new Ship[5];
    private Board board = new Board();

    public Ship[] ships() {
        return ships;
    }

    public Board board() {
        return board;
    }
}


