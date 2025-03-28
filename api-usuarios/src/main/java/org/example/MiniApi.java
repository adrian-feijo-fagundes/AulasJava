package org.example;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe principal da aplicação
public class MiniApi {
    // Lista para armazenar os itens recebidos via POST
    private static final List<String> items = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // Criação do servidor HTTP na porta 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Definição do endpoint "/items" e associação ao manipulador ItemHandler
        server.createContext("/items", new ItemHandler());

        // Configuração do executor padrão (thread pool do servidor)
        server.setExecutor(null);

        // Inicia o servidor
        server.start();
        System.out.println("Servidor rodando em http://localhost:8080/items");
    }

    // Classe interna responsável por tratar as requisições HTTP
    static class ItemHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Obtém o método HTTP da requisição (GET ou POST)
            String method = exchange.getRequestMethod();

            if ("GET".equalsIgnoreCase(method)) {
                handleGet(exchange); // Trata requisições GET
            } else if ("POST".equalsIgnoreCase(method)) {
                handlePost(exchange); // Trata requisições POST
            } else {
                // Responde com código 405 (Método não permitido) para outros métodos
                exchange.sendResponseHeaders(405, -1);
            }
        }

        // Método para tratar requisições GET
        private void handleGet(HttpExchange exchange) throws IOException {
            // Concatena os itens armazenados em uma string separada por vírgulas
            String response = String.join(", ", items);

            // Envia a resposta com status 200 (OK) e o tamanho do corpo da resposta
            exchange.sendResponseHeaders(200, response.getBytes().length);

            // Escreve a resposta no corpo da requisição
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }

        // Método para tratar requisições POST
        private void handlePost(HttpExchange exchange) throws IOException {
            // Lê o corpo da requisição e converte para string
            Scanner scanner = new Scanner(exchange.getRequestBody()).useDelimiter("\\A");
            String item = scanner.hasNext() ? scanner.next() : "";

            // Adiciona o item à lista
            items.add(item);

            // Mensagem de resposta
            String response = "Item adicionado: " + item;

            // Envia a resposta com status 200 (OK)
            exchange.sendResponseHeaders(200, response.getBytes().length);

            // Escreve a resposta no corpo da requisição
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }
    }
}
