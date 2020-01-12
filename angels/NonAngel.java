package angels;

import java.io.IOException;

public class NonAngel extends Angel implements AngelVisitor{

    public NonAngel(int xCoordonate, int yCoordonate, String output) throws IOException {
        super(xCoordonate, yCoordonate, output);
    }

    @Override
    public String toString() {
        return "Sunt un inger fake";
    }
}
