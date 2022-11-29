package Classes;

import Exceptions.JaAdicionadoUnChecked;

public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Joao", 20, "Programador");
        Pessoa p2 = new Pessoa("Maria", 30, "Engenheira");
        Pessoa p3 = new Pessoa("Kleber", 40, "Detetive");

        Misterio m = new Misterio(1, "São Paulo", "Achar o Fred");

        try {
            m.adicionarSuspeito(p1);
        } catch (JaAdicionadoUnChecked e) {
            System.out.println(e.getMessage());
        }

        try {
            m.adicionarSuspeito(p2);
        } catch (JaAdicionadoUnChecked e) {
            System.out.println(e.getMessage());
        }

        try {
            m.adicionarSuspeito(p2);
        } catch (JaAdicionadoUnChecked e) {
            System.out.println(e.getMessage());
        }

        try {
            m.adicionarSuspeito(p3);
        } catch (JaAdicionadoUnChecked e) {
            System.out.println(e.getMessage());
        }

        m.adicionarPista("Não está nessa cidade");
        m.adicionarPista("Está em uma faculdade");

        m.gravarInformacoes();
        m.lerInformacoes();
    }
}