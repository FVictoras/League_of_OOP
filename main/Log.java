package main;

import angels.*;
import heroes.Hero;

import fileio.implementations.FileWriter;
import java.io.IOException;

public class Log {

    public static void updateA(Hero h, FileWriter fileWriter) throws IOException {
        fileWriter.writeWord("Player ");
        fileWriter.writeWord(h.toString());
        fileWriter.writeWord(" ");
        fileWriter.writeInt(h.getId());
        fileWriter.writeWord(" was killed by an angel");
        fileWriter.writeNewLine();
    }

    public static void update(int i, FileWriter fileWriter) throws IOException {
        fileWriter.writeWord("~~ Round ");
        fileWriter.writeInt(i);
        fileWriter.writeWord(" ~~");
        fileWriter.writeNewLine();
    }
    public static void update(Hero h, FileWriter fileWriter) throws IOException {
        fileWriter.writeWord(h.toString());
        fileWriter.writeWord(" ");
        fileWriter.writeInt(h.getId());
        fileWriter.writeWord(" reached level ");
        fileWriter.writeInt(h.getLevel());
        fileWriter.writeNewLine();

    }
    public static void update(Angel a, FileWriter fileWriter) throws IOException {
        fileWriter.writeWord("Angel ");
        fileWriter.writeWord(a.toString());
        fileWriter.writeWord(" was spawned at ");
        fileWriter.writeInt(a.getxCoordonate());
        fileWriter.writeWord(" ");
        fileWriter.writeInt(a.getyCoordonate());
        fileWriter.writeNewLine();

    }
    public static void update(Angel a, Hero h, FileWriter fileWriter) throws IOException {
        if (a instanceof DamageAngel || a instanceof GoodBoy || a instanceof LevelUpAngel ||
                a instanceof LifeGiver || a instanceof SmallAngel || a instanceof Spawner ||
                a instanceof XPAngel) {
            fileWriter.writeWord(a.toString());
            fileWriter.writeWord(" helped ");
            fileWriter.writeWord(h.toString());
            fileWriter.writeWord(" ");
            fileWriter.writeInt(h.getId());
            fileWriter.writeNewLine();

        } else {
            fileWriter.writeWord(a.toString());
            fileWriter.writeWord(" hit ");
            fileWriter.writeWord(h.toString());
            fileWriter.writeWord(" ");
            fileWriter.writeInt(h.getId());
            fileWriter.writeNewLine();
        }
    }
    public static void update(Hero h1, Hero h2, FileWriter fileWriter) throws IOException {
        fileWriter.writeWord("Player ");
        fileWriter.writeWord(h2.toString());
        fileWriter.writeWord(" ");
        fileWriter.writeInt(h2.getId());
        fileWriter.writeWord(" was killed by ");
        fileWriter.writeWord(h1.toString());
        fileWriter.writeWord(" ");
        fileWriter.writeInt(h1.getId());
        fileWriter.writeNewLine();

    }
    public static void update(Hero h, int i, FileWriter fileWriter) throws IOException {
        for (int j = i; j > 0; j--){
            fileWriter.writeWord(h.toString());
            fileWriter.writeWord(" ");
            fileWriter.writeInt(h.getId());
            fileWriter.writeWord(" reached level ");
            fileWriter.writeInt(h.getLevel()-j+1);
            fileWriter.writeNewLine();
        }
    }
}
