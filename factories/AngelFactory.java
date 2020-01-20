package factories;

import angels.Angel;
import angels.DamageAngel;
import angels.DarkAngel;
import angels.Dracula;
import angels.GoodBoy;
import angels.LevelUpAngel;
import angels.LifeGiver;
import angels.SmallAngel;
import angels.Spawner;
import angels.TheDoomer;
import angels.XPAngel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
    Fabrica de Angel primeste de la clasa care se ocupa de cititul datelor o structura de date
    care are la baza o lista, formatul ingerilor cititi. Este prelucrata structura mare de date si
    sunt initializati pe rand ingerii conform datelor citite.
 */

public class AngelFactory {

    private static ArrayList<ArrayList<Angel>> myAngels = new ArrayList<ArrayList<Angel>>();

    public AngelFactory(final List<Map<Integer, HashMap<String, ArrayList<Integer>>>> angels)
            throws IOException {
        this.setMyAngels(angels);
    }

    public static final ArrayList<ArrayList<Angel>> getMyAngels() {
        return myAngels;
    }
    // Aici sunt initializati intr-un vector de vector toti ingerii repartizati pe runde.
    public final void setMyAngels(final List<Map<Integer,
            HashMap<String, ArrayList<Integer>>>> angels) throws IOException {
        ArrayList<Angel> arrAngels = new ArrayList<Angel>();
        Angel nullAngel = new Angel(-1, -1);
        ArrayList<Angel> nullClone = new ArrayList<Angel>();
        nullClone.add(nullAngel);
        for (Map<Integer, HashMap<String, ArrayList<Integer>>> angel : angels) {
            if (angel == null) {
                myAngels.add(nullClone);
            } else {
                Set<Map.Entry<Integer, HashMap<String, ArrayList<Integer>>>> s1 = angel.entrySet();
                for (Map.Entry<Integer, HashMap<String, ArrayList<Integer>>> it1 : s1) {
                    HashMap<String, ArrayList<Integer>> miniAngels = it1.getValue();
                    Set<Map.Entry<String, ArrayList<Integer>>> s2 = miniAngels.entrySet();
                    for (Map.Entry<String, ArrayList<Integer>> it2 : s2) {
                        arrAngels.add(this.createAngel(it2.getKey(), it2.getValue()));
                    }
                }
                ArrayList<Angel> clone = (ArrayList<Angel>) arrAngels.clone();
                myAngels.add(clone);
            }
            arrAngels.clear();
        }
    }
    // Aici ingerii sunt creati ca obiecte.
    public final Angel createAngel(final String type, final ArrayList<Integer> coord) throws
            IOException {
        if (type.equals("DamageAngel")) {
            return new DamageAngel(coord.get(0), coord.get(1));
        }
        if (type.equals("DarkAngel")) {
            return new DarkAngel(coord.get(0), coord.get(1));
        }
        if (type.equals("Dracula")) {
            return new Dracula(coord.get(0), coord.get(1));
        }
        if (type.equals("GoodBoy")) {
            return new GoodBoy(coord.get(0), coord.get(1));
        }
        if (type.equals("LevelUpAngel")) {
            return new LevelUpAngel(coord.get(0), coord.get(1));
        }
        if (type.equals("LifeGiver")) {
            return new LifeGiver(coord.get(0), coord.get(1));
        }
        if (type.equals("SmallAngel")) {
            return new SmallAngel(coord.get(0), coord.get(1));
        }
        if (type.equals("Spawner")) {
            return new Spawner(coord.get(0), coord.get(1));
        }
        if (type.equals("TheDoomer")) {
            return new TheDoomer(coord.get(0), coord.get(1));
        }
        if (type.equals("XPAngel")) {
            return new XPAngel(coord.get(0), coord.get(1));
        }
        return null;
    }

}
