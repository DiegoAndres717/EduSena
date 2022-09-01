
package Models;

/**
 *
 * @author ¡Diego Andres Salas!
 */
public class Notas {
    private int id;
    private int idCurso;
    private int idAlumno;
    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;
    private double promedio;

    public Notas() {
    }
    
    
    public Notas(int id, int idCurso, int idAlumno, double nota1, double nota2, double nota3, double nota4, double promedio) {
        this.id = id;
        this.idCurso = idCurso;
        this.idAlumno = idAlumno;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
        this.promedio = promedio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getNota4() {
        return nota4;
    }

    public void setNota4(double nota4) {
        this.nota4 = nota4;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    
}
