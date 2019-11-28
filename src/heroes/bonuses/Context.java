package heroes.bonuses;

import heroes.Hero;

public class Context {
    private TileBonusStrategy strategy;

    public Context(char tile) {
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

    public void executeStrategy(Hero H) {
        strategy.setPlayersStrategy(H);
    }
}
