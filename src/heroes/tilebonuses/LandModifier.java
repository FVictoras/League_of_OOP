package heroes.tilebonuses;

import heroes.Hero;
import heroes.Knight;

public class LandModifier implements TileBonusStrategy {

    @Override
    public void setPlayersStrategy(Hero h1) {
        if (h1 instanceof Knight) {
            ((Knight) h1).setLandBonus(true);
        }
    }
}
