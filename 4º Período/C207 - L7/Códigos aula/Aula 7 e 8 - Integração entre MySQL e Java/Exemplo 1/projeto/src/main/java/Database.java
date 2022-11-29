import java.sql.*;

public abstract class Database {
    protected Connection connection; // objeto responsável por fazer a conexão com o servidor MySQL
    protected Statement statement; // objeto responsável por preparar consultas "SELECT"
    protected ResultSet result; // objeto responsável por executar consultas "SELECT"
    protected PreparedStatement pst; // objeto responsável por preparar querys de manipulação dinâmicas (INSERT, UPDATE e DELETE)

    private static final String USERNAME = "root"; // usuário da instância local do servidor
    private static final String PASSWORD = "root"; // senha do usuário da instância local do servidor
    private static final String DB_NAME = "projeto"; // nome do banco de dados a ser utilizado

    // string com URL de conexão com o servidor
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME
            + "?useTimezone=true&serverTimezone=UTC&useSSL=false";

    public void connect() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Successfully connected to the database! Info: " + connection);
        } catch (SQLException error) {
            System.out.println("Connection Error: " + error.getMessage());
        }
    }
}
