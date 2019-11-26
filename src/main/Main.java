package main;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        GameInputLoader loader = new GameInputLoader("E:\\Java Development\\League of OOP\\in\\3x3.in", "E:\\Java Development\\League of OOP\\in\\output.txt");
        GameInput gameInput = loader.load();
        System.out.println(gameInput);
    }
}
