package main.mechanicslogic;

import common.Constants;
import fileio.implementations.FileWriter;
import heroes.Hero;
import java.io.IOException;

public class ContextRound {
    private RoundStrategy roundStrategy;

    /**
     * Se returneaza strategia ceruta din logica jocului.
     * @param strategy tipul strategiei
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
     * Se aplica operatia potrivita contextului.
     * @param h eroul careia i se aplica
     */
    public void doOperation(final Hero h) {
        roundStrategy.doOperation(h);
    }

    /**
     * Overwrite. Operatie pentru contextul care implica doi compioni.
     * @param h1 primul erou
     * @param h2 al doilea erou
     */
    public void doOperation(final Hero h1, final Hero h2) {
        roundStrategy.doOperation(h1, h2);
    }

    /**
     * Overwrite. Operatie pentru contextul care implica doi campioni si un FileWriter
     * @param h1
     * @param h2
     * @param fileWriter
     * @throws IOException
     */
    public void doOperation(final Hero h1, final Hero h2, final FileWriter fileWriter)
            throws IOException {
        roundStrategy.doOperation(h1, h2, fileWriter);
    }


}
