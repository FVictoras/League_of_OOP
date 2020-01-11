package heroes.strategies;

import heroes.Hero;

public class PyromancerDecision implements heroStrategy {

    private int choice;

    public PyromancerDecision(int choice)  {
        this.choice = choice;
    }

    @Override
    public void setPlayersStrategy(Hero h1) {

    }
}
