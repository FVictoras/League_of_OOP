package heroes.tilebonuses;

import heroes.Hero;
import heroes.Wizard;

public class DesertModifier implements TileBonusStrategy {

    @Override
    public void setPlayersStrategy(Hero h1) {
        if (h1 instanceof Wizard) {
            ((Wizard) h1).setDesertBonus(true);
        } else {
            h1.noLandBonus();
        }
    }
}
