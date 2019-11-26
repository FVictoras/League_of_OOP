package heroes;

import common.Constants;

public class Wizard extends Hero {
    public Wizard(int x, int y) {
        super(x, y);
        this.setHealth(Constants.STARTING_HP_WIZARD);
    }

    public String emote() {
        return "Sunt un wizard";
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
