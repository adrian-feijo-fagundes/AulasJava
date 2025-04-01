/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.novosconceitos.excecoes;

/**
 *
 * @author ADRIANFEIJOFAGUNDES
 */
public class Excecoes {
	public static void main(String[] args) {
		try {
			System.out.println(10/0);
			int[] array = {1, 1, 1};
			System.out.println(array[10]);
		} catch (ArithmeticException | IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
