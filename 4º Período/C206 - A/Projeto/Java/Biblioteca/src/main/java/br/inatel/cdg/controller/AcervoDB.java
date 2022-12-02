package br.inatel.cdg.controller;

import br.inatel.cdg.model.Acervo;

import java.sql.SQLException;
import java.util.ArrayList;

public class AcervoDB extends Database{

    public static boolean insertAcervo(String cdu, String titulo) {
        boolean check = false;
        connect();
        String sql = "INSERT INTO Acervo (cdu, título) VALUES (?, ?);";
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

    public static boolean pesquisaLivro(String titulo){
        boolean check = false;
        connect();
        String sql = "SELECT título FROM Acervo WHERE título = ?;";
        try {
            statement = connection.createStatement();
            pst.setString(1, titulo);
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

    public static boolean updateDataEmpréstimo(int Conta_idConta, int Acervo_idAcervo,String dataEmpréstimo) {
        boolean check = false;
        connect();
        String sql = "UPDATE Conta_fazEmpréstimo_Acervo SET dataEmpréstimo = ? WHERE Conta_idConta = ? AND Acervo_idAcervo = ?;";
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
        String sql = "UPDATE Conta_fazEmpréstimo_Acervo SET dataDevolução = ? WHERE Conta_idConta = ? AND Acervo_idAcervo = ?;";
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

    public static boolean updateItens(int Conta_idConta, int Acervo_idAcervo,String itens) {
        boolean check = false;
        connect();
        String sql = "UPDATE Conta_fazEmpréstimo_Acervo SET itens = ? WHERE Conta_idConta = ? AND Acervo_idAcervo = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, itens);
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

    public static boolean updateQtdRenovados(int Conta_idConta, int Acervo_idAcervo,int qtdRenovados) {
        boolean check = false;
        connect();
        String sql = "UPDATE Conta_fazEmpréstimo_Acervo SET qtdRenovados = ? WHERE Conta_idConta = ? AND Acervo_idAcervo = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, qtdRenovados);
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

    public static boolean deleteEmpréstimo(int Conta_idConta, int Acervo_idAcervo) {
        boolean check = false;
        connect();
        String sql = "DELETE FROM Conta_fazEmpréstimo_Acervo WHERE Conta_idConta = ? AND Acervo_idAcervo = ?;";
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
