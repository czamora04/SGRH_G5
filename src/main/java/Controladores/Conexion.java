package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private String url;
    private String db;
    private String user;
    private String password;
    private String driver;
    private Connection connection;

    public Conexion() {
        this.url = "jdbc:mysql://127.0.0.1:3306/";
        this.db = "SGRHDB";
        this.user = "root";
        this.password = "tmp123.";
        this.driver = "com.mysql.cj.jdbc.Driver";
    }
    
    public Connection conectar(){
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url + db, user, password);
            return connection;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error class: " + ex.getMessage());
        } catch (SQLException ex){
            System.out.println("Error class: " + ex.getMessage());
        }
        return null;
    }
    
    public void desConectar(){
        try {
            System.out.println("Conexion finalizada");
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
