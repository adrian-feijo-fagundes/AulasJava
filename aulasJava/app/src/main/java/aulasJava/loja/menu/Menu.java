/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aulasJava.loja.menu;

import java.util.Scanner;

/**
 *
 * @author ADRIANFEIJOFAGUNDES
 */
public class Menu {

	public static void start() {
		Scanner sc = new Scanner(System.in);
		
		boolean running = true;
		while(running) {
			System.out.println("-- PRODUTOS --");
			System.out.println("1. Ver  os Produtos");
			System.out.println("2. Adicionar");
			System.out.println("3. Remover");
			System.out.println("4. Realizar compra");
			System.out.print("Escolha: ");
			int option = sc.nextInt();
			
			switch(option) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
			}
			
		}
	}
}
