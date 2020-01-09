package heroes.tilebonuses;

import heroes.Hero;
import heroes.Pyromancer;

public class VolcanicModifier implements TileBonusStrategy {
    // Se acorda bonusul obiectelor Pyromancer, in caz contrar se seteaza noLandBonus
    @Override
    public final void setPlayersStrategy(final Hero h1) {
        if (h1 instanceof Pyromancer) {
            ((Pyromancer) h1).setVolcanicBonus(true);
        } else {
            h1.noLandBonus();
        }
    }
}
