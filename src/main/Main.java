package main;

import factories.PlayerFactory;
import heroes.Hero;
import heroes.Pyromancer;
import heroes.tilebonuses.Context;

import java.util.ArrayList;

class Tester {
    public static void printInputPage(GameInput gameInput) {
        System.out.println(gameInput);
        gameInput.getPlayerOnTheMap();
        char[][] map = gameInput.getMap();
        for (int i = 0; i < gameInput.getN(); i++) {
            for (int j = 0; j < gameInput.getM(); j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}

public class Main {

    public static void main(String[] args) {
        GameInputLoader loader = new GameInputLoader("E:\\Java Development\\League of " + "OOP" +
                "\\in\\4x4.in", "E:\\Java Development\\League of OOP\\in\\output.txt");
        GameInput gameInput = loader.load();
        Tester.printInputPage(gameInput);
        PlayerFactory factory = new PlayerFactory(gameInput.getPlayerOnTheMap());
        ArrayList<Hero> myHeroes = factory.allHeroes();
        for (Hero a : myHeroes) {
            System.out.println(a.emote() + " " + a.getxCoordonate() + " " + a.getyCoordonate() +
                    "   am viata: " + a.getHealth() + "hp");
        }
        Context context = new Context('W');
        context.executeStrategy(myHeroes.get(0));
        context.executeStrategy(myHeroes.get(1));
        myHeroes.get(0).accept(myHeroes.get(1));
        System.out.println("P " + myHeroes.get(0).getHealth() + " K" + myHeroes.get(1).getHealth());

//        System.out.println(((Pyromancer) myHeroes.get(0)).Fireblast());
    }


}
