package angels;

import heroes.*;

public class SmallAngel extends Angel implements AngelVisitor {

    public SmallAngel(int xCoordonate, int yCoordonate) {
        super(xCoordonate, yCoordonate);
    }

    @Override
    public void visit(Hero h) {

    }

}
