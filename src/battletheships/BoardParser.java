package battletheships;

/**
 * Created by bears8yourface on 1/13/16.
 */
public class BoardParser {
    StateTranslator translator;

    public BoardParser(StateTranslator translator) {
        this.translator = translator;
    }

    public void parse(Board board) {

    }

    public String[] parseRow(Space[] row) {
        return new String[10];
    }

    public StateTranslator parseSpace(Space space) {
        if (isMiss(space)) { return StateTranslator.MISS; }
        if (isWater(space)) { return StateTranslator.WATER; }
        if (isHit(space)) { return StateTranslator.HIT; }

        return StateTranslator.SHIP;
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
