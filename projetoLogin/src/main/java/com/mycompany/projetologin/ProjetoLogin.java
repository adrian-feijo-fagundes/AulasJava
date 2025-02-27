/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projetologin;

import com.mycompany.projetologin.database.ConnectionSQLite;

import java.sql.Connection;

/**
 *
 * @author ADRIANFEIJOFAGUNDES
 */
public class ProjetoLogin {

    public static void main(String[] args) {
        ConnectionSQLite conSQLite = new ConnectionSQLite();

        Connection connection = conSQLite.connect();
    }
}
