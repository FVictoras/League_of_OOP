package main;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        GameInputLoader loader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = loader.load();
        GameMechanics M = new GameMechanics(gameInput, loader.getmOutputPath());
        M.launchGame();
    }


}
