package Classes;

import Exceptions.NenhumaCriancaUnChecked;

public class Main {
    public static void main(String[] args) {
        Crianca c1 = new Crianca("João", 10, "Brasileiro", "Bola");
        Crianca c2 = new Crianca("Maria", 8, "Brasileira", "Boneca");
        Crianca c3 = new Crianca("Pedro", 12, "Brasileiro", "Carro");

        Elfo e1 = new Elfo("Elfo1", "Fabricante");
        Elfo e2 = new Elfo("Elfo2", "Entregador");

        Fabrica fabrica = new Fabrica();
        fabrica.novaCrianca(c1);
        fabrica.novaCrianca(c2);
        fabrica.novaCrianca(c3);

        fabrica.novaElfo(e1);
        fabrica.novaElfo(e2);

        try{
            fabrica.addBonzinho("João");
        } catch (NenhumaCriancaUnChecked e) {
            System.out.println(e.getMessage());
        }
        try{
            fabrica.addBonzinho("Maria");
        } catch (NenhumaCriancaUnChecked e) {
            System.out.println(e.getMessage());
        }
        try{
            fabrica.addBonzinho("Gustavo");
        } catch (NenhumaCriancaUnChecked e) {
            System.out.println(e.getMessage());
        }

        fabrica.listarBonzinhos();
    }
}
