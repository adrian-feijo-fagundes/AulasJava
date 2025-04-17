/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciadordeusuarios.controller;

import com.mycompany.gerenciadordeusuarios.dao.UserDAO;
import com.mycompany.gerenciadordeusuarios.model.User;

/**
 *
 * @author ADRIANFEIJOFAGUNDES
 */
public class UserController {
	private final UserDAO userDAO = new UserDAO();

    /**
     * Registra um novo usuário no sistema.
     * 
     * @param user Nome de usuário
     * @param password Senha do usuário
     * @return true se o registro for bem-sucedido, false caso contrário
     */
    public boolean registrarUsuario(String user, String password) {
	
        return userDAO.registerUser(new User(user, password));
    }

    /**
     * Valida o login de um usuário verificando as credenciais.
     * 
     * @param user Nome de usuário
     * @param password Senha do usuário
     * @return true se o login for válido, false caso contrário
     */
    public boolean validarLogin(String user, String password) {
        return userDAO.validateLogin(new User(user, password));
    }
}
