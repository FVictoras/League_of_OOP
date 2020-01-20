package main;

import angels.Angel;
import common.Constants;
import factories.AngelFactory;
import factories.PlayerFactory;
import fileio.implementations.FileWriter;
import heroes.Hero;
import heroes.strategies.ContextHero;
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
    NEW) Isi aleg strategia.
    3) Se verifica coliziunile de pe harta. In cazul unei coliziuni se declanseaza (4)
    4) Eroii se ataca. Procedeu implementat prin double-dispatch (detalii in README). In urma atacu-
    lui se verifica starea de viata a fiecaruia si sunt date punctele XP, aferent si levelup + viata
    5) La finalul tuturor rundelor se apeleaza functia de printare.
    NEW) Toate modificarile, cerute in enunt, sunt notificate cate LOG (observerul).
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
    private FileWriter fileWriter;

    GameMechanics(final GameInput gameInput, final String outputPath) throws IOException {
        this.heroes = (new PlayerFactory(gameInput.getPlayerOnTheMap())).allHeroes();
        this.map = gameInput.getMap();
        this.moves = gameInput.getPlayerMoves();
        this.numberOfRounds = gameInput.getnRounds();
        this.nColumn = gameInput.getN();
        this.nRows = gameInput.getM();
        this.outputPath = outputPath;
        this.myAngels = new ArrayList<ArrayList<Angel>>(AngelFactory.getMyAngels());
        this.fileWriter = new FileWriter(outputPath);
    }

    private void setAllAvailable() {
        for (Hero h : heroes) {
            h.setAvailable(true);
        }
    }

    final void launchGame() throws IOException {
        for (int i = 0; i < numberOfRounds; i++) {
            Log.update(i + 1, fileWriter);
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
                        h.setStunned(false);
                    } else {
                        h.setStunned(h.getStunned() - 1);
                        h.setStunned(true);
                    }
                    // Se alege strategia disponibila
                    ContextHero strategy = new ContextHero(h);
                    if (!h.isStunned() && UtilsHero.isAlive(h)) {
                        strategy.executeStrategy(h);
                    }
                }
            }
            // Se verifica coliziuni
            this.checkCollisions();
            this.angelVisit(i);
            fileWriter.writeNewLine();
        }
        this.printScoreboard();
        fileWriter.close();

    }

    private void angelVisit(final int round) throws IOException {
        ArrayList<Angel> myRoundAngels = new ArrayList<Angel>(myAngels.get(round));
        ArrayList<Hero> heroesToBeVisited = new ArrayList<Hero>();
        for (Angel angel : myRoundAngels) {
            if (angel.getxCoordonate() != -1) {
                Log.update(angel, fileWriter);
                heroesToBeVisited.addAll(this.collisions(angel.getxCoordonate(),
                        angel.getyCoordonate()));
                for (Hero h : heroesToBeVisited) {
                    angel.visit(h, fileWriter);
                }
                heroesToBeVisited.clear();
            }
        }
    }

    private ArrayList<Hero> collisions(final int x, final int y) {
        ArrayList<Hero> returnHero = new ArrayList<Hero>();
        for (Hero h : heroes) {
            if (h.getxCoordonate() == x && h.getyCoordonate() == y) {
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

    private void checkCollisions() throws IOException {
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

    private void startAttack(final Hero h1, final Hero h2, final char tile) throws IOException {
        ContextTile tileBonus = new ContextTile(tile);
        tileBonus.executeStrategy(h1);
        tileBonus.executeStrategy(h2);
        h1.accept(h2);
        ContextRound roundLogic = new ContextRound(Constants.XP_OPERATION);
        if (UtilsHero.isAlive(h1) && !UtilsHero.isAlive(h2)) {
            Log.update(h1, h2, fileWriter);
            roundLogic.doOperation(h1, h2, fileWriter);

        }
        if (!UtilsHero.isAlive(h1) && UtilsHero.isAlive(h2)) {
            Log.update(h2, h1, fileWriter);
            roundLogic.doOperation(h2, h1, fileWriter);

        }
        if (!UtilsHero.isAlive(h1) && !UtilsHero.isAlive(h2)) {
            int hardLevel = h1.getLevel();
            int auxLevel = h2.getLevel();
            Log.update(h2, h1, fileWriter);
            Log.update(h1, h2, fileWriter);
            roundLogic.doOperation(h1, h2, fileWriter);
            int newHardLevel = h1.getLevel();
            // Corner case cand amandoi se omoara si primul primeste xp, creste level, iar al doilea
            // cand isi calculeaza XP-ul trebuie sa primeasca corespunzator nivelului eroului 1
            // inainte de primirea xp-ului.
            if (newHardLevel > hardLevel) {
                h1.setLevel(newHardLevel - (newHardLevel - hardLevel));
                roundLogic.doOperation(h2, h1, fileWriter);
                h1.setLevel(newHardLevel);
                Log.update(h2, (h2.getLevel() - auxLevel), fileWriter);
                Log.update(h1, (newHardLevel - hardLevel), fileWriter);
            } else {

                roundLogic.doOperation(h2, h1, fileWriter);
            }
        }
    }

    private void printScoreboard() throws IOException {
        GameOutput.printGame(heroes, fileWriter);
    }


}
