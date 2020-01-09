package angels;

import heroes.*;

public class Spawner extends Angel implements AngelVisitor {

    public Spawner(int xCoordonate, int yCoordonate) {
        super(xCoordonate, yCoordonate);
    }

    @Override
    public void visit(Hero h) {
    }

}
