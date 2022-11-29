import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> frutas = new ArrayList<String>();
        frutas.add("banana");
        frutas.add("maçã");
        frutas.add("uva");

        frutas.set(0, "laranja");
        frutas.remove(1);

        System.out.println(frutas);
    }
}
