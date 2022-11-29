import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Computador[] computadores = new Computador[3];
        Computador[] computadoresComprados = new Computador[10];
        int cod;
        int j = 0;

        Cliente cliente = new Cliente("Gabriel", 12345678999L);

        // entrando com os computadores
        computadores[0] = new Computador("Positivo", 1300.00F, 1);
        computadores[1] = new Computador("Acer", 1800.00F, 2);
        computadores[2] = new Computador("Vaio", 2800.00F, 3);

        // entrando com as memórias USB
        MemoriaUSB memoriaUSB1 = new MemoriaUSB("Pen-Drive", 16);
        MemoriaUSB memoriaUSB2 = new MemoriaUSB("Pen-Drive", 32);
        MemoriaUSB memoriaUSB3 = new MemoriaUSB("HD Externo", 1);

        // entrando com os hardwares
        computadores[0].addHardwareBasico("Processador Core i3", 1200);
        computadores[0].addHardwareBasico("Memória Ram", 4);
        computadores[0].addHardwareBasico("HD", 500);

        computadores[1].addHardwareBasico("Processador Core i5", 2260);
        computadores[1].addHardwareBasico("Memória Ram", 8);
        computadores[1].addHardwareBasico("HD", 1);

        computadores[2].addHardwareBasico("Processador Core i7", 3500);
        computadores[2].addHardwareBasico("Memória Ram", 16);
        computadores[2].addHardwareBasico("HD", 2);

        // entrando com os sistemas
        computadores[0].addSistema("Linux", 32);
        computadores[1].addSistema("Windows 8", 64);
        computadores[2].addSistema("Windows 10", 64);

        // adicionando as memórias USB
        computadores[0].addMemoriaUSB(memoriaUSB1);
        computadores[1].addMemoriaUSB(memoriaUSB2);
        computadores[2].addMemoriaUSB(memoriaUSB3);

        // mostrando configs dos computadores
        for (int i = 0; i < computadores.length; i++) {
            computadores[i].mostraPCConfigs();
        }

        System.out.print("Digite o código do computador que deseja comprar: ");
        cod = ler.nextInt();

        while (cod != 0) {
            computadoresComprados[j] = computadores[cod - 1];
            computadoresComprados[j].calculaPreco(cliente);
            j++;
            cod = ler.nextInt();
        }

        System.out.println("");
        System.out.println("------------------------");
        System.out.println("Computadores comprados: ");
        for (int i = 0; i < j; i++) {
            computadoresComprados[i].mostraPCConfigs();
        }
        cliente.comprou();

        ler.close();
    }
}
