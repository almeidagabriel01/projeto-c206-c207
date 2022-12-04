package br.inatel.projeto.controller;

import br.inatel.projeto.model.Emprestimo;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmprestimoDB extends Database{
    public static boolean insertEmprestimo(int idConta, int idAcervo, String user, Emprestimo emprestimo) {
        boolean check = false;
        connect();
        String sql = "INSERT INTO Acervo_fazEmprestimo_Conta (Conta_idConta, Acervo_idAcervo, user, dataEmprestimo, dataDevolucao) VALUES (?, ?, ?, ?, ?);";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, idConta);
            pst.setInt(2, idAcervo);
            pst.setString(3, user);
            pst.setString(4, emprestimo.getDataEmprestimo());
            pst.setString(5, emprestimo.getDataDevolucao());
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
    public static ArrayList<Emprestimo> selectEmprestimo() {
        connect();
        ArrayList<Emprestimo> emprestimos = new ArrayList<>();
        String sql = "SELECT * FROM Acervo_fazEmprestimo_Conta;";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                Emprestimo emprestimo = new Emprestimo(result.getString("dataEmpréstimo"), result.getString("dataDevolução"));
                emprestimos.add(emprestimo);
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
        return emprestimos;
    }

    public static boolean updateDataEmprestimo(int Conta_idConta, int Acervo_idAcervo,String dataEmpréstimo) {
        boolean check = false;
        connect();
        String sql = "UPDATE Acervo_fazEmprestimo_Conta SET dataEmprestimo = ? WHERE Conta_idConta = ? AND Acervo_idAcervo = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, dataEmpréstimo);
            pst.setInt(2, Conta_idConta);
            pst.setInt(3, Acervo_idAcervo);
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

    public static boolean updateDataDevolução(int Conta_idConta, int Acervo_idAcervo,String dataDevolução) {
        boolean check = false;
        connect();
        String sql = "UPDATE Acervo_fazEmprestimo_Conta SET dataDevolucao = ? WHERE Conta_idConta = ? AND Acervo_idAcervo = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, dataDevolução);
            pst.setInt(2, Conta_idConta);
            pst.setInt(3, Acervo_idAcervo);
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

    public static boolean deleteEmprestimo(int Conta_idConta, int Acervo_idAcervo) {
        boolean check = false;
        connect();
        String sql = "DELETE FROM Acervo_fazEmprestimo_Conta WHERE Conta_idConta = ? AND Acervo_idAcervo = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, Conta_idConta);
            pst.setInt(2, Acervo_idAcervo);
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
