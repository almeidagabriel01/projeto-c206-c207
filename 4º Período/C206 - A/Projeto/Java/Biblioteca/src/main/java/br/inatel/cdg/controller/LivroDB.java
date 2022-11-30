package br.inatel.cdg.controller;

import br.inatel.cdg.model.Livro;

import java.sql.SQLException;

public class LivroDB extends Database{
    private boolean check = false;

    public boolean insertLivro(Livro livro) {
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

    public String[][] selectLivro(String título) {
        connect();
        String sql = "SELECT a.título, l.autor FROM Livro l, Acervo a WHERE a.título LIKE %?% AND a.idAcervo = l.Acervo_idAcervo;";
        String[][] data = new String[100][2];
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, título);
            while (result.next()) {
                System.out.println("Título: " + result.getString("título"));
                System.out.println("Autor: " + result.getString("autor"));
                for(int i = 0; i < 100; i++) {
                    data[i][0] = result.getString("título");
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

    public boolean updateLivro(int idLivro, String autor, String editora, String edição) {
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

    public boolean deleteLivro(int idLivro) {
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
