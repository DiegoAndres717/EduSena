package Models;
import Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MetodoCurso {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listarCu(){
        
        List<Cursos> lista = new ArrayList();
        String sql = "SELECT * FROM cursos";
        try {
            con = conectar.getConnecion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Cursos u = new Cursos();
                u.setId(rs.getInt("idCurso"));
                u.setMateria(rs.getString("materia"));
                u.setIdProfesor(rs.getString("idProfesor"));
                lista.add(u);
            }
        } catch (SQLException e) {
            System.out.println("No hay acceso a la base de datos");
        }
        return lista;
    }
    
    public int agregarCurso(Cursos u){
        int r = 1;
        String sql = "INSERT INTO edusena.cursos (materia, idProfesor) VALUES(?,?)";
        try {
            con = conectar.getConnecion();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getMateria());
            ps.setString(2, u.getIdProfesor());
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
    
    public int actualizarCu(Cursos u){
        int r = 1;
        String sql = "UPDATE edusena.cursos SET materia=?, idProfesor=? WHERE idCurso=?;";
        try {
            con = conectar.getConnecion();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getMateria());
            ps.setString(2, u.getIdProfesor());
            ps.setString(2, u.getCodigoCurso());
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
    
    public void eliminarCursos(int doc){
        String sql = "DELETE FROM edusena.cursos WHERE idCurso="+doc;
        try {
            con = conectar.getConnecion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No hay acceso a la base de datos");
        }
    }
}

