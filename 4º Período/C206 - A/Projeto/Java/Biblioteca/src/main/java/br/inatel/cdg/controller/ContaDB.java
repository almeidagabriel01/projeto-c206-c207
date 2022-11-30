package br.inatel.cdg.controller;

import br.inatel.cdg.model.Conta;

import java.sql.SQLException;
import java.util.ArrayList;

public class ContaDB extends Database{
    private boolean check = false;

    public boolean insertConta(Conta conta) {
        connect();
        String sql = "INSERT INTO Conta (user, senha) VALUES (?, ?);";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, conta.getUser());
            pst.setString(2, conta.getSenha());
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

    public ArrayList<String> selectUser() {
        connect();
        ArrayList<String> users = new ArrayList<>();
        String sql = "SELECT user FROM Conta;";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                System.out.println(result.getString("user"));
                System.out.println("--------------------");
                users.add(result.getString("user"));
            }
        } catch (SQLException error) {
            System.out.println("Operation Error: " + error.getMessage());
        } finally {
            try {
                connection.close();
                statement.close();
                result.close();
            } catch (SQLException error) {
                System.out.println("Connection Closure Error: " + error.getMessage());
            }
        }
        return users;
    }

    public boolean deleteConta(int idConta) {
        connect();
        String sql = "DELETE FROM Conta WHERE idConta = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, idConta);
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
