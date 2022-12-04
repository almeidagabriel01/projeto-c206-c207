package br.inatel.cdg.controller;

import br.inatel.cdg.model.Livro;

import java.sql.SQLException;
import java.util.ArrayList;

public class LivroDB extends Database{
    public static boolean insertLivro(Livro livro) {
        boolean check = false;
        connect();
        String sql = "INSERT INTO Livro (autor, editora, edição) VALUES (?, ?, ?);";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, livro.getAutor());
            pst.setString(2, livro.getEditora());
            pst.setString(3, livro.getEdição());
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

    public static boolean updateFkLivro(int id_livro, int id_acervo) {
        boolean check = false;
        connect();
        String sql = " UPDATE Livro SET Acervo_idAcervo = ? WHERE idLivro = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id_acervo);
            pst.setInt(2, id_livro);
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

    public static ArrayList<Livro> readAllLivro() {
        connect();
        ArrayList<Livro> livros = new ArrayList<>();
        String sql = "SELECT l.*, a.* FROM Livro AS l INNER JOIN Acervo AS a WHERE l.idLivro = a.idAcervo;";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                Livro livro = new Livro(result.getString("titulo"), result.getString("cdu"),result.getString("autor"), result.getString("editora"), result.getString("edição"));
                livros.add(livro);
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
        return livros;
    }


    public static String[][] selectLivro(String título) {
        connect();
        String sql = "SELECT a.titulo, l.autor FROM Livro l, Acervo a WHERE a.titulo LIKE %'"+ título +"'% AND a.idAcervo = l.idAcervo;";
        String[][] data = new String[100][2];
        try {
            pst = connection.prepareStatement(sql);
            while (result.next()) {
                System.out.println("Título: " + result.getString("título"));
                System.out.println("Autor: " + result.getString("autor"));
                for(int i = 0; i < 100; i++) {
                    data[i][0] = result.getString("titulo");
                    data[i][1] = result.getString("autor");
                }
            }
        }  catch (SQLException error) {
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
        return data;
    }

    public static boolean updateLivro(int idLivro, String autor, String editora, String edição) {
        boolean check = false;
        connect();
        String sql = "UPDATE Livro SET autor = ?, editora = ?, edição = ? WHERE idLivro = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, autor);
            pst.setString(2, editora);
            pst.setString(3, edição);
            pst.setInt(4, idLivro);
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

    public static boolean deleteLivro(int idLivro) {
        boolean check = false;
        connect();
        String sql = "DELETE FROM Livro WHERE idLivro = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, idLivro);
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
