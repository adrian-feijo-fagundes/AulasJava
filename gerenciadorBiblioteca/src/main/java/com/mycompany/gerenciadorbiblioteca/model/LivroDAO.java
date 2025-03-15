/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciadorbiblioteca.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    private final Connection conexao;

    public LivroDAO() {
	DatabaseConnection dbc = new DatabaseConnection();
        this.conexao = dbc.connect();
    }

    public void adicionarLivro(Livro livro)  {
        String sql = "INSERT INTO livros (titulo, autor, ano) VALUES (?, ?, ?)";
        try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
		stmt.setString(1, livro.getTitulo());
		stmt.setString(2, livro.getAutor());
		stmt.setInt(3, livro.getAnoPublicacao());
		stmt.executeUpdate();
		stmt.close();
		
	} catch (SQLException e) {
		System.out.print("Erro: " + e.getMessage());
	}
    }

    public ArrayList<Livro> listarLivros() {
	String sql = "SELECT * FROM livros";
	ArrayList<Livro> livros = new ArrayList<>();
	try (
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            // Loop para percorrer todos os registros retornados
            while (rs.next()) {
                 Livro livro = new Livro(
			rs.getString("titulo"),
                          rs.getString("autor"),
			rs.getInt("ano"));
		livro.setId(rs.getInt("id"));
                livros.add(livro);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar livros: " + e.getMessage());
        }
        return livros;
    }
    public String deletarLivro(int id) {
	String sql = "DELETE FROM livros WHERE id = ?";
			
	try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
	
		pstmt.setInt(1, id);
		
		int rowsDeleted = pstmt.executeUpdate();
		
	} catch(Exception e) {
		return ("Erro ao deletar livro: " + e.getMessage());
	}
	
	return "Livro deletado com sucesso";
    }
    public void atualizarLivro(Livro livro) {
        String sql = "UPDATE livros SET titulo = ?, autor = ?, ano = ? WHERE id = ?";
	try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
		stmt.setString(1, livro.getTitulo());
		stmt.setString(2, livro.getAutor());
		stmt.setInt(3, livro.getAnoPublicacao());
		stmt.setInt(4, livro.getId());	
		stmt.executeUpdate();
	} catch (Exception e) {
            System.out.println("Erro ao listar livros: " + e.getMessage());
        }
    }
}
