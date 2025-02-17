/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package aulasJava.loja.financeiro;

/**
 *
 * @author ADRIANFEIJOFAGUNDES
 */
public enum Impostos {
	ALIMENTICIO(20), 
	COSMETICO(15),
	HIGIENE(5),
	LIMPEZA(10),
	ELETRONICO(30);
    
	private final int valor;

    // Construtor
    Impostos(int valor) {
        this.valor = valor;
    }

    // Método para acessar o código
    public int getValor() {
        return valor;
    }
}
