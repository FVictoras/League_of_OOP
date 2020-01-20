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

public class SmallAngel extends Angel implements AngelVisitor {

    public SmallAngel(final int xCoordonate, final int yCoordonate) throws IOException {
        super(xCoordonate, yCoordonate);
    }
    @Override
    public final String toString() {
        return "SmallAngel";
    }

    @Override
    public final void visit(final Hero h, final FileWriter fileWriter) throws IOException {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.increaseDamageModifier(Constants.SMALLANGELF_K);
                h.setHealth(h.getHealth() + Constants.SMALLANGEL_K);
                Log.update(this, h, fileWriter);
            }
            if (h instanceof Pyromancer) {
                h.increaseDamageModifier(Constants.SMALLANGELF_P);
                h.setHealth(h.getHealth() + Constants.SMALLANGEL_P);
                Log.update(this, h, fileWriter);
            }
            if (h instanceof Rogue) {
                h.increaseDamageModifier(Constants.SMALLANGELF_R);
                h.setHealth(h.getHealth() + Constants.SMALLANGEL_R);
                Log.update(this, h, fileWriter);
            }
            if (h instanceof Wizard) {
                h.increaseDamageModifier(Constants.SMALLANGELF_W);
                h.setHealth(h.getHealth() + Constants.SMALLANGEL_W);
                Log.update(this, h, fileWriter);
            }
        }
    }

}
