package angels;

import heroes.*;
import heroes.utils.UtilsHero;
import main.Log;

import java.io.IOException;

public class DamageAngel extends Angel implements AngelVisitor  {

    public DamageAngel(int xCoordonate, int yCoordonate, String output) throws IOException {
        super(xCoordonate, yCoordonate, output);
    }

    @Override
    public String toString() {
        return "DamageAngel";
    }

    @Override
    public void visit(Hero h) throws IOException {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.increaseDamageModifier(0.15f);
                Log.update(this, h, output);
            }
            if (h instanceof Pyromancer) {
                h.increaseDamageModifier(0.20f);
                Log.update(this, h, output);
            }
            if (h instanceof Rogue) {
                h.increaseDamageModifier(0.30f);
                Log.update(this, h, output);
            }
            if (h instanceof Wizard) {
                h.increaseDamageModifier(0.40f);
                Log.update(this, h, output);
            }
        }
    }

}
