package angels;

import heroes.*;
import heroes.utils.UtilsHero;
import main.Log;

import java.io.IOException;

public class LevelUpAngel extends Angel implements AngelVisitor {

    public LevelUpAngel(int xCoordonate, int yCoordonate, String output) throws IOException {
        super(xCoordonate, yCoordonate, output);
    }
    @Override
    public String toString() {
        return "LevelUpAngel";
    }

    @Override
    public void visit(Hero h) throws IOException {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.increaseDamageModifier(0.10f);
                h.setLevel(h.getLevel()+1);
                h.setHealth(UtilsHero.getMaxHp(h));
                Log.update(this, h, output);
                Log.update(h, output);
            }
            if (h instanceof Pyromancer) {
                h.increaseDamageModifier(0.20f);
                h.setLevel(h.getLevel()+1);
                h.setHealth(UtilsHero.getMaxHp(h));
                Log.update(this, h, output);
                Log.update(h, output);
            }
            if (h instanceof Rogue) {
                h.increaseDamageModifier(0.15f);
                h.setLevel(h.getLevel()+1);
                h.setHealth(UtilsHero.getMaxHp(h));
                Log.update(this, h, output);
                Log.update(h, output);
            }
            if (h instanceof Wizard) {
                h.increaseDamageModifier(0.25f);
                h.setLevel(h.getLevel()+1);
                h.setHealth(UtilsHero.getMaxHp(h));
                Log.update(this, h, output);
                Log.update(h, output);
            }
        }
    }
}
