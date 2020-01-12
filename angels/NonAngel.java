package angels;

import java.io.IOException;

public class NonAngel extends Angel implements AngelVisitor{

    public NonAngel(int xCoordonate, int yCoordonate) throws IOException {
        super(xCoordonate, yCoordonate);
    }

    @Override
    public String toString() {
        return "Sunt un inger fake";
    }
}
