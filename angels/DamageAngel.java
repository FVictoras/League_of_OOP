package angels;

import fileio.implementations.FileWriter;
import heroes.*;
import heroes.utils.UtilsHero;
import main.Log;

import java.io.IOException;

public class DamageAngel extends Angel implements AngelVisitor  {

    public DamageAngel(int xCoordonate, int yCoordonate) throws IOException {
        super(xCoordonate, yCoordonate);
    }

    @Override
    public String toString() {
        return "DamageAngel";
    }

    @Override
    public void visit(Hero h, FileWriter fileWriter) throws IOException {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.increaseDamageModifier(0.15f);
                Log.update(this, h, fileWriter);
            }
            if (h instanceof Pyromancer) {
                h.increaseDamageModifier(0.20f);
                Log.update(this, h, fileWriter);
            }
            if (h instanceof Rogue) {
                h.increaseDamageModifier(0.30f);
                Log.update(this, h, fileWriter);
            }
            if (h instanceof Wizard) {
                h.increaseDamageModifier(0.40f);
                Log.update(this, h, fileWriter);
            }
        }
    }

}
