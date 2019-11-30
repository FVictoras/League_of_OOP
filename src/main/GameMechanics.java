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

    public GameMechanics(final GameInput gameInput, final String outputPath) {
        this.heroes = (new PlayerFactory(gameInput.getPlayerOnTheMap())).allHeroes();
        this.map = gameInput.getMap();
        this.moves = gameInput.getPlayerMoves();
        this.numberOfRounds = gameInput.getnRounds();
        this.numberOfPlayers = gameInput.getnPlayers();
        this.nColumn = gameInput.getN();
        this.nRows = gameInput.getM();
        this.outputPath = outputPath;
    }

    private void setAllAvailable() {
        for (Hero h : heroes) {
            h.setAvailable(true);
        }
    }
    final void launchGame() throws IOException {
        for (int i = 0; i < numberOfRounds; i++) {
            this.setAllAvailable();
            ContextRound roundLogic = new ContextRound(Constants.DMG_OVERTIME);
            for (Hero h : heroes) {
                // Aici se ia damageul overtime
                roundLogic.doOperation(h);
                // Se verifica daca e alive
                if (UtilsHero.isAlive(h)) {
                    // Se face miscarea
                    if (h.getStunned() == 0) {
                        this.doMovement(i, h);
                    } else {
                        h.setStunned(h.getStunned() - 1);
                    }
                }
            }
            // Se verifica coliziuni
            this.checkCollisions();
        }
        this.printScoreboard();
    }

    private void doMovement(final int currentRound, final Hero h) {
        int index = heroes.indexOf(h);
        if (moves.get(currentRound).get(index) == 'U') {
            h.setxCoordonate(h.getxCoordonate() - 1);
        }
        if (moves.get(currentRound).get(index) == 'D') {
            h.setxCoordonate(h.getxCoordonate() + 1);
        }
        if (moves.get(currentRound).get(index) == 'R') {
            h.setyCoordonate(h.getyCoordonate() + 1);
        }
        if (moves.get(currentRound).get(index) == 'L') {
            h.setyCoordonate(h.getyCoordonate() - 1);
        }
    }

    private void checkCollisions() {
        int[][] traceMap = new int[nColumn][nRows];
        for (int i = 0; i < nColumn; i++) {
            for (int j = 0; j < nColumn; j++) {
                traceMap[i][j] = -1;
            }
        }
        for (Hero h : heroes) {
            if (UtilsHero.isAlive(h)) {
                int x = h.getxCoordonate();
                int y = h.getyCoordonate();
                if (traceMap[x][y] == -1) {
                    traceMap[x][y] = heroes.indexOf(h);
                } else {
                    startAttack(h, heroes.get(traceMap[x][y]), map[x][y]);
                }
            }
        }
    }

    private void startAttack(final Hero h1, final Hero h2, final char tile) {
        ContextTile tileBonus = new ContextTile(tile);
        tileBonus.executeStrategy(h1);
        tileBonus.executeStrategy(h2);
        h1.accept(h2);
        ContextRound roundLogic = new ContextRound(Constants.XP_OPERATION);
        if (UtilsHero.isAlive(h1) && !UtilsHero.isAlive(h2)) {
            roundLogic.doOperation(h1, h2);
        }
        if (!UtilsHero.isAlive(h1) && UtilsHero.isAlive(h2)) {
            roundLogic.doOperation(h2, h1);
        }
        if (!UtilsHero.isAlive(h1) && !UtilsHero.isAlive(h2)) {
            int hardLevel = h1.getLevel();
            roundLogic.doOperation(h1, h2);
            int newHardLevel = h1.getLevel();
            // Corner case cand amandoi se omoara si primul primeste xp, creste level, iar al doilea
            // cand isi calculeaza XP-ul trebuie sa primeasca corespunzator nivelului eroului 1
            // inainte de primirea xp-ului.
            if (newHardLevel > hardLevel) {
                h1.setLevel(newHardLevel - (newHardLevel - hardLevel));
                roundLogic.doOperation(h2, h1);
                h1.setLevel(newHardLevel);
            }
        }
    }

    private void printScoreboard() throws IOException {
        GameOutput.printGame(outputPath, heroes);
    }


}
