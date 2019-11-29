package main;

import factories.PlayerFactory;
import heroes.Hero;

import java.util.ArrayList;
import java.util.HashMap;

public class GameMechanics {
    private ArrayList<Hero> heroes;
    private char[][] map;
    private HashMap<Integer, ArrayList<Character>> moves;
    private int numberOfRounds;
    private int numberOfPlayers;
    private int nColumn;
    private int nRows;

    public GameMechanics(GameInput gameInput) {
        this.heroes = (new PlayerFactory(gameInput.getPlayerOnTheMap())).allHeroes();
        this.map = gameInput.getMap();
        this.moves = gameInput.getPlayerMoves();
        this.numberOfRounds = gameInput.getnRounds();
        this.numberOfPlayers = gameInput.getnPlayers();
        this.nColumn = gameInput.getN();
        this.nRows = gameInput.getM();
    }



}
