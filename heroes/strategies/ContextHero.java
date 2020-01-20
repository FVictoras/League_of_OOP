package heroes.strategies;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Wizard;
import heroes.Rogue;
import heroes.Hero;

import heroes.utils.UtilsHero;

public class ContextHero {
    private HeroStrategy strategy;

    /**
     * Se alege contextul posibil.
     * @param h
     */
    public ContextHero(final Hero h) {
        if (h instanceof Knight) {
            if ((Constants.TREIME * UtilsHero.getMaxHp(h)) < h.getHealth()
                    && h.getHealth() < (Constants.JUMATATE * UtilsHero.getMaxHp(h))) {
                strategy = new KnightDecision(0);

            }
            if (h.getHealth() < (Constants.TREIME * UtilsHero.getMaxHp(h))) {
                strategy = new KnightDecision(1);
            }
        }
        if (h instanceof Pyromancer) {
            if ((Constants.PATRIME * UtilsHero.getMaxHp(h)) < h.getHealth()
                    && h.getHealth() < (Constants.TREIME * UtilsHero.getMaxHp(h))) {
                strategy = new PyromancerDecision(0);

            }
            if (h.getHealth() < (Constants.PATRIME * UtilsHero.getMaxHp(h))) {
                strategy = new PyromancerDecision(1);
            }
        }
        if (h instanceof Rogue) {
            if ((Constants.SEPTIME * UtilsHero.getMaxHp(h)) < h.getHealth()
                    && h.getHealth() < (Constants.CINCIME * UtilsHero.getMaxHp(h))) {
                strategy = new RogueDecision(0);

            }
            if (h.getHealth() < (Constants.SEPTIME * UtilsHero.getMaxHp(h))) {
                strategy = new RogueDecision(1);
            }
        }
        if (h instanceof Wizard) {
            if ((Constants.PATRIME * UtilsHero.getMaxHp(h)) < h.getHealth()
                    && h.getHealth() < (Constants.JUMATATE * UtilsHero.getMaxHp(h))) {
                strategy = new WizardDecision(0);
            }
            if (h.getHealth() < (Constants.PATRIME * UtilsHero.getMaxHp(h))) {
                strategy = new WizardDecision(1);
            }
        }
    }
    public final void executeStrategy(final Hero h) {
        try {
            this.strategy.setPlayersStrategy(h);
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }
}
