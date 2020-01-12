package angels;

import heroes.*;
import heroes.utils.UtilsHero;
import main.Log;
import fileio.implementations.FileWriter;
import java.io.IOException;

public class LifeGiver extends Angel implements AngelVisitor {

    public LifeGiver(int xCoordonate, int yCoordonate) throws IOException {
        super(xCoordonate, yCoordonate);
    }
    @Override
    public String toString() {
        return "LifeGiver";
    }

    @Override
    public void visit(Hero h, FileWriter fileWriter) throws IOException {
        if (UtilsHero.isAlive(h)) {
            if (h instanceof Knight) {
                if (UtilsHero.getMaxHp(h)>=h.getHealth()+100) {
                    h.setHealth(h.getHealth() + 100);
                    Log.update(this, h, fileWriter);
                }
                else {
                    h.setHealth(UtilsHero.getMaxHp(h));
                    Log.update(this, h, fileWriter);
                }
            }
            if (h instanceof Pyromancer) {
                if (UtilsHero.getMaxHp(h)>=h.getHealth()+80) {
                    h.setHealth(h.getHealth() + 80);
                    Log.update(this, h, fileWriter);
                }
                else {
                    h.setHealth(UtilsHero.getMaxHp(h));
                    Log.update(this, h, fileWriter);
                }
            }
            if (h instanceof Rogue) {
                if (UtilsHero.getMaxHp(h)>=h.getHealth()+90) {
                    h.setHealth(h.getHealth() + 90);
                    Log.update(this, h, fileWriter);
                }
                else {
                    h.setHealth(UtilsHero.getMaxHp(h));
                    Log.update(this, h, fileWriter);
                }
            }
            if (h instanceof Wizard) {
                if (UtilsHero.getMaxHp(h)>=h.getHealth()+120) {
                    h.setHealth(h.getHealth() + 120);
                    Log.update(this, h, fileWriter);
                }
                else {
                    h.setHealth(UtilsHero.getMaxHp(h));
                    Log.update(this, h, fileWriter);
                }
            }
        }
    }
}
