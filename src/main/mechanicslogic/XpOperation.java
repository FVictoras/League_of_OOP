package main.mechanicslogic;

import common.Constants;
import heroes.Hero;
import heroes.utils.UtilsHero;

public class XpOperation implements RoundStrategy {
    @Override
    public void doOperation(Hero H) {

    }

    @Override
    public void doOperation(Hero H1, Hero H2) {
        H1.setXP(H1.getXP() + Math.max(0, (200 - (H1.getLevel() - H2.getLevel())*40)));
        int lastLevel = H1.getLevel();
        H1.setLevel(Math.max(0, (int)
                Math.ceil((double)((H1.getXP() - Constants.XP_BASE)+1)/Constants.XP_MULTIPLICATOR)));
        if (H1.getLevel() > lastLevel) {
            H1.setLevel(UtilsHero.getMaxHp(H1));
        }
    }
}
