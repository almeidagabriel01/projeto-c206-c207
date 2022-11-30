package br.inatel.cdg.model;

import java.util.List;

public class Conta {
    private int idConta;
    private String user;
    private String senha;
    private Usuário usuário;
    private Acervo acervo;
    private List<Livro> livros;

    private Empréstimo empréstimo;

    public Conta(String user, String senha) {
        this.user = user;
        this.senha = senha;
    }

    public void VerificaLogin(String user, String senha) {
        if (user == this.user && senha == this.senha) {
            System.out.println("Login efetuado com sucesso!");
        } else {
            System.out.println("Login ou senha incorretos!");
        }
    }

    public void Cadastro(Usuário usuário, String user, String senha) {
        this.usuário = usuário;
        this.user = user;
        this.senha = senha;
    }

    public void reservaLivro(Livro livro) {
        this.livros.add(livro);
    }

    public void devolveLivro(Livro livro) {
        this.livros.remove(livro);
    }

    public void fazEmprestimo(Empréstimo empréstimo) {
        this.empréstimo = empréstimo;
    }

    public int getIdConta() {
        return idConta;
    }

    public int setId(int Id) {
        this.idConta = Id;
        return Id;
    }

    public String getUser() {
        return user;
    }

    public String getSenha() {
        return senha;
    }
}
