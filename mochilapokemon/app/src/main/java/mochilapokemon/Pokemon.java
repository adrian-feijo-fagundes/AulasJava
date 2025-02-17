/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mochilapokemon;

/**
 *
 * @author ADRIANFEIJOFAGUNDES
 */
public class Pokemon {
	private String nome;
	private String tipo;
	private int nivel;
	
	public Pokemon(String nome, String tipo, int nivel) {
		this.nome = nome;
		this.tipo = tipo;
		this.nivel = nivel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
}
