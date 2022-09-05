package Models;
import Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MetodoUsuario {
    Conexion usuarioco = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        
        List<Usuario> lista = new ArrayList();
        String sql = "SELECT * FROM usuarios";
        try {
            con = usuarioco.getConnecion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setUsuario(rs.getString("usuario"));
                u.setContraseña(rs.getString("contraseña"));
                u.setRol(rs.getString("rol"));
                u.setActivo(rs.getString("activo"));
                lista.add(u);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    
    public int agregarUsu(Usuario u){
        int r = 1;
        String sql = "INSERT INTO edusena.usuarios (usuario, contraseña, rol, activo) VALUES(?,?,?,?)";
        try {
            con = usuarioco.getConnecion();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getUsuario());
            ps.setString(2, u.getContraseña());
            ps.setString(3, u.getRol());
            ps.setString(4, u.getActivo());
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
    
    public int actualizarUsuarios(Usuario u){
        int r = 1;
        String sql = "UPDATE edusena.usuarios SET contraseña=?, rol=?, activo=? WHERE usuario=?";
        try {
            con = usuarioco.getConnecion();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getContraseña());
            ps.setString(2, u.getRol());
            ps.setString(3, u.getActivo());
            ps.setString(4, (u.getUsuario()));
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
        String sql = "DELETE FROM edusena.notas WHERE id="+doc;
        try {
            con = usuarioco.getConnecion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No hay acceso a la base de datos");
        }
    }
    
}


