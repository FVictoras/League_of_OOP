package angels;

import heroes.*;

public class TheDoomer extends Angel implements AngelVisitor {

    public TheDoomer(int xCoordonate, int yCoordonate) {
        super(xCoordonate, yCoordonate);
    }

    @Override
    public void visit(Hero h) {

    }

}
