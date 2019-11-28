package heroes;

import common.Constants;

import java.util.ArrayList;

public class Rogue extends Hero {
    private boolean woodsBonus = false;

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
        // TODO: Adauga conditia de teren!!
        if (this.totalBackstabs == Constants.BACKSTAB_CRITICAL_HITSNEEDED) {
            this.totalBackstabs = 0;
            return Math.round(Constants.BACKSTAB_CRITICAL_BONUS * (Constants.BACKSTAB_BASE_DMG + (Constants.BACKSTAB_INCREASED_DMG * this.getLevel())));
        } else {
            return Constants.BACKSTAB_BASE_DMG + (Constants.BACKSTAB_INCREASED_DMG * this.getLevel());
        }
    }

    public ArrayList<Integer> Paralysis(Hero H) {
        // TODO: Adauga conditia de teren!!!
        int overtimeRounds = Constants.PARALYSIS_OVERTIME_ROUNDS;
        ArrayList<Integer> paralysis = new ArrayList<Integer>(3);
        paralysis.add(Constants.PARALYSIS_BASE_DMG + (Constants.PARALYSIS_INCREASED_DMG * this.getLevel()));
        paralysis.add(overtimeRounds);
        return paralysis;

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
