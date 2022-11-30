package br.inatel.cdg.controller;

import br.inatel.cdg.model.Usuário;

import java.sql.SQLException;
import java.util.ArrayList;

public class UsuárioDB extends Database{
    private boolean check = false;

    public boolean insertUsuário(Usuário user) {
        connect();
        String sql = "INSERT INTO Usuário (cpf, nomeCompleto, idade, celular) VALUES (?, ?, ?, ?);";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, user.getCpf());
            pst.setString(2, user.getNomeCompleto());
            pst.setInt(3, user.getIdade());
            pst.setInt(4, user.getCelular());
            pst.execute();
            check = true;
        } catch (SQLException error) {
            System.out.println("Operation Error: " + error.getMessage());
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException error) {
                System.out.println("Connection Closure Error: " + error.getMessage());
            }
        }
        return check;
    }

    public boolean updateUsuário(String cpf, String nomeCompleto, int idade, int celular) {
        connect();
        String sql = "UPDATE Usuário SET cpf = ?, nomeCompleto = ?, idade = ?, celular = ? WHERE cpf = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, cpf);
            pst.setString(2, nomeCompleto);
            pst.setInt(3, idade);
            pst.setInt(4, celular);
            pst.setString(5, cpf);
            pst.execute();
            check = true;
        } catch (SQLException error) {
            System.out.println("Operation Error: " + error.getMessage());
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException error) {
                System.out.println("Connection Closure Error: " + error.getMessage());
            }
        }
        return check;
    }

    public boolean deleteUsuário(String cpf) {
        connect();
        String sql = "DELETE FROM Usuário WHERE cpf = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, cpf);
            pst.execute();
            check = true;
        } catch (SQLException error) {
            System.out.println("Operation Error: " + error.getMessage());
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException error) {
                System.out.println("Connection Closure Error: " + error.getMessage());
            }
        }
        return check;
    }
}
