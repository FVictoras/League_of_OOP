package angels;

import heroes.*;
import heroes.utils.UtilsHero;

public class GoodBoy extends Angel implements AngelVisitor {

    public GoodBoy(int xCoordonate, int yCoordonate) {
        super(xCoordonate, yCoordonate);
    }

    @Override
    public void visit(Hero h) {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.increaseDamageModifier(0.40f);
                h.setHealth(h.getHealth()+20);
            }
            if (h instanceof Pyromancer) {
                h.increaseDamageModifier(0.50f);
                h.setHealth(h.getHealth()+30);
            }
            if (h instanceof Rogue) {
                h.increaseDamageModifier(0.40f);
                h.setHealth(h.getHealth()+40);
            }
            if (h instanceof Wizard) {
                h.increaseDamageModifier(0.30f);
                h.setHealth(h.getHealth()+50);
            }
        }
    }
}
