package heroes;

import common.Constants;
import heroes.utils.UtilsHero;

/*
    Fiecare clasa care implementeaza un copil al clasei Hero are specific:
    Abilitatile, bonusurile aferente abilitatii, bonusul aferent tile-ului
    Interactiunile sunt overrideuite in concordanta cu logica jocului.
 */

public class Knight extends Hero {
    private boolean landBonus = false;
    private float executeBonus = 1f;
    private float slamBonus = 1f;

    public Knight(final int x, final int y) {
        super(x, y);
        this.setHealth(Constants.STARTING_HP_KNIGHT);
    }

    public final String emote() {
        return "K";
    }

    private int execute(final Hero h) {
        float bonusTile = 1f;
        if (landBonus) {
            bonusTile = Constants.LAND_BONUS;
        }
        float reqHp =
                (Constants.EXECUTE_BASE_DESTROY + (Constants.EXECUTE_INCREASED_DESTROY
                        * h.getLevel())) * UtilsHero.getMaxHp(h);
        if (h.getHealth() > reqHp) {
            return Math.round(bonusTile * (executeBonus * (Constants.EXECUTE_BASE_DMG
                    + Constants.EXECUTE_INCREASED_DMG * this.getLevel())));
        } else {
            return h.getHealth();
        }
    }

    private int slam(final Hero h) {
        h.setStunned(1);
        float bonusTile = 1f;
        if (landBonus) {
            bonusTile = Constants.LAND_BONUS;
        }
        return Math.round(bonusTile * (slamBonus * (Constants.SLAM_BASE_DMG
                + Constants.SLAM_INCREASED_DMG * this.getLevel())));
    }

    public final void setLandBonus(final boolean landBonus) {
        this.landBonus = landBonus;
    }
    public final void accept(final Hero h) {
        h.interactWith(this);
    }
    @Override
    public final void noLandBonus() {
        this.setLandBonus(false);
    }

    @Override
    final void interactWith(final Pyromancer p) {
        this.setAvailable(false);
        this.executeBonus = Constants.EXECUTE_P_B;
        this.slamBonus = Constants.SLAM_P_B;
        p.receiveDamage(this.execute(p) + this.slam(p));
        if (p.isAvailable()) {
            p.interactWith(this);
        }

    }

    @Override
    final void interactWith(final Knight k) {
        this.setAvailable(false);
        this.executeBonus = Constants.EXECUTE_K_B;
        this.slamBonus = Constants.SLAM_K_B;
        k.receiveDamage(this.execute(k) + this.slam(k));
        if (k.isAvailable()) {
            k.interactWith(this);
        }
    }

    @Override
    final void interactWith(final Wizard w) {
        this.setAvailable(false);
        this.executeBonus = Constants.EXECUTE_W_B;
        this.slamBonus = Constants.SLAM_W_B;
        w.receiveDamage(this.execute(w), this.slam(w));
        if (w.isAvailable()) {
            w.interactWith(this);
        }

    }

    @Override
    final void interactWith(final Rogue r) {
        this.setAvailable(false);
        this.executeBonus = Constants.EXECUTE_R_B;
        this.slamBonus = Constants.SLAM_R_B;
        r.receiveDamage(this.execute(r) + this.slam(r));
        if (r.isAvailable()) {
            r.interactWith(this);
        }
    }


}
