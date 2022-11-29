import java.util.Scanner;

public class Exercício2 {

  static float calc (float  nota1, float nota2, float nota3)
  {
    float media;
    media = ((nota1 * 2) + (nota2 * 3) + (nota3 * 5)) / 10f;
    return media;
  }
  public static void main(String[] args) {
    float nota1, nota2, nota3;
    float total;

    Scanner input = new Scanner(System.in);
    nota1 = input.nextFloat();
    nota2 = input.nextFloat();
    nota3 = input.nextFloat();

    total = calc(nota1, nota2, nota3);
    System.out.println(String.format("A média do aluno é: %.1f",total));

    input.close();
  }
}
