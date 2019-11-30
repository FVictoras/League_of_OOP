package main.mechanicslogic;

import heroes.Hero;

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
}
