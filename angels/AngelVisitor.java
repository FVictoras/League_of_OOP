package angels;

import fileio.implementations.FileWriter;
import heroes.*;

import java.io.IOException;

public interface AngelVisitor {
    void visit(Hero h, FileWriter fileWriter) throws IOException;
}
