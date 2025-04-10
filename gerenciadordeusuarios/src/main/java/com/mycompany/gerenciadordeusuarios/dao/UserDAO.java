/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciadordeusuarios.dao;

import com.mycompany.gerenciadordeusuarios.database.DatabaseConnection;
import com.mycompany.gerenciadordeusuarios.model.User;
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
	private String error;

	public String getError() {
		return error;
	}
	
	public boolean registerUser(User user) {
		String sql = "INSERT INTO users (name, password) VALUES ( ? ,? )";
		
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		
		try (Connection connection = DatabaseConnection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, user.getName());
			stmt.setString(2, hash);
			
			stmt.executeUpdate();
		        
			return true;
		} catch (SQLException e) {
			this.error = "Erro ao registrar usuário";
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean validateLogin(User user) {
		String sql = "SELECT password FROM users WHERE name = ?";
		try (Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)) {
         
			stmt.setString(1, user.getName());
			ResultSet rs = stmt.executeQuery();
			boolean login = false;
			if (rs.next()) {
				login = BCrypt.checkpw(user.getPassword(), rs.getString("senha"));
			}
			
			return login;
		} catch (SQLException e) {
			this.error = "Erro ao tentar realizar login";
			System.out.println(e.getMessage());
			return false;
		}

	}
	
	public User getUser(int id) {
		String sql = "SELECT * FROM users WHERE id = ?";

		User user = null;

		try (Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) { 
				user = new User(
				rs.getString("name"),
				rs.getString("password")
				);
				user.setId( rs.getInt("id"));
			} else {
				throw new Exception("Usuário não foi encontrado");
			}
		} catch (Exception e) {
			this.error = "Erro ao obter usuário";
			System.out.println(e.getMessage());

		}
		return user;
	}


	public boolean putUser(User user) {
		String sql = "UPDATE users  SET name = ?, password = ? WHERE id = ?";
		try (Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(sql)) {

			pstmt.setString(1, user.getName());
			pstmt.setString(2,BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
			pstmt.setInt(3, user.getId());

			int rowsUpdated = pstmt.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("Usuário atualizado com sucesso!");
			} else {
				System.out.println("Nenhum usuário encontrado com o ID fornecido.");
			}
			return true;
		} catch (Exception e) {
			this.error = "Erro ao atualizar usuário: ";
			System.out.println(e.getMessage());
			return false;
		}
        
	}
	
	
	public boolean deleteUser(int id) {
		String sql = "DELETE FROM users WHERE id = ?";

		try (Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(sql)) {

			pstmt.setInt(1, id);

			pstmt.executeUpdate();
			return true;
		} catch(Exception e) {
			this.error = "Erro ao deletar usuário";
			System.out.println(e.getMessage());
			return false;
		}
        }
	
}
