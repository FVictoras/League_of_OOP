package heroes;

import common.Constants;

public class Pyromancer extends Hero {
    public Pyromancer(int x, int y) {
        super(x, y);
        this.setHealth(Constants.STARTING_HP_PYRO);
    }

    public String emote() {
        return "Sunt un pyro";
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
