package data;

import static data.Conexion.close;
import static data.Conexion.getConexion;
import entity.Peliculas;
import java.sql.*;
import java.util.*;

public class CineDAO {

    private static final String SQL_CREATE = "INSERT INTO peliculas(nombre, director, recaudacion, secuelas) VALUES(?, ?, ?, ?)";
    private static final String SQL_READ = "SELECT * FROM peliculas";
    private static final String SQL_UPDATE_RECAUDACION = "UPDATE peliculas SET recaucacion = ? WHERE idpeliculas = ?";
    private static final String SQL_UPDATE_SECUELAS = "UPDATE peliculas SET secuelas = ? WHERE idpeliculas = ?";
    private static final String SQL_UPDATE= "UPDATE peliculas SET nombre = ?, director = ?, recaudacion = ?, secuelas = ? WHERE idpeliculas = ?";
    private static final String SQL_DELETE = "DELETE FROM peliculas WHERE idpeliculas = ?";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM peliculas WHERE idpeliculas = ?";

    public List<Peliculas> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Peliculas pelicula = null;
        List<Peliculas> peliculas = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPeliculas = rs.getInt(1);
                String nombre = rs.getString(2);
                String director = rs.getString(3);
                double recaudacion = rs.getDouble(4);
                int secuelas = rs.getInt(5);

                pelicula = new Peliculas(idPeliculas,nombre, director, recaudacion, secuelas);

                peliculas.add(pelicula);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return peliculas;
    }
    
    public Peliculas findFilmById(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Peliculas pelicula = null;
        
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()){
                int idPeliculas = rs.getInt(1);
                String nombre = rs.getString(2);  
                String director = rs.getString(3);
                double recaudacion = rs.getDouble(4);
                int secuelas = rs.getInt(5);
                
                pelicula = new Peliculas(idPeliculas,nombre, director, recaudacion, secuelas);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return pelicula;
    }

    public int create(Peliculas pelicula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_CREATE);
            stmt.setString(1, pelicula.getNombre());
            stmt.setString(2, pelicula.getDirector());
            stmt.setDouble(3, pelicula.getRecaudacion());
            stmt.setInt(4, pelicula.getSecuelas());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int updateRecaudacion(Peliculas pelicula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_RECAUDACION);
            stmt.setDouble(1, pelicula.getRecaudacion());
            stmt.setInt(2, pelicula.getIdPeliculas());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
     public int updateSecuelas(Peliculas pelicula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_SECUELAS);
            stmt.setInt(1, pelicula.getSecuelas());
            stmt.setInt(2, pelicula.getIdPeliculas());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
     
     public int update(Peliculas pelicula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, pelicula.getNombre());
            stmt.setString(2, pelicula.getDirector());
            stmt.setDouble(3, pelicula.getRecaudacion());
            stmt.setInt(4, pelicula.getSecuelas());
            stmt.setInt(5, pelicula.getIdPeliculas());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int delete(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

} 

