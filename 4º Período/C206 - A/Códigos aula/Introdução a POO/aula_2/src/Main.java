public class Main {
    public static void main(String[] args) {
        Conta c1 = new Conta();
        c1.saldo = 1000;
        c1.nomeDoDono = "Joaquina";
        c1.numero = 1234;
        c1.limite = 10000;

        Conta c2 = new Conta();
        c2.nomeDoDono = "Roberval";
        c2.saldo = 2000;
        c2.limite = 10000;
        c2.numero = 12345;

        System.out.println("O dono da conta 1 eh: " + c1.nomeDoDono);
        System.out.println("O dono da conta 2 eh: " + c2.nomeDoDono);
        System.out.println("O saldo da conta 1 eh: " + c1.saldo);

        c1.deposita(1000);

        System.out.println("O novo saldo da conta 1 eh: " + c1.saldo);

    }
}
