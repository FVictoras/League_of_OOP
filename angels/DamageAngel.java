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

public class DamageAngel extends Angel implements AngelVisitor  {

    public DamageAngel(final int xCoordonate, final int yCoordonate) throws IOException {
        super(xCoordonate, yCoordonate);
    }

    @Override
    public final String toString() {
        return "DamageAngel";
    }

    @Override
    public final void visit(final Hero h, final FileWriter fileWriter) throws IOException {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.increaseDamageModifier(Constants.DAMAGEANGEL_K);
                Log.update(this, h, fileWriter);
            }
            if (h instanceof Pyromancer) {
                h.increaseDamageModifier(Constants.DAMAGEANGEL_P);
                Log.update(this, h, fileWriter);
            }
            if (h instanceof Rogue) {
                h.increaseDamageModifier(Constants.DAMAGEANGEL_R);
                Log.update(this, h, fileWriter);
            }
            if (h instanceof Wizard) {
                h.increaseDamageModifier(Constants.DAMAGEANGEL_W);
                Log.update(this, h, fileWriter);
            }
        }
    }

}
