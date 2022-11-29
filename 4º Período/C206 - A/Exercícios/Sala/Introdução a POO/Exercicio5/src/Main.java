import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Personagem personagem = new Personagem();
        personagem.arma = new Arma();
        Scanner scanner = new Scanner(System.in);

        personagem.arma.poder = 2;
        personagem.arma.resistencia = 10;
        personagem.pontos = 50;

        System.out.println("Digite o nome do personagem: ");
        personagem.nome = scanner.nextLine();

        System.out.println("Digite o nome da arma: ");
        personagem.arma.nome = scanner.nextLine();

        System.out.println("Digite a durabilidade da arma: ");
        personagem.arma.durabilidade = scanner.nextLine();

        personagem.usarArma();
        personagem.tomarDano();

        personagem.arma.mostraInfoArma();

        scanner.close();
    }
}
