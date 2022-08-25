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
                u.setId(rs.getInt("id"));
                u.setCodigo(rs.getInt("codigo"));
                u.setNombres(rs.getString("nombres"));
                u.setApellidos(rs.getString("apellidos"));
                u.setNid(rs.getInt("nid"));
                u.setEdad(rs.getInt("edad"));
                u.setEmail(rs.getString("email"));
                u.setTelefono(rs.getInt("telefono"));
                u.setDireccion(rs.getString("direccion"));
                u.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                lista.add(u);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    
    public int agregar(Persona u){
        int r = 1;
        String sql = "INSERT INTO docentes (codigo, nombres, apellidos, nid, edad, email, telefono, "
                + "direccion, fecha_nacimiento) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            con = conectar.getConnecion();
            ps = con.prepareStatement(sql);
            ps.setString(1, Integer.toString(u.getCodigo()));
            ps.setString(2, u.getNombres());
            ps.setString(3, u.getApellidos());
            ps.setString(4, Integer.toString(u.getNid()));
            ps.setString(5, Integer.toString(u.getEdad()));
            ps.setString(6, u.getEmail());
            ps.setString(7, Integer.toString(u.getTelefono()));
            ps.setString(8, u.getDireccion());
            ps.setString(9, u.getFecha_nacimiento());
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
        String sql = "UPDATE edusena.docentes SET codigo=?, nombres=?, apellidos=?, edad=?, email=?,"
                + "telefono=?, direccion=?, fecha_nacimiento=? WHERE nid=?";
        try {
            con = conectar.getConnecion();
            ps = con.prepareStatement(sql);
            ps.setString(1, Integer.toString(u.getCodigo()));
            ps.setString(2, u.getNombres());
            ps.setString(3, u.getApellidos());
            ps.setString(4, Integer.toString(u.getEdad()));
            ps.setString(5, u.getEmail());
            ps.setString(6, Integer.toString(u.getTelefono()));
            ps.setString(7, u.getDireccion());
            ps.setString(8,  u.getFecha_nacimiento());
            ps.setString(9, Integer.toString(u.getNid()));
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
