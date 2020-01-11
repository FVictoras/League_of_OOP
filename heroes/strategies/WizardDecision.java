package heroes.strategies;

import heroes.Hero;

public class WizardDecision implements heroStrategy{

    private int choice;

    public WizardDecision(int choice)  {
        this.choice = choice;
    }

    @Override
    public void setPlayersStrategy(Hero h1) {

    }
}
