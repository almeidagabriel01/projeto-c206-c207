package br.inatel.cdg.controller;

import br.inatel.cdg.model.Artigo;

import java.sql.SQLException;
import java.util.ArrayList;

public class ArtigoDB extends Database{
    public static boolean insertArtigo(Artigo artigo) {
        boolean check = false;
        connect();
        String sql = "INSERT INTO Artigo (autor) VALUES (?);";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, artigo.getAutor());
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

    public static ArrayList<Artigo> readAllArtigo() {
        connect();
        ArrayList<Artigo> artigos = new ArrayList<>();
        String sql = "SELECT art.*, ace.* FROM Artigo AS art INNER JOIN Acervo AS ace WHERE art.idArtigo = ace.idAcervo;";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                Artigo artigo = new Artigo(result.getString("titulo"), result.getString("CDU"), result.getString("autor"));
                artigos.add(artigo);
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
        return artigos;
    }

    public static boolean updateAutorArtigo(int idArtigo, String autor) {
        boolean check = false;
        connect();
        String sql = "UPDATE Autor SET autor = ? WHERE idArtigo = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, autor);
            pst.setInt(2, idArtigo);
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

    public static boolean updateFkArtigo(int idArtigo, int idAcervo) {
        boolean check = false;
        connect();
        String sql = " UPDATE Artigo SET Acervo_idAcervo = ? WHERE idArtigo = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, idAcervo);
            pst.setInt(2, idArtigo);
            pst.execute();
            check = true;
        } catch (SQLException error) {
            System.out.println("Operation Error: " + error.getMessage());
            check = false;
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

    public static boolean deleteArtigo(int id) {
        boolean check = false;
        connect();
        String sql = "DELETE FROM Artigo WHERE id = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
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
