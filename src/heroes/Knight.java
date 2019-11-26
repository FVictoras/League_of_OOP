package heroes;

import common.Constants;

public class Knight extends Hero {
    public Knight(int x, int y) {
        super(x, y);
        this.setHealth(Constants.STARTING_HP_KNIGHT);
    }

    public String emote() { return "Sunt un knight"; }

    public void accept(Hero H) {
        H.interactWith(this);
    }

    @Override
    void interactWith(Pyromancer P) {
        System.out.println("Sunt knight, ma ataca un Pyro");
    }

    @Override
    void interactWith(Knight P) {
        System.out.println("Sunt knight, ma ataca un Knight");
    }

    @Override
    void interactWith(Wizard B) {
        System.out.println("Sunt knight, ma ataca un Wizard");
    }

    @Override
    void interactWith(Rogue R) {
        System.out.println("Sunt knight, ma ataca un Rouge");
    }
}
