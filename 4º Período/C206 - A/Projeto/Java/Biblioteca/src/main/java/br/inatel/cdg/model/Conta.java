package br.inatel.cdg.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Conta {
    private int idConta;
    private String user;
    private String senha;
    private Usuário usuário;
    private Acervo acervo;
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

    public boolean validarCadastro(ArrayList<String> selectUser, String user){
        for(int i=0;i<selectUser.size();i++){
            if(selectUser.get(i) == user);
                return true;
        }
        return false;
    }

    public void fazEmprestimo(Empréstimo empréstimo) {
        this.empréstimo = empréstimo;
    }

    public  void pesquisarLivros()

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
