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

    public static int selectIdAcervo(String titulo){
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

    public static String pesquisaLivro(String titulo){
        String resultado = "";
        connect();
        String sql = "SELECT titulo FROM Acervo AS a INNER JOIN livro AS l ON a.titulo ='" + titulo + "' AND a.idAcervo = l.Acervo_idAcervo;";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                resultado = result.getString("titulo");
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
        return resultado;
    }

    public static String pesquisaArigo(String titulo){
        String resultado = "";
        connect();
        String sql = "SELECT titulo FROM Acervo AS ac INNER JOIN Arigo AS ar ON ac.titulo ='" + titulo + "' AND ac.idAcervo = ar.Acervo_idAcervo;";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                resultado = result.getString("titulo");
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
        return resultado;
    }

    public static String pesquisaRevista(String titulo){
        String resultado = "";
        connect();
        String sql = "SELECT titulo FROM Acervo AS a INNER JOIN revista AS r ON a.titulo = '" + titulo + "' AND a.idAcervo = r.Acervo_idAcervo;";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                resultado = result.getString("titulo");
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
        return resultado;
    }
}
