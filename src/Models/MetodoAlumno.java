package Models;

import Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetodoAlumno {

    Conexion conectarAlumno = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List listar() {

        List<Persona> lista = new ArrayList();
        String sql = "SELECT * FROM alumnos";
        try {
            con = conectarAlumno.getConnecion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Persona u = new Persona();
                u.setId(rs.getInt("idAlumno"));
                u.setNombres(rs.getString("nombres"));
                u.setApellidos(rs.getString("apellidos"));
                u.setNid(rs.getString("nid"));
                u.setGrado(rs.getString("grado"));
                u.setEmail(rs.getString("email"));
                u.setTelefono(rs.getString("telefono"));
                u.setDireccion(rs.getString("direccion"));
                u.setGenero(rs.getString("genero"));
                u.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                u.setCodigo(rs.getInt("codigoAlu"));
                lista.add(u);
            }
        } catch (SQLException e) {
        }
        return lista;
    }

    public List listarAlumnoProf() {

        List<Persona> lista = new ArrayList();
        String sql = "SELECT idAlumno, nombres, apellidos, grado, email, telefono,"
                + "direccion, genero, fecha_nacimiento, codigoAlu FROM edusena.alumnos";
        try {
            con = conectarAlumno.getConnecion();
            ps = con.prepareStatement(sql);
            Persona u = new Persona();
            ps.setInt(1, u.getCodigo());
            rs = ps.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt("idAlumno"));
                u.setNombres(rs.getString("nombres"));
                u.setApellidos(rs.getString("apellidos"));
                u.setGrado(rs.getString("grado"));
                u.setEmail(rs.getString("email"));
                u.setTelefono(rs.getString("telefono"));
                u.setDireccion(rs.getString("direccion"));
                u.setGenero(rs.getString("genero"));
                u.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                u.setCodigo(rs.getInt("codigoAlu"));
                lista.add(u);
            }
        } catch (SQLException e) {
        }
        return lista;
    }

    public int agregarAlumno(Persona u) {
        int r = 1;
        String sql = "INSERT INTO edusena.alumnos (nombres, apellidos, nid, grado, email, telefono, "
                + "direccion, genero, fecha_nacimiento, codigoAlu)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            con = conectarAlumno.getConnecion();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombres());
            ps.setString(2, u.getApellidos());
            ps.setString(3, (u.getNid()));
            ps.setString(4, (u.getGrado()));
            ps.setString(5, u.getEmail());
            ps.setString(6, (u.getTelefono()));
            ps.setString(7, u.getDireccion());
            ps.setString(8, u.getGenero());
            ps.setString(9, u.getFecha_nacimiento());
            ps.setString(10, Integer.toString(u.getCodigo()));
            ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            System.out.println("kkklkkkhay acceso a la base de datos");
        }
        return r;
    }

    public boolean UsuarioIngresado(Persona P) {

        String sql = "SELECT * FROM edusena.alumnos where codigoAlu=?";
        try {
            con = conectarAlumno.getConnecion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, P.getCodigo());
            rs = ps.executeQuery();
            if (rs.next()) {
                P.setNombres(rs.getString("nombres"));
                P.setApellidos(rs.getString("apellidos"));
                P.setNid(rs.getString("nid"));
                P.setGrado(rs.getString("grado"));
                P.setEmail(rs.getString("email"));
                P.setTelefono(rs.getString("telefono"));
                P.setDireccion(rs.getString("direccion"));
                P.setGenero(rs.getString("genero"));
                P.setFecha_nacimiento(rs.getString("fecha_nacimiento"));

                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println("No hay acceso a la base de datos");
            return false;
        }

    }

    public int actualizarAlumnos(Persona u) {
        int r = 1;
        String sql = "UPDATE edusena.alumnos SET nombres=?, apellidos=?, nid=?, grado=?, email=?,"
                + "telefono=?, direccion=?, genero=?, fecha_nacimiento=? WHERE codigoAlu=?";
        try {
            con = conectarAlumno.getConnecion();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombres());
            ps.setString(2, u.getApellidos());
            ps.setString(3, (u.getNid()));
            ps.setString(4, (u.getGrado()));
            ps.setString(5, u.getEmail());
            ps.setString(6, (u.getTelefono()));
            ps.setString(7, u.getDireccion());
            ps.setString(8, u.getGenero());
            ps.setString(9, u.getFecha_nacimiento());
            ps.setString(10, Integer.toString(u.getCodigo()));
            ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            System.out.println("No hay acceso a la base de datos");
        }
        return r;
    }

    public void eliminarAlumno(int doc) {
        String sql = "DELETE FROM edusena.alumnos WHERE idAlumno=" + doc;
        try {
            con = conectarAlumno.getConnecion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No hay acceso a la base de datos");
        }
    }
}
