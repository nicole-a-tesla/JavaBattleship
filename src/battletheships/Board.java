package battletheships;
import battletheships.Space;

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

    public Ship getContents(int x_coord, int y_coord) {
        Space thisSpace = spaces[x_coord][y_coord];
        return thisSpace.getContents();
    }

    public void setContents(int x_coord, int y_coord, Ship ship) {
        spaces[x_coord][y_coord].setContents(ship);
    }

    public void placeShipVertically(Ship ship, int x_coord, int y_coord) {
        for (int i=y_coord; i<ship.getSize() + y_coord; i++)
            spaces[x_coord][i].setContents(ship);
    }

    public void placeShipHorizontally(Ship ship, int x_coord, int y_coord) {
        for (int i=x_coord; i < ship.getSize() + x_coord; i++)
            spaces[i][y_coord].setContents(ship);
    }

    public void placeShipDiagonallyLTR(Ship ship, int x_coord, int y_coord) {
        for (int i=0; i<ship.getSize(); i++)
            spaces[x_coord + i][y_coord + i].setContents(ship);
    }


    public void placeShipDiagonallyRTL(Ship ship, int x_coord, int y_coord) {
        for (int i=0; i<ship.getSize(); i++)
            spaces[x_coord - i][y_coord + i].setContents(ship);
    }
}