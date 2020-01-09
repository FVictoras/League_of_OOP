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
                "OOP\\checkerE2\\checker\\resources\\in\\fightKRL.in", "E:\\Java " +
                "Development\\League of OOP\\checkerE2\\checker\\resources\\in\\out.txt");
        GameInput gameInput = loader.load();
        GameMechanics m = new GameMechanics(gameInput, loader.getmOutputPath());
        m.launchGame();
        ArrayList<Angel> angels = new ArrayList<Angel>();
        angels.add(new DamageAngel(1,2));
        System.out.println(angels.get(0));
        ArrayList<AngelVisitor> angelsVisitors = new ArrayList<AngelVisitor>();
        angelsVisitors.add(new DamageAngel(1,4));
        System.out.println(angelsVisitors.get(0));
        Hero salut = new Rogue(1,2);
        angelsVisitors.get(0).visit(salut);
    }



}
