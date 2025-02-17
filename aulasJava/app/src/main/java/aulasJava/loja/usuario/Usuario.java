/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aulasJava.loja.usuario;

/**
 *
 * @author ADRIANFEIJOFAGUNDES
 */
public class Usuario {
	private double saldo;
	private String nome;

	public Usuario(double saldo, String nome) {
		this.saldo = saldo;
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void comprar(double valor) {
		this.saldo = this.saldo - valor;
	}
}
