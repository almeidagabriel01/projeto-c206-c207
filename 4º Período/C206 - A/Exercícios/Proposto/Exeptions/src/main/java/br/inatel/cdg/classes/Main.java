package br.inatel.cdg.classes;

import br.inatel.cdg.execptions.NotaInsuficienteUnChecked;
import br.inatel.cdg.execptions.ProjetoDuplicadoChecked;

public class Main {
    public static void main(String[] args) {
        Fetin fetin = new Fetin();

        System.out.println("Tenta adicionar projeto 1 com nota 50");
        try {
            fetin.addProjeto("Projeto 1", 50.0);
            System.out.println("Projeto 1 adicionado com sucesso!");
        } catch (ProjetoDuplicadoChecked | NotaInsuficienteUnChecked e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("Tenta adicionar projeto 2 com nota 70");
        try {
            fetin.addProjeto("Projeto 2", 70.0);
            System.out.println("Projeto 2 adicionado com sucesso!");
        } catch (ProjetoDuplicadoChecked | NotaInsuficienteUnChecked e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("Tenta adicionar projeto 2 de novo com nota 80");
        try {
            fetin.addProjeto("Projeto 2", 80.0);
            System.out.println("Projeto 2 adicionado com sucesso!");
        } catch (ProjetoDuplicadoChecked | NotaInsuficienteUnChecked e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("Tenta adicionar projeto 3 com nota 80");
        try {
            fetin.addProjeto("Projeto 3", 80.0);
            System.out.println("Projeto 3 adicionado com sucesso!");
        } catch (ProjetoDuplicadoChecked | NotaInsuficienteUnChecked e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.print("Mostra todos os projetos");
        fetin.mostrarProjetos();
        System.out.println("Final da main");
    }
}
