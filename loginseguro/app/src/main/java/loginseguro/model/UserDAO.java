/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginseguro.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author ADRIANFEIJOFAGUNDES
 */
public class UserDAO {
	public boolean registerUser(User user) {
		String sql = "INSERT INTO usuarios (usuarios, senha) VALUES ( ? ,? )";
		
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		
		try (Connection connection = DatabaseConnector.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, user.getName());
			stmt.setString(2, hash);
			
			stmt.executeUpdate();
		        
			return true;
		} catch (SQLException e) {
			e.printStackTrace(); // Exibe o erro no console
			return false;
		}
	}
	
	public boolean validateLogin(User user) {
		String sql = "SELECT senha FROM usuarios WHERE usuario = ?";
		try (Connection conn = DatabaseConnector.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)) {
         
			stmt.setString(1, user.getName());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return BCrypt.checkpw(user.getPassword(), rs.getString("senha"));
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Exibe o erro no console
		}
		return false; // Retorna false caso não encontre o usuário ou ocorra um erro
	}
}
