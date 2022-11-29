import java.util.Scanner;

public class Exercicio3 {
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    int npa, np3;
    System.out.println("Entre com a npa: ");
    npa = entrada.nextInt();

    if (npa >= 60) {
      System.out.println("Aprovado");
    } else if (npa < 60 && npa >= 30) {
      System.out.println("Ainda ha chances! Bora para NP3!");

      System.out.println("Entre com a np3: ");
      np3 = entrada.nextInt();

      if ((np3 + npa) / 2 >= 50)
        System.out.println("Aprovado");
      else
        System.out.println("Reprovado");
    }

    entrada.close();
  }
}
