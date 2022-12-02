package br.inatel.cdg.model;

import br.inatel.cdg.controller.UsuárioDB;

public class Usuário {
    private String nomeCompleto;
    private String cpf;
    private int idade;
    private String celular;
    private static UsuárioDB userDB = new UsuárioDB();

    public Usuário(String nomeCompleto, String cpf, int idade, String celular) {
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

    public static String pesquisaUsuario(String cpf) {
        String result = userDB.selectCPF(cpf);

        return result;
    }
}
