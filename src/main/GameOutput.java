package main;

import fileio.implementations.FileWriter;
import heroes.Hero;
import heroes.utils.UtilsHero;

import java.io.IOException;
import java.util.ArrayList;


final class GameOutput {
    private GameOutput() {

    }
    static void printGame(final String output, final ArrayList<Hero> heroes) throws IOException {
        FileWriter fileWriter = new FileWriter(output);
        // Se scrie in fisierul de output.
        try {
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
            fileWriter.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
