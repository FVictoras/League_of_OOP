package main.mechanicslogic;

import fileio.implementations.FileWriter;
import heroes.Hero;
import main.Log;

import java.io.IOException;

public class StunReduction implements RoundStrategy {
    /**
     * Se decrementeaza timpul stunului.
     * @param h eroul.
     */
    @Override
    public void doOperation(final Hero h) {
        if (h.getStunned() > 0) {
            h.setStunned(h.getStunned() - 1);
        }
    }

    @Override
    public void doOperation(final Hero h1, final Hero h2) {

    }

    @Override
    public void doOperation(Hero h1, Hero h2, FileWriter fileWriter) throws IOException {

    }
}
