package main;

import fileio.FileSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class GameInputLoader {
    private final String mInputPath;

    String getmOutputPath() {
        return mOutputPath;
    }

    private final String mOutputPath;

    GameInputLoader(final String mInputPath, final String mOutputPath) {
        this.mInputPath = mInputPath;
        this.mOutputPath = mOutputPath;
    }

    /**
     * Fac citirea, stochez Eroii intr-un Hashmap<Index , Hashmap<Tip_Erou, Coordonate>>.
     * Harta este intr-o matrice de charuri
     * Mutarile care trebuiesc facute de jucatori sunt scrise ca Hashmap <Runda, Arraylist<mutari>>
     */
    GameInput load() {
        int n = 0;
        int m = 0;
        int p = 0;
        int r = 0;
        Map<Integer, HashMap<String, ArrayList<Integer>>> playerOnTheMap = new HashMap<Integer,
                HashMap<String, ArrayList<Integer>>>();
        Map<Integer, ArrayList<Character>> playerMoves = new HashMap<Integer,
                ArrayList<Character>>();
        String playerType = null;
        char[][] gameMap = new char[0][];
        ArrayList<Integer> coordonates = new ArrayList<Integer>(2);
        try {
            FileSystem file = new FileSystem(mInputPath, mOutputPath);
            n = file.nextInt();
            m = file.nextInt();
            gameMap = new char[n][m];
            for (int i = 0; i < n; i++) {
                String myString = file.nextWord();
                for (int j = 0; j < m; j++) {
                    gameMap[i][j] = myString.charAt(j);
                }
            }
            p = file.nextInt();
            for (int i = 0; i < p; i++) {
                playerType = file.nextWord();
                coordonates.add(file.nextInt());
                coordonates.add(file.nextInt());
                String finalPlayerType = playerType;
                playerOnTheMap.put(i, new HashMap<String, ArrayList<Integer>>() {{
                    put(finalPlayerType, new ArrayList<Integer>(coordonates));
                }});
                coordonates.clear();
            }
            ArrayList<Character> moves = new ArrayList<Character>();
            r = file.nextInt();
            for (int i = 0; i < r; i++) {
                String myString = file.nextWord();
                for (int j = 0; j < p; j++) {
                    moves.add(myString.charAt(j));
                }
                playerMoves.put(i, new ArrayList<Character>(moves));
                moves.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new GameInput(n, m, p, r, gameMap, playerOnTheMap, playerMoves);
    }

}
