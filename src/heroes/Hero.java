package heroes;

public abstract class Hero {
    private int health;
    private int XP;
    private int level;
    private int xCoordonate;
    private int yCoordonate;
    private int damageOvertime;
    private boolean stunned;
    private float raceModifier;

    public boolean isStunned() {
        return stunned;
    }

    public void setStunned(boolean stunned) {
        this.stunned = stunned;
    }

    public int getLevel() {
        return level;
    }

    public Hero(int x, int y) {
        this.level = 0;
        this.XP = 0;
        this.xCoordonate = x;
        this.yCoordonate = y;
    }

    public int getxCoordonate() {
        return xCoordonate;
    }

    public int getyCoordonate() {
        return yCoordonate;
    }

    public int getHealth() {
        return health;
    }

    void setHealth(int health) {
        this.health = health;
    }

    void setDamageOvertime(int damageOvertime) {
        this.damageOvertime = damageOvertime;
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
