package main.mechanicslogic;

import heroes.Hero;
import main.Log;

import java.io.IOException;

public interface RoundStrategy {
     void doOperation(Hero h);

     void doOperation(Hero h1, Hero h2);

     void doOperation(Hero h1, Hero h2, String output) throws IOException;

}
