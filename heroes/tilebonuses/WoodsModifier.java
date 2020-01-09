package heroes.tilebonuses;

import heroes.Hero;
import heroes.Rogue;

public class WoodsModifier implements TileBonusStrategy {
    // Se acorda bonusul obiectelor Rogue, in caz contrar se seteaza noLandBonus
    @Override
    public final void setPlayersStrategy(final Hero h1) {
        if (h1 instanceof Rogue) {
            ((Rogue) h1).setWoodsBonus(true);
        } else {
            h1.noLandBonus();
        }
    }
}
