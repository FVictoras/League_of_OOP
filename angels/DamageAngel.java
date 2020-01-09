package angels;

import heroes.*;

public class DamageAngel extends Angel implements AngelVisitor  {

    public DamageAngel(int xCoordonate, int yCoordonate) {
        super(xCoordonate, yCoordonate);
    }

    @Override
    public String toString() {
        return "Sunt un DamageAngel si ma aflu la " + this.xCoordonate + ", " + this.yCoordonate;
    }

    @Override
    public void visit(Hero h) {
        if (h instanceof Rogue)
            System.out.println("Bau rogule");
        if (h instanceof Wizard)
            System.out.println("Bau wizard");
    }

}
