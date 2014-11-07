package com.mackenzie.ep.comparador.dao;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class GenericDao {
	private String url = "jdbc:mysql://localhost:3306/Loja";
    private String username = "root";
    private String password = "";
    private Connection conn;
    
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(url, username, password);
            return conn;
        }catch(ClassNotFoundException cnf){
            cnf.printStackTrace();
        }catch(SQLException sqlex){
            sqlex.printStackTrace();;
        }
        return null;
    }
}
