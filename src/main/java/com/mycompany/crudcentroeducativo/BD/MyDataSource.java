/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudcentroeducativo.BD;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author juudi
 */
public class MyDataSource {
    private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/centroeducativo";
    private static final String user="userCentroEducativo";
    private static final String passwd="1234";
    private static Connection cn;
    
    static {
        try {
            //Class.forName(driver);  
            cn=DriverManager.getConnection(url, user, passwd);
            
        } catch (Exception e) {
            System.out.println("Error al conectar a la Base de Datos");
        }
    }
   
    
    public static Connection getConnection(){
        try {
            if(cn==null || cn.isClosed());
            cn=DriverManager.getConnection(url, user, passwd);
        } catch (Exception e) {
            System.out.println("Error al conectar"+e.getMessage());
        }
        return cn;
    }
}
