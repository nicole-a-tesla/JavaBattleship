package battletheships;

import java.util.ArrayList;

/**
 * Created by bears8yourface on 1/11/16.
 */
public class Player {
    private ArrayList ships;
    private Board playerBoard = new Board();
    private Board opponentBoard;

    public Player() {
        ships = new FleetBuilder().build();
    }

    public ArrayList ships() {
        return ships;
    }

    public Board getPlayerBoard() {
        return playerBoard;
    }

    public Board getOpponentBoard() {
        return opponentBoard;
    }

    public void setShipAt(Ship ship, int[] coords) {

    }

    public Board setupBoard() {
        return getPlayerBoard();
    }

}


