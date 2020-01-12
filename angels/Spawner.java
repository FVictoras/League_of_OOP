package angels;

import common.Constants;
import heroes.*;
import heroes.utils.UtilsHero;
import main.Log;

import java.io.IOException;

public class Spawner extends Angel implements AngelVisitor {

    public Spawner(int xCoordonate, int yCoordonate, String output) throws IOException {
        super(xCoordonate, yCoordonate, output);
    }
    @Override
    public String toString() {
        return "Spawner";
    }

    @Override
    public void visit(Hero h) throws IOException {
        if (!UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.setHealth(200);
                Log.update(this, h, output);
            }
            if (h instanceof Pyromancer) {
                h.setHealth(150);
                Log.update(this, h, output);
            }
            if (h instanceof Rogue) {
                h.setHealth(180);
                Log.update(this, h, output);
            }
            if (h instanceof Wizard) {
                h.setHealth(120);
                Log.update(this, h, output);
            }
        }
    }

}
