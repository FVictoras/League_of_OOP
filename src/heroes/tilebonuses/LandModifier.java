package heroes.tilebonuses;

import heroes.Hero;
import heroes.Knight;

public class LandModifier implements TileBonusStrategy {

    @Override
    public final void setPlayersStrategy(final Hero h1) {
        if (h1 instanceof Knight) {
            ((Knight) h1).setLandBonus(true);
        } else {
            h1.noLandBonus();
        }
    }
}
