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

public class DarkAngel extends Angel implements AngelVisitor  {

    public DarkAngel(final int xCoordonate, final int yCoordonate) throws IOException {
        super(xCoordonate, yCoordonate);
    }
    @Override
    public final String toString() {
        return "DarkAngel";
    }

    @Override
    public final void visit(final Hero h, final FileWriter fileWriter) throws IOException {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.setHealth(h.getHealth() - Constants.DARKANGEL_K);
                Log.update(this, h, fileWriter);
            }
            if (h instanceof Pyromancer) {
                h.setHealth(h.getHealth() - Constants.DARKANGEL_P);
                Log.update(this, h, fileWriter);
            }
            if (h instanceof Rogue) {
                h.setHealth(h.getHealth() - Constants.DARKANGEL_R);
                Log.update(this, h, fileWriter);
            }
            if (h instanceof Wizard) {
                h.setHealth(h.getHealth() - Constants.DARKANGEL_W);
                Log.update(this, h, fileWriter);
            }
        }
    }
}
