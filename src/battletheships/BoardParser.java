package battletheships;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bears8yourface on 1/13/16.
 */
public class BoardParser {

    public ArrayList<ArrayList> parse(Space[][] spaces) {
        ArrayList parsedBoard = new ArrayList();

        for (int i=0; i<spaces.length; i++)
            parsedBoard.add(parseRow(spaces[i]));

        return parsedBoard;
    }

    public List parseRow(Space[] row) {
        List<SpaceState> parsedRow = new ArrayList<SpaceState>();

        for (Space space : row)
            parsedRow.add(parseSpace(space));

        return parsedRow;
    }

    public SpaceState parseSpace(Space space) {
        if (isMiss(space)) { return SpaceState.MISS; }
        if (isWater(space)) { return SpaceState.WATER; }
        if (isHit(space)) { return SpaceState.HIT; }

        return SpaceState.SHIP;
    }


    private Boolean isMiss(Space space) {
        return space.isEmpty() && space.isHit();
    }

    private Boolean isWater(Space space) {
        return space.isEmpty() && !space.isHit();
    }

    private Boolean isHit(Space space) {
        return !space.isEmpty() && space.isHit();
    }

}
