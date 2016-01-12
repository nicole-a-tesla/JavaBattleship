package battletheships;

/**
 * Created by bears8yourface on 1/11/16.
 */
public class Ship {
    private String name;
    private int size;

    public Ship(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}
