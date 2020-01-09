package heroes.utils;

import common.Constants;
import heroes.Hero;
import heroes.Pyromancer;
import heroes.Knight;
import heroes.Wizard;
import heroes.Rogue;

public final class UtilsHero {
    private UtilsHero() {
    }
    /**
     * @return HP maxim pe care un erou il poate avea in functie de nivel si rasa
     */
    public static int getMaxHp(final Hero h) {
        try {
            if (h instanceof Knight) {
                return Constants.STARTING_HP_KNIGHT + h.getLevel() * Constants.INCREASE_HP_KNIGHT;
            }
            if (h instanceof Pyromancer) {
                return Constants.STARTING_HP_PYRO + h.getLevel() * Constants.INCREASE_HP_PYRO;
            }
            if (h instanceof Wizard) {
                return Constants.STARTING_HP_WIZARD + h.getLevel() * Constants.INCREASE_HP_WIZARD;
            }
            if (h instanceof Rogue) {
                return Constants.STARTING_HP_ROGUE + h.getLevel() * Constants.INCREASE_HP_ROGUE;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    /**
     * Verifica daca eroul este sau nu in viata.
     * @param h eroul dat spre verificare
     * @return starea vietii eroului
     */
    public static boolean isAlive(final Hero h) {
        return h.getHealth() > 0;
    }
}
