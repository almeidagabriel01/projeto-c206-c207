
public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("João", 123456789);
        Cliente cliente2 = new Cliente("Maria", 987654321);
        Cliente cliente3 = null;
        Conta conta1 = new Conta(1000, 1000);
        Conta conta2 = new Conta(2000, 2000);
        Conta conta3 = new Conta(3000, 3000);

        conta1.addCliente(cliente1);
        conta2.addCliente(cliente2);
        conta3.addCliente(cliente3);

        conta1.sacar(950);
        conta2.sacar(2000);
        conta3.sacar(3000);

        conta1.mostraInfo();
        conta2.mostraInfo();
        conta3.mostraInfo();
    }
}
