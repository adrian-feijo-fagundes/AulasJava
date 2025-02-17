/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aulasJava.loja.produtos;

import aulasJava.loja.financeiro.Impostos;

/**
 *
 * @author ADRIANFEIJOFAGUNDES
 */
public class ProdutoCosmetico extends Produto implements Iproduto{

	public ProdutoCosmetico(int id, String nome, String categoria, double preco) {
		super(id, nome, categoria, preco);
	}

	public ProdutoCosmetico(Produto produto) {
		super(produto);
	}

	@Override
	public double calcularImposto() {
		double porcentagemImposto = (int) Impostos.COSMETICO.getValor();
		double imposto = (super.getPreco() * (porcentagemImposto / 100)) - super.getPreco();
		return imposto;
	}

	@Override
	public double calcularLucro() {
		return this.getPreco() - calcularImposto();
	}


}
