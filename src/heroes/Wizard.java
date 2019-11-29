package heroes;

import common.Constants;
import heroes.utils.UtilsHero;

public class Wizard extends Hero {
    boolean desertBonus = false;
    private float drainRaceBonus = 1f;
    private float deflectRaceBonus = 1f;

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
        float bonusTile = 1f;
        if (desertBonus) {
            bonusTile = Constants.DESERT_BONUS;
        }
        float percent =
                Constants.DRAIN_BASE_PERCENT + (Constants.DRAIN_INCREASED_PERCENT * this.getLevel());
        float baseHp = Math.min(Constants.DRAIN_BASE_CONSTANT * UtilsHero.getMaxHp(H),
                H.getHealth());
        return Math.round(bonusTile * ((drainRaceBonus * percent) * baseHp));
    }

    public int Deflect(int dmgReceived) {
        float bonusTile = 1f;
        if (desertBonus) {
            bonusTile = Constants.DESERT_BONUS;
        }
        return Math.round(bonusTile * (deflectRaceBonus * (Math.min(Constants.DEFLECT_BASE_PERCENT +
                        (Constants.DEFLECT_INCREASED_PERCENT * this.getLevel()),
                Constants.DEFLECT_MAX_PERCENT) * dmgReceived)));
    }

    public void accept(Hero H) {
        H.interactWith(this);
    }

    @Override
    public void noLandBonus() {
        this.setDesertBonus(false);
    }

    @Override
    void interactWith(Pyromancer P) {
        this.drainRaceBonus = Constants.DRAIN_P_B;
        this.deflectRaceBonus = Constants.DEFLECT_P_B;
    }

    @Override
    void interactWith(Knight K) {
        this.drainRaceBonus = Constants.DRAIN_K_B;
        this.deflectRaceBonus = Constants.DEFLECT_K_B;
    }

    @Override
    void interactWith(Wizard W) {
        this.drainRaceBonus = Constants.DRAIN_W_B;
    }

    @Override
    void interactWith(Rogue R) {
        this.drainRaceBonus = Constants.DRAIN_R_B;
        this.deflectRaceBonus = Constants.DEFLECT_R_B;
    }
}
