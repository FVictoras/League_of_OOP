package heroes;

import common.Constants;
import heroes.utils.UtilsHero;

/*
    Fiecare clasa care implementeaza un copil al clasei Hero are specific:
    Abilitatile, bonusurile aferente abilitatii, bonusul aferent tile-ului
    Interactiunile sunt overrideuite in concordanta cu logica jocului.
 */

public class Wizard extends Hero {
    private boolean desertBonus = false;
    private float drainRaceBonus = 1f;
    private float deflectRaceBonus = 1f;

    public Wizard(final int x, final int y) {
        super(x, y);
        this.setHealth(Constants.STARTING_HP_WIZARD);
    }

    public final String emote() {
        return "W";
    }

    private int drain(final Hero h) {
        float bonusTile = 1f;
        if (desertBonus) {
            bonusTile = Constants.DESERT_BONUS;
        }
        float percent =
                Constants.DRAIN_BASE_PERCENT + (Constants.DRAIN_INCREASED_PERCENT
                        * this.getLevel());
        float baseHp = Math.min(Constants.DRAIN_BASE_CONSTANT * UtilsHero.getMaxHp(h),
                h.getHealth());
        return Math.round(bonusTile * ((drainRaceBonus * percent) * baseHp));
    }

    private int deflect(final int dmgReceived) {
        float bonusTile = 1f;
        if (desertBonus) {
            bonusTile = Constants.DESERT_BONUS;
        }
        return Math.round(bonusTile * (deflectRaceBonus * (Math.min(Constants.DEFLECT_BASE_PERCENT
                + (Constants.DEFLECT_INCREASED_PERCENT * this.getLevel()),
                Constants.DEFLECT_MAX_PERCENT) * dmgReceived)));
    }

    public final void setDesertBonus(final boolean desertBonus) {
        this.desertBonus = desertBonus;
    }

    public final void accept(final Hero h) {
        h.interactWith(this);
    }

    @Override
    public final void noLandBonus() {
        this.setDesertBonus(false);
    }

    @Override
    final void interactWith(final Pyromancer p) {
        this.setAvailable(false);
        if (p.isAvailable()) {
            p.interactWith(this);
        }
        this.drainRaceBonus = Constants.DRAIN_P_B;
        this.deflectRaceBonus = Constants.DEFLECT_P_B;
        int dmgReceived =
                Math.round(this.getLastDamageReceived().get(0) * (1 / Constants.FIREBLAST_W_B))
                        + Math.round(this.getLastDamageReceived().get(1)
                        * (1 / Constants.IGNITE_W_B));
        p.receiveDamage(this.drain(p) + this.deflect(dmgReceived));
    }

    @Override
    final void interactWith(final Knight k) {
        this.setAvailable(false);
        if (k.isAvailable()) {
            k.interactWith(this);
        }
        this.drainRaceBonus = Constants.DRAIN_K_B;
        this.deflectRaceBonus = Constants.DEFLECT_K_B;
        int dmgReceived =
                Math.round(this.getLastDamageReceived().get(0) * (1 / Constants.EXECUTE_W_B)
                        + this.getLastDamageReceived().get(1) * (1 / Constants.SLAM_W_B));
        k.receiveDamage(this.drain(k) + this.deflect(dmgReceived));
    }

    @Override
    final void interactWith(final Wizard w) {
        this.setAvailable(false);
        this.drainRaceBonus = Constants.DRAIN_W_B;
        w.receiveDamage(this.drain(w));
        if (w.isAvailable()) {
            w.interactWith(this);
        }
    }

    @Override
    final void interactWith(final Rogue r) {
        this.setAvailable(false);
        if (r.isAvailable()) {
            r.interactWith(this);
        }
        this.drainRaceBonus = Constants.DRAIN_R_B;
        this.deflectRaceBonus = Constants.DEFLECT_R_B;
        int dmgReceived =
                Math.round(this.getLastDamageReceived().get(0) * (1 / Constants.BACKSTAB_W_B)
                        + this.getLastDamageReceived().get(1) * (1 / Constants.PARALYSIS_W_B));
        r.receiveDamage(this.drain(r) + this.deflect(dmgReceived));
    }
}
