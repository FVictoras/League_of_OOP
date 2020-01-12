package angels;

import heroes.*;
import main.Log;

import java.io.IOException;

public class TheDoomer extends Angel implements AngelVisitor {

    public TheDoomer(int xCoordonate, int yCoordonate, String output) throws IOException {
        super(xCoordonate, yCoordonate, output);
    }
    @Override
    public String toString() {
        return "TheDoomer";
    }

    @Override
    public void visit(Hero h) throws IOException {
        h.setHealth(-1);
        Log.update(this, h, output);
    }

}
