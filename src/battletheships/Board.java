package battletheships;
/**
 * Created by bears8yourface on 1/11/16.
 */

public class Board {
    private Object[][] spaces = new Object[10][10];

    public Board() {
        for (int iRow=0; iRow<10; iRow++) {
            for (int iCol=0; iCol<10; iCol++) {
                spaces[iRow][iCol] = new Ship("empty", 0);
            }
        }
    }

    public Object[][] spaces() {
        return spaces;
    }

    public Object getContents(int x_coord, int y_coord) {
        return spaces[x_coord][y_coord];
    }

    public void placeShipVertically(Ship ship, int x_coord, int y_coord) {
        for (int i=y_coord; i<ship.getSize() + y_coord; i++)
            spaces[x_coord][i] = ship;
    }
}