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

    public void setDesertBonus(boolean desertBonus) {
        this.desertBonus = desertBonus;
    }

    public void accept(Hero H) {
        H.interactWith(this);
    }

//    public void calculateDmgReceived()

    @Override
    public void noLandBonus() {
        this.setDesertBonus(false);
    }

    @Override
    void interactWith(Pyromancer P) {
        if (P.isAvailable()) P.interactWith(this);
        this.drainRaceBonus = Constants.DRAIN_P_B;
        this.deflectRaceBonus = Constants.DEFLECT_P_B;
        int dmgReceived = Math.round(this.getLastDamageReceived().get(0) * (1/Constants.FIREBLAST_W_B)
                + this.getLastDamageReceived().get(1) * (1/Constants.IGNITE_W_B));
        P.receiveDamage(this.Drain(P) + this.Deflect(dmgReceived));
        this.setAvailable(false);
    }

    @Override
    void interactWith(Knight K) {
        if (K.isAvailable()) K.interactWith(this);
        this.drainRaceBonus = Constants.DRAIN_K_B;
        this.deflectRaceBonus = Constants.DEFLECT_K_B;
        int dmgReceived = Math.round(this.getLastDamageReceived().get(0) * (1/Constants.EXECUTE_W_B)
                + this.getLastDamageReceived().get(1) * (1/Constants.SLAM_W_B));
        K.receiveDamage(this.Drain(K) + this.Deflect(dmgReceived));
        this.setAvailable(false);
    }

    @Override
    void interactWith(Wizard W) {
        this.setAvailable(false);
        this.drainRaceBonus = Constants.DRAIN_W_B;
        W.receiveDamage(this.Drain(W));
        if (W.isAvailable()) W.interactWith(this);
    }

    @Override
    void interactWith(Rogue R) {
        if (R.isAvailable()) R.interactWith(this);
        this.drainRaceBonus = Constants.DRAIN_R_B;
        this.deflectRaceBonus = Constants.DEFLECT_R_B;
        int dmgReceived =
                Math.round(this.getLastDamageReceived().get(0) * (1/Constants.BACKSTAB_W_B)
                + this.getLastDamageReceived().get(1) * (1/Constants.PARALYSIS_W_B));
        R.receiveDamage(this.Drain(R) + this.Deflect(dmgReceived));
        this.setAvailable(false);
    }
}
