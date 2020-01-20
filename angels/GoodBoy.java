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

public class GoodBoy extends Angel implements AngelVisitor {

    public GoodBoy(final int xCoordonate, final int yCoordonate) throws IOException {
        super(xCoordonate, yCoordonate);
    }
    @Override
    public final String toString() {
        return "GoodBoy";
    }

    @Override
    public final void visit(final Hero h, final FileWriter fileWriter) throws IOException {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.increaseDamageModifier(Constants.GOODBOYF_K);
                if (UtilsHero.getMaxHp(h) >= h.getHealth() + Constants.GOODBOY_K) {
                    h.setHealth(h.getHealth() + Constants.GOODBOY_K);
                    Log.update(this, h, fileWriter);
                } else {
                    h.setHealth(UtilsHero.getMaxHp(h));
                    Log.update(this, h, fileWriter);
                }
            }
            if (h instanceof Pyromancer) {
                h.increaseDamageModifier(Constants.GOODBOYF_P);
                if (UtilsHero.getMaxHp(h) >= h.getHealth() + Constants.GOODBOY_P) {
                    h.setHealth(h.getHealth() + Constants.GOODBOY_P);
                    Log.update(this, h, fileWriter);
                } else {
                    h.setHealth(UtilsHero.getMaxHp(h));
                    Log.update(this, h, fileWriter);
                }
            }
            if (h instanceof Rogue) {
                h.increaseDamageModifier(Constants.GOODBOYF_R);
                if (UtilsHero.getMaxHp(h) >= h.getHealth() + Constants.GOODBOY_R) {
                    h.setHealth(h.getHealth() + Constants.GOODBOY_R);
                    Log.update(this, h, fileWriter);
                } else {
                    h.setHealth(UtilsHero.getMaxHp(h));
                    Log.update(this, h, fileWriter);
                }
            }
            if (h instanceof Wizard) {
                h.increaseDamageModifier(Constants.GOODBOYF_W);
                if (UtilsHero.getMaxHp(h) >= h.getHealth() + Constants.GOODBOY_W) {
                    h.setHealth(h.getHealth() + Constants.GOODBOY_W);
                    Log.update(this, h, fileWriter);
                } else {
                    h.setHealth(UtilsHero.getMaxHp(h));
                    Log.update(this, h, fileWriter);
                }
            }
        }
    }
}
