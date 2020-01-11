package main;

import angels.Angel;
import common.Constants;
import factories.AngelFactory;
import factories.PlayerFactory;
import heroes.Hero;
import heroes.tilebonuses.ContextTile;
import heroes.utils.UtilsHero;
import main.mechanicslogic.ContextRound;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/*
    Clasa indeplineste toata dinamicitatea jocului.
    i) Eroii se seteaza available de lupta la inceputul fiecarei runde (se pot lupta o singura data
    pe runda)
    1) Eroii iau damageul corespunzator abilitatilor cu overtime din rundele trecute
    ii) Se verifica daca supravietuiesc damageului overtime.
    iii) Se verifica daca au stun. Daca au nu se efectueaza (2) si li se decrementeaza stunul.
    2) Eroii se misca conform comenzii de la input.
    3) Se verifica coliziunile de pe harta. In cazul unei coliziuni se declanseaza (4)
    4) Eroii se ataca. Procedeu implementat prin double-dispatch (detalii in README). In urma atacu-
    lui se verifica starea de viata a fiecaruia si sunt date punctele XP, aferent si levelup + viata
    5) La finalul tuturor rundelor se apeleaza functia de printare.
 */

class GameMechanics {
    private String outputPath;
    private ArrayList<Hero> heroes;
    private char[][] map;
    private HashMap<Integer, ArrayList<Character>> moves;
    private int numberOfRounds;
    private int nColumn;
    private int nRows;
    private ArrayList<ArrayList<Angel>> myAngels;

    GameMechanics(final GameInput gameInput, final String outputPath) {
        this.heroes = (new PlayerFactory(gameInput.getPlayerOnTheMap())).allHeroes();
        this.map = gameInput.getMap();
        this.moves = gameInput.getPlayerMoves();
        this.numberOfRounds = gameInput.getnRounds();
        this.nColumn = gameInput.getN();
        this.nRows = gameInput.getM();
        this.outputPath = outputPath;
        this.myAngels = new ArrayList<ArrayList<Angel>>(AngelFactory.myAngels);
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
                    if (h.getStunned() == 0 && UtilsHero.isAlive(h)) {
                        this.doMovement(i, h);
                    } else {
                        h.setStunned(h.getStunned() - 1);
                    }
                }
            }
            // Se verifica coliziuni
            this.checkCollisions();
            this.AngelVisit(i);
        }
        this.printScoreboard();
    }

    private void AngelVisit(int round) {
        ArrayList<Angel> myRoundAngels = new ArrayList<Angel>(myAngels.get(round));
        ArrayList<Hero> heroesToBeVisited = new ArrayList<Hero>();
        for (Angel angel: myRoundAngels
             ) {
            if (angel.getxCoordonate()!=-1) {
                heroesToBeVisited.addAll(this.collisions(angel.getxCoordonate(), angel.getyCoordonate()));
                for (Hero h : heroesToBeVisited) {
                    angel.visit(h);
                }
                heroesToBeVisited.clear();
            }
        }
    }

    private ArrayList<Hero> collisions(int x, int y) {
        ArrayList<Hero> returnHero = new ArrayList<Hero>();
        for (Hero h: heroes) {
            if (h.getxCoordonate() == x && h.getyCoordonate()==y) {
                returnHero.add(h);
            }
        }
        return returnHero;
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
