
package Models;

/**
 *
 * @author ¡Diego Andres Salas!
 */
public class Cursos {
    private int id;
    private String codigoCurso;
    private String materia;
    private String idProfesor;

    public Cursos() {
    }

    public Cursos(int id, String codigoCurso, String materia, String idProfesor) {
        this.id = id;
        this.codigoCurso = codigoCurso;
        this.materia = materia;
        this.idProfesor = idProfesor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }
    
    
}
