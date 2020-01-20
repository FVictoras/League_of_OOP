package main.mechanicslogic;

import fileio.implementations.FileWriter;
import heroes.Hero;

public class OvertimeDamage implements RoundStrategy {
    /**
     * Se incaseaza damageul avut ca overtime.
     * @param h eroul
     */
    @Override
    public void doOperation(final Hero h) {
        if (h.getRoundsOvertime() > 0) {
            h.receiveDamage(h.getDamageOvertime());
            h.setRoundsOvertime(h.getRoundsOvertime() - 1);
        }
    }

    @Override
    public void doOperation(final Hero h1, final Hero h2) {

    }

    @Override
    public void doOperation(final Hero h1, final Hero h2, final FileWriter fileWriter) {

    }

}
