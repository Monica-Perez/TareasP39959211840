/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsUsuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Usuario
 */
public class daoUsuario {
    private static final String SQL_SELECT = "SELECT idUsuarios, Usuario, contra FROM tblUsuarios";
    private static final String SQL_INSERT = "INSERT INTO tblUsuarios(Usuario, contra) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tblUsuarios SET Usuario=?, contra=? WHERE idUsuarios = ?";
    private static final String SQL_DELETE = "DELETE FROM tblUsuarios WHERE idUsuarios=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT idUsuarios, Usuario, contra FROM tblUsuarios WHERE Usuario = ?";
    private static final String SQL_SELECT_ID = "SELECT idUsuarios, Usuario, contra FROM tblUsuarios WHERE idUsuarios = ?";    

    public List<clsUsuario> consultaUsuarios() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsUsuario> usuarios = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idUsuarios");
                String nombre = rs.getString("Usuario");
                String contrasena = rs.getString("contra");
                clsUsuario usuario = new clsUsuario();
                usuario.setIdUsuario(id);
                usuario.setNombreUsuario(nombre);
                usuario.setContrasenaUsuario(contrasena);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuarios; 
    }

    public int ingresaUsuarios(clsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getContrasenaUsuario());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaUsuarios(clsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getContrasenaUsuario());
            stmt.setInt(3, usuario.getIdUsuario());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarUsuarios(clsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getIdUsuario());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsUsuario consultaUsuariosPorNombre(clsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + usuario);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idUsuarios");
                String nombre = rs.getString("Usuario");
                String contrasena = rs.getString("contra");

                //usuario = new clsUsuario();
                usuario.setIdUsuario(id);
                usuario.setNombreUsuario(nombre);
                usuario.setContrasenaUsuario(contrasena);
                System.out.println(" registro consultado: " + usuario);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return usuario;
    }
    public clsUsuario consultaUsuariosPorId(clsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + usuario);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, usuario.getIdUsuario());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idUsuarios");
                String nombre = rs.getString("Usuario");
                String contrasena = rs.getString("contra");

                //usuario = new clsUsuario();
                usuario.setIdUsuario(id);
                usuario.setNombreUsuario(nombre);
                usuario.setContrasenaUsuario(contrasena);
                System.out.println(" registro consultado: " + usuario);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return usuario;
    }
}
