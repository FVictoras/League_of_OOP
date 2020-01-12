package main;

import angels.*;
import heroes.Hero;

import fileio.implementations.FileWriter;
import java.io.IOException;

public class Log {

    public static void update(int i, String output) throws IOException {
        FileWriter fileWriter = new FileWriter(output);
        fileWriter.writeWord("~~ ROUND ");
        fileWriter.writeInt(i);
        fileWriter.writeWord(" ~~");
        fileWriter.writeNewLine();
        fileWriter.close();
    }
    public static void update(Hero h, String output) throws IOException {
        FileWriter fileWriter = new FileWriter(output);
        fileWriter.writeWord(h.toString());
        fileWriter.writeWord(" ");
        fileWriter.writeInt(h.getId());
        fileWriter.writeWord(" reached level ");
        fileWriter.writeInt(h.getLevel());
        fileWriter.writeNewLine();
        fileWriter.close();

    }
    public static void update(Angel a, String output) throws IOException {
        FileWriter fileWriter = new FileWriter(output);
        fileWriter.writeWord("Angel ");
        fileWriter.writeWord(a.toString());
        fileWriter.writeWord(" was spawned at ");
        fileWriter.writeInt(a.getxCoordonate());
        fileWriter.writeWord(" ");
        fileWriter.writeInt(a.getxCoordonate());
        fileWriter.writeNewLine();
        fileWriter.close();

    }
    public static void update(Angel a, Hero h, String output) throws IOException {
        FileWriter fileWriter = new FileWriter(output);
        if (a instanceof DamageAngel || a instanceof GoodBoy || a instanceof LevelUpAngel ||
                a instanceof LifeGiver || a instanceof SmallAngel || a instanceof Spawner ||
                a instanceof XPAngel) {
            fileWriter.writeWord(a.toString());
            fileWriter.writeWord(" helped ");
            fileWriter.writeWord(h.toString());
            fileWriter.writeWord(" ");
            fileWriter.writeInt(h.getId());
            fileWriter.writeNewLine();
            fileWriter.close();

        } else {
            fileWriter.writeWord(a.toString());
            fileWriter.writeWord(" hit ");
            fileWriter.writeWord(h.toString());
            fileWriter.writeWord(" ");
            fileWriter.writeInt(h.getId());
            fileWriter.writeNewLine();
            fileWriter.close();
        }
    }
    public static void update(Hero h1, Hero h2, String output) throws IOException {
        FileWriter fileWriter = new FileWriter(output);
        fileWriter.writeWord("Player ");
        fileWriter.writeWord(h2.toString());
        fileWriter.writeWord(" ");
        fileWriter.writeInt(h2.getId());
        fileWriter.writeWord(" was killed by ");
        fileWriter.writeWord(h1.toString());
        fileWriter.writeWord(" ");
        fileWriter.writeInt(h1.getId());
        fileWriter.writeNewLine();
        fileWriter.close();

    }
    public static void update(Hero h, int i, String output) throws IOException {
        FileWriter fileWriter = new FileWriter(output);
        for (int j = i; j > 0; j--){
            fileWriter.writeWord(h.toString());
            fileWriter.writeWord(" ");
            fileWriter.writeInt(h.getId());
            fileWriter.writeWord(" reached level ");
            fileWriter.writeInt(h.getLevel()-j+1);
            fileWriter.writeNewLine();
        }
        fileWriter.close();
    }
}
