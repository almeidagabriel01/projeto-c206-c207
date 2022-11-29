import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        Map <String, Integer> mapa1 = new HashMap<String, Integer>();
        mapa1.put("one", 1);
        mapa1.put("two", 2);

        System.out.println(mapa1.get("one"));

        for(String key : mapa1.keySet()) {
            System.out.println(key);
        }*/

        Set<String> set = new HashSet<String>();
        set.add("Londrina");
        set.add("Curitiba");
        set.add("São Paulo");
        set.add("Rio de Janeiro");
        System.out.println(set);
        /*
        set.remove("Londrina");
        System.out.println(set);
        System.out.println(set.size());
        set.clear();
        System.out.println(set);
        System.out.println(set.size()); 
        */

        for(String cidades : set) {
            System.out.println(cidades);
        }
    }
}
