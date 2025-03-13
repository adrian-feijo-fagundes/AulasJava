package com.mycompany.gerenciadorbiblioteca.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public Connection connect() {
        // Declara uma variável para armazenar a conexão
        Connection connection = null;
        // Define o caminho do banco de dados SQLite
        String url = "jdbc:sqlite:library.db";

        try {
            // Tenta estabelecer a conexão com o banco de dados usando a URL fornecida
            connection = DriverManager.getConnection(url);
            System.out.println("Conexão com SQLite estabelecida!"); // Mensagem de sucesso
        } catch (SQLException e) {
            // Caso ocorra um erro, ele será capturado e exibido
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
        }

        return connection; // Retorna a conexão estabelecida (ou null se falhou)
    }

    public void disconnect(Connection connection) {
        try {
            // Verifica se a conexão não é nula (ou seja, se está aberta)
            if (connection != null) {
                connection.close(); // Fecha a conexão
                System.out.println("Conexão fechada."); // Mensagem de sucesso
            }
        } catch (SQLException e) {
            // Captura e exibe qualquer erro ao tentar fechar a conexão
            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }
}


