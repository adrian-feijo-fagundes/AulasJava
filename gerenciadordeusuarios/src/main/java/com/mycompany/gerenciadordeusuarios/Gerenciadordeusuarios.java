/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciadordeusuarios;

import com.mycompany.gerenciadordeusuarios.database.DatabaseConnection;
import java.sql.Connection;
/**
 *
 * @author ADRIANFEIJOFAGUNDES
 */
public class Gerenciadordeusuarios {

    public static void main(String[] args) {
       Connection conn = DatabaseConnection.getConnection();

    }
}
