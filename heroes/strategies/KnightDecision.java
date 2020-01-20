package heroes.strategies;

import common.Constants;
import heroes.Hero;


public class KnightDecision implements HeroStrategy {

    private int choice;

    public KnightDecision(final int choice)  {
        this.choice = choice;
    }
    @Override
    public final void setPlayersStrategy(final Hero h) {
        if (this.choice == 0) {
            h.setHealth((int) (Constants.KNIGHT_H_1 * h.getHealth()));
            h.increaseDamageModifier(Constants.KNIGHT_D_1);
        }
        if (this.choice == 1) {
            h.setHealth((int) (Constants.KNIGHT_H_2 * h.getHealth()));
            h.increaseDamageModifier(Constants.KNIGHT_D_2);
        }
    }
}
