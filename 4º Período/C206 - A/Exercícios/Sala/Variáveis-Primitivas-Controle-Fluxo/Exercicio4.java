import java.util.Scanner;

public class Exercicio4 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int alunos = input.nextInt();

    switch (alunos){
      case 10:
      case 20:
        System.out.println("A sala utilizada é a l-16.");
        break;
      case 30:
        System.out.println("A sala utilizada é a l-22");
        break;
      default:
        System.out.println("Tente novamente.");
        break;
    }
    input.close();
  }
}
