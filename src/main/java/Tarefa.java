/**
 * Representa uma tarefa no sistema.
 * Cada tarefa possui um identificador único (id), título, descrição e status.
 */
public class Tarefa {

    private int id;
    private String titulo;
    private String descricao;
    private String status;

    /**
     * Obtém o id da tarefa.
     *
     * @return o identificador único da tarefa
     */
    public int getId() {
        return id;
    }

    /**
     * Define o id da tarefa.
     *
     * @param novoId o identificador único a ser atribuído à tarefa
     */
    public void setId(int novoId) {
        this.id = novoId;
    }

    /**
     * Obtém o título da tarefa.
     *
     * @return o título da tarefa
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Define o título da tarefa.
     *
     * @param novoTitulo o título a ser atribuído à tarefa
     */
    public void setTitulo(String novoTitulo) {
        this.titulo = novoTitulo;
    }

    /**
     * Obtém a descrição da tarefa.
     *
     * @return a descrição da tarefa
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição da tarefa.
     *
     * @param novaDescricao a descrição a ser atribuída à tarefa
     */
    public void setDescricao(String novaDescricao) {
        this.descricao = novaDescricao;
    }

    /**
     * Obtém o status da tarefa.
     *
     * @return o status atual da tarefa
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define o status da tarefa.
     *
     * @param novoStatus o status a ser atribuído à tarefa
     */
    public void setStatus(String novoStatus) {
        this.status = novoStatus;
    }
}
