package main;

import angels.LifeGiver;
import angels.SmallAngel;
import angels.Spawner;
import angels.XPAngel;
import angels.LevelUpAngel;
import angels.GoodBoy;
import angels.DamageAngel;
import angels.Angel;

import heroes.Hero;

import fileio.implementations.FileWriter;
import java.io.IOException;

/*
    Acesta este implementarea logului, care scrie mesaje in output. Plecand de la Patternul
    Observer, am ajuns la aceasta adaptare considerand-o cea mai potrivita contextului dat de
    problema. Are functii de update, overloaduite astfel incat sa suporte orice context de update.
 */
public final class Log {
    private Log() {
    }

    public static void update(final int i, final FileWriter fileWriter) throws IOException {
        fileWriter.writeWord("~~ Round ");
        fileWriter.writeInt(i);
        fileWriter.writeWord(" ~~");
        fileWriter.writeNewLine();
    }
    public static void update(final Hero h, final FileWriter fileWriter) throws IOException {
        fileWriter.writeWord(h.toString());
        fileWriter.writeWord(" ");
        fileWriter.writeInt(h.getId());
        fileWriter.writeWord(" reached level ");
        fileWriter.writeInt(h.getLevel());
        fileWriter.writeNewLine();

    }
    public static void update(final Angel a, final FileWriter fileWriter) throws IOException {
        fileWriter.writeWord("Angel ");
        fileWriter.writeWord(a.toString());
        fileWriter.writeWord(" was spawned at ");
        fileWriter.writeInt(a.getxCoordonate());
        fileWriter.writeWord(" ");
        fileWriter.writeInt(a.getyCoordonate());
        fileWriter.writeNewLine();

    }
    public static void update(final Angel a, final Hero h, final FileWriter fileWriter)
            throws IOException {
        if (a instanceof DamageAngel || a instanceof GoodBoy || a instanceof LevelUpAngel
                || a instanceof LifeGiver || a instanceof SmallAngel || a instanceof Spawner
                || a instanceof XPAngel) {
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
    public static void update(final Hero h1, final Hero h2, final FileWriter fileWriter)
            throws IOException {
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
    public static void update(final Hero h, final int i, final FileWriter fileWriter)
            throws IOException {
        for (int j = i; j > 0; j--) {
            fileWriter.writeWord(h.toString());
            fileWriter.writeWord(" ");
            fileWriter.writeInt(h.getId());
            fileWriter.writeWord(" reached level ");
            fileWriter.writeInt(h.getLevel() - j + 1);
            fileWriter.writeNewLine();
        }
    }

    public static void updateA(final Hero h, final FileWriter fileWriter) throws IOException {
        fileWriter.writeWord("Player ");
        fileWriter.writeWord(h.toString());
        fileWriter.writeWord(" ");
        fileWriter.writeInt(h.getId());
        fileWriter.writeWord(" was killed by an angel");
        fileWriter.writeNewLine();
    }

    public static void updateB(final Hero h, final FileWriter fileWriter) throws IOException {
        fileWriter.writeWord("Player ");
        fileWriter.writeWord(h.toString());
        fileWriter.writeWord(" ");
        fileWriter.writeInt(h.getId());
        fileWriter.writeWord(" was brought to life by an angel");
        fileWriter.writeNewLine();
    }

}
