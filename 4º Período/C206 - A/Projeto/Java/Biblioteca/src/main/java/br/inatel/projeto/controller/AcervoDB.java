package br.inatel.projeto.controller;

import java.sql.SQLException;

public class AcervoDB extends Database{

    public static boolean insertAcervo(String titulo, String cdu) {
        boolean check = false;
        connect();
        String sql = "INSERT INTO Acervo (cdu, titulo) VALUES (?, ?);";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, cdu);
            pst.setString(2, titulo);
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

    public static int selectId(String titulo){
        int id = 0;
        connect();
        String sql = "SELECT idAcervo FROM Acervo WHERE titulo ='" + titulo + "';";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                id = result.getInt("idAcervo");
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
        return id;
    }

    public static boolean pesquisaLivro(String titulo){
        boolean check = false;
        connect();
        String sql = "SELECT titulo FROM Acervo WHERE titulo ='" + titulo + "';";
        try {
            statement = connection.createStatement();
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
}
