package angels;

import heroes.*;

public class LifeGiver extends Angel implements AngelVisitor {

    public LifeGiver(int xCoordonate, int yCoordonate) {
        super(xCoordonate, yCoordonate);
    }

    @Override
    public void visit(Hero h) {

    }
}
