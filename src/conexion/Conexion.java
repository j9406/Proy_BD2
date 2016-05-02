package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion {
    private static Connection con;
    private static String username ="proyecto";
    private static String password = "proyecto";
    private static String bd="proyecto";
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String driverClass = "oracle.jdbc.driver.OracleDriver";
    private static Conexion conn = new Conexion();

    public Conexion() {
        try {
            Class.forName(driverClass).newInstance();
            con = DriverManager.getConnection(url, this.username, this.password);
            System.out.println("Conexion a Base de Datos " + bd + " Ok");
        } catch (Exception exc) {
            System.out.println("Error al tratar de abrir la base de Datos " + bd + " : " + exc);
        }
    }
   
    static {
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
   
    public static Connection getConnection() throws SQLException{
        return con = DriverManager.getConnection(url, username, password);
    }

    public static void beginTransaction(){
        if(con!=null){
            try {
                con.setAutoCommit(false);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void commit(){
        if(con!=null){
            try {
                con.commit();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void rollback(){
        if(con!=null){
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void closeDBUtil(ResultSet rs, Statement stmt, Connection con){
        try {
            if(rs!=null) {
                rs.close();
                rs =null;
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
       
        try {
            if(stmt!=null) {
                stmt.close();
                stmt =null;
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
       
        try {
            if(con!=null) {
                con.close();
                con =null;
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
       
    }
    
    public Connection getConexion() {
        return con;
    }
        
    public static void main(String[] args) {
        conn.getConexion();
    }
}

