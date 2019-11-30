package main.mechanicslogic;

import common.Constants;
import heroes.Hero;

public class ContextRound {
    private RoundStrategy roundStrategy;

    /**
     * .
     * @param strategy
     */
    public ContextRound(final String strategy) {
        if (strategy.compareTo(Constants.DMG_OVERTIME) == 0) {
            roundStrategy = new OvertimeDamage();
        }
        if (strategy.compareTo(Constants.STUN_REDUCTION) == 0) {
            roundStrategy = new StunReduction();
        }
        if (strategy.compareTo(Constants.XP_OPERATION) == 0) {
            roundStrategy = new XpOperation();
        }
    }

    /**
     * .
     * @param h
     */
    public void doOperation(final Hero h) {
        roundStrategy.doOperation(h);
    }

    /**
     * .
     * @param h1
     * @param h2
     */
    public void doOperation(final Hero h1, final Hero h2) {
        roundStrategy.doOperation(h1, h2);
    }

}
