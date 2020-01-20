package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class GameInput {

    private int n, m, nPlayers, nRounds;
    private char[][] map;
    private HashMap<Integer, HashMap<String, ArrayList<Integer>>> playerOnTheMap;

    /**
     * @param n              nr_randuri
     * @param m              nr_coloane
     * @param p              nr_playeri
     * @param r              nr_runde
     * @param map            matricea hartii
     * @param playerOnTheMap jucatorii + coordonatele lor
     * @param playerMoves    mutarile jucatorilor
     */
    GameInput(final int n, final int m, final int p, final int r, final char[][] map,
              final Map<Integer, HashMap<String, ArrayList<Integer>>> playerOnTheMap,
              final Map<Integer, ArrayList<Character>> playerMoves) {
        this.n = n;
        this.m = m;
        nPlayers = p;
        nRounds = r;
        this.map = map;
        this.playerOnTheMap =
                (HashMap<Integer, HashMap<String, ArrayList<Integer>>>) playerOnTheMap;
        this.playerMoves = (HashMap<Integer, ArrayList<Character>>) playerMoves;
    }

    int getN() {
        return n;
    }

    int getM() {
        return m;
    }

    int getnRounds() {
        return nRounds;
    }

    char[][] getMap() {
        return map;
    }

    HashMap<Integer, HashMap<String, ArrayList<Integer>>> getPlayerOnTheMap() {
        return playerOnTheMap;
    }

    HashMap<Integer, ArrayList<Character>> getPlayerMoves() {
        return playerMoves;
    }

    private HashMap<Integer, ArrayList<Character>> playerMoves;
}
