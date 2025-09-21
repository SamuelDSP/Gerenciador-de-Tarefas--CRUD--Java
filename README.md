CRUD Gerenciador de Tarefas

Projeto Java simples para gerenciar tarefas usando PostgreSQL. Permite adicionar, listar, atualizar e deletar tarefas via console.

Tecnologias: Java 17, Maven, PostgreSQL, JDBC.

Estrutura do projeto: Main.java (classe principal com menu interativo), Tarefa.java (classe modelo da tarefa), TarefaDAO.java (classe de acesso a dados para CRUD), DatabaseConnection.java (gerencia a conexão com o banco), DAOException.java (tratamento de exceções customizado).

Funcionalidades: adicionar tarefa com título, descrição e status; listar todas as tarefas; atualizar status de uma tarefa existente; remover tarefa pelo ID.

Como rodar: configure seu banco PostgreSQL criando a tabela tarefas com id SERIAL PRIMARY KEY, titulo VARCHAR(100), descricao TEXT e status VARCHAR(50). Configure DatabaseConnection.java com URL, USER e PASSWORD corretos. Compile e execute via Maven usando mvn compile e mvn exec:java -Dexec.mainClass="Main".

Observações: o menu é interativo via console; para encerrar o programa, selecione a opção 0 - Sair do gerenciador.