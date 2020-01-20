package main.mechanicslogic;

import fileio.implementations.FileWriter;
import heroes.Hero;


import java.io.IOException;

public interface RoundStrategy {
     void doOperation(Hero h);

     void doOperation(Hero h1, Hero h2);

     void doOperation(Hero h1, Hero h2, FileWriter fileWriter) throws IOException;

}
