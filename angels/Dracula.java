package angels;

import heroes.*;
import heroes.utils.UtilsHero;

public class Dracula extends Angel implements AngelVisitor {

    public Dracula(int xCoordonate, int yCoordonate) {
        super(xCoordonate, yCoordonate);
    }

    @Override
    public void visit(Hero h) {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.increaseDamageModifier(-0.20f);
                h.setHealth(h.getHealth()-60);
            }
            if (h instanceof Pyromancer) {
                h.increaseDamageModifier(-0.30f);
                h.setHealth(h.getHealth()-40);
            }
            if (h instanceof Rogue) {
                h.increaseDamageModifier(-0.10f);
                h.setHealth(h.getHealth()-35);
            }
            if (h instanceof Wizard) {
                h.increaseDamageModifier(-0.40f);
                h.setHealth(h.getHealth()-20);
            }
        }
    }
}
