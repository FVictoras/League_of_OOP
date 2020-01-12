package main;

import angels.Angel;
import angels.AngelVisitor;
import angels.DamageAngel;
import heroes.Hero;
import heroes.Rogue;

import java.io.IOException;
import java.util.ArrayList;

public final class Main {
    private Main() {
    }
    public static void main(final String[] args) throws IOException {
        // Se citeste inputul, incepe jocul, se scriu fisierele.
        GameInputLoader loader = new GameInputLoader("E:\\Java Development\\League of " +
                "OOP\\src\\checker\\resources\\in\\fightKWL.in", "E:\\Java Development\\League of" +
                " OOP\\src\\checker\\resources\\in\\out.txt");
//        GameInputLoader loader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = loader.load();
        GameMechanics m = new GameMechanics(gameInput, loader.getmOutputPath());
        m.launchGame();
    }



}
