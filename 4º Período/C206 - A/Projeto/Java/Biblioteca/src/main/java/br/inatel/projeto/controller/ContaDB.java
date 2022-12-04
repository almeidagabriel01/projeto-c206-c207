package br.inatel.projeto.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    public static Map<String, String> validaLogin(String usuario, String senha){
        Map<String, String> login = new HashMap<>();
        connect();
        String sql = "SELECT user, senha FROM Conta WHERE user ='" + usuario + "' AND senha ='" + senha + "';";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                login.put(result.getString("user"), result.getString("senha"));
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
        return login;
    }

    public static boolean updateFkConta(String user, String cpf) {
        boolean check = false;
        connect();
        String sql = "UPDATE Conta SET usuario_cpf = ? WHERE user = ?;";
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
