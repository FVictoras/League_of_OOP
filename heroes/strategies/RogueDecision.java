package heroes.strategies;

import heroes.Hero;

public class RogueDecision implements heroStrategy {

    private int choice;

    public RogueDecision(int choice)  {
        this.choice = choice;
    }
    @Override
    public void setPlayersStrategy(Hero h1) {

    }
}
