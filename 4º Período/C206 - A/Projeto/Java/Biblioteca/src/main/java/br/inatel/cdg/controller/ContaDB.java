package br.inatel.cdg.controller;

import br.inatel.cdg.model.Conta;

import java.sql.SQLException;
import java.util.ArrayList;

public class ContaDB extends Database{
    public static boolean insertConta(Conta conta, String cpfUsuário) {
        boolean check = false;
        connect();
        String sql = "INSERT INTO Conta (user, senha, cpfUsuário) VALUES (?, ?, ?);";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, conta.getUser());
            pst.setString(2, conta.getSenha());
            pst.setString(3, cpfUsuário);
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

    public static boolean validarCadastro(String user){
        boolean check = false;
        connect();
        ArrayList<String> users = new ArrayList<>();
        String sql = "SELECT user, senha FROM Conta WHERE user = ?;";
        try {
            statement = connection.createStatement();
            pst.setString(1, user);
            result = statement.executeQuery(sql);
            System.out.println("User = " + result.getString("user"));
            check = true;
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
        return check;
    }

    public static boolean validarLogin(String user, String senha){
        boolean check = false;
        connect();
        String sql = "SELECT user, senha FROM Conta WHERE user = ? AND senha = ?;";
        try {
            statement = connection.createStatement();
            pst.setString(1, user);
            pst.setString(2, senha);
            result = statement.executeQuery(sql);
            System.out.println("User = " + result.getString("user"));
            System.out.println("Senha = " + result.getString("senha"));
            check = true;
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
        return check;
    }

    public boolean deleteConta(String user) {
        boolean check = false;
        connect();
        String sql = "DELETE FROM Conta WHERE user = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, user);
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
