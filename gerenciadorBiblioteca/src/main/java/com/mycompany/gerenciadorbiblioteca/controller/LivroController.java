/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciadorbiblioteca.controller;

import com.mycompany.gerenciadorbiblioteca.model.Livro;
import com.mycompany.gerenciadorbiblioteca.model.LivroDAO;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ADRIANFEIJOFAGUNDES
 */
public class LivroController {
	private final LivroDAO livroDAO;
	
	public LivroController() {
		this.livroDAO = new LivroDAO();
	}
	
	private int getLivroId(String livro) throws NumberFormatException{
		String[] informacoes = livro.split(" ");
		int id = Integer.parseInt(informacoes[0]);
		return id;		
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
	
	public ArrayList<String> listarLivros() {
		ArrayList<Livro> livros = livroDAO.listarLivros();
		ArrayList<String> livrosInformacoes = new ArrayList<>();
		
		for (Livro livro : livros) {
			livrosInformacoes.add(livro.toString());
		}
		return livrosInformacoes;
	}
	
	public String deletarLivro(String livroInfo) {
		try {
			int id = getLivroId(livroInfo);	
			return livroDAO.deletarLivro(id);
		} catch (NumberFormatException e) {
			return "Erro: " + e.getMessage();
		}
	}
	
	public String atualizarLivro(String livroInfo, String titulo, String autor, String anoTexto) {
		try {
			int id = getLivroId(livroInfo);	
			int ano = Integer.parseInt(anoTexto);
			Livro livro = new Livro(titulo, autor, ano);
			livro.setId(id);
			livroDAO.atualizarLivro(livro);
			return "Livro atualizado com sucesso!.";
		} catch (NumberFormatException e) {
			return "Erro: " + e.getMessage();
		}
	}
}
