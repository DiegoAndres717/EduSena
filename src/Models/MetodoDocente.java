package Models;
import Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MetodoDocente {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        
        List<Persona> lista = new ArrayList();
        String sql = "SELECT * FROM docentes";
        try {
            con = conectar.getConnecion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Persona u = new Persona();
                u.setId(rs.getInt("idProfesor"));
                u.setNombres(rs.getString("nombres"));
                u.setApellidos(rs.getString("apellidos"));
                u.setNid(rs.getString("nid"));
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
        String sql = "INSERT INTO docentes (nombres, apellidos, nid, email, telefono, "
                + "direccion, genero, fecha_nacimiento) VALUES(?,?,?,?,?,?,?,?)";
        try {
            con = conectar.getConnecion();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombres());
            ps.setString(2, u.getApellidos());
            ps.setString(3, (u.getNid()));
            ps.setString(4, u.getEmail());
            ps.setString(5, (u.getTelefono()));
            ps.setString(6, u.getDireccion());
            ps.setString(7, u.getGenero());
            ps.setString(8, u.getFecha_nacimiento());
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
    
    public int actualizar(Persona u){
        int r = 1;
        String sql = "UPDATE edusena.docentes SET nombres=?, apellidos=?, email=?,"
                + "telefono=?, direccion=?, genero=?, fecha_nacimiento=? WHERE nid=?";
        try {
            con = conectar.getConnecion();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombres());
            ps.setString(2, u.getApellidos());
            ps.setString(3, u.getEmail());
            ps.setString(4, (u.getTelefono()));
            ps.setString(5, u.getDireccion());
            ps.setString(6, u.getGenero());
            ps.setString(7,  u.getFecha_nacimiento());
            ps.setString(8, (u.getNid()));
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
    
    public void eliminar(int doc){
        String sql = "DELETE FROM edusena.docentes WHERE id="+doc;
        try {
            con = conectar.getConnecion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No hay acceso a la base de datos");
        }
    }
}
