package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameInput {

    private int N, M, nPlayers, nRounds;
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
    public GameInput(int n, int m, int p, int r, char[][] map, Map<Integer, HashMap<String,
            ArrayList<Integer>>> playerOnTheMap, Map<Integer, ArrayList<Character>> playerMoves) {
        N = n;
        M = m;
        nPlayers = p;
        nRounds = r;
        this.map = map;
        this.playerOnTheMap =
                (HashMap<Integer, HashMap<String, ArrayList<Integer>>>) playerOnTheMap;
        this.playerMoves = (HashMap<Integer, ArrayList<Character>>) playerMoves;
    }

    public int getN() {
        return N;
    }

    public int getM() {
        return M;
    }

    public int getnPlayers() {
        return nPlayers;
    }

    public int getnRounds() {
        return nRounds;
    }

    public char[][] getMap() {
        return map;
    }

    public HashMap<Integer, HashMap<String, ArrayList<Integer>>> getPlayerOnTheMap() {
        return playerOnTheMap;
    }

    public HashMap<Integer, ArrayList<Character>> getPlayerMoves() {
        return playerMoves;
    }

    private HashMap<Integer, ArrayList<Character>> playerMoves;
}
