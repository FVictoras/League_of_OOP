package main;

import fileio.implementations.FileWriter;
import heroes.Hero;
import heroes.utils.UtilsHero;

import java.util.ArrayList;


final class GameOutput {
    private GameOutput() {

    }
    static void printGame(final ArrayList<Hero> heroes,
                          final  FileWriter fileWriter) {
        // Se scrie in fisierul de output.
        try {
            fileWriter.writeWord("~~ Results ~~");
            fileWriter.writeNewLine();
            for (Hero h : heroes) {
                fileWriter.writeWord(h.emote());
                fileWriter.writeWord(" ");
                if (!UtilsHero.isAlive(h)) {
                    fileWriter.writeWord("dead");
                } else {
                    fileWriter.writeInt(h.getLevel());
                    fileWriter.writeWord(" ");
                    fileWriter.writeInt(h.getXp());
                    fileWriter.writeWord(" ");
                    fileWriter.writeInt(h.getHealth());
                    fileWriter.writeWord(" ");
                    fileWriter.writeInt(h.getxCoordonate());
                    fileWriter.writeWord(" ");
                    fileWriter.writeInt(h.getyCoordonate());
                }
            fileWriter.writeNewLine();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
