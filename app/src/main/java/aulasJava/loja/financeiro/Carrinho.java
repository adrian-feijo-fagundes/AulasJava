/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aulasJava.loja.financeiro;

import aulasJava.loja.produtos.Produto;
import aulasJava.loja.usuario.Usuario;
import java.util.ArrayList;

/**
 *
 * @author ADRIANFEIJOFAGUNDES
 */
public class Carrinho {
	private final ArrayList<Produto> carrinho;
	private double valorCompra;
	public Carrinho() {
		carrinho = new ArrayList<>();
	}
	
	public void listarProdutos() {
		for (Produto produto: carrinho) {
			System.out.println("Id: " + produto.getId() + produto.getNome() +  " " + produto.getCategoria() + " " + produto.getPreco());
		}
	}
	
	public void adicionarProduto(Produto produto) {
		carrinho.add(produto);
	}
	
	public void removerProduto(int idProduto) {
		for (int i = 0; i < carrinho.size(); i++  ) {
			if (carrinho.get(i).getId() == idProduto) {
				carrinho.remove(i);
			}
		}
	}

	public void fazerCompra(Usuario usuario) {
	
		if (usuario.getSaldo() < this.valorCompra) {
			System.out.println("Voce não tem saldo suficiente para realizar a compra!");
			return;
		} 
		usuario.comprar(this.valorCompra);
		this.valorCompra = 0;
		carrinho.clear();

	}

	private double calcularLucroTotal() {
		
		
		return 0;
	}
	
	private double calcularImpostoTotal() {
		return 0;
	}
	
	private double calcularValorCompra() {
		return 0;
	}
}
