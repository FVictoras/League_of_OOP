package heroes.tilebonuses;

import heroes.Hero;
import heroes.Pyromancer;

public class VolcanicModifier implements TileBonusStrategy {

    @Override
    public void setPlayersStrategy(Hero h1) {
        if (h1 instanceof Pyromancer) {
            ((Pyromancer) h1).setVolcanicBonus(true);
        }
    }
}
