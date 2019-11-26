package heroes;

import common.Constants;

public class Rogue extends Hero {
    public Rogue(int x, int y) {
        super(x, y);
        this.setHealth(Constants.STARTING_HP_ROGUE);
    }

    public String emote() {
        return "Sunt un rogue";
    }

    public void accept(Hero H) {
        H.interactWith(this);
    }

    @Override
    void interactWith(Pyromancer P) {

    }

    @Override
    void interactWith(Knight P) {

    }

    @Override
    void interactWith(Wizard B) {

    }

    @Override
    void interactWith(Rogue R) {

    }
}
