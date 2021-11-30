
package controlador;

import bd.Conexion;
import java.util.Date;
import modelo.Juego;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zicko
 */
public class Registro {

    public boolean agregar(Juego juego) {

        Date date;
        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            date = juego.getPublicacion();
            String query = "INSERT INTO JUEGO(titulo,programador,precio,publicacion,disponible) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, juego.getTitulo());
            stmt.setString(2, juego.getProgramador());
            stmt.setDate(3, new java.sql.Date(date.getTime()));
            stmt.setInt(4, juego.getPrecio());
            stmt.setBoolean(5, juego.isDisponible());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;

        } catch (SQLException e) {

            System.out.println("Error sql al agregar Juego");
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar Juego");
            return false;
        }

    }

    public boolean actualizar(Juego juego) {

        Date date;
        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            date = juego.getPublicacion();
            String query = "UPDATE juego SET titulo=?,programador =?,publicacion=?,precio=?,disponible=? WHERE = idjuego=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, juego.getTitulo());
            stmt.setString(2, juego.getProgramador());
            stmt.setDate(3, new java.sql.Date(date.getTime()));
            stmt.setInt(4, juego.getPrecio());
            stmt.setBoolean(5, juego.isDisponible());
            stmt.setInt(6, juego.getIdJuego());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;

        } catch (SQLException e) {

            System.out.println("Error sql al actualizar Juego");
            return false;
        } catch (Exception e) {
            System.out.println("Error al actualizar juego");
            return false;
        }

    }

    public boolean eliminar(int idJuego) {
        Date date;
        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "DELETE FROM juego WHERE = idjuego=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, idJuego);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;

        } catch (SQLException e) {

            System.out.println("Error sql al eliminar Juego");
            return false;
        } catch (Exception e) {
            System.out.println("Error al eliminar Juego");
            return false;
        }
    }

    public Juego buscarPorId(int idJuego) {
        Juego juego = new Juego();
        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT * FROM juego WHERE = idjuego=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, idJuego);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                juego.setIdJuego(rs.getInt("idjuego"));
                juego.setTitulo(rs.getString("titulo"));
                juego.setProgramador(rs.getString("Programador"));
                juego.setPublicacion(rs.getDate("publicacion"));
                juego.setPrecio(rs.getInt("Precio"));
                juego.setDisponible(rs.getBoolean("disponible"));

            }
            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error sql al listar el Juego por id " + e.getMessage());

        }
        return juego;

    }

    public List<Juego> buscarTodos() {

        List<Juego> lista = new ArrayList<>();

        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT * FROM juego order by titulo";
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Juego juego = new Juego();
                juego.setIdJuego(rs.getInt("idjuego"));
                juego.setTitulo(rs.getString("titulo"));
                juego.setProgramador(rs.getString("programador"));
                juego.setPublicacion(rs.getDate("publicacion"));
                juego.setPrecio(rs.getInt("Precio"));
                juego.setDisponible(rs.getBoolean("disponible"));
                
                lista.add(juego);
            }
            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error sql al listar todos los juegos" + e.getMessage());

        }
        return lista;

    }
    
    public boolean buscarJuego(List<Juego>lista,String titulo){
    
        for (Juego juego : lista){
            if (juego.getTitulo().equalsIgnoreCase(titulo)) {
                return true;
                
            }
            
            
        }
        return false;
    }

}
