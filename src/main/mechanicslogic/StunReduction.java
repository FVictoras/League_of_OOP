package main.mechanicslogic;

import heroes.Hero;

public class StunReduction implements RoundStrategy {
    @Override
    public void doOperation(Hero H) {
        if (H.getStunned() > 0) {
            H.setStunned(H.getStunned()-1);
        }
    }

    @Override
    public void doOperation(Hero H1, Hero H2) {

    }
}
