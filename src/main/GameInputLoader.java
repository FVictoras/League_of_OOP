package main;

import fileio.FileSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String mInputPath, final String mOutputPath) {
        this.mInputPath = mInputPath;
        this.mOutputPath = mOutputPath;
    }

    public GameInput load() {
        int N = 0;
        int M = 0;
        int P = 0;
        int R = 0;
        Map<Integer, HashMap<String, ArrayList<Integer>>> playerOnTheMap =  new HashMap<Integer,
                HashMap<String, ArrayList<Integer>>>();
        Map<Integer, ArrayList<Character>> playerMoves  = new HashMap<Integer,
                ArrayList<Character>>();
        String playerType = null;
        char[][] gameMap = new char[0][];
        ArrayList<Integer> coordonates = new ArrayList<Integer>(2);
        try {
            FileSystem file = new FileSystem(mInputPath, mOutputPath);
            N = file.nextInt();
            M = file.nextInt();
            gameMap =  new char[N][M];
            for (int i = 0; i < N; i++) {
                String myString = file.nextWord();
                for (int j = 0; j < M; j++) {
                    gameMap[i][j] = myString.charAt(j);
                }
            }
            P = file.nextInt();
            System.out.println(P);
            for (int i = 0; i < P; i++) {
                playerType = file.nextWord();
                coordonates.add(file.nextInt());
                coordonates.add(file.nextInt());
                String finalPlayerType = playerType;
                playerOnTheMap.put(i,
                        new HashMap<String, ArrayList<Integer>>() {{ put(finalPlayerType
                        , new ArrayList<Integer>(coordonates)); }});
                coordonates.clear();
            }
            ArrayList<Character> moves = new ArrayList<Character>();
            R = file.nextInt();
            for (int i = 0; i < R; i++) {
                String myString = file.nextWord();
                for (int j = 0; j < P; j++) {
                    moves.add(myString.charAt(j));
                }
                playerMoves.put(i, new ArrayList<Character>(moves));
                moves.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new GameInput(N, M, P, R, gameMap, playerOnTheMap, playerMoves);
    }

}
