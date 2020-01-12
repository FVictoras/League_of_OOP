package angels;

import common.Constants;
import heroes.*;
import heroes.utils.UtilsHero;
import main.Log;

import java.io.IOException;

public class DarkAngel extends Angel implements AngelVisitor  {

    public DarkAngel(int xCoordonate, int yCoordonate, String output) throws IOException {
        super(xCoordonate, yCoordonate, output);
    }
    @Override
    public String toString() {
        return "DarkAngel";
    }

    @Override
    public void visit(Hero h) throws IOException {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.setHealth(h.getHealth() - Constants.DARKANGEL_K);
                Log.update(this, h, output);
            }
            if (h instanceof Pyromancer) {
                h.setHealth(h.getHealth() - Constants.DARKANGEL_P);
                Log.update(this, h, output);
            }
            if (h instanceof Rogue) {
                h.setHealth(h.getHealth() - Constants.DARKANGEL_R);
                Log.update(this, h, output);
            }
            if (h instanceof Wizard) {
                h.setHealth(h.getHealth() - Constants.DARKANGEL_W);
                Log.update(this, h, output);
            }
        }
    }
}
