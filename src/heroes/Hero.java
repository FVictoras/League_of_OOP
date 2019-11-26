package heroes;

public abstract class Hero {
    private int health;
    private int XP;
    private int level;
    private int xCoordonate;
    private int yCoordonate;
    private int damageOvertime;

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

    public String emote() { return null; }

    abstract public void accept(Hero H);

    abstract void interactWith(Pyromancer P);

    abstract void interactWith(Knight P);

    abstract void interactWith(Wizard B);

    abstract void interactWith(Rogue R);


}
