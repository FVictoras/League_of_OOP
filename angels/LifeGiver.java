package angels;

import heroes.*;
import heroes.utils.UtilsHero;
import main.Log;

import java.io.IOException;

public class LifeGiver extends Angel implements AngelVisitor {

    public LifeGiver(int xCoordonate, int yCoordonate, String output) throws IOException {
        super(xCoordonate, yCoordonate, output);
    }
    @Override
    public String toString() {
        return "LifeGiver";
    }

    @Override
    public void visit(Hero h) throws IOException {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.setHealth(h.getHealth()+100);
                Log.update(this, h, output);
            }
            if (h instanceof Pyromancer) {
                h.setHealth(h.getHealth()+80);
                Log.update(this, h, output);
            }
            if (h instanceof Rogue) {
                h.setHealth(h.getHealth()+90);
                Log.update(this, h, output);
            }
            if (h instanceof Wizard) {
                h.setHealth(h.getHealth()+120);
                Log.update(this, h, output);
            }
        }
    }
}
