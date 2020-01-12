package angels;

import heroes.*;
import heroes.utils.UtilsHero;
import main.Log;
import fileio.implementations.FileWriter;
import java.io.IOException;

public class LifeGiver extends Angel implements AngelVisitor {

    public LifeGiver(int xCoordonate, int yCoordonate) throws IOException {
        super(xCoordonate, yCoordonate);
    }
    @Override
    public String toString() {
        return "LifeGiver";
    }

    @Override
    public void visit(Hero h, FileWriter fileWriter) throws IOException {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.setHealth(h.getHealth()+100);
                Log.update(this, h, fileWriter);
            }
            if (h instanceof Pyromancer) {
                h.setHealth(h.getHealth()+80);
                Log.update(this, h, fileWriter);
            }
            if (h instanceof Rogue) {
                h.setHealth(h.getHealth()+90);
                Log.update(this, h, fileWriter);
            }
            if (h instanceof Wizard) {
                h.setHealth(h.getHealth()+120);
                Log.update(this, h, fileWriter);
            }
        }
    }
}
