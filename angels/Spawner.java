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

public class Spawner extends Angel implements AngelVisitor {

    public Spawner(final int xCoordonate, final int yCoordonate) throws IOException {
        super(xCoordonate, yCoordonate);
    }
    @Override
    public final String toString() {
        return "Spawner";
    }

    @Override
    public final void visit(final Hero h, final FileWriter fileWriter) throws IOException {
        if (!UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.setHealth(Constants.SPAWNER_K);
                Log.update(this, h, fileWriter);
                Log.updateB(h, fileWriter);
            }
            if (h instanceof Pyromancer) {
                h.setHealth(Constants.SPAWNER_P);
                Log.update(this, h, fileWriter);
                Log.updateB(h, fileWriter);
            }
            if (h instanceof Rogue) {
                h.setHealth(Constants.SPAWNER_R);
                Log.update(this, h, fileWriter);
                Log.updateB(h, fileWriter);
            }
            if (h instanceof Wizard) {
                h.setHealth(Constants.SPAWNER_W);
                Log.update(this, h, fileWriter);
                Log.updateB(h, fileWriter);
            }
        }
    }

}
