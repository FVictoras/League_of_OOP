package angels;

import heroes.*;

public class LevelUpAngel extends Angel implements AngelVisitor {

    public LevelUpAngel(int xCoordonate, int yCoordonate) {
        super(xCoordonate, yCoordonate);
    }

    @Override
    public void visit(Hero h) {

    }
}
