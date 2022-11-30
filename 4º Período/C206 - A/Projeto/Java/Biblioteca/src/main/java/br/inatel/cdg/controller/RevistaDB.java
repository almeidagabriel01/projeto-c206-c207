package br.inatel.cdg.controller;

import br.inatel.cdg.model.Revista;

import java.sql.SQLException;
import java.util.ArrayList;

public class RevistaDB extends Database {
    private boolean check = false;

    public boolean insertRevista(Revista revista) {
        connect();
        String sql = "INSERT INTO Revista (editora, ano) VALUES (?, ?);";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, revista.getEditora());
            pst.setInt(2, revista.getAno());
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

    public boolean updateEditoraRevista(int idRevista, String editora) {
        connect();
        String sql = "UPDATE Revista SET editora = ? WHERE idRevista = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, editora);
            pst.setInt(2, idRevista);
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

    public boolean updateAnoRevista(int idRevista, int ano) {
        connect();
        String sql = "UPDATE Revista SET ano = ? WHERE idRevista = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, ano);
            pst.setInt(2, idRevista);
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

    public boolean updateFkRevista(int idRevista, int idAcervo) {
        connect();
        String sql = " UPDATE Aluno SET Acervo_idAcervo = ? WHERE idRevista = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, idAcervo);
            pst.setInt(2, idRevista);
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

    public boolean deleteRevista(int id) {
        connect();
        String sql = "DELETE FROM Revista WHERE id = ?;";
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
