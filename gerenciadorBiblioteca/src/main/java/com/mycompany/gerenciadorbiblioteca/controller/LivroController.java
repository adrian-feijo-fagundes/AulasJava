/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciadorbiblioteca.controller;

import com.mycompany.gerenciadorbiblioteca.model.Livro;
import com.mycompany.gerenciadorbiblioteca.model.LivroDAO;


/**
 *
 * @author ADRIANFEIJOFAGUNDES
 */
public class LivroController {
	private final LivroDAO livroDAO;
	
	public LivroController() {
		this.livroDAO = new LivroDAO();
	}
	
	public String adicionarLivros(String titulo, String autor, String anoTexto)  {
		try {
			int ano = Integer.parseInt(anoTexto);
			Livro livro = new Livro(titulo, autor, ano);
			livroDAO.adicionarLivro(livro);
			return "Livro adicionado com sucesso!.";
		} catch (NumberFormatException e) {
			return "Erro: " + e.getMessage();
		}
	}
}
