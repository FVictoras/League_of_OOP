package angels;

import heroes.*;
import heroes.utils.UtilsHero;
import main.Log;
import fileio.implementations.FileWriter;

import java.io.IOException;

public class TheDoomer extends Angel implements AngelVisitor {

    public TheDoomer(int xCoordonate, int yCoordonate) throws IOException {
        super(xCoordonate, yCoordonate);
    }
    @Override
    public String toString() {
        return "TheDoomer";
    }

    @Override
    public void visit(Hero h, FileWriter fileWriter) throws IOException {
        if(UtilsHero.isAlive(h)) {
            h.setHealth(-1);
            Log.update(this, h, fileWriter);
            Log.updateA(h, fileWriter);
        }
    }

}
