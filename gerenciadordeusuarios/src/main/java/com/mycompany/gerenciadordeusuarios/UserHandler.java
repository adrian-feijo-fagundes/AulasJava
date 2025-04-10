/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciadordeusuarios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.gerenciadordeusuarios.dao.UserDAO;
import com.mycompany.gerenciadordeusuarios.model.User;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ADRIANFEIJOFAGUNDES
 */
public class UserHandler implements HttpHandler {
    private static final ObjectMapper mapper = new ObjectMapper();
    private final UserDAO userDAO;

    public UserHandler() {
        this.userDAO = new UserDAO();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        String path = exchange.getRequestURI().getPath();
        String[] parts = path.split("/");

        if (parts.length == 3) {
            int id;
            id = Integer.parseInt(parts[2]);
            if ("GET".equalsIgnoreCase(method)) {
                handleGet(exchange, id);
            } else if ("UPDATE".equalsIgnoreCase(method)) {
                handleUpdate(exchange, id);
            } else if ("DELETE".equalsIgnoreCase(method)) {
                handleDelete(exchange, id);
            } else {
                // Responde com código 405 (Método não permitido) para outros métodos
                exchange.sendResponseHeaders(405, -1);
            }
        } else if ("POST".equalsIgnoreCase(method)) {
            handlePost(exchange);
        } else {
            // Responde com código 405 (Método não permitido) para outros métodos
            exchange.sendResponseHeaders(405, -1);
        }
    }

    public void handleGet(HttpExchange exchange, int id) throws IOException {
        User user = userDAO.getUser(id);
        if (user != null) {
            sendResponse(exchange, 200, user);
        } else {
            sendResponse(exchange, 404, "Pessoa não encontrada");
        }
    }

    public void handlePost(HttpExchange exchange) {
        User user;
        try {
            user = mapper.readValue(exchange.getRequestBody(), User.class);
            userDAO.registerUser(user);
            sendResponse(exchange, 201, user);
        } catch (IOException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void handleDelete(HttpExchange exchange, int id) throws IOException {
        if (userDAO.deleteUser(id)) {
            sendResponse(exchange, 200, "User removido");
        } else {
            sendResponse(exchange, 404, "User não encontrado");
        }
    }

    public void handleUpdate(HttpExchange exchange, int id) throws IOException {
        User currentUser = userDAO.getUser(id);
        if (currentUser != null) {
            User user = mapper.readValue(exchange.getRequestBody(), User.class);
            user.setId(id);
            userDAO.putUser(currentUser);
            sendResponse(exchange, 200, user);
        } else {
            sendResponse(exchange, 404, "Pessoa não encontrada");
        }

    }

    private void sendResponse(HttpExchange exchange, int status, Object response) throws IOException {
        String json = (response instanceof String) ?
                String.format("{\"mensagem\":\"%s\"}", response) :
                mapper.writeValueAsString(response);

        exchange.getResponseHeaders().add("Content-Type", "application/json");
        exchange.sendResponseHeaders(status, json.getBytes().length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(json.getBytes());
        }
    }
}
