/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginseguro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ADRIANFEIJOFAGUNDES
 */
public class DatabaseConnector {
	private static final String URL = "jdbc:mysql://localhost:3306/meu_db";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	private static Connection connection;

	public static Connection getConnection() {
		try {
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
			}
			return connection;
		} catch (SQLException e ) {
			throw new RuntimeException("Erro na conexão com o banco de Dados", e);
		}
	};
	
	public static void createTableUsers() {
		String sql = "CREATE TABLE IF NOT EXISTS usuarios (" +
                     "id INT AUTO_INCREMENT PRIMARY KEY, " +
                     "usuario VARCHAR(255) NOT NULL, " +
                     "senha VARCHAR(255) NOT NULL)";
		
		try (Statement stmt = connection.createStatement()) {
			stmt.execute(sql);
		} catch (SQLException e) {
            
			throw new RuntimeException("Erro ao criar a tabela", e);
		}
	} 
}
