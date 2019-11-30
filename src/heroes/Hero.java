package heroes;

import java.util.ArrayList;

public abstract class Hero {
    private int health;
    private int xp;
    private int level;
    private int xCoordonate;
    private int yCoordonate;
    private int damageOvertime;
    private int roundsOvertime;
    private int roundsStunned;
    private ArrayList<Integer> lastDamageReceived;

    public final  int getDamageOvertime() {
        return damageOvertime;
    }

    public final int getRoundsOvertime() {
        return roundsOvertime;
    }

    public final void setRoundsOvertime(final int roundsOvertime) {
        this.roundsOvertime = roundsOvertime;
    }

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
     * Javadoc.
     * @return
     */
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
