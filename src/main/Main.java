package main;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        GameInputLoader loader = new GameInputLoader("E:\\Java Development\\League of " +
                "OOP\\in\\3x3.in", "E:\\Java Development\\League of OOP\\in\\output.txt");
        GameInput gameInput = loader.load();
        GameMechanics M = new GameMechanics(gameInput, loader.getmOutputPath());
        M.launchGame();
    }


}
