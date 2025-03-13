package com.mycompany.gerenciadorbiblioteca.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTableInitializer {
    public static void createUsers(Connection connection) {
        String sql = "CREATE TABLE IF NOT EXISTS livros (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "titulo TEXT NOT NULL,"+
                "autor TEXT NOT NULL," +
                "ano INTEGER NOT NULL)";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso");
        } catch(SQLException e) {
            System.out.println("Erro ao criar tabela" + e.getMessage());
        }
    }
}
