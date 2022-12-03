package br.inatel.cdg.controller;

import br.inatel.cdg.model.Conta;
import br.inatel.cdg.model.Empréstimo;

import java.sql.SQLException;
import java.util.ArrayList;

public class ContaDB extends Database{
    public static boolean insertConta(String user, String senha) {
        boolean check = false;
        connect();
        String sql = "INSERT INTO Conta (user, senha) VALUES (?, ?);";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, user);
            pst.setString(2, senha);
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

    public static ArrayList<String> selectUser(){
        connect();
        ArrayList<String> users = new ArrayList<>();
        String sql = "SELECT user FROM Conta;";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
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

    public static boolean validarLogin(String user, String senha){
        boolean check = false;
        connect();
        String sql = "SELECT user, senha FROM Conta WHERE user = ? AND senha = ?;";
        try {
            statement = connection.createStatement();
            pst.setString(1, user);
            pst.setString(2, senha);
            result = statement.executeQuery(sql);
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

    public static boolean updateFkConta(String user, String cpf) {
        boolean check = false;
        connect();
        String sql = "UPDATE Conta SET Usuário_cpf = ? WHERE user = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, cpf);
            pst.setString(2, user);
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
