package main.mechanicslogic;

import common.Constants;
import heroes.Hero;
import heroes.utils.UtilsHero;

public class XpOperation implements RoundStrategy {
    @Override
    public void doOperation(final Hero h) {

    }

    /**
     * Javadoc.
     * @param h1
     * @param h2
     */
    @Override
    public void doOperation(final Hero h1, final Hero h2) {
        h1.setXp(h1.getXp() + Math.max(0,
                (Constants.XP_EARN_BASE - (h1.getLevel() - h2.getLevel())
                        * Constants.XP_EARN_LEVEL)));
        int lastLevel = h1.getLevel();
        h1.setLevel(Math.max(0,
                (int) Math.ceil((double) ((h1.getXp() - Constants.XP_BASE) + 1)
                        / Constants.XP_MULTIPLICATOR)));
        if (h1.getLevel() > lastLevel && UtilsHero.isAlive(h1)) {
            h1.setHealth(UtilsHero.getMaxHp(h1));
        }
    }
}
