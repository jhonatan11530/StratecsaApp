package com.stratecsa.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connectar {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String IP = "10.10.20.52";
    private static final int PORT = 3306;
    private static final String usuario = "root";
    private static final String contraseña = "";
    private static final String Database = "soft_crm";
    private static Connection conexionMySQL;
    Statement st;
    String mensaje = "";

    // Clase para conectar a la base de datos.
    public Connectar() {

        try {
            Class.forName(driver);
            conexionMySQL = DriverManager.getConnection("jdbc:mysql://" + IP + ":" + PORT + "/" + Database, usuario, contraseña);
            st = conexionMySQL.createStatement();
            if (conexionMySQL != null) {
                System.out.println("Conexion establecida");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Conexion Error " + ex);
        }
    }

    public ResultSet consultaBD(String query) {
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(Connectar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public void modificaBD(String query) {
        try {
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Connectar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
