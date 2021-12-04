/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moto_pieces_shop;

import java.sql.*;

/**
 *
 * @author famille_essuthi
 */
public class ConnectionDB {
    
    public Connection conn;
    public ConnectionDB(){

    }
    public void connection(){
    
                try{
            Class.forName("org.postgresql.Driver");
            
            String url = "jdbc:postgresql://localhost:5432/essuthimotopieces";
            String user = "essuthi";
            String password = "essoh";
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion Réussie");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Connexion échouée");
        }
    }
}
