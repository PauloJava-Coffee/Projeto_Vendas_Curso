/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author barbo
 */
public class ConnectionFactory {
    
    public Connection getConnection(){
        
        try {
         
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/bdvendas", "teste", "123");
        } catch (Exception erro) {
                    
        throw new RuntimeException(erro);
        }
        
    }
}
