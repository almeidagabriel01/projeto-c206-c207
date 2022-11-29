import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Kart, motor e piloto 1
        Piloto piloto1 = new Piloto();
        Kart kart1 = new Kart();

        // Kart, motor e piloto 2
        Piloto piloto2 = new Piloto();
        Kart kart2 = new Kart();

        Scanner scanner = new Scanner(System.in);

        // associando os karts com os pilotos
        kart1.piloto = piloto1;
        kart2.piloto = piloto2;

        // membros da instancia do piloto 1
        System.out.print("Nome do primeiro piloto: ");
        piloto1.nome = scanner.nextLine();

        piloto1.vilao = true;
        kart1.nome = "Kart 1";

        System.out.print("Cilindradas do primeiro kart: ");
        kart1.motor.cilindradas = scanner.nextLine();

        System.out.print("Velocidade maxima do primeiro kart: ");
        kart1.motor.velocidadeMaxima = scanner.nextFloat();
        scanner.nextLine(); // esvaziando o buffer do teclado


        // membros da instancia do piloto 2
        System.out.print("Nome do segundo piloto: ");
        piloto2.nome = scanner.nextLine();

        piloto2.vilao = true;
        kart2.nome = "Kart 2";

        System.out.print("Cilindradas do segundo kart: ");
        kart2.motor.cilindradas = scanner.nextLine();

        System.out.print("Velocidade maxima do segundo kart: ");
        kart2.motor.velocidadeMaxima = scanner.nextFloat();
        scanner.nextLine(); // esvaziando o buffer do teclado


        // vendo as informações de cada motor
        System.out.println("Motor do kart 1: ");
        kart1.motor.mostraInfo();
        System.out.println("Motor do kart 2: ");
        kart2.motor.mostraInfo();

        System.out.println("");
        
        // executando as ações
        piloto1.soltaSuperPoder();
        kart2.pular();
        kart1.soltarTurbo();
        piloto2.soltaSuperPoder();
        kart2.soltarTurbo();
        kart1.fazerDrift();

        scanner.close();
    }
}
