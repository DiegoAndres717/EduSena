
package Conexion;

import java.sql.*;

/**
 *
 * @author ¡Diego Andres Salas!
 */
public class Conexion {

    private String db = "edusena";
    private String user = "root";
    private String password = "root";
    private String urlMysql = "jdbc:mysql://localhost/" + db + "?SslMode=none";
    private Connection con = null;
    
    public Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(this.urlMysql, this.user, this.password);
           // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           // con = DriverManager.getConnection(urlMysql);
            if (con != null) {
                System.out.println("Conexion a la base de datos "+this.db + "............Listo");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: "+e);
        }
    }
    
    public Connection getConnecion(){
        return con;
    }
}
