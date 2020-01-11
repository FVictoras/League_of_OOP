package heroes.strategies;

import heroes.Hero;


public class KnightDecision implements heroStrategy {

    private int choice;

    public KnightDecision(int choice)  {
        this.choice = choice;
    }
    @Override
    public void setPlayersStrategy(Hero h) {
        if (this.choice == 0) {
            h.setHealth((int)(0.8f*h.getHealth()));
            h.increaseDamageModifier(0.50f);
        }
        if (this.choice == 1) {
            h.setHealth((int)(1.25f*h.getHealth()));
            h.increaseDamageModifier(-0.2f);
        }
    }
}
