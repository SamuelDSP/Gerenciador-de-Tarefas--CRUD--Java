/**
 * Exceção personalizada para erros relacionados às operações de acesso a dados (DAO).
 * 
 * <p>Ela estende {@link RuntimeException}, permitindo que erros de banco de dados
 * sejam tratados ou propagados sem necessidade de declaração explícita em métodos
 * que a lançam.</p>
 */
public class DAOException extends RuntimeException {

    /**
     * Cria uma nova exceção DAO com uma mensagem descritiva.
     *
     * @param mensagem a mensagem que descreve o erro
     */
    public DAOException(String mensagem) {
        super(mensagem);
    }

    /**
     * Cria uma nova exceção DAO com uma mensagem descritiva e a causa original.
     *
     * @param mensagem a mensagem que descreve o erro
     * @param causa a exceção original que causou o erro
     */
    public DAOException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
