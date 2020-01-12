package angels;

import common.Constants;
import heroes.*;
import heroes.utils.UtilsHero;
import main.Log;

import fileio.implementations.FileWriter;
import java.io.IOException;

public class XPAngel extends Angel implements AngelVisitor {

    public XPAngel(int xCoordonate, int yCoordonate) throws IOException {
        super(xCoordonate, yCoordonate);
    }
    @Override
    public String toString() {
        return "XPAngel";
    }

    @Override
    public void visit(Hero h, FileWriter fileWriter) throws IOException {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.setXp(h.getXp()+45);
                Log.update(this, h, fileWriter);
                int lastLevel = h.getLevel();
                h.setLevel(Math.max(0,
                        (int) Math.ceil((double) ((h.getXp() - Constants.XP_BASE) + 1)
                                / Constants.XP_MULTIPLICATOR)));
                if (h.getLevel()>lastLevel && UtilsHero.isAlive(h)) {
                    h.setHealth(UtilsHero.getMaxHp(h));
                    if (h.getLevel() - lastLevel > 0) {
                        Log.update(h, h.getLevel()-lastLevel, fileWriter);
                    } else {
                        Log.update(h, fileWriter);
                    }
                }
            }
            if (h instanceof Pyromancer) {
                h.setXp(h.getXp()+50);
                Log.update(this, h, fileWriter);
                int lastLevel = h.getLevel();
                h.setLevel(Math.max(0,
                        (int) Math.ceil((double) ((h.getXp() - Constants.XP_BASE) + 1)
                                / Constants.XP_MULTIPLICATOR)));
                if (h.getLevel()>lastLevel && UtilsHero.isAlive(h)) {
                    h.setHealth(UtilsHero.getMaxHp(h));
                    if (h.getLevel() - lastLevel > 0) {
                        Log.update(h, h.getLevel()-lastLevel, fileWriter);
                    } else {
                        Log.update(h, fileWriter);
                    }
                }
            }
            if (h instanceof Rogue) {
                h.setXp(h.getXp()+40);
                Log.update(this, h, fileWriter);
                int lastLevel = h.getLevel();
                h.setLevel(Math.max(0,
                        (int) Math.ceil((double) ((h.getXp() - Constants.XP_BASE) + 1)
                                / Constants.XP_MULTIPLICATOR)));
                if (h.getLevel()>lastLevel && UtilsHero.isAlive(h)) {
                    h.setHealth(UtilsHero.getMaxHp(h));
                    if (h.getLevel() - lastLevel > 0) {
                        Log.update(h, h.getLevel()-lastLevel, fileWriter);
                    } else {
                        Log.update(h, fileWriter);
                    }
                }
            }
            if (h instanceof Wizard) {
                h.setXp(h.getXp()+60);
                Log.update(this, h, fileWriter);
                int lastLevel = h.getLevel();
                h.setLevel(Math.max(0,
                        (int) Math.ceil((double) ((h.getXp() - Constants.XP_BASE) + 1)
                                / Constants.XP_MULTIPLICATOR)));
                if (h.getLevel()>lastLevel && UtilsHero.isAlive(h)) {
                    h.setHealth(UtilsHero.getMaxHp(h));
                    if (h.getLevel() - lastLevel > 0) {
                        Log.update(h, h.getLevel()-lastLevel, fileWriter);
                    } else {
                        Log.update(h, fileWriter);
                    }
                }
            }
        }
    }
}
