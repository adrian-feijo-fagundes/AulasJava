package com.mycompany.gerenciadordeusuarios;


import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {	
	public static void start() throws IOException  {
		HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

		server.createContext("/user", new UserHandler());
		server.setExecutor(null);
		server.start();
	}
}
