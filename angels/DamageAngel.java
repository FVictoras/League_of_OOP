package angels;

import heroes.*;
import heroes.utils.UtilsHero;

public class DamageAngel extends Angel implements AngelVisitor  {

    public DamageAngel(int xCoordonate, int yCoordonate) {
        super(xCoordonate, yCoordonate);
    }

    @Override
    public String toString() {
        return "Sunt un DamageAngel si ma aflu la " + this.xCoordonate + ", " + this.yCoordonate;
    }

    @Override
    public void visit(Hero h) {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) h.increaseDamageModifier(0.15f);
            if (h instanceof Pyromancer) h.increaseDamageModifier(0.20f);
            if (h instanceof Rogue) h.increaseDamageModifier(0.30f);
            if (h instanceof Wizard) h.increaseDamageModifier(0.40f);
        }
    }

}
