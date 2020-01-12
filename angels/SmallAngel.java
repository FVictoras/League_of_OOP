package angels;

import heroes.*;
import heroes.utils.UtilsHero;
import main.Log;
import fileio.implementations.FileWriter;
import java.io.IOException;

public class SmallAngel extends Angel implements AngelVisitor {

    public SmallAngel(int xCoordonate, int yCoordonate) throws IOException {
        super(xCoordonate, yCoordonate);
    }
    @Override
    public String toString() {
        return "SmallAngel";
    }

    @Override
    public void visit(Hero h, FileWriter fileWriter) throws IOException {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.increaseDamageModifier(0.10f);
                h.setHealth(h.getHealth()+10);
                Log.update(this, h, fileWriter);
            }
            if (h instanceof Pyromancer) {
                h.increaseDamageModifier(0.15f);
                h.setHealth(h.getHealth()+15);
                Log.update(this, h, fileWriter);
            }
            if (h instanceof Rogue) {
                h.increaseDamageModifier(0.05f);
                h.setHealth(h.getHealth()+20);
                Log.update(this, h, fileWriter);
            }
            if (h instanceof Wizard) {
                h.increaseDamageModifier(0.10f);
                h.setHealth(h.getHealth()+25);
                Log.update(this, h, fileWriter);
            }
        }
    }

}
