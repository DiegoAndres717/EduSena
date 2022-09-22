package Models;

import Conexion.Conexion;
import Views.Colegio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class MetodoNotas {

    Colegio cole = new Colegio();
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs = null;
    DefaultTableModel modelo = new DefaultTableModel();
    Colegio vista = new Colegio();

    public List listar() {

        List<Notas> lista = new ArrayList();
        String sql = "SELECT * FROM notas";
        try {
            con = conectar.getConnecion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
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

    public boolean listarBusqueda(Notas N) {

        String sql = "SELECT * FROM edusena.notas where idAlumno=? and idCurso=?";
        try {
            con = conectar.getConnecion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, N.getIdAlumno());
            ps.setInt(2, N.getIdCurso());
            rs = ps.executeQuery();
            if (rs.next()) {
                N.setNota1(Double.parseDouble(rs.getString("nota1")));
                N.setNota2(Double.parseDouble(rs.getString("nota2")));
                N.setNota3(Double.parseDouble(rs.getString("nota3")));
                N.setNota4(Double.parseDouble(rs.getString("nota4")));
                N.setPromedio(Double.parseDouble(rs.getString("promedio")));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println("No hay acceso a la base de datos");
            return false;
        }
       
    }

    public int agregarNota(Notas u) {
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

    public int actualizarNota(Notas u) {
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

    public void eliminar(int doc) {
        String sql = "DELETE FROM edusena.notas WHERE idNotas=" + doc;
        try {
            con = conectar.getConnecion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No hay acceso a la base de datos");
        }
    }
}
