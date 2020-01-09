package angels;

import common.Constants;
import heroes.*;

public class DarkAngel extends Angel implements AngelVisitor  {

    public DarkAngel(int xCoordonate, int yCoordonate) {
        super(xCoordonate, yCoordonate);
    }

    @Override
    public void visit(Hero h) {
        if (h instanceof Knight) {
            h.setHealth(h.getHealth() - Constants.DARKANGEL_K);
        }
        if (h instanceof Pyromancer) {
            h.setHealth(h.getHealth() - Constants.DARKANGEL_P);
        }
        if (h instanceof Rogue) {
            h.setHealth(h.getHealth() - Constants.DARKANGEL_R);
        }
        if (h instanceof Wizard) {
            h.setHealth(h.getHealth() - Constants.DARKANGEL_W);
        }
    }
}
