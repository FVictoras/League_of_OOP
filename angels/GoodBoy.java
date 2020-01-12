package angels;

import heroes.*;
import heroes.utils.UtilsHero;
import main.Log;

import java.io.IOException;

public class GoodBoy extends Angel implements AngelVisitor {

    public GoodBoy(int xCoordonate, int yCoordonate, String output) throws IOException {
        super(xCoordonate, yCoordonate, output);
    }
    @Override
    public String toString() {
        return "GoodBoy";
    }

    @Override
    public void visit(Hero h) throws IOException {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.increaseDamageModifier(0.40f);
                h.setHealth(h.getHealth()+20);
                Log.update(this, h, output);
            }
            if (h instanceof Pyromancer) {
                h.increaseDamageModifier(0.50f);
                h.setHealth(h.getHealth()+30);
                Log.update(this, h, output);
            }
            if (h instanceof Rogue) {
                h.increaseDamageModifier(0.40f);
                h.setHealth(h.getHealth()+40);
                Log.update(this, h, output);
            }
            if (h instanceof Wizard) {
                h.increaseDamageModifier(0.30f);
                h.setHealth(h.getHealth()+50);
                Log.update(this, h, output);
            }
        }
    }
}
