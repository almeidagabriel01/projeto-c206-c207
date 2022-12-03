package br.inatel.cdg.controller;

import br.inatel.cdg.model.Revista;

import java.sql.SQLException;
import java.util.ArrayList;

public class RevistaDB extends Database {

    public static boolean insertRevista(Revista revista) {
        boolean check = false;
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

    public static ArrayList<Revista> readAllRevista() {
        ArrayList<Revista> revistas = new ArrayList<>();
        connect();
        String sql = "SELECT r.*, a.* FROM Revista AS r INNER JOIN Acervo AS a WHERE r.idRevista = a.idAcervo;";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                Revista revista = new Revista(result.getString("título"), result.getString("cdu"), result.getString("editora"), result.getInt("ano"));
                revistas.add(revista);
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
        return revistas;
    }

    public static boolean updateEditoraRevista(int idRevista, String editora) {
        boolean check = false;
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

    public static boolean updateAnoRevista(int idRevista, int ano) {
        boolean check = false;
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

    public static boolean updateFkRevista(int idRevista, int idAcervo) {
        boolean check = false;
        connect();
        String sql = " UPDATE Revista SET Acervo_idAcervo = ? WHERE idRevista = ?;";
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

    public static boolean deleteRevista(int id) {
        boolean check = false;
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
