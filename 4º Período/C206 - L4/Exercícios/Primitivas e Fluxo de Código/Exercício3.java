import java.util.Scanner;

public class Exercício3 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int num = 0;

    do {
      System.out.println("Digite um número: ");
      num = input.nextInt();
    } while (!(num > 1 && num < 1000));

    for (int i = 1; i <= num; i++)
      if (i % 2 != 0)
        System.out.println(i);

    input.close();
  }
}