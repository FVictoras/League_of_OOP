package angels;

import heroes.*;

import java.io.IOException;

public interface AngelVisitor {
    void visit(Hero h) throws IOException;
}
