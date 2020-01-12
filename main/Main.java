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
                "OOP\\checkerE2\\checker\\resources\\in\\4x4.in", "E:\\Java " +
                "Development\\League of OOP\\checkerE2\\checker\\resources\\in\\out.txt");
        GameInput gameInput = loader.load();
        GameMechanics m = new GameMechanics(gameInput, loader.getmOutputPath());
        m.launchGame();
    }



}
