package heroes;

import java.util.ArrayList;

/*
    Fiecare erou este implimentat mostenind clasa Hero. Aici sunt datele comune fiecarui erou,
    viata, xp, nivel, coordonate, damage-ul abilitatilor cu overtime, incapacitatea de miscare.
    Pentru a facilita implementarea unor abilitati vom stoca si cel mai recent damage primit.
    Cum la compilare stim ca eroii sunt Hero, dar nu stim exact ce copii ai lui Hero, abordam
    problema interactiunii dintre eroi la RUNTIME, atunci cand prin double-dispatch acestia vor
    interactiona corect.
    Double dispatch implementarea este printr-o functie de accept overriduita de fiecare copil si
    alte numarClaseCopil de functii InteractWith overwriteuite si overrideuita fiecare in clasa
    copil,
    Majoritatea metodelor sunt getter si setteri.
 */

public abstract class Hero {
    private int health, xp, level, xCoordonate, yCoordonate, damageOvertime, roundsOvertime,
            roundsStunned, id;

    public boolean isStunned() {
        return stunned;
    }

    public void setStunned(boolean stunned) {
        this.stunned = stunned;
    }

    private boolean stunned;
    private ArrayList<Integer> lastDamageReceived;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public final  int getDamageOvertime() {
        return damageOvertime;
    }

    public final int getRoundsOvertime() {
        return roundsOvertime;
    }

    public final void setRoundsOvertime(final int roundsOvertime) {
        this.roundsOvertime = roundsOvertime;
    }
    public String toString() { return "Hero"; }

    final ArrayList<Integer> getLastDamageReceived() {
        return lastDamageReceived;
    }

    final boolean isAvailable() {
        return available;
    }

    public final void setAvailable(final boolean available) {
        this.available = available;
    }

    public final int getXp() {
        return xp;
    }

    public final void setLevel(final int level) {
        this.level = level;
    }

    public final void setXp(final int xp) {
        this.xp = xp;
    }

    private boolean available;

    public Hero(final int x, final int y) {
        this.level = 0;
        this.xp = 0;
        this.xCoordonate = x;
        this.yCoordonate = y;
        this.roundsStunned = 0;
        this.damageOvertime = 0;
        this.roundsOvertime = 0;
        this.available = true;
        this.stunned = true;
    }

    public final int getHealth() {
        return health;
    }

    public final int getLevel() {
        return level;
    }

    public final int getxCoordonate() {
        return xCoordonate;
    }

    public final int getyCoordonate() {
        return yCoordonate;
    }

    public final void setxCoordonate(final int xCoordonate) {
        this.xCoordonate = xCoordonate;
    }

    public final void setyCoordonate(final int yCoordonate) {
        this.yCoordonate = yCoordonate;
    }

    public final int getStunned() {
        return roundsStunned;
    }

    public final void setStunned(final int stunned) {
        this.roundsStunned = stunned;
    }

    public final void setHealth(final int health) {
        this.health = health;
    }

    public final void receiveDamage(final int damage) {
        this.health = this.health - damage;
    }

    final void receiveDamage(final int damageFirstSkill, final int damageSecondSkill) {
        this.health = this.health - damageFirstSkill - damageSecondSkill;
        this.lastDamageReceived = new ArrayList<Integer>();
        this.lastDamageReceived.add(damageFirstSkill);
        this.lastDamageReceived.add(damageSecondSkill);
    }

    final void setDamageOvertime(final int overtime, final int rounds) {
        this.damageOvertime = overtime;
        this.roundsOvertime = rounds;
    }

    /**
     * Returneaza tipul de erou.
     * @return tipul de erou.
     */

    public abstract void increaseDamageModifier(float val);

    public String emote() {
        return null;
    }

    public abstract void noLandBonus();

    public abstract void accept(Hero h);

    abstract void interactWith(Pyromancer p);

    abstract void interactWith(Knight k);

    abstract void interactWith(Wizard w);

    abstract void interactWith(Rogue r);


}
