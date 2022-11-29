package br.inatel.cdg.classes;
import br.inatel.cdg.execptions.NotaInsuficienteUnChecked;
import br.inatel.cdg.execptions.ProjetoDuplicadoChecked;

import java.util.HashMap;
import java.util.Map;

public class Fetin {
    private Map<String, Double> projetos = new HashMap<>();

    public void addProjeto(String nome, Double valor) throws ProjetoDuplicadoChecked, NotaInsuficienteUnChecked {
        if(projetos.containsKey(nome)) {
            throw new ProjetoDuplicadoChecked("Projeto com nome já cadastrado!");
        } else {
            if(valor >= 60) {
                projetos.put(nome, valor);
            } else {
                throw new NotaInsuficienteUnChecked("Nota insuficiente para ser aprovado na Fetin");
            }
        }
    }

    public void mostrarProjetos() {
        projetos.forEach((nome, nota) -> {
            System.out.println(" ");
            System.out.println("Nome: " + nome);
            System.out.println("Nota: " + nota);
            System.out.println(" ");
        });
    }
}
