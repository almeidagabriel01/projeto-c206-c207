import java.util.Scanner;

public class Exercício1 {

  static float calc (float raio, float pi)
  {
    float area;
    area = pi * (raio * raio);
    return area;
  }
  public static void main(String[] args) {
    float raio, res;
    float pi = 3.14f;
    
    Scanner input = new Scanner(System.in);
    raio = input.nextFloat();
    res = calc(raio, pi);

    System.out.println("A área do círculo é: " + res);

    input.close();
  }
}
