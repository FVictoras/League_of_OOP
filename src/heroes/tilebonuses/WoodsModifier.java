package heroes.tilebonuses;

import heroes.Hero;
import heroes.Rogue;

public class WoodsModifier implements TileBonusStrategy {

    @Override
    public void setPlayersStrategy(Hero h1) {
        if (h1 instanceof Rogue) {
            ((Rogue) h1).setWoodsBonus(true);
        } else {
            h1.noLandBonus();
        }
    }
}
