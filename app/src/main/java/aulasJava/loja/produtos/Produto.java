/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package aulasJava.loja.produtos;

/**
 *
 * @author ADRIANFEIJOFAGUNDES
 */
public interface Produto {
	Produto clone();
	int getID();
	String getNome();
	String getCategoria();
}
