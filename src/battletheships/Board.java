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

    public Space getSpace(int x_coord, int y_coord) {
        return spaces[x_coord][y_coord];
    }

    public Ship getShip(int x_coord, int y_coord) {
        return spaces[x_coord][y_coord].getShip();
    }

    public void setContents(int x_coord, int y_coord, Ship ship) {
        spaces[x_coord][y_coord].setShip(ship);
    }

    public void placeShipVertically(Ship ship, int x_coord, int y_coord) {
        for (int i=y_coord; i<ship.getSize() + y_coord; i++)
            setContents(x_coord, i, ship);
    }

    public void placeShipHorizontally(Ship ship, int x_coord, int y_coord) {
        for (int i=x_coord; i < ship.getSize() + x_coord; i++)
            setContents(i, y_coord, ship);
    }

    public void placeShipDiagonallyLTR(Ship ship, int x_coord, int y_coord) {
        for (int i=0; i<ship.getSize(); i++)
            setContents(x_coord + i, y_coord + i, ship);
    }

    public void placeShipDiagonallyRTL(Ship ship, int x_coord, int y_coord) {
        for (int i=0; i<ship.getSize(); i++)
            setContents(x_coord - i, y_coord + i, ship);
    }

    public void logStrike(int x_coord, int y_coord) {
        getSpace(x_coord, y_coord).logHit();
    }
}