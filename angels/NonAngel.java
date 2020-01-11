package angels;

public class NonAngel extends Angel implements AngelVisitor{

    public NonAngel(int xCoordonate, int yCoordonate) {
        super(xCoordonate, yCoordonate);
    }

    @Override
    public String toString() {
        return "Sunt un inger fake";
    }
}
