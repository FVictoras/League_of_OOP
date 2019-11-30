package heroes;

import common.Constants;
import heroes.utils.UtilsHero;

public class Knight extends Hero {
    private boolean landBonus = false;
    private float executeBonus = 1f;
    private float slamBonus = 1f;

    public Knight(int x, int y) {
        super(x, y);
        this.setHealth(Constants.STARTING_HP_KNIGHT);
    }

    public String emote() {
        return "K";
    }

    public int Execute(Hero H) {
        float bonusTile = 1f;
        if (landBonus) {
            bonusTile = Constants.LAND_BONUS;
        }
        float reqHp =
                (Constants.EXECUTE_BASE_DESTROY + (Constants.EXECUTE_INCREASED_DESTROY *
                        H.getLevel())) * UtilsHero.getMaxHp(H);
        if (H.getHealth() > reqHp) {
            return Math.round(bonusTile * (executeBonus * (Constants.EXECUTE_BASE_DMG +
                    Constants.EXECUTE_INCREASED_DMG * this.getLevel())));
        } else {
            return H.getHealth();
        }
    }

    public int Slam(Hero H) {
        H.setStunned(1);
        float bonusTile = 1f;
        if (landBonus) {
            bonusTile = Constants.LAND_BONUS;
        }
        return Math.round(bonusTile * (slamBonus * (Constants.SLAM_BASE_DMG +
                Constants.SLAM_INCREASED_DMG * this.getLevel())));
    }

    public void setLandBonus(boolean landBonus) {
        this.landBonus = landBonus;
    }

    public void accept(Hero H) {
        H.interactWith(this);
    }

    @Override
    public void noLandBonus() {
        this.setLandBonus(false);
    }

    @Override
    void interactWith(Pyromancer P) {
        this.setAvailable(false);
        this.executeBonus = Constants.EXECUTE_P_B;
        this.slamBonus = Constants.SLAM_P_B;
//        System.out.println(this.emote() + "exe:" + this.executeBonus + "slam" + this.slamBonus);
        P.receiveDamage(this.Execute(P) + this.Slam(P));
        if (P.isAvailable()) { P.interactWith(this); }

    }

    @Override
    void interactWith(Knight K) {
        this.setAvailable(false);
        this.executeBonus = Constants.EXECUTE_K_B;
        this.slamBonus = Constants.SLAM_K_B;
//        System.out.println(this.emote() + "exe:" + this.executeBonus + "slam" + this.slamBonus);
        K.receiveDamage(this.Execute(K) + this.Slam(K));
        if (K.isAvailable()) { K.interactWith(this); }
    }

    @Override
    void interactWith(Wizard W) {
        this.setAvailable(false);
        this.executeBonus = Constants.EXECUTE_W_B;
        this.slamBonus = Constants.SLAM_W_B;
//        System.out.println(this.emote() + "exe:" + this.executeBonus + "slam" + this.slamBonus);
        W.receiveDamage(this.Execute(W), this.Slam(W));
        if (W.isAvailable()) { W.interactWith(this); }

    }

    @Override
    void interactWith(Rogue R) {
        this.setAvailable(false);
        this.executeBonus = Constants.EXECUTE_R_B;
        this.slamBonus = Constants.SLAM_R_B;
//        System.out.println(this.emote() + "exe:" + this.executeBonus + "slam" + this.slamBonus);
        R.receiveDamage(this.Execute(R) + this.Slam(R));
        if (R.isAvailable()) { R.interactWith(this); }
    }


}
