package heroes.tilebonuses;

import heroes.Hero;
import heroes.Wizard;

public class DesertModifier implements TileBonusStrategy {

    // Se acorda bonusul obiectelor Wizard, in caz contrar se seteaza noLandBonus
    @Override
    public final void setPlayersStrategy(final Hero h1) {
        if (h1 instanceof Wizard) {
            ((Wizard) h1).setDesertBonus(true);
        } else {
            h1.noLandBonus();
        }
    }
}
