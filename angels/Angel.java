package angels;

import fileio.implementations.FileWriter;
import heroes.Hero;
import main.Log;

import java.io.IOException;

public class Angel implements AngelVisitor{
    int xCoordonate;
    int yCoordonate;
    String output;
    public int getxCoordonate() {
        return xCoordonate;
    }

    public int getyCoordonate() {
        return yCoordonate;
    }

    public Angel(int xCoordonate, int yCoordonate) throws IOException {
        this.xCoordonate = xCoordonate;
        this.yCoordonate = yCoordonate;
    }

    @Override
    public String toString() {
        return "Sunt un inger";
    }

    @Override
    public void visit(Hero H, FileWriter fileWriter) throws IOException {}
}
