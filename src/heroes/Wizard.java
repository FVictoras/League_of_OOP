package heroes;

import common.Constants;
import heroes.utils.UtilsHero;

public class Wizard extends Hero {
    boolean desertBonus = false;

    public Wizard(int x, int y) {
        super(x, y);
        this.setHealth(Constants.STARTING_HP_WIZARD);
    }

    public String emote() {
        return "Sunt un wizard";
    }

    public void setDesertBonus(boolean desertBonus) {
        this.desertBonus = desertBonus;
    }

    public int Drain(Hero H) {
        float percent = Constants.DRAIN_BASE_PERCENT + (Constants.DRAIN_INCREASED_PERCENT * this.getLevel());
        float baseHp = Math.min(Constants.DRAIN_BASE_CONSTANT * UtilsHero.getMaxHp(H), H.getHealth());
        return Math.round(percent * baseHp);
    }

    public int Deflect(int dmgReceived) {
        return Math.round(Math.min(Constants.DEFLECT_BASE_PERCENT + (Constants.DEFLECT_INCREASED_PERCENT * this.getLevel()), Constants.DEFLECT_MAX_PERCENT) * dmgReceived);
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
