package br.inatel.projeto.model;

import br.inatel.projeto.controller.UsuarioDB;

public class Usuario {
    private String nomeCompleto;
    private String cpf;
    private int idade;
    private String celular;
    private static UsuarioDB userDB = new UsuarioDB();

    public Usuario(String nomeCompleto, String cpf, int idade, String celular) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.idade = idade;
        this.celular = celular;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public String getCelular() {
        return celular;
    }
}
