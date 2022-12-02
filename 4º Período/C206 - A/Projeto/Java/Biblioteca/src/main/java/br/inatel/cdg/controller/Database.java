package br.inatel.cdg.controller;
import java.sql.*;

public abstract class Database {
    protected static Connection connection; // objeto responsável por fazer a conexão com o servidor MySQL
    protected static Statement statement; // objeto responsável por preparar consultas "SELECT"
    protected static ResultSet result; // objeto responsável por executar consultas "SELECT"
    protected static PreparedStatement pst; // objeto responsável por preparar querys de manipulação dinâmicas (INSERT, UPDATE e DELETE)

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DB_NAME = "biblioteca";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME
            + "?useTimezone=true&serverTimezone=UTC&useSSL=false";

    public static void connect() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            // System.out.println("Successfully connected to the database! Info: " + connection);
        } catch (SQLException error) {
            System.out.println("Connection Error: " + error.getMessage());
        }
    }

    public static boolean checkaDB() {
        boolean check = false;
        connect();
        String sql = "SELECT COUNT() FROM Conta;";
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
