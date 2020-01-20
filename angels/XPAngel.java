package angels;

import common.Constants;
import fileio.implementations.FileWriter;
import heroes.Hero;
import heroes.Pyromancer;
import heroes.Knight;
import heroes.Wizard;
import heroes.Rogue;
import heroes.utils.UtilsHero;
import main.Log;

import java.io.IOException;

public class XPAngel extends Angel implements AngelVisitor {

    public XPAngel(final int xCoordonate, final int yCoordonate) throws IOException {
        super(xCoordonate, yCoordonate);
    }

    @Override
    public final String toString() {
        return "XPAngel";
    }

    @Override
    public final void visit(final Hero h, final FileWriter fileWriter) throws IOException {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.setXp(h.getXp() + Constants.XPA_K);
                Log.update(this, h, fileWriter);
                int lastLevel = h.getLevel();
                h.setLevel(Math.max(0,
                        (int) Math.ceil((double) ((h.getXp() - Constants.XP_BASE) + 1)
                                / Constants.XP_MULTIPLICATOR)));
                if (h.getLevel() > lastLevel && UtilsHero.isAlive(h)) {
                    h.setHealth(UtilsHero.getMaxHp(h));
                    if (h.getLevel() - lastLevel > 0) {
                        Log.update(h, h.getLevel() - lastLevel, fileWriter);
                    } else {
                        Log.update(h, fileWriter);
                    }
                }
            }
            if (h instanceof Pyromancer) {
                h.setXp(h.getXp() + Constants.XPA_P);
                Log.update(this, h, fileWriter);
                int lastLevel = h.getLevel();
                h.setLevel(Math.max(0,
                        (int) Math.ceil((double) ((h.getXp() - Constants.XP_BASE) + 1)
                                / Constants.XP_MULTIPLICATOR)));
                if (h.getLevel() > lastLevel && UtilsHero.isAlive(h)) {
                    h.setHealth(UtilsHero.getMaxHp(h));
                    if (h.getLevel() - lastLevel > 0) {
                        Log.update(h, h.getLevel() - lastLevel, fileWriter);
                    } else {
                        Log.update(h, fileWriter);
                    }
                }
            }
            if (h instanceof Rogue) {
                h.setXp(h.getXp() + Constants.XPA_R);
                Log.update(this, h, fileWriter);
                int lastLevel = h.getLevel();
                h.setLevel(Math.max(0,
                        (int) Math.ceil((double) ((h.getXp() - Constants.XP_BASE) + 1)
                                / Constants.XP_MULTIPLICATOR)));
                if (h.getLevel() > lastLevel && UtilsHero.isAlive(h)) {
                    h.setHealth(UtilsHero.getMaxHp(h));
                    if (h.getLevel() - lastLevel > 0) {
                        Log.update(h, h.getLevel() - lastLevel, fileWriter);
                    } else {
                        Log.update(h, fileWriter);
                    }
                }
            }
            if (h instanceof Wizard) {
                h.setXp(h.getXp() + Constants.XPA_W);
                Log.update(this, h, fileWriter);
                int lastLevel = h.getLevel();
                h.setLevel(Math.max(0,
                        (int) Math.ceil((double) ((h.getXp() - Constants.XP_BASE) + 1)
                                / Constants.XP_MULTIPLICATOR)));
                if (h.getLevel() > lastLevel && UtilsHero.isAlive(h)) {
                    h.setHealth(UtilsHero.getMaxHp(h));
                    if (h.getLevel() - lastLevel > 0) {
                        Log.update(h, h.getLevel() - lastLevel, fileWriter);
                    } else {
                        Log.update(h, fileWriter);
                    }
                }
            }
        }
    }
}
