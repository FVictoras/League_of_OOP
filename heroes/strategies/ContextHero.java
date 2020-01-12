package heroes.strategies;

import heroes.*;
import heroes.utils.UtilsHero;

public class ContextHero {
    private heroStrategy strategy;

    public ContextHero(final Hero h) {
        if (h instanceof Knight) {
            if ((0.33f*UtilsHero.getMaxHp(h))<h.getHealth()
                    && h.getHealth()<(0.5f*UtilsHero.getMaxHp(h))) {
                strategy = new KnightDecision(0);

            }
            if (h.getHealth()<(0.33f*UtilsHero.getMaxHp(h))) {
                strategy = new KnightDecision(1);
            }
        }
        if (h instanceof Pyromancer) {
            if ((0.25f*UtilsHero.getMaxHp(h))<h.getHealth()
                    && h.getHealth()<(0.33f*UtilsHero.getMaxHp(h))) {
                strategy = new PyromancerDecision(0);

            }
            if (h.getHealth()<(0.25f*UtilsHero.getMaxHp(h))) {
                strategy = new PyromancerDecision(1);
            }
        }
        if (h instanceof Rogue) {
            if ((0.142f*UtilsHero.getMaxHp(h))<h.getHealth()
                    && h.getHealth()<(0.2f*UtilsHero.getMaxHp(h))) {
                strategy = new RogueDecision(0);

            }
            if (h.getHealth()<(0.142f*UtilsHero.getMaxHp(h))) {
                strategy = new RogueDecision(1);
            }
        }
        if (h instanceof Wizard) {
            if ((0.25f*UtilsHero.getMaxHp(h))<h.getHealth()
                    && h.getHealth()<(0.5f*UtilsHero.getMaxHp(h))) {
                strategy = new WizardDecision(0);
            }
            if (h.getHealth()<(0.25f*UtilsHero.getMaxHp(h))) {
                strategy = new WizardDecision(1);
            }
        }
    }

    public void executeStrategy(Hero h) {
        try {
            this.strategy.setPlayersStrategy(h);
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }
}
