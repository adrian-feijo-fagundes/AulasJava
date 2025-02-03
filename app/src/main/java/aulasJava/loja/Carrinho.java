/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aulasJava.loja;

import aulasJava.loja.produtos.Produto;
import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author ADRIANFEIJOFAGUNDES
 */
public class Carrinho {
	private final ArrayList<Produto> carrinho;
	
	public Carrinho() {
		carrinho = new ArrayList<>();
	}
	
	public void adicionarProduto(Produto produto) {
		carrinho.add(produto);
	}
	
	public void removerProduto(int idProduto) {
		for (int i = 0; i < carrinho.size(); i++  ) {
			if (carrinho.get(i).getID() == idProduto) {
				carrinho.remove(i);
			}
		}
	}
	
}
