package main.mechanicslogic;

import common.Constants;
import heroes.Hero;
import heroes.utils.UtilsHero;
import main.Log;

import java.io.IOException;

public class XpOperation implements RoundStrategy {
    @Override
    public void doOperation(final Hero h) {

    }

    public void doOperation(final Hero h1, final Hero h2) {

    }

    /**
     * Se ofera XP eroului castigator.
     * @param h1 erou invingator
     * @param h2 erou infrant
     */
    @Override
    public void doOperation(final Hero h1, final Hero h2, String output) throws IOException {
        Log.update(h1, h2, output);
        h1.setXp(h1.getXp() + Math.max(0,
                (Constants.XP_EARN_BASE - (h1.getLevel() - h2.getLevel())
                        * Constants.XP_EARN_LEVEL)));
        int lastLevel = h1.getLevel();
        h1.setLevel(Math.max(0,
                (int) Math.ceil((double) ((h1.getXp() - Constants.XP_BASE) + 1)
                        / Constants.XP_MULTIPLICATOR)));
        if (h1.getLevel() > lastLevel && UtilsHero.isAlive(h1)) {
            h1.setHealth(UtilsHero.getMaxHp(h1));
            if (h1.getLevel() - lastLevel > 0) {
                Log.update(h1, h1.getLevel()-lastLevel, output);
            } else {
                Log.update(h1, output);
            }
        }
    }
}
