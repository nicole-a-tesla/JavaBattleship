package battletheships;
/**
 * Created by bears8yourface on 1/11/16.
 */

public class Board {
    private String[][] spaces = new String[10][10];

    public Board() {
        for (int iRow=0; iRow<10; iRow++) {
            for (int iCol=0; iCol<10; iCol++) {
                spaces[iRow][iCol] = "empty space";
            }
        }
    }

    public String[][] spaces() {
        return spaces;
    }
}