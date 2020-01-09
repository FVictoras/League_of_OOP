package angels;

import heroes.*;

public class GoodBoy extends Angel implements AngelVisitor {

    public GoodBoy(int xCoordonate, int yCoordonate) {
        super(xCoordonate, yCoordonate);
    }

    @Override
    public void visit(Hero h) {

    }

}
