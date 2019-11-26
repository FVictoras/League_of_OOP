package heroes;

import common.Constants;

import java.util.ArrayList;

public class Pyromancer extends Hero {
    public Pyromancer(int x, int y) {
        super(x, y);
        this.setHealth(Constants.STARTING_HP_PYRO);
    }

    public String emote() {
        return "Sunt un pyro";
    }

    public int Fireblast() {
        return Constants.FIREBLAST_BASE_DMG + this.getLevel() * Constants.FIREBLAST_INCREASED_DMG;
    }

    public ArrayList<Integer> Ignite() {
        ArrayList<Integer> igniteDamage = new ArrayList<Integer>(2);
        igniteDamage.add(Constants.IGNITE_BASE_DMG + this.getLevel() * Constants.IGNITE_INCREASED_DMG);
        igniteDamage.add(Constants.IGNITE_BASE_OVERTIME + this.getLevel() * Constants.IGNITE_INCREASED_OVERTIME);
        return igniteDamage;
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
