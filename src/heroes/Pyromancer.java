package heroes;

import common.Constants;

import java.util.ArrayList;

public class Pyromancer extends Hero {
    private boolean volcanicBonus = false;
    private float fireblastBonus = 1f;
    private float igniteBonus = 1f;

    public Pyromancer(int x, int y) {
        super(x, y);
        this.setHealth(Constants.STARTING_HP_PYRO);
    }

    public String emote() {
        return "Sunt un pyro";
    }


    public int Fireblast() {
        float tileBonus = 1f;
        if (volcanicBonus) {
            tileBonus = Constants.VOLCANIC_BONUS;
        }
        return Math.round(tileBonus * (fireblastBonus * Constants.FIREBLAST_BASE_DMG + this.getLevel()
                * Constants.FIREBLAST_INCREASED_DMG));
    }

    public ArrayList<Integer> Ignite() {
        ArrayList<Integer> igniteDamage = new ArrayList<Integer>(3);
        float tileBonus = 1f;
        if (volcanicBonus) {
            tileBonus = Constants.VOLCANIC_BONUS;
        }
        igniteDamage.add(Math.round(tileBonus * (igniteBonus * Constants.IGNITE_BASE_DMG +
                this.getLevel() * Constants.IGNITE_INCREASED_DMG)));
        igniteDamage.add((Math.round(tileBonus * (igniteBonus * Constants.IGNITE_BASE_OVERTIME +
                this.getLevel() * Constants.IGNITE_INCREASED_OVERTIME))));
        igniteDamage.add(Constants.IGNITE_DURATION_OVERTIME);
        return igniteDamage;
    }

    public void accept(Hero H) {
        H.interactWith(this);
    }

    public void setVolcanicBonus(boolean volcanicBonus) {
        this.volcanicBonus = volcanicBonus;
        System.out.println("pyro: mi-a fost setat " + volcanicBonus + " volcanicBonus");
    }

    @Override
    public void noLandBonus() {
        this.setVolcanicBonus(false);
    }

    @Override
    void interactWith(Pyromancer P) {
        this.fireblastBonus = Constants.FIREBLAST_P_B;
        this.igniteBonus = Constants.IGNITE_P_B;
    }

    @Override
    void interactWith(Knight K) {
        this.fireblastBonus = Constants.FIREBLAST_K_B;
        this.igniteBonus = Constants.IGNITE_K_B;
    }

    @Override
    void interactWith(Wizard W) {
        this.fireblastBonus = Constants.FIREBLAST_W_B;
        this.igniteBonus = Constants.IGNITE_W_B;
    }

    @Override
    void interactWith(Rogue R) {
        this.fireblastBonus = Constants.FIREBLAST_R_B;
        this.igniteBonus = Constants.IGNITE_R_B;
    }
}
