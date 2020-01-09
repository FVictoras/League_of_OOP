package factories;

import angels.*;

import java.lang.reflect.Array;
import java.util.*;
import java.util.logging.Level;

public class AngelFactory {

    private ArrayList<ArrayList<Angel>> myAngels2 = new ArrayList<ArrayList<Angel>>(5);

    public AngelFactory(List<Map<Integer, HashMap<String, ArrayList<Integer>>>> angels) {
        this.setMyAngels(angels);
    }

    public final ArrayList<ArrayList<Angel>> getMyAngels() {
        return myAngels2;
    }

    public void setMyAngels(List<Map<Integer, HashMap<String, ArrayList<Integer>>>> angels) {
        ArrayList<Angel> arrAngels = new ArrayList<Angel>();
        ArrayList<ArrayList<Angel>> myAngels = new ArrayList<ArrayList<Angel>>(10);
        for (int i = 0; i < angels.size(); i++) {
            if (angels.get(i) == null) {
                myAngels.add(0, null);
            } else {
                Set<Map.Entry<Integer, HashMap<String, ArrayList<Integer>>>> s1 = angels.get(i).entrySet();
                for (Map.Entry<Integer, HashMap<String, ArrayList<Integer>>> it1 : s1) {
                    HashMap<String, ArrayList<Integer>> miniAngels = it1.getValue();
                    Set<Map.Entry<String, ArrayList<Integer>>> s2 = miniAngels.entrySet();
                    for (Map.Entry<String, ArrayList<Integer>> it2 : s2) {
                        System.out.println(it2.getKey() + it2.getValue());
                        arrAngels.add(this.createAngel(it2.getKey(), it2.getValue()));
                    }
                }
            }
            ArrayList<Angel> clone = (ArrayList<Angel>) arrAngels.clone();
            myAngels.add(clone);
            arrAngels.clear();
        }
        System.out.println(myAngels);
    }

    public final Angel createAngel(String type, ArrayList<Integer> coord) {
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
        return null;
    }

}
