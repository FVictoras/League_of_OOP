package heroes.tilebonuses;

import heroes.Hero;

public class ContextTile {
    private TileBonusStrategy strategy;

    public ContextTile(final char tile) {
        if (tile == 'V') {
            this.strategy = new VolcanicModifier();
        }
        if (tile == 'W') {
            this.strategy = new WoodsModifier();
        }
        if (tile == 'D') {
            this.strategy = new DesertModifier();
        }
        if (tile == 'L') {
            this.strategy = new LandModifier();
        }
    }

    public final void executeStrategy(final Hero h) {
        strategy.setPlayersStrategy(h);
    }
}
