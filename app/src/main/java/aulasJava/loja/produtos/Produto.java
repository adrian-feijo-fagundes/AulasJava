/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aulasJava.loja.produtos;

/**
 *
 * @author ADRIANFEIJOFAGUNDES
 */
abstract public class Produto implements Iproduto {
	
	private int id;
	private String nome;
	private String categoria;
	private double preco;
	
	public Produto (int id, String nome, String categoria, double preco) {
		this.id =  id;
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
	}
	
	public Produto (Produto produto) {
		this.id =  produto.id;
		this.nome = produto.nome;
		this.categoria = produto.categoria;
		this.preco = produto.preco;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPreco() {
		return this.preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
