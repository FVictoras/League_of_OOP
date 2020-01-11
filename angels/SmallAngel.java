package angels;

import heroes.*;
import heroes.utils.UtilsHero;

public class SmallAngel extends Angel implements AngelVisitor {

    public SmallAngel(int xCoordonate, int yCoordonate) {
        super(xCoordonate, yCoordonate);
    }

    @Override
    public void visit(Hero h) {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.increaseDamageModifier(0.10f);
                h.setHealth(h.getHealth()+10);
            }
            if (h instanceof Pyromancer) {
                h.increaseDamageModifier(0.15f);
                h.setHealth(h.getHealth()+15);
            }
            if (h instanceof Rogue) {
                h.increaseDamageModifier(0.05f);
                h.setHealth(h.getHealth()+20);
            }
            if (h instanceof Wizard) {
                h.increaseDamageModifier(0.10f);
                h.setHealth(h.getHealth()+25);
            }
        }
    }

}
