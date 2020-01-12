package heroes.strategies;

import heroes.Hero;

public class RogueDecision implements heroStrategy {

    private int choice;

    public RogueDecision(int choice)  {
        this.choice = choice;
    }
    @Override
    public void setPlayersStrategy(Hero h) {
        if (this.choice == 0) {
            h.setHealth((int)(0.8571f*h.getHealth()));
            h.increaseDamageModifier(0.40f);
        }
        if (this.choice == 1) {
            h.setHealth((int)(1.5f*h.getHealth()));
            h.increaseDamageModifier(-0.1f);
        }
    }
}
