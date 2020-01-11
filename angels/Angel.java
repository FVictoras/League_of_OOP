package angels;

import heroes.Hero;

public class Angel implements AngelVisitor{
    int xCoordonate;
    int yCoordonate;

    public int getxCoordonate() {
        return xCoordonate;
    }

    public int getyCoordonate() {
        return yCoordonate;
    }

    public Angel(int xCoordonate, int yCoordonate) {
        this.xCoordonate = xCoordonate;
        this.yCoordonate = yCoordonate;
    }

    @Override
    public String toString() {
        return "Sunt un inger";
    }

    @Override
    public void visit(Hero H) {}
}
