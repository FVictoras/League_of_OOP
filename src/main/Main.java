package main;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        GameInputLoader loader = new GameInputLoader("E:\\Java Development\\League of " +
                "OOP\\in\\4x4.in", "E:\\Java Development\\League of OOP\\in\\output.txt");
        GameInput gameInput = loader.load();
        System.out.println(gameInput);
        char[][] map = gameInput.getMap();
        for (int i = 0; i < gameInput.getN(); i++) {
            for (int j = 0; j<gameInput.getM(); j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
