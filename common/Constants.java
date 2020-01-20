package common;

public final class Constants {
    private Constants() {
    }
    // XP constant
    public static final int XP_BASE = 250;
    public static final int XP_MULTIPLICATOR = 50;
    public static final int XP_EARN_BASE = 200;
    public static final int XP_EARN_LEVEL = 40;

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
    public static final float DRAIN_BASE_PERCENT = 20 / 100f;
    public static final float DRAIN_INCREASED_PERCENT = 5 / 100f;
    public static final float DRAIN_BASE_CONSTANT = 30 / 100f;
    // Deflect
    public static final float DEFLECT_BASE_PERCENT = 35 / 100f;
    public static final float DEFLECT_INCREASED_PERCENT = 2 / 100f;
    public static final float DEFLECT_MAX_PERCENT = 70 / 100f;
    // Backstab
    public static final int BACKSTAB_BASE_DMG = 200;
    public static final int BACKSTAB_INCREASED_DMG = 20;
    public static final float BACKSTAB_CRITICAL_BONUS = 150 / 100f;
    public static final int BACKSTAB_CRITICAL_HITSNEEDED = 3;
    // Paralysis
    public static final int PARALYSIS_BASE_DMG = 40;
    public static final int PARALYSIS_INCREASED_DMG = 10;
    public static final int PARALYSIS_OVERTIME_ROUNDS = 3;
    public static final int PARALYSIS_OVERTIME_BONUS_ROUNDS = 6;

    // Tile bonuses
    public static final float LAND_BONUS = 1 + (15 / 100f);
    public static final float VOLCANIC_BONUS = 1 + (25 / 100f);
    public static final float DESERT_BONUS = 1 + (10 / 100f);
    public static final float WOODS_BONUS = 1 + (15 / 100f);

    // pyro bonus
    public static final float FIREBLAST_R_B = 1 + (-20 / 100f);
    public static final float FIREBLAST_K_B = 1 + (20 / 100f);
    public static final float FIREBLAST_P_B = 1 + (-10 / 100f);
    public static final float FIREBLAST_W_B = 1 + (5 / 100);

    public static final float IGNITE_R_B = 1 + (-20 / 100f);
    public static final float IGNITE_K_B = 1 + (20 / 100f);
    public static final float IGNITE_P_B = 1 + (-10 / 100f);
    public static final float IGNITE_W_B = 1 + (5 / 100f);

    // knight bonus
    public static final float EXECUTE_R_B = 1 + (15 / 100f);
    public static final float EXECUTE_K_B = 1;
    public static final float EXECUTE_P_B = 1 + (10 / 100f);
    public static final float EXECUTE_W_B = 1 + (-20 / 100f);

    public static final float SLAM_R_B = 1 + (-20 / 100f);
    public static final float SLAM_K_B = 1 + (20 / 100f);
    public static final float SLAM_P_B = 1 + (-10 / 100f);
    public static final float SLAM_W_B = 1 + (5 / 100f);

    // wizard bonus
    public static final float DRAIN_R_B = 1 + (-20 / 100f);
    public static final float DRAIN_K_B = 1 + (20 / 100f);
    public static final float DRAIN_P_B = 1 + (-10 / 100f);
    public static final float DRAIN_W_B = 1 + (5 / 100f);

    public static final float DEFLECT_R_B = 1 + (20 / 100f);
    public static final float DEFLECT_K_B = 1 + (40 / 100f);
    public static final float DEFLECT_P_B = 1 + (30 / 100f);

    //rogue bonus
    public static final float BACKSTAB_R_B = 1 + (20 / 100f);
    public static final float BACKSTAB_K_B = 1 + (-10 / 100f);
    public static final float BACKSTAB_P_B = 1 + (25 / 100f);
    public static final float BACKSTAB_W_B = 1 + (25 / 100f);

    public static final float PARALYSIS_R_B = 1 + (-10 / 100f);
    public static final float PARALYSIS_K_B = 1 + (-20 / 100f);
    public static final float PARALYSIS_P_B = 1 + (20 / 100f);
    public static final float PARALYSIS_W_B = 1 + (25 / 100f);

    //String constants
    public static final String DMG_OVERTIME = "damage overtime";
    public static final String STUN_REDUCTION = "stun reduction";
    public static final String XP_OPERATION = "xp operation";

    //Stage2

    //darkAngel
    public static final int DARKANGEL_K = 40;
    public static final int DARKANGEL_P = 30;
    public static final int DARKANGEL_W = 20;
    public static final int DARKANGEL_R = 10;

    public static final float DAMAGEANGEL_K = 0.150000f;
    public static final float DAMAGEANGEL_P = 0.20f;
    public static final float DAMAGEANGEL_R = 0.30f;
    public static final float DAMAGEANGEL_W = 0.40f;

    public static final float DRACULAF_K = -0.20f;
    public static final float DRACULAF_P = -0.30f;
    public static final float DRACULAF_R = -0.10001f;
    public static final float DRACULAF_W = -0.40f;
    public static final int DRACULA_K = -60;
    public static final int DRACULA_P = -40;
    public static final int DRACULA_R = -35;
    public static final int DRACULA_W = -20;

    public static final float GOODBOYF_K = 0.40f;
    public static final float GOODBOYF_P = 0.50f;
    public static final float GOODBOYF_R = 0.40f;
    public static final float GOODBOYF_W = 0.30f;
    public static final int GOODBOY_K = 20;
    public static final int GOODBOY_P = 30;
    public static final int GOODBOY_R = 40;
    public static final int GOODBOY_W = 50;

    public static final float LVLUPANG_K = 0.10f;
    public static final float LVLUPANG_P = 0.20f;
    public static final float LVLUPANG_R = 0.14999f;
    public static final float LVLUPANG_W = 0.25f;

    public static final int LIFEGIVER_K = 100;
    public static final int LIFEGIVER_P = 80;
    public static final int LIFEGIVER_R = 90;
    public static final int LIFEGIVER_W = 120;

    public static final float SMALLANGELF_K = 0.10f;
    public static final float SMALLANGELF_P = 0.15f;
    public static final float SMALLANGELF_R = 0.05f;
    public static final float SMALLANGELF_W = 0.10f;
    public static final int SMALLANGEL_K = 10;
    public static final int SMALLANGEL_P = 15;
    public static final int SMALLANGEL_R = 20;
    public static final int SMALLANGEL_W = 25;

    public static final int SPAWNER_K = 200;
    public static final int SPAWNER_P = 150;
    public static final int SPAWNER_R = 180;
    public static final int SPAWNER_W = 120;
    public static final int XPA_K = 45;
    public static final int XPA_P = 50;
    public static final int XPA_R = 40;
    public static final int XPA_W = 60;
    public static final float TREIME = 0.33f;
    public static final float JUMATATE = 0.5f;
    public static final float PATRIME = 0.25f;
    public static final float SEPTIME = 0.142f;
    public static final float CINCIME = 0.2f;
    public static final float KNIGHT_H_1 = 0.8f;
    public static final float KNIGHT_H_2 = 1.25f;
    public static final float KNIGHT_D_1 = 0.50f;
    public static final float KNIGHT_D_2 = -0.20f;
    public static final float PYRO_H_1 = 0.75f;
    public static final float PYRO_H_2 = 0.70f;
    public static final float PYRO_D_1 = 1.33f;
    public static final float PYRO_D_2 = -0.3f;
    public static final float ROG_H_1 = 0.8571f;
    public static final float ROG_H_2 = 0.40f;
    public static final float ROG_D_1 = 1.5f;
    public static final float ROG_D_2 = -0.1f;
    public static final float WIZ_H_1 = 0.9f;
    public static final float WIZ_D_1 = 0.60f;
    public static final float WIZ_H_2 = 1.2f;
    public static final float WIZ_D_2 = -0.20f;


}
