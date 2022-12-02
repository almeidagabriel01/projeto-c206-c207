package br.inatel.cdg.model;

import br.inatel.cdg.controller.ContaDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Conta {
    private String user;
    private String senha;

    public Conta(String user, String senha) {
        this.user = user;
        this.senha = senha;
    }

    public  void pesquisarLivros(){

    }

    public String getUser() {
        return user;
    }

    public String getSenha() {
        return senha;
    }
}
