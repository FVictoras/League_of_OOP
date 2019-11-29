package common;

public final class Constants {

    // XP constant
    public static final int XP_BASE = 250;
    public static final int XP_MULTIPLICATOR = 50;
    // Starting HP Zone
    public static final int STARTING_HP_PYRO = 500;
    public static final int STARTING_HP_KNIGHT = 900;
    public static final int STARTING_HP_WIZARD = 400;
    public static final int STARTING_HP_ROGUE = 600;
    // Increased HP per Level
    public static final int INCREASE_HP_PYRO = 50;
    public static final int INCREASE_HP_KNIGHT = 80;
    public static final int INCREASE_HP_WIZARD = 30;
    public static final int INCREASE_HP_ROGUE = 40;

    // Skills Zone
    // Fireblast
    public static final int FIREBLAST_BASE_DMG = 350;
    public static final int FIREBLAST_INCREASED_DMG = 50;
    // Ignite
    public static final int IGNITE_BASE_DMG = 150;
    public static final int IGNITE_INCREASED_DMG = 20;
    public static final int IGNITE_BASE_OVERTIME = 50;
    public static final int IGNITE_INCREASED_OVERTIME = 30;
    public static final int IGNITE_DURATION_OVERTIME = 2;
    // Execute
    public static final int EXECUTE_BASE_DMG = 200;
    public static final int EXECUTE_INCREASED_DMG = 30;
    public static final float EXECUTE_BASE_DESTROY = 20 / 100f;
    public static final float EXECUTE_INCREASED_DESTROY = 1 / 100f;
    // Slam
    public static final int SLAM_BASE_DMG = 100;
    public static final int SLAM_INCREASED_DMG = 40;
    // Drain
    public static final float DRAIN_BASE_PERCENT = 20/100f;
    public static final float DRAIN_INCREASED_PERCENT = 5/100f;
    public static final float DRAIN_BASE_CONSTANT = 30/100f;
    // Deflect
    public static final float DEFLECT_BASE_PERCENT = 35/100f;
    public static final float DEFLECT_INCREASED_PERCENT  = 2/100f;
    public static final float DEFLECT_MAX_PERCENT = 70/100f;
    // Backstab
    public static final int BACKSTAB_BASE_DMG = 200;
    public static final int BACKSTAB_INCREASED_DMG = 20;
    public static final float BACKSTAB_CRITICAL_BONUS = 150/100f;
    public static int BACKSTAB_CRITICAL_HITSNEEDED = 3;
    // Paralysis
    public static final int PARALYSIS_BASE_DMG = 40;
    public static final int PARALYSIS_INCREASED_DMG = 10;
    public static final int PARALYSIS_OVERTIME_ROUNDS = 3;
    public static final int PARALYSIS_OVERTIME_BONUS_ROUNDS = 6;


    // Tile bonuses
    public static final float LAND_BONUS = 1 + (15/100f);
    public static final float VOLCANIC_BONUS = 1 + (25/100f);
    public static final float DESERT_BONUS = 1 + (10/100f);
    public static final float WOODS_BONUS = 1 + (15/100f);

    // pyro bonus
    public static final float FIREBLAST_R_B = 1 + (-20/100f);
    public static final float FIREBLAST_K_B = 1 + (20/100f);
    public static final float FIREBLAST_P_B = 1 + (10/100f);
    public static final float FIREBLAST_W_B = 1 + (5/100f);

    public static final float IGNITE_R_B = 1 + (-20/100f);
    public static final float IGNITE_K_B = 1 + (20/100f);
    public static final float IGNITE_P_B = 1 + (-10/100f);
    public static final float IGNITE_W_B = 1 + (5/100f);

    // knight bonus
    public static final float EXECUTE_R_B = 1 + (15/100f);
    public static final float EXECUTE_K_B = 1;
    public static final float EXECUTE_P_B = 1 + (10/100f);
    public static final float EXECUTE_W_B = 1 + (-20/100f);

    public static final float SLAM_R_B = 1 + (-20/100f);
    public static final float SLAM_K_B = 1 + (20/100f);
    public static final float SLAM_P_B = 1 + (-10/100f);
    public static final float SLAM_W_B = 1 + (5/100f);

    // wizard bonus
    public static final float DRAIN_R_B = 1 + (-20/100f);
    public static final float DRAIN_K_B = 1 + (20/100f);
    public static final float DRAIN_P_B = 1 + (-10/100f);
    public static final float DRAIN_W_B = 1 + (5/100f);

    public static final float DEFLECT_R_B = 1 + (20/100f);
    public static final float DEFLECT_K_B = 1 + (40/100f);
    public static final float DEFLECT_P_B = 1 + (30/100f);

    //rogue bonus
    public static final float BACKSTAB_R_B = 1 + (20/100f);
    public static final float BACKSTAB_K_B = 1 + (-10/100f);
    public static final float BACKSTAB_P_B = 1 + (25/100f);
    public static final float BACKSTAB_W_B = 1 + (25/100f);

    public static final float PARALYSIS_R_B = 1 + (-10/100f);
    public static final float PARALYSIS_K_B = 1 + (-20/100f);
    public static final float PARALYSIS_P_B = 1 + (20/100f);
    public static final float PARALYSIS_W_B = 1 + (25/100f);


    //String constants
    public static final String DMG_OVERTIME = "damage overtime";
    public static final String STUN_REDUCTION = "stun reduction";
    public static final String XP_OPERATION = "xp operation";

}

/**
 * IN CAZUL DMG DAT PRIN ABILITATI OVERTIME SE VA RETURNA UN ARRAY
 * array[0] - damageul in runda curenta (Daca exista)
 * array[1] - damageul overtime/runda
 * array[2] - durata overtime
 */