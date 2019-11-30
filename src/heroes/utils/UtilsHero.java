package heroes.utils;

import common.Constants;
import heroes.*;

public class UtilsHero {
    /**
     * @return HP maxim pe care un erou il poate avea in functie de nivel si rasa
     */
    public static int getMaxHp(Hero H) {
        try {
            if (H instanceof Knight) {
                return Constants.STARTING_HP_KNIGHT + H.getLevel() * Constants.INCREASE_HP_KNIGHT;
            }
            if (H instanceof Pyromancer) {
                return Constants.STARTING_HP_PYRO + H.getLevel() * Constants.INCREASE_HP_PYRO;
            }
            if (H instanceof Wizard) {
                return Constants.STARTING_HP_WIZARD + H.getLevel() * Constants.INCREASE_HP_WIZARD;
            }
            if (H instanceof Rogue) {
                return Constants.STARTING_HP_ROGUE + H.getLevel() * Constants.INCREASE_HP_ROGUE;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public static boolean isAlive(Hero H) {
        if (H.getHealth() <= 0) {
            return false;
        }
        return true;
    }
}
