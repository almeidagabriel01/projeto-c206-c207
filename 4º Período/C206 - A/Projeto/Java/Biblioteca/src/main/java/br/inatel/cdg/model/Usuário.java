package br.inatel.cdg.model;

public class Usuário {
    private String nomeCompleto;
    private String cpf;
    private int idade;
    private int celular;

    public Usuário(String nomeCompleto, String cpf, int idade, int celular) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.idade = idade;
        this.celular = celular;
    }
}
