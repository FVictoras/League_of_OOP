package main;

import fileio.implementations.FileWriter;
import heroes.Hero;
import heroes.utils.UtilsHero;

import java.io.IOException;
import java.util.ArrayList;


public class GameOutput {
    public static void printGame(String output, ArrayList<Hero> heroes) throws IOException {
        FileWriter fileWriter = new FileWriter(output);
        try {
            for (Hero H : heroes) {
                fileWriter.writeWord(H.emote());
                fileWriter.writeWord(" ");
                if (!UtilsHero.isAlive(H)) {
                    fileWriter.writeWord("dead");
                } else {
                    fileWriter.writeInt(H.getLevel());
                    fileWriter.writeWord(" ");
                    fileWriter.writeInt(H.getXP());
                    fileWriter.writeWord(" ");
                    fileWriter.writeInt(H.getHealth());
                    fileWriter.writeWord(" ");
                    fileWriter.writeInt(H.getxCoordonate());
                    fileWriter.writeWord(" ");
                    fileWriter.writeInt(H.getyCoordonate());
                }
            fileWriter.writeNewLine();
            }
            fileWriter.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
