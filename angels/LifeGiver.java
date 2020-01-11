package angels;

import heroes.*;
import heroes.utils.UtilsHero;

public class LifeGiver extends Angel implements AngelVisitor {

    public LifeGiver(int xCoordonate, int yCoordonate) {
        super(xCoordonate, yCoordonate);
    }

    @Override
    public void visit(Hero h) {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.setHealth(h.getHealth()+100);
            }
            if (h instanceof Pyromancer) {
                h.setHealth(h.getHealth()+80);
            }
            if (h instanceof Rogue) {
                h.setHealth(h.getHealth()+90);
            }
            if (h instanceof Wizard) {
                h.setHealth(h.getHealth()+120);
            }
        }
    }
}
