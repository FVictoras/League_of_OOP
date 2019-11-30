package main.mechanicslogic;

import heroes.Hero;

public interface RoundStrategy {
     void doOperation(Hero h);

     void doOperation(Hero h1, Hero h2);
}
