package heroes;

import common.Constants;

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
        return "Sunt un rogue";
    }

    public void setWoodsBonus(boolean woodsBonus) {
        this.woodsBonus = woodsBonus;
    }

    public int Backstab() {
        float tileBonus = 1f;
        if (woodsBonus) {
            tileBonus = Constants.WOODS_BONUS;
        }
        if (this.totalBackstabs == Constants.BACKSTAB_CRITICAL_HITSNEEDED && woodsBonus) {
            this.totalBackstabs = 0;
            return Math.round(tileBonus *  (Constants.BACKSTAB_CRITICAL_BONUS * (backstabBonus *
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
        paralysis.add(Math.round(tileBonus * (paralysisBonus *(Constants.PARALYSIS_BASE_DMG +
                (Constants.PARALYSIS_INCREASED_DMG * this.getLevel())))));
        paralysis.add(overtimeRounds);
        return paralysis;
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
