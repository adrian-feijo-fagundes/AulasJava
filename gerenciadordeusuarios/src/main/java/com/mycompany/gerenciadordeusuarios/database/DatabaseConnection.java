/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciadordeusuarios.database;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADRIANFEIJOFAGUNDES
 */
public class DatabaseConnection {
	
	private static final Dotenv dotenv = Dotenv.load();
	private static final String DB_URL = dotenv.get("DB_URL");
	private static final String DB_USER = dotenv.get("DB_USER");
	private static final String DB_PASSWORD = dotenv.get("DB_PASSWORD");
	
	private static Connection connection;
	
	public static Connection getConnection() {
		try {
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			}
			return connection;
		} catch (SQLException e) {
			throw new RuntimeException("Erro na conexão com o banco de dados: ", e);
		}
	}
}
