package angels;

import fileio.implementations.FileWriter;
import heroes.Hero;
import java.io.IOException;

/*
    Ingerii sunt implementati astfel incat ei functioneaza conform Visitor Design Pattern.
    Toti implementeaza o metoda de visit.
 */

public interface AngelVisitor {
    /**
     * Interactiune inger, erou.
     * @param h - eroul tinta
     * @param fileWriter - locul de scriere
     * @throws IOException
     */
    void visit(Hero h, FileWriter fileWriter) throws IOException;
}
