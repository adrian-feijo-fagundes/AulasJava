/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciadordeusuarios;

import com.mycompany.gerenciadordeusuarios.database.DatabaseConnection;
import java.io.IOException;
/**
 *
 * @author ADRIANFEIJOFAGUNDES
 */
public class Gerenciadordeusuarios {

    public static void main(String[] args) throws IOException {
        DatabaseConnection.getConnection();
	    Server.start();
    }
}
