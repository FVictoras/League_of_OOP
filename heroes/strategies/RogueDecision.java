package heroes.strategies;

import common.Constants;
import heroes.Hero;

public class RogueDecision implements HeroStrategy {

    private int choice;

    public RogueDecision(final int choice)  {
        this.choice = choice;
    }
    @Override
    public final void setPlayersStrategy(final Hero h) {
        if (this.choice == 0) {
            h.setHealth((int) (Constants.ROG_H_1 * h.getHealth()));
            h.increaseDamageModifier(Constants.ROG_D_1);
        }
        if (this.choice == 1) {
            h.setHealth((int) (Constants.ROG_H_2 * h.getHealth()));
            h.increaseDamageModifier(Constants.ROG_D_2);
        }
    }
}
