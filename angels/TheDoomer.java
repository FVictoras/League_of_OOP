package angels;

import fileio.implementations.FileWriter;
import heroes.Hero;
import heroes.utils.UtilsHero;
import main.Log;

import java.io.IOException;

public class TheDoomer extends Angel implements AngelVisitor {

    public TheDoomer(final int xCoordonate, final  int yCoordonate) throws IOException {
        super(xCoordonate, yCoordonate);
    }

    @Override
    public final String toString() {
        return "TheDoomer";
    }

    @Override
    public final void visit(final Hero h, final FileWriter fileWriter) throws IOException {
        if (UtilsHero.isAlive(h)) {
            h.setHealth(-1);
            Log.update(this, h, fileWriter);
            Log.updateA(h, fileWriter);
        }
    }

}
