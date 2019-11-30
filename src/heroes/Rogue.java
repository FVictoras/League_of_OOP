package heroes;

import common.Constants;
import main.mechanicslogic.ContextRound;

import java.util.ArrayList;

public class Rogue extends Hero {
    private boolean woodsBonus = false;
    private float backstabBonus = 0;
    private float paralysisBonus = 0;

    private int totalBackstabs = 0;

    public Rogue(int x, int y) {
        super(x, y);
        this.setHealth(Constants.STARTING_HP_ROGUE);
    }

    public String emote() {
        return "R";
    }

    public int Backstab() {
        float tileBonus = 1f;
        if (woodsBonus) {
            tileBonus = Constants.WOODS_BONUS;
        } else {
            this.totalBackstabs = 0;
        }
        if ((this.totalBackstabs == Constants.BACKSTAB_CRITICAL_HITSNEEDED || this.totalBackstabs
                == 0)  && woodsBonus) {
            if (this.totalBackstabs == Constants.BACKSTAB_CRITICAL_HITSNEEDED)
                this.totalBackstabs = 1;
            else this.totalBackstabs++;
            return Math.round(tileBonus * (Constants.BACKSTAB_CRITICAL_BONUS * (backstabBonus *
                    (Constants.BACKSTAB_BASE_DMG + (Constants.BACKSTAB_INCREASED_DMG *
                            this.getLevel())))));
        } else {
            this.totalBackstabs++;
            return Math.round(tileBonus * (backstabBonus * (Constants.BACKSTAB_BASE_DMG +
                    (Constants.BACKSTAB_INCREASED_DMG * this.getLevel()))));
        }
    }

    public ArrayList<Integer> Paralysis(Hero H) {
        float tileBonus = 1f;
        int overtimeRounds = Constants.PARALYSIS_OVERTIME_ROUNDS;
        if (woodsBonus) {
            tileBonus = Constants.WOODS_BONUS;
            overtimeRounds = Constants.PARALYSIS_OVERTIME_BONUS_ROUNDS;
        }
        ArrayList<Integer> paralysis = new ArrayList<Integer>(3);
        paralysis.add(Math.round(tileBonus * (paralysisBonus * (Constants.PARALYSIS_BASE_DMG +
                (Constants.PARALYSIS_INCREASED_DMG * this.getLevel())))));
        paralysis.add(overtimeRounds);
        H.setDamageOvertime(paralysis.get(0), paralysis.get(1));
        H.setStunned(paralysis.get(1));
        return paralysis;
    }

    public void setWoodsBonus(boolean woodsBonus) {
        this.woodsBonus = woodsBonus;
    }

    public void accept(Hero H) {
        H.interactWith(this);
    }

    @Override
    public void noLandBonus() {
        this.setWoodsBonus(false);
    }

    @Override
    void interactWith(Pyromancer P) {
        this.setAvailable(false);
        this.backstabBonus = Constants.BACKSTAB_P_B;
        this.paralysisBonus = Constants.PARALYSIS_P_B;
        P.receiveDamage(this.Backstab() + this.Paralysis(P).get(0));
        if (P.isAvailable()) { P.interactWith(this); }
    }

    @Override
    void interactWith(Knight K) {
        this.setAvailable(false);
        this.backstabBonus = Constants.BACKSTAB_K_B;
        this.paralysisBonus = Constants.PARALYSIS_K_B;
        K.receiveDamage(this.Backstab() + this.Paralysis(K).get(0));
        if (K.isAvailable()) { K.interactWith(this); }
    }

    @Override
    void interactWith(Wizard W) {
        this.setAvailable(false);
        this.backstabBonus = Constants.BACKSTAB_W_B;
        this.paralysisBonus = Constants.PARALYSIS_W_B;
        W.receiveDamage(this.Backstab(), this.Paralysis(W).get(0));
        if (W.isAvailable()) { W.interactWith(this); }
    }

    @Override
    void interactWith(Rogue R) {
        this.setAvailable(false);
        this.backstabBonus = Constants.BACKSTAB_R_B;
        this.paralysisBonus = Constants.PARALYSIS_R_B;
        R.receiveDamage(this.Backstab() + this.Paralysis(R).get(0));
        if (R.isAvailable()) { R.interactWith(this); }
    }
}
