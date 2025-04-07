/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciadordeusuarios;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;

/**
 *
 * @author ADRIANFEIJOFAGUNDES
 */
public class UserHandler  implements HttpHandler{

	@Override
	public void handle(HttpExchange exchange) throws IOException {
            String method = exchange.getRequestMethod();

            if ("GET".equalsIgnoreCase(method)) {
                handleGet(exchange); 
            } else if ("POST".equalsIgnoreCase(method)) {
                handlePost(exchange); 
            } else if("UPDATE".equalsIgnoreCase(method)) {
	       handleUpdate(exchange);
	   } else if("DELETE".equalsIgnoreCase(method)) {
	      handleDelete(exchange);
	   } else {
                // Responde com código 405 (Método não permitido) para outros métodos
                exchange.sendResponseHeaders(405, -1);
            }
	}
	
	public void handleGet(HttpExchange exchange) {
	}
	public void handlePost(HttpExchange exchange) {
	}
	public void handleDelete(HttpExchange exchange) {
	}
	public void handleUpdate(HttpExchange exchange) {
	}
}
