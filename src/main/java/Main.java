import java.util.Scanner;
import java.util.List;

/**
 * Classe principal que executa o sistema de Gerenciamento de Tarefas.
 * <p>
 * Esta classe contém o método {@code main} que apresenta ao usuário um menu interativo
 * para realizar operações de CRUD (Create, Read, Update, Delete) sobre as tarefas,
 * utilizando a classe {@link TarefaDAO} para persistência no banco de dados.
 */
public class Main {

    /**
     * Método principal que inicia o programa e controla o loop do menu de opções.
     * <p>
     * O sistema exibe opções ao usuário para:
     * <ul>
     *   <li>Adicionar nova tarefa</li>
     *   <li>Listar todas as tarefas</li>
     *   <li>Atualizar o status de uma tarefa</li>
     *   <li>Remover uma tarefa existente</li>
     *   <li>Encerrar o programa</li>
     * </ul>
     *
     * @param args argumentos da linha de comando (não utilizados neste programa).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TarefaDAO tarefaDAO = new TarefaDAO();
        boolean rodando = true;

        while (rodando) {
            System.out.println("Gerenciador de tarefas");
            System.out.println("Digite a opção desejada:");
            System.out.println("0 - Sair do gerenciador");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Ver lista de tarefas");
            System.out.println("3 - Atualizar status de tarefa");
            System.out.println("4 - Remover tarefa");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 0: {
                    System.out.println("Saindo do sistema...");
                    rodando = false;
                    break;
                }
                case 1: {
                    System.out.print("Digite o titulo da tarefa: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Escreva a descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Digite o status atual para a tarefa: ");
                    String status = scanner.nextLine();

                    Tarefa t = new Tarefa();
                    t.setTitulo(titulo);
                    t.setDescricao(descricao);
                    t.setStatus(status);
                    tarefaDAO.adicionarTarefa(t);
                    break;
                }
                case 2: {
                    List<Tarefa> lista = tarefaDAO.verTarefas();
                    for (int i = 0; i < lista.size(); i++) {
                        Tarefa t = lista.get(i);
                        System.out.println(
                            t.getId() + " - " + t.getTitulo() +
                            " | " + t.getDescricao() +
                            " | " + t.getStatus()
                        );
                    }
                    break;
                }
                case 3: {
                    System.out.print("Digite o número da tarefa a ser atualizada: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o novo status para a tarefa: ");
                    String status = scanner.nextLine();

                    Tarefa tarefa = new Tarefa();
                    tarefa.setId(id);
                    tarefa.setStatus(status);
                    tarefaDAO.atualizarTarefa(tarefa);
                    break;
                }
                case 4: {
                    System.out.print("Digite o número da tarefa a ser excluída: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Tarefa tarefa = new Tarefa();
                    tarefa.setId(id);
                    tarefaDAO.deletarTarefa(tarefa);
                    break;
                }
                default: {
                    System.out.println("Opção inválida, tente novamente.");
                    break;
                }
            }
            System.out.println("-------------------------------");
        }
    }
}
