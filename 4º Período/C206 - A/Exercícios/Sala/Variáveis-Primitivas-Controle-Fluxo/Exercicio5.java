import java.util.Random;
import java.util.Scanner;

public class Exercicio5 {
  public static void main(String[] args) {
    Random rand = new Random();
    Scanner input = new Scanner(System.in);
    int x = rand.nextInt(10)+1;

    System.out.println("Chute um número de 1 a 10: ");
    int y = input.nextInt();

    while(x != y){
      System.out.println("Chute um número de 1 a 10: ");
      y = input.nextInt();
    }

    System.out.println("Parabéns, você acertou!");
    input.close();
  }
}
