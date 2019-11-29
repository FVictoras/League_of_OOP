package main.mechanicslogic;

import heroes.Hero;

public interface RoundStrategy {
    public void doOperation(Hero H);

    public void doOperation(Hero H1, Hero H2);
}
