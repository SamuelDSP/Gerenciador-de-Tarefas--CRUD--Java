import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 * Classe de acesso a dados (DAO) para a entidade Tarefa.
 * Contém métodos para adicionar, atualizar, deletar e listar tarefas no banco de dados.
 */
public class TarefaDAO {

    /**
     * Adiciona uma nova tarefa no banco de dados.
     *
     * @param tarefa objeto Tarefa contendo título, descrição e status
     * @throws DAOException se ocorrer algum erro de acesso ao banco de dados
     */
    public void adicionarTarefa(Tarefa tarefa) {
        String sql = "INSERT INTO tarefas (titulo, descricao, status) VALUES (?, ?, ?)";
        try (Connection conexao = DatabaseConnection.getConnection();
             PreparedStatement statement = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, tarefa.getTitulo());
            statement.setString(2, tarefa.getDescricao());
            statement.setString(3, tarefa.getStatus());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Erro ao adicionar tarefa", e);
        }
    }

    /**
     * Atualiza o status de uma tarefa existente no banco de dados.
     *
     * @param tarefa objeto Tarefa contendo o id e o novo status
     * @throws DAOException se ocorrer algum erro de acesso ao banco de dados
     */
    public void atualizarTarefa(Tarefa tarefa) {
        String sql = "UPDATE tarefas SET status = ? WHERE id = ?";
        try (Connection conexao = DatabaseConnection.getConnection();
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            statement.setString(1, tarefa.getStatus());
            statement.setInt(2, tarefa.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Erro ao atualizar tarefa", e);
        }
    }

    /**
     * Remove uma tarefa do banco de dados pelo seu id.
     *
     * @param tarefa objeto Tarefa contendo o id a ser removido
     * @throws DAOException se ocorrer algum erro de acesso ao banco de dados
     */
    public void deletarTarefa(Tarefa tarefa) {
        String sql = "DELETE FROM tarefas WHERE id = ?";
        try (Connection conexao = DatabaseConnection.getConnection();
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            statement.setInt(1, tarefa.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Erro ao deletar tarefa", e);
        }
    }

    /**
     * Retorna uma lista de todas as tarefas cadastradas no banco de dados.
     *
     * @return lista de objetos Tarefa
     * @throws DAOException se ocorrer algum erro de acesso ao banco de dados
     */
    public List<Tarefa> verTarefas() {
        List<Tarefa> tarefas = new ArrayList<>();
        String sql = "SELECT id, titulo, descricao, status FROM tarefas";
        try (Connection conexao = DatabaseConnection.getConnection();
             PreparedStatement statement = conexao.prepareStatement(sql);
             ResultSet resultados = statement.executeQuery()) {

            while (resultados.next()) {
                Tarefa t = new Tarefa();
                t.setId(resultados.getInt("id"));
                t.setTitulo(resultados.getString("titulo"));
                t.setDescricao(resultados.getString("descricao"));
                t.setStatus(resultados.getString("status"));
                tarefas.add(t);
            }

        } catch (SQLException e) {
            throw new DAOException("Erro ao listar tarefas", e);
        }
        return tarefas;
    }
}
