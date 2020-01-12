package heroes.strategies;

import heroes.Hero;

public class WizardDecision implements heroStrategy{

    private int choice;

    public WizardDecision(int choice)  {
        this.choice = choice;
    }

    @Override
    public void setPlayersStrategy(Hero h) {
        if (this.choice == 0) {
            h.setHealth((int)(0.9f*h.getHealth()));
            h.increaseDamageModifier(0.60f);
        }
        if (this.choice == 1) {
            h.setHealth((int)(1.2f*h.getHealth()));
            h.increaseDamageModifier(-0.2f);
            System.out.println(0f-0.2f);
        }
    }
}
