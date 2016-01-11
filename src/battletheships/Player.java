package battletheships;

/**
 * Created by bears8yourface on 1/11/16.
 */
public class Player {
    private String[][] ships = new String[5][];
    private Board board = new Board();

    public String[][] ships() {
        return ships;
    }

    public Board board() {
        return board;
    }
}
