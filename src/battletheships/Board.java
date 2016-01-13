package battletheships;

/**
 * Created by bears8yourface on 1/11/16.
 */

public class Board {
    private Space[][] spaces = new Space[10][10];

    public Board() {
        for (int iRow = 0; iRow < 10; iRow++) {
            for (int iCol = 0; iCol < 10; iCol++) {
                spaces[iRow][iCol] = new Space();
            }
        }
    }

    public Space[][] spaces() {
        return spaces;
    }

    public Space getSpace(int x, int y) {
        return spaces[x][y];
    }

    public Ship getShip(int x, int y) {
        return getSpace(x, y).getShip();
    }

    public Boolean isSpaceEmpty(int x, int y) {
        return getSpace(x, y).isEmpty();
    }

    public void setContents(int x, int y, Ship ship) {
        getSpace(x,y).setShip(ship);
    }

    public void placeShipVertically(Ship ship, int x, int y) {
        for (int i=y; i<ship.getSize() + y; i++)
            setContents(x, i, ship);
    }

    public void placeShipHorizontally(Ship ship, int x, int y) {
        for (int i=x; i < ship.getSize() + x; i++)
            setContents(i, y, ship);
    }

    public void placeShipDiagonallyLTR(Ship ship, int x, int y) {
        for (int i=0; i<ship.getSize(); i++)
            setContents(x + i, y + i, ship);
    }

    public void placeShipDiagonallyRTL(Ship ship, int x, int y) {
        for (int i=0; i<ship.getSize(); i++)
            setContents(x - i, y + i, ship);
    }

    public void logStrike(int x, int y) {
        getSpace(x, y).logHit();
    }
}