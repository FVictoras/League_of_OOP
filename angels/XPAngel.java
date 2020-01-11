package angels;

import heroes.*;
import heroes.utils.UtilsHero;

public class XPAngel extends Angel implements AngelVisitor {

    public XPAngel(int xCoordonate, int yCoordonate) {
        super(xCoordonate, yCoordonate);
    }

    @Override
    public void visit(Hero h) {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.setXp(h.getXp()+45);
            }
            if (h instanceof Pyromancer) {
                h.setXp(h.getXp()+50);
            }
            if (h instanceof Rogue) {
                h.setXp(h.getXp()+40);
            }
            if (h instanceof Wizard) {
                h.setXp(h.getXp()+60);

            }
        }
    }
}
