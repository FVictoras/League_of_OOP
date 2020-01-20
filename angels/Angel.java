package angels;

import fileio.implementations.FileWriter;
import heroes.Hero;

import java.io.IOException;

/*
    Clasa Angel este mostenita de fiecare inger in parte.
    Ea contine lucrurile general valabile pentru toti ingerii.
 */

public class Angel implements AngelVisitor {
    private int xCoordonate;
    private int yCoordonate;

    public final int getxCoordonate() {
        return xCoordonate;
    }

    public final int getyCoordonate() {
        return yCoordonate;
    }

    public Angel(final int xCoordonate, final int yCoordonate) throws IOException {
        this.xCoordonate = xCoordonate;
        this.yCoordonate = yCoordonate;
    }

    @Override
    /**
     * Returneza string ca tipul ingerului.
     */
    public String toString() {
        return "Sunt un inger";
    }

    @Override
    public void visit(final Hero h, final FileWriter fileWriter) throws IOException {
    }
}
