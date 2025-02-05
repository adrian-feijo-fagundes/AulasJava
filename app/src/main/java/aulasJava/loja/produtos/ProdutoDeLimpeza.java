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
public class ProdutoDeLimpeza extends Produto implements Iproduto {

	public ProdutoDeLimpeza(int id, String nome, String categoria, double preco) {
		super(id, nome, categoria, preco);
	}

	public ProdutoDeLimpeza(Produto produto) {
		super(produto);
	}

	@Override
	public double calcularImposto() {
		double porcentagemImposto = (int) Impostos.LIMPEZA.getValor();
		double imposto = (super.getPreco() * (porcentagemImposto / 100)) - super.getPreco();
		return imposto;
	}

	@Override
	public double calcularLucro() {
		return this.getPreco() - calcularImposto();
	}
}
