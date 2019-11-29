package main.mechanicslogic;

import common.Constants;

import javax.naming.Context;

public class ContextRound {
    private RoundStrategy roundStrategy;

    public ContextRound(String strategy) {
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
}