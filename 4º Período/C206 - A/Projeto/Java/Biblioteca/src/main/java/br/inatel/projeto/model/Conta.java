package br.inatel.projeto.model;

public class Conta {
    private String user;
    private String senha;

    public Conta(String user, String senha) {
        this.user = user;
        this.senha = senha;
    }

    public String getUser() {
        return user;
    }

    public String getSenha() {
        return senha;
    }
}
