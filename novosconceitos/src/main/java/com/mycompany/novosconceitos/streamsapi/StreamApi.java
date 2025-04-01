/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.novosconceitos.streamsapi;

import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author ADRIANFEIJOFAGUNDES
 */
public class StreamApi {
	public static void main(String[] args) {
		List<String> nomes = List.of("Pedro", "Pe");
		
		Stream<String> stream = nomes.stream();
	}
}
