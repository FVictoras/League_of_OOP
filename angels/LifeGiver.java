package angels;

import common.Constants;
import heroes.Hero;
import heroes.Pyromancer;
import heroes.Knight;
import heroes.Wizard;
import heroes.Rogue;
import heroes.utils.UtilsHero;
import main.Log;
import fileio.implementations.FileWriter;
import java.io.IOException;

public class LifeGiver extends Angel implements AngelVisitor {

    public LifeGiver(final int xCoordonate, final int yCoordonate) throws IOException {
        super(xCoordonate, yCoordonate);
    }
    @Override
    public final String toString() {
        return "LifeGiver";
    }

    @Override
    public final void visit(final Hero h, final FileWriter fileWriter) throws IOException {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                if (UtilsHero.getMaxHp(h) >= h.getHealth() + Constants.LIFEGIVER_K) {
                    h.setHealth(h.getHealth() + Constants.LIFEGIVER_K);
                    Log.update(this, h, fileWriter);
                } else {
                    h.setHealth(UtilsHero.getMaxHp(h));
                    Log.update(this, h, fileWriter);
                }
            }
            if (h instanceof Pyromancer) {
                if (UtilsHero.getMaxHp(h) >= h.getHealth() + Constants.LIFEGIVER_P) {
                    h.setHealth(h.getHealth() + Constants.LIFEGIVER_P);
                    Log.update(this, h, fileWriter);
                } else {
                    h.setHealth(UtilsHero.getMaxHp(h));
                    Log.update(this, h, fileWriter);
                }
            }
            if (h instanceof Rogue) {
                if (UtilsHero.getMaxHp(h) >= h.getHealth() + Constants.LIFEGIVER_R) {
                    h.setHealth(h.getHealth() + Constants.LIFEGIVER_R);
                    Log.update(this, h, fileWriter);
                } else {
                    h.setHealth(UtilsHero.getMaxHp(h));
                    Log.update(this, h, fileWriter);
                }
            }
            if (h instanceof Wizard) {
                if (UtilsHero.getMaxHp(h) >= h.getHealth() + Constants.LIFEGIVER_W) {
                    h.setHealth(h.getHealth() + Constants.LIFEGIVER_W);
                    Log.update(this, h, fileWriter);
                } else {
                    h.setHealth(UtilsHero.getMaxHp(h));
                    Log.update(this, h, fileWriter);
                }
            }
        }
    }
}
