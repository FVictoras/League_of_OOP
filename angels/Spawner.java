package angels;

import common.Constants;
import heroes.*;
import heroes.utils.UtilsHero;

public class Spawner extends Angel implements AngelVisitor {

    public Spawner(int xCoordonate, int yCoordonate) {
        super(xCoordonate, yCoordonate);
    }

    @Override
    public void visit(Hero h) {
        if (!UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.setHealth(200);
            }
            if (h instanceof Pyromancer) {
                h.setHealth(150);
            }
            if (h instanceof Rogue) {
                h.setHealth(180);
            }
            if (h instanceof Wizard) {
                h.setHealth(120);
            }
        }
    }

}
