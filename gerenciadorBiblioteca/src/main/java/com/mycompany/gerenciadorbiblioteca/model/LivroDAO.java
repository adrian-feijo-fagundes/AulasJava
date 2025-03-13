/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciadorbiblioteca.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroDAO {
    private final Connection conexao;

    public LivroDAO() {
	DatabaseConnection dbc = new DatabaseConnection();
        this.conexao = dbc.connect();
    }

    public void adicionarLivro(Livro livro)  {
        String sql = "INSERT INTO livros (titulo, autor, anoPublicacao) VALUES (?, ?, ?)";
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

    public void listarLivros() {}
    public void deletarLivro(int id) {

    }
    public void atualizarLivro(Livro livro) throws SQLException {
        String sql = "UPDATE livros SET titulo = ? autor = ?, anoPublicacao = ? WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, livro.getTitulo());
        stmt.setString(2, livro.getAutor());
        stmt.setInt(3, livro.getAnoPublicacao());
        stmt.setInt(4, livro.getId());
        stmt.executeUpdate();
        stmt.close();
    }
}
