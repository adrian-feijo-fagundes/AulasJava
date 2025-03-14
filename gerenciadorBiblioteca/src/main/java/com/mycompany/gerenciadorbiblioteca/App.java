/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciadorbiblioteca;

import com.mycompany.gerenciadorbiblioteca.model.DatabaseConnection;
import com.mycompany.gerenciadorbiblioteca.model.DatabaseTableInitializer;
import com.mycompany.gerenciadorbiblioteca.view.FmtLivro;
import java.sql.Connection;

/**
 *
 * @author ADRIANFEIJOFAGUNDES
 */
public class App {

    public static void main(String[] args) {

	DatabaseConnection dbc = new DatabaseConnection();
	Connection conn = dbc.connect();
	DatabaseTableInitializer.createUsers(conn);
	new FmtLivro().setVisible(true);

    }
}
