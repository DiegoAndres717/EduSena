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
    
    public List listar(){
        
        List<Persona> lista = new ArrayList();
        String sql = "SELECT * FROM alumnos";
        try {
            con = conectarAlumno.getConnecion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Persona u = new Persona();
                u.setId(rs.getInt("id"));
                u.setCodigo(rs.getString("codigo"));
                u.setNombres(rs.getString("nombres"));
                u.setApellidos(rs.getString("apellidos"));
                u.setNid(rs.getString("nid"));
                u.setGrado(rs.getInt("grado"));
                u.setEmail(rs.getString("email"));
                u.setTelefono(rs.getString("telefono"));
                u.setDireccion(rs.getString("direccion"));
                u.setGenero(rs.getString("genero"));
                u.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                lista.add(u);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    
    public int agregar(Persona u){
        int r = 1;
        String sql = "INSERT INTO edusena.alumnos (codigo, nombres, apellidos, nid, grado, email, telefono, "
                + "direccion, genero, fecha_nacimiento) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            con = conectarAlumno.getConnecion();
            ps = con.prepareStatement(sql);
            ps.setString(1, (u.getCodigo()));
            ps.setString(2, u.getNombres());
            ps.setString(3, u.getApellidos());
            ps.setString(4, (u.getNid()));
            ps.setString(5, Integer.toString(u.getGrado()));
            ps.setString(6, u.getEmail());
            ps.setString(7, (u.getTelefono()));
            ps.setString(8, u.getDireccion());
            ps.setString(9, u.getGenero());
            ps.setString(10, u.getFecha_nacimiento());
            ps.executeUpdate();
            if(r == 1){
                return 1;
            }
            else{
                return 0;
            }
        } catch (SQLException e) {
            System.out.println("No hay acceso a la base de datos");
        }
        return r;
    }
    
    public int actualizarAlumnos(Persona u){
        int r = 1;
        String sql = "UPDATE edusena.alumnos SET codigo=?, nombres=?, apellidos=?, grado=?, email=?,"
                + "telefono=?, direccion=?, genero=?, fecha_nacimiento=? WHERE nid=?";
        try {
            con = conectarAlumno.getConnecion();
            ps = con.prepareStatement(sql);
            ps.setString(1, (u.getCodigo()));
            ps.setString(2, u.getNombres());
            ps.setString(3, u.getApellidos());
            ps.setString(4, Integer.toString(u.getGrado()));
            ps.setString(5, u.getEmail());
            ps.setString(6, (u.getTelefono()));
            ps.setString(7, u.getDireccion());
            ps.setString(8, u.getGenero());
            ps.setString(9,  u.getFecha_nacimiento());
            ps.setString(10, (u.getNid()));
            ps.executeUpdate();
            if(r == 1){
                return 1;
            }
            else{
                return 0;
            }
        } catch (SQLException e) {
            System.out.println("No hay acceso a la base de datos");
        }
        return r;
    }
    
    public void eliminarAlumno(int doc){
        String sql = "DELETE FROM edusena.alumnos WHERE id="+doc;
        try {
            con = conectarAlumno.getConnecion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No hay acceso a la base de datos");
        }
    }
}

