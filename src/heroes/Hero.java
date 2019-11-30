package heroes;

import java.util.ArrayList;

public abstract class Hero {
    private int health;
    private int XP;
    private int level;
    private int xCoordonate;
    private int yCoordonate;
    private int damageOvertime;
    private int roundsOvertime;
    private int roundsStunned;
    private ArrayList<Integer> lastDamageReceived;

    public int getDamageOvertime() {
        return damageOvertime;
    }

    public void setDamageOvertime(int damageOvertime) {
        this.damageOvertime = damageOvertime;
    }

    public int getRoundsOvertime() {
        return roundsOvertime;
    }

    public void setRoundsOvertime(int roundsOvertime) {
        this.roundsOvertime = roundsOvertime;
    }

    public ArrayList<Integer> getLastDamageReceived() {
        return lastDamageReceived;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getXP() {
        return XP;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }

    private boolean available;

    public Hero(int x, int y) {
        this.level = 0;
        this.XP = 0;
        this.xCoordonate = x;
        this.yCoordonate = y;
        this.roundsStunned = 0;
        this.damageOvertime = 0;
        this.roundsOvertime = 0;
        this.available = true;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public int getxCoordonate() {
        return xCoordonate;
    }

    public int getyCoordonate() {
        return yCoordonate;
    }

    public void setxCoordonate(int xCoordonate) {
        this.xCoordonate = xCoordonate;
    }

    public void setyCoordonate(int yCoordonate) {
        this.yCoordonate = yCoordonate;
    }

    public int getStunned() {
        return roundsStunned;
    }

    public void setStunned(int stunned) {
        this.roundsStunned = stunned;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void receiveDamage(int damage) {
        this.health = this.health - damage;
    }

    public void receiveDamage(int damageFirstSkill, int damageSecondSkill) {
        this.health = this.health - damageFirstSkill - damageSecondSkill;
        this.lastDamageReceived = new ArrayList<Integer>();
        this.lastDamageReceived.add(damageFirstSkill);
        this.lastDamageReceived.add(damageSecondSkill);
    }

    void setDamageOvertime(int damageOvertime, int roundsOvertime) {
        this.damageOvertime = damageOvertime;
        this.roundsOvertime = roundsOvertime;
    }

    public String emote() {
        return null;
    }

    abstract public void noLandBonus();

    abstract public void accept(Hero H);

    abstract void interactWith(Pyromancer P);

    abstract void interactWith(Knight P);

    abstract void interactWith(Wizard B);

    abstract void interactWith(Rogue R);


}
