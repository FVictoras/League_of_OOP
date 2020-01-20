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

public class LevelUpAngel extends Angel implements AngelVisitor {

    public LevelUpAngel(final int xCoordonate, final int yCoordonate) throws IOException {
        super(xCoordonate, yCoordonate);
    }

    @Override
    public final String toString() {
        return "LevelUpAngel";
    }

    @Override
    public final void visit(final Hero h, final FileWriter fileWriter) throws IOException {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.increaseDamageModifier(Constants.LVLUPANG_K);
                h.setLevel(h.getLevel() + 1);
                h.setXp(Constants.XP_BASE + (h.getLevel() - 1) * Constants.XP_MULTIPLICATOR);
                h.setHealth(UtilsHero.getMaxHp(h));
                Log.update(this, h, fileWriter);
                Log.update(h, fileWriter);
            }
            if (h instanceof Pyromancer) {
                h.increaseDamageModifier(Constants.LVLUPANG_P);
                h.setLevel(h.getLevel() + 1);
                h.setXp(Constants.XP_BASE + (h.getLevel() - 1) * Constants.XP_MULTIPLICATOR);
                h.setHealth(UtilsHero.getMaxHp(h));
                Log.update(this, h, fileWriter);
                Log.update(h, fileWriter);
            }
            if (h instanceof Rogue) {
                h.increaseDamageModifier(Constants.LVLUPANG_R);
                h.setLevel(h.getLevel() + 1);
                h.setXp(Constants.XP_BASE + (h.getLevel() - 1) * Constants.XP_MULTIPLICATOR);
                h.setHealth(UtilsHero.getMaxHp(h));
                Log.update(this, h, fileWriter);
                Log.update(h, fileWriter);
            }
            if (h instanceof Wizard) {
                h.increaseDamageModifier(Constants.LVLUPANG_W);
                h.setLevel(h.getLevel() + 1);
                h.setXp(Constants.XP_BASE + (h.getLevel() - 1) * Constants.XP_MULTIPLICATOR);
                h.setHealth(UtilsHero.getMaxHp(h));
                Log.update(this, h, fileWriter);
                Log.update(h, fileWriter);
            }
        }
    }
}
