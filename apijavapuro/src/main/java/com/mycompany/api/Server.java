/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.api;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

/**
 *
 * @author ADRIANFEIJOFAGUNDES
 */
public class Server {

    public static void main(String[] args) throws IOException {
        int port = 8080;
	String host = "localhost";
	
	String response = "Servidor aberto...";
		
	InetSocketAddress adress = new InetSocketAddress(host, port);
	
	HttpServer server = HttpServer.create(adress, 0);
	
	server.createContext("/", (exchange -> {
		try (exchange) {
			exchange.getResponseHeaders().set("Content-Type", "text/plain");
			exchange.sendResponseHeaders(200, response.getBytes().length);
			exchange.getResponseBody().write(response.getBytes());
		}
	}));

	server.start();
	System.out.println("Servidor iniciado em http://" + host + ":" + port + "/");	
    }
}
