import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por gerenciar a conexão com o banco de dados PostgreSQL.
 * <p>
 * Fornece um método estático {@link #getConnection()} que cria e retorna uma
 * conexão ativa com o banco configurado.
 * </p>
 */
public class DatabaseConnection {

    /** URL de conexão com o banco de dados. */
    private static final String URL = "jdbc:postgresql://localhost:5432/gerenciador_tarefas";

    /** Usuário do banco de dados. */
    private static final String USER = "postgres";

    /** Senha do usuário do banco de dados. */
    private static final String PASSWORD = "Sua_Senha_Aqui";

    /**
     * Cria e retorna uma conexão com o banco de dados PostgreSQL.
     *
     * @return uma instância de {@link Connection} ativa
     * @throws RuntimeException se ocorrer algum erro ao tentar conectar
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão com o banco de dados", e);
        }
    }
}

