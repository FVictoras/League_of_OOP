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

public class Dracula extends Angel implements AngelVisitor {

    public Dracula(final int xCoordonate, final int yCoordonate) throws IOException {
        super(xCoordonate, yCoordonate);
    }
    @Override
    public final String toString() {
        return "Dracula";
    }

    @Override
    public final void visit(final Hero h, final FileWriter fileWriter) throws IOException {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.increaseDamageModifier(Constants.DRACULAF_K);
                h.setHealth(h.getHealth() + Constants.DRACULA_K);
                Log.update(this, h, fileWriter);
                if (!UtilsHero.isAlive(h)) {
                    Log.updateA(h, fileWriter);
                }
            }
            if (h instanceof Pyromancer) {
                h.increaseDamageModifier(Constants.DRACULAF_P);
                h.setHealth(h.getHealth() + Constants.DRACULA_P);
                Log.update(this, h, fileWriter);
                if (!UtilsHero.isAlive(h)) {
                    Log.updateA(h, fileWriter);
                }
            }
            if (h instanceof Rogue) {
                h.increaseDamageModifier(Constants.DRACULAF_R);
                h.setHealth(h.getHealth() + Constants.DRACULA_R);
                Log.update(this, h, fileWriter);
                if (!UtilsHero.isAlive(h)) {
                    Log.updateA(h, fileWriter);
                }
            }
            if (h instanceof Wizard) {
                h.increaseDamageModifier(Constants.DRACULAF_W);
                h.setHealth(h.getHealth() + Constants.DRACULA_W);
                Log.update(this, h, fileWriter);
                if (!UtilsHero.isAlive(h)) {
                    Log.updateA(h, fileWriter);
                }
            }
        }
    }
}
