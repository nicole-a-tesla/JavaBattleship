package battletheships;

/**
 * Created by bears8yourface on 1/12/16.
 */
public class Space {
    private Ship contents;
    private Boolean isEmpty;

    public Space() {
        isEmpty = true;
    }

    public Ship getContents(){
        return contents;
    }

    public Boolean isEmpty() {
        return isEmpty;
    }

    public void setContents(Ship ship) {
        contents = ship;
    }
}
