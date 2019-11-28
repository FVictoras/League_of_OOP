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
        return "Sunt un knight";
    }

    public void setLandBonus(boolean landBonus) {
        this.landBonus = landBonus;
    }

    public int Execute(Hero H) {
        float bonusTile = 1f;
        if (landBonus) {
            bonusTile = Constants.LAND_BONUS;
        }
        float reqHp = (Constants.EXECUTE_BASE_DESTROY + (Constants.EXECUTE_INCREASED_DESTROY *
                        H.getLevel())) * UtilsHero.getMaxHp(H);
        if (H.getHealth() > reqHp) {
            return Math.round(bonusTile * (executeBonus * (Constants.EXECUTE_BASE_DMG +
                    Constants.EXECUTE_INCREASED_DMG * this.getLevel())));
        } else {
            return H.getHealth();
        }
    }

    public int Slam(Hero H) {
        H.setStunned(true);
        float bonusTile = 1f;
        if (landBonus) {
            bonusTile = Constants.LAND_BONUS;
        }
        return Math.round(bonusTile * (slamBonus * (Constants.SLAM_BASE_DMG +
                Constants.SLAM_INCREASED_DMG * this.getLevel())));
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
        System.out.println("Sunt knight, ma ataca un Pyro");
    }

    @Override
    void interactWith(Knight P) {
        System.out.println("Sunt knight, ma ataca un Knight");
    }

    @Override
    void interactWith(Wizard B) {
        System.out.println("Sunt knight, ma ataca un Wizard");
    }

    @Override
    void interactWith(Rogue R) {
        System.out.println("Sunt knight, ma ataca un Rouge");
    }


}
