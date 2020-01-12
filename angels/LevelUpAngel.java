package angels;

import heroes.*;
import heroes.utils.UtilsHero;
import main.Log;
import fileio.implementations.FileWriter;
import java.io.IOException;

public class LevelUpAngel extends Angel implements AngelVisitor {

    public LevelUpAngel(int xCoordonate, int yCoordonate) throws IOException {
        super(xCoordonate, yCoordonate);
    }
    @Override
    public String toString() {
        return "LevelUpAngel";
    }

    @Override
    public void visit(Hero h, FileWriter fileWriter) throws IOException {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                h.increaseDamageModifier(0.10f);
                h.setLevel(h.getLevel()+1);
                h.setHealth(UtilsHero.getMaxHp(h));
                Log.update(this, h, fileWriter);
                Log.update(h, fileWriter);
            }
            if (h instanceof Pyromancer) {
                h.increaseDamageModifier(0.20f);
                h.setLevel(h.getLevel()+1);
                h.setHealth(UtilsHero.getMaxHp(h));
                Log.update(this, h, fileWriter);
                Log.update(h, fileWriter);
            }
            if (h instanceof Rogue) {
                h.increaseDamageModifier(0.15f);
                h.setLevel(h.getLevel()+1);
                h.setHealth(UtilsHero.getMaxHp(h));
                Log.update(this, h, fileWriter);
                Log.update(h, fileWriter);
            }
            if (h instanceof Wizard) {
                h.increaseDamageModifier(0.25f);
                h.setLevel(h.getLevel()+1);
                h.setHealth(UtilsHero.getMaxHp(h));
                Log.update(this, h, fileWriter);
                Log.update(h, fileWriter);
            }
        }
    }
}
