package heroes;

import common.Constants;

import java.util.ArrayList;
/*
    Fiecare clasa care implementeaza un copil al clasei Hero are specific:
    Abilitatile, bonusurile aferente abilitatii, bonusul aferent tile-ului
    Interactiunile sunt overrideuite in concordanta cu logica jocului.
 */

public class Pyromancer extends Hero {
    private boolean volcanicBonus = false;
    private float fireblastBonus = 1f;
    private float igniteBonus = 1f;
    private float damageModifier = 0f;

    public Pyromancer(final int x, final int y) {
        super(x, y);
        this.setHealth(Constants.STARTING_HP_PYRO);
    }

    public final String emote() {
        return "P";
    }

    public final void increaseDamageModifier(float val) {
        this.damageModifier = this.damageModifier + val;
    }

    private int fireblast() {
        float tileBonus = 1f;
        if (volcanicBonus) {
            tileBonus = Constants.VOLCANIC_BONUS;
        }
        return Math.round(tileBonus * (fireblastBonus * Constants.FIREBLAST_BASE_DMG
                + this.getLevel() * Constants.FIREBLAST_INCREASED_DMG));
    }

    private ArrayList<Integer> ignite(final Hero h) {
        ArrayList<Integer> igniteDamage = new ArrayList<Integer>();
        float tileBonus = 1f;
        if (volcanicBonus) {
            tileBonus = Constants.VOLCANIC_BONUS;
        }
        igniteDamage.add(Math.round(tileBonus * (igniteBonus * Constants.IGNITE_BASE_DMG
                + this.getLevel() * Constants.IGNITE_INCREASED_DMG)));
        igniteDamage.add((Math.round(tileBonus * (igniteBonus * Constants.IGNITE_BASE_OVERTIME
                + this.getLevel() * Constants.IGNITE_INCREASED_OVERTIME))));
        igniteDamage.add(Constants.IGNITE_DURATION_OVERTIME);
        h.setDamageOvertime(igniteDamage.get(1), igniteDamage.get(2));
        return igniteDamage;
    }

    public final void accept(final Hero h) {
        h.interactWith(this);
    }

    public final void setVolcanicBonus(final boolean volcanicBonus) {
        this.volcanicBonus = volcanicBonus;
    }

    @Override
    public final void noLandBonus() {
        this.setVolcanicBonus(false);
    }

    @Override
    final void interactWith(final Pyromancer p) {
        this.setAvailable(false);
        this.fireblastBonus = Constants.FIREBLAST_P_B;
        this.igniteBonus = Constants.IGNITE_P_B;
        p.receiveDamage(this.fireblast() + this.ignite(p).get(0));
        if (p.isAvailable()) {
            p.interactWith(this);
        }
    }

    @Override
    final void interactWith(final Knight k) {
        this.setAvailable(false);
        this.fireblastBonus = Constants.FIREBLAST_K_B;
        this.igniteBonus = Constants.IGNITE_K_B;
        k.receiveDamage(this.fireblast() + this.ignite(k).get(0));
        if (k.isAvailable()) {
            k.interactWith(this);
        }
    }

    @Override
    final void interactWith(final Wizard w) {
        this.setAvailable(false);
        this.fireblastBonus = Constants.FIREBLAST_W_B;
        this.igniteBonus = Constants.IGNITE_W_B;
        w.receiveDamage(this.fireblast(), this.ignite(w).get(0));
        if (w.isAvailable()) {
            w.interactWith(this);
        }
    }

    @Override
    final void interactWith(final Rogue r) {
        this.setAvailable(false);
        this.fireblastBonus = Constants.FIREBLAST_R_B;
        this.igniteBonus = Constants.IGNITE_R_B;
        r.receiveDamage(this.fireblast() + this.ignite(r).get(0));
        if (r.isAvailable()) {
            r.interactWith(this);
        }
    }
}
