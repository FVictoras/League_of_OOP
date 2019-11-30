package main;

import common.Constants;
import factories.PlayerFactory;
import heroes.Hero;
import heroes.tilebonuses.ContextTile;
import heroes.utils.UtilsHero;
import main.mechanicslogic.ContextRound;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class GameMechanics {
    private String outputPath;
    private ArrayList<Hero> heroes;
    private char[][] map;
    private HashMap<Integer, ArrayList<Character>> moves;
    private int numberOfRounds;
    private int numberOfPlayers;
    private int nColumn;
    private int nRows;

    public GameMechanics(GameInput gameInput, String outputPath) {
        this.heroes = (new PlayerFactory(gameInput.getPlayerOnTheMap())).allHeroes();
        this.map = gameInput.getMap();
        this.moves = gameInput.getPlayerMoves();
        this.numberOfRounds = gameInput.getnRounds();
        this.numberOfPlayers = gameInput.getnPlayers();
        this.nColumn = gameInput.getN();
        this.nRows = gameInput.getM();
        this.outputPath = outputPath;
    }

    public void setAllAvailable() {
        for (Hero H : heroes) {
            H.setAvailable(true);
        }
    }

    public void launchGame() throws IOException {
        for (int i = 0; i < numberOfRounds; i++) {
            this.setAllAvailable();
            ContextRound roundLogic = new ContextRound(Constants.DMG_OVERTIME);
            for (Hero H : heroes) {
                // Aici se ia damageul overtime
                roundLogic.doOperation(H);
                // Se verifica daca e alive
                if (UtilsHero.isAlive(H)) {
                    // Se face miscarea
                    if (H.getStunned() == 0) { this.doMovement(i, H); } else {
                        H.setStunned(H.getStunned() - 1);
                    }
                }
            }
            // Se verifica coliziuni
            this.checkCollisions();
        }
        this.printScoreboard();
    }

    public void doMovement(int currentRound, Hero H) {
        int index = heroes.indexOf(H);
        if (moves.get(currentRound).get(index) == 'U') {
            H.setxCoordonate(H.getxCoordonate() - 1);
        }
        if (moves.get(currentRound).get(index) == 'D') {
            H.setxCoordonate(H.getxCoordonate() + 1);
        }
        if (moves.get(currentRound).get(index) == 'R') {
            H.setyCoordonate(H.getyCoordonate() + 1);
        }
        if (moves.get(currentRound).get(index) == 'L') {
            H.setyCoordonate(H.getyCoordonate() - 1);
        }
    }

    public void checkCollisions() {
        int[][] traceMap = new int[nColumn][nRows];
        for (int i = 0; i < nColumn; i++) {
            for (int j = 0; j < nColumn; j++) {
                traceMap[i][j] = -1;
            }
        }
        for (Hero H : heroes) {
            if (UtilsHero.isAlive(H)) {
                int X = H.getxCoordonate();
                int Y = H.getyCoordonate();
                if (traceMap[X][Y] == -1) { traceMap[X][Y] = heroes.indexOf(H); } else {
                    startAttack(H, heroes.get(traceMap[X][Y]), map[X][Y]);
                }
            }
        }
    }

    public void startAttack(Hero H1, Hero H2, char tile) {
        ContextTile tileBonus = new ContextTile(tile);
        tileBonus.executeStrategy(H1);
        tileBonus.executeStrategy(H2);
        H1.accept(H2);
        ContextRound roundLogic = new ContextRound(Constants.XP_OPERATION);
        if (UtilsHero.isAlive(H1) && !UtilsHero.isAlive(H2)) {
            roundLogic.doOperation(H1, H2);
        }
        if (!UtilsHero.isAlive(H1) && UtilsHero.isAlive(H2)) {
            roundLogic.doOperation(H2, H1);
        }
        if (!UtilsHero.isAlive(H1) && !UtilsHero.isAlive(H2)) {
            int hardLevel = H1.getLevel();
            roundLogic.doOperation(H1, H2);
            int newHardLevel = H1.getLevel();
            // Corner case cand amandoi se omoara si primul primeste xp, creste level, iar al doilea
            // cand isi calculeaza XP-ul trebuie sa primeasca corespunzator nivelului eroului 1
            // inainte de primirea xp-ului.
            if (newHardLevel > hardLevel) {
                H1.setLevel(newHardLevel - (newHardLevel - hardLevel));
                roundLogic.doOperation(H2, H1);
                H1.setLevel(newHardLevel);
            }
        }
    }

    public void printScoreboard() throws IOException {
        GameOutput.printGame(outputPath, heroes);
        for (Hero H : heroes) {
        }
    }


}
