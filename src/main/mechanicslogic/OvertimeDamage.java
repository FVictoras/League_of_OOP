package main.mechanicslogic;

import heroes.Hero;

public class OvertimeDamage implements RoundStrategy {
    @Override
    public void doOperation(Hero H) {
        if (H.getRoundsOvertime() > 0) {
            H.receiveDamage(H.getDamageOvertime());
            H.setRoundsOvertime(H.getRoundsOvertime() - 1);
        }
    }

    @Override
    public void doOperation(Hero H1, Hero H2) {

    }
}
