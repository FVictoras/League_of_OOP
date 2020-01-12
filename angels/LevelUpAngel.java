package angels;

import heroes.*;
import heroes.utils.UtilsHero;

public class LevelUpAngel extends Angel implements AngelVisitor {

    public LevelUpAngel(int xCoordonate, int yCoordonate) {
        super(xCoordonate, yCoordonate);
    }

    @Override
    public void visit(Hero h) {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.increaseDamageModifier(0.10f);
                h.setXp(0);
                h.setLevel(h.getLevel()+1);
                h.setHealth(UtilsHero.getMaxHp(h));
            }
            if (h instanceof Pyromancer) {
                h.increaseDamageModifier(0.20f);
                h.setXp(0);
                h.setLevel(h.getLevel()+1);
                h.setHealth(UtilsHero.getMaxHp(h));
            }
            if (h instanceof Rogue) {
                h.increaseDamageModifier(0.15f);
                h.setXp(0);
                h.setLevel(h.getLevel()+1);
                h.setHealth(UtilsHero.getMaxHp(h));
            }
            if (h instanceof Wizard) {
                h.increaseDamageModifier(0.25f);
                h.setXp(0);
                h.setLevel(h.getLevel()+1);
                h.setHealth(UtilsHero.getMaxHp(h));
            }
        }
    }
}
