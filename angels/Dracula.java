package angels;

import heroes.*;

public class Dracula extends Angel implements AngelVisitor {

    public Dracula(int xCoordonate, int yCoordonate) {
        super(xCoordonate, yCoordonate);
    }

    @Override
    public void visit(Hero h) {

    }

}
