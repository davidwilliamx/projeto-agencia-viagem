import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/golobe_viagens";

    public static Connection conectar() throws SQLException {
        System.out.println("Conexão com banco realizada com sucesso!!!");
        return DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
    }
}