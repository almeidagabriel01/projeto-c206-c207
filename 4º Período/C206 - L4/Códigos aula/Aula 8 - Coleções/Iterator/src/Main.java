import java.util.Iterator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> frutas = new HashSet<String>();
        frutas.add("banana");
        frutas.add("maçã");
        frutas.add("uva");
        System.out.println(frutas);
        Iterator<String> it = frutas.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
