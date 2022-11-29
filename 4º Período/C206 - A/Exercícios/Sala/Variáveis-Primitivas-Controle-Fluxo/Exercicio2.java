import java.util.Scanner;

public class Exercicio2 {
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    int lanche1 = entrada.nextInt(), lanche2 = entrada.nextInt(), lanche3 = entrada.nextInt();
    int total = lanche1 + lanche2 + lanche3;
    float media = total / 3F;

    System.out.println("Total de lanches consumidos: " + total);
    System.out.println("Média de lanches consumidos: " + media);

    entrada.close();
  }  
}