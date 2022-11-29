package br.inatel.cdg.controller;

import br.inatel.cdg.model.Artigo;

import java.sql.SQLException;
import java.util.ArrayList;

public class ArtigoDB extends Database{
    private boolean check = false;

    public boolean insertArtigo(Artigo artigo) {
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

    public ArrayList<Artigo> selectArtigo() {
        connect();
        ArrayList<Artigo> artigos = new ArrayList<>();
        String sql = "SELECT * FROM Artigo;";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                Artigo artigo = new Artigo(result.getInt("numRegistro"), result.getString("titulo"), result.getString("CDU"), result.getString("autor"));
                artigo.setIdArtigo(result.getInt("idArtigo"));
                System.out.println("Id = " + result.getInt("idArtigo"));
                System.out.println("Autor = " + result.getString("autor"));
                System.out.println("--------------------");
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

    public boolean updateAutorArtigo(int idArtigo, String autor) {
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

    public boolean updateFkArtigo(int idArtigo, int idAcervo) {
        connect();
        String sql = " UPDATE Aluno SET Acervo_idAcervo = ? WHERE idArtigo = ?;";
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

    public boolean deleteArtigo(int id) {
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
