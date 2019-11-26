package factories;

import heroes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PlayerFactory {
    private HashMap<Integer, HashMap<String, ArrayList<Integer>>> map;

    /**
     * Se primeste HashMapul cu jucatorii cititi. Acestia se initializeaza si se
     * returneaza un ArrayList cu obiectele instantiate.
     */
    public PlayerFactory(HashMap<Integer, HashMap<String, ArrayList<Integer>>> map) {
        this.map = map;
    }

    public ArrayList<Hero> allHeroes() {
        ArrayList<Hero> myHeroes = new ArrayList<Hero>();
        Set<Map.Entry<Integer, HashMap<String, ArrayList<Integer>>>> s1 = map.entrySet();
        for (Map.Entry<Integer, HashMap<String, ArrayList<Integer>>> it1 : s1) {
            HashMap<String, ArrayList<Integer>> miniMap = it1.getValue();
            Set<Map.Entry<String, ArrayList<Integer>>> s2 = miniMap.entrySet();
            for (Map.Entry<String, ArrayList<Integer>> it2 : s2) {
                myHeroes.add(this.createHero(it2.getKey(), it2.getValue()));
            }
        }
        return myHeroes;
    }

    /**
     * Se creeaza instanta corespunzatoare fiecarui erou.
     */
    private Hero createHero(String heroType, ArrayList<Integer> coordinates) {
        if (heroType == null) {
            return null;
        } else {
            try {
                if (heroType.equals("P")) {
                    return new Pyromancer(coordinates.get(0), coordinates.get(1));
                }
                if (heroType.equals("W")) {
                    return new Wizard(coordinates.get(0), coordinates.get(1));
                }
                if (heroType.equals("R")) {
                    return new Rogue(coordinates.get(0), coordinates.get(1));
                }
                if (heroType.equals("K")) {
                    return new Knight(coordinates.get(0), coordinates.get(1));
                }
            } catch (Exception e) {
                System.out.println("EROARE");
            }
        }
        return null;
    }
}
