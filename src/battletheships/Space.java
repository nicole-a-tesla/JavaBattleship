package battletheships;

/**
 * Created by bears8yourface on 1/12/16.
 */
public class Space {
    private Ship ship;
    private Boolean isEmpty;
    private Boolean isHit;

    public Space() {
        isEmpty = true;
        isHit = false;
    }

    public Ship getShip(){
        return ship;
    }

    public Boolean isEmpty() {
        return isEmpty;
    }

    public Boolean containsShip() {
        return !isEmpty;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
        isEmpty = false;
    }

    public void logHit() {
        isHit = true;

        if (containsShip()) {
            ship.logHit();
        }
    }

    public Boolean isHit() {
        return isHit;
    }
}
