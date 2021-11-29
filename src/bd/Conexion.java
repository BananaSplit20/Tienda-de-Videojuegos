package bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
        

public class Conexion {
    
    public Connection obtenerConexion () throws SQLException{
     
        
        Connection connection = null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "root", "");
            System.out.println("Conexion exitosa");          
        } catch (ClassNotFoundException e) {
            System.out.println("Error de Conexion " + e.getMessage());
        }
        
        return connection;
    }
//    public static void main(String[] args) {
//        Conexion con = new Conexion();
//        con.obtenerConexion();
//   }
}
