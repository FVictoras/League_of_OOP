package heroes.strategies;

import common.Constants;
import heroes.Hero;

public class WizardDecision implements HeroStrategy {

    private int choice;

    public WizardDecision(final int choice)  {
        this.choice = choice;
    }

    @Override
    public final void setPlayersStrategy(final Hero h) {
        if (this.choice == 0) {
            h.setHealth((int) (Constants.WIZ_H_1 * h.getHealth()));
            h.increaseDamageModifier(Constants.WIZ_D_1);
        }
        if (this.choice == 1) {
            h.setHealth((int) (Constants.WIZ_H_2 * h.getHealth()));
            h.increaseDamageModifier(Constants.WIZ_D_2);

        }
    }
}
