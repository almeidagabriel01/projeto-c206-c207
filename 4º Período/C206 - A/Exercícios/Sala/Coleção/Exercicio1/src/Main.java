import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        double x1 = Math.random();
        double x2 = Math.random();
        double x3 = Math.random();
        double x4 = Math.random();
        double x5 = Math.random();

        list.add(x1);
        list.add(x2);
        list.add(x3);
        list.add(x4);
        list.add(x5);

        Collections.sort(list, Collections.reverseOrder());

        for (Double num : list) {
            System.out.println(num);
        }

    }
}
