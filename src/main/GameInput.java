package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameInput {

    private int N, M, nPlayers, nRounds;
    private char[][] map;
    private HashMap<Integer, HashMap<String, ArrayList<Integer>>> playerOnTheMap;
    private HashMap<Integer, ArrayList<Character>> playerMoves;

    public GameInput(int n, int m, int p, int r, char[][] map, Map<Integer, HashMap<String, ArrayList<Integer>>> playerOnTheMap, Map<Integer, ArrayList<Character>> playerMoves) {
        N = n;
        M = m;
        nPlayers = p;
        nRounds = r;
        this.map = map;
        this.playerOnTheMap = (HashMap<Integer, HashMap<String, ArrayList<Integer>>>) playerOnTheMap;
        this.playerMoves = (HashMap<Integer, ArrayList<Character>>) playerMoves;
    }

    @Override
    public String toString() {
        return "Este o mapa " + N + "x" + M + " participa: " + nPlayers + " sunt " + nRounds +
                " runde" + "       " + "\n" + playerOnTheMap + "\n" + playerMoves;
    }
}
