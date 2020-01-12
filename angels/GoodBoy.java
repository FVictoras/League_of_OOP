package angels;

import fileio.implementations.FileWriter;
import heroes.*;
import heroes.utils.UtilsHero;
import main.Log;

import java.io.IOException;

public class GoodBoy extends Angel implements AngelVisitor {

    public GoodBoy(int xCoordonate, int yCoordonate) throws IOException {
        super(xCoordonate, yCoordonate);
    }
    @Override
    public String toString() {
        return "GoodBoy";
    }

    @Override
    public void visit(Hero h, FileWriter fileWriter) throws IOException {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.increaseDamageModifier(0.40f);
                h.setHealth(h.getHealth()+20);
                Log.update(this, h, fileWriter);
            }
            if (h instanceof Pyromancer) {
                h.increaseDamageModifier(0.50f);
                h.setHealth(h.getHealth()+30);
                Log.update(this, h, fileWriter);
            }
            if (h instanceof Rogue) {
                h.increaseDamageModifier(0.40f);
                h.setHealth(h.getHealth()+40);
                Log.update(this, h, fileWriter);
            }
            if (h instanceof Wizard) {
                h.increaseDamageModifier(0.30f);
                h.setHealth(h.getHealth()+50);
                Log.update(this, h, fileWriter);
            }
        }
    }
}
