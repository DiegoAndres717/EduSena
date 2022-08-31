package Models;
import Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MetodoNotas {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        
        List<Notas> lista = new ArrayList();
        String sql = "SELECT * FROM notas";
        try {
            con = conectar.getConnecion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Notas u = new Notas();
                u.setId(rs.getInt("idNotas"));
                u.setIdCurso(rs.getInt("idCurso"));
                u.setIdAlumno(rs.getInt("idAlumno"));
                u.setNota1(rs.getDouble("nota1"));
                u.setNota2(rs.getDouble("nota2"));
                u.setNota3(rs.getDouble("nota3"));
                u.setNota4(rs.getDouble("nota4"));
                u.setPromedio(rs.getDouble("promedio"));
                lista.add(u);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    
    public int agregar(Notas u){
        int r = 1;
        String sql = "INSERT INTO edusena.notas (idCurso, idAlumno, nota1, nota2, nota3, nota4, "
                + "promedio) VALUES(?,?,?,?,?,?,?)";
        try {
            con = conectar.getConnecion();
            ps = con.prepareStatement(sql);
            ps.setString(1, Integer.toString(u.getIdCurso()));
            ps.setString(2, Integer.toString(u.getIdAlumno()));
            ps.setString(3, Double.toString(u.getNota1()));
            ps.setString(4, Double.toString(u.getNota2()));
            ps.setString(5, Double.toString(u.getNota3()));
            ps.setString(6, Double.toString(u.getNota4()));
            ps.setString(7, Double.toString(u.getPromedio()));
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
    
    public int actualizarNota(Notas u){
        int r = 1;
        String sql = "UPDATE edusena.notas SET idAlumno=?, nota1=?, nota2=?,"
                + "nota3=?, nota4=?, promedio=? WHERE idCurso=?";
        try {
            con = conectar.getConnecion();
            ps = con.prepareStatement(sql);
            ps.setString(1, Integer.toString(u.getIdAlumno()));
            ps.setString(2, Double.toString(u.getNota1()));
            ps.setString(3, Double.toString(u.getNota2()));
            ps.setString(4, Double.toString(u.getNota3()));
            ps.setString(5, Double.toString(u.getNota4()));
            ps.setString(6, Double.toString(u.getPromedio()));
            ps.setString(7, Integer.toString(u.getIdCurso()));
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
            con = conectar.getConnecion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No hay acceso a la base de datos");
        }
    }
}
