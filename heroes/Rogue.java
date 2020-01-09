package heroes;

import common.Constants;

import java.util.ArrayList;
/*
    Fiecare clasa care implementeaza un copil al clasei Hero are specific:
    Abilitatile, bonusurile aferente abilitatii, bonusul aferent tile-ului
    Interactiunile sunt overrideuite in concordanta cu logica jocului.
 */
public class Rogue extends Hero {
    private boolean woodsBonus = false;
    private float backstabBonus = 0;
    private float paralysisBonus = 0;

    private int totalBackstabs = 0;

    public Rogue(final int x, final int y) {
        super(x, y);
        this.setHealth(Constants.STARTING_HP_ROGUE);
    }

    public final String emote() {
        return "R";
    }

    private int backstab() {
        float tileBonus = 1f;
        if (woodsBonus) {
            tileBonus = Constants.WOODS_BONUS;
        } else {
            this.totalBackstabs = 0;
        }
        if ((this.totalBackstabs == Constants.BACKSTAB_CRITICAL_HITSNEEDED || this.totalBackstabs
                == 0)  && woodsBonus) {
            if (this.totalBackstabs == Constants.BACKSTAB_CRITICAL_HITSNEEDED) {
                this.totalBackstabs = 1;
            } else {
                this.totalBackstabs++;
            }
            return Math.round(tileBonus * (Constants.BACKSTAB_CRITICAL_BONUS * (backstabBonus
                    * (Constants.BACKSTAB_BASE_DMG + (Constants.BACKSTAB_INCREASED_DMG
                    * this.getLevel())))));
        } else {
            this.totalBackstabs++;
            return Math.round(tileBonus * (backstabBonus * (Constants.BACKSTAB_BASE_DMG
                    + (Constants.BACKSTAB_INCREASED_DMG * this.getLevel()))));
        }
    }

    private ArrayList<Integer> paralysis(final Hero h) {
        float tileBonus = 1f;
        int overtimeRounds = Constants.PARALYSIS_OVERTIME_ROUNDS;
        if (woodsBonus) {
            tileBonus = Constants.WOODS_BONUS;
            overtimeRounds = Constants.PARALYSIS_OVERTIME_BONUS_ROUNDS;
        }
        ArrayList<Integer> paralysis = new ArrayList<Integer>();
        paralysis.add(Math.round(tileBonus * (paralysisBonus * (Constants.PARALYSIS_BASE_DMG
                + (Constants.PARALYSIS_INCREASED_DMG * this.getLevel())))));
        paralysis.add(overtimeRounds);
        h.setDamageOvertime(paralysis.get(0), paralysis.get(1));
        h.setStunned(paralysis.get(1));
        return paralysis;
    }

    public final void setWoodsBonus(final boolean woodsBonus) {
        this.woodsBonus = woodsBonus;
    }

    public final void accept(final Hero h) {
        h.interactWith(this);
    }

    @Override
    public final void noLandBonus() {
        this.setWoodsBonus(false);
    }

    @Override
    final void interactWith(final Pyromancer p) {
        this.setAvailable(false);
        this.backstabBonus = Constants.BACKSTAB_P_B;
        this.paralysisBonus = Constants.PARALYSIS_P_B;
        p.receiveDamage(this.backstab() + this.paralysis(p).get(0));
        if (p.isAvailable()) {
            p.interactWith(this);
        }
    }

    @Override
    final void interactWith(final Knight k) {
        this.setAvailable(false);
        this.backstabBonus = Constants.BACKSTAB_K_B;
        this.paralysisBonus = Constants.PARALYSIS_K_B;
        k.receiveDamage(this.backstab() + this.paralysis(k).get(0));
        if (k.isAvailable()) {
            k.interactWith(this);
        }
    }

    @Override
    final void interactWith(final Wizard w) {
        this.setAvailable(false);
        this.backstabBonus = Constants.BACKSTAB_W_B;
        this.paralysisBonus = Constants.PARALYSIS_W_B;
        w.receiveDamage(this.backstab(), this.paralysis(w).get(0));
        if (w.isAvailable()) {
            w.interactWith(this);
        }
    }

    @Override
    final void interactWith(final Rogue r) {
        this.setAvailable(false);
        this.backstabBonus = Constants.BACKSTAB_R_B;
        this.paralysisBonus = Constants.PARALYSIS_R_B;
        r.receiveDamage(this.backstab() + this.paralysis(r).get(0));
        if (r.isAvailable()) {
            r.interactWith(this);
        }
    }
}
