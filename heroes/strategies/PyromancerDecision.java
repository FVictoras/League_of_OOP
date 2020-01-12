package heroes.strategies;

import heroes.Hero;

public class PyromancerDecision implements heroStrategy {

    private int choice;

    public PyromancerDecision(int choice)  {
        this.choice = choice;
    }

    @Override
    public void setPlayersStrategy(Hero h) {
        if (this.choice == 0) {
            h.setHealth((int)(0.75f*h.getHealth()));
            h.increaseDamageModifier(0.70f);
        }
        if (this.choice == 1) {
            h.setHealth((int)(1.33f*h.getHealth()));
            h.increaseDamageModifier(-0.3f);
        }
    }
}
