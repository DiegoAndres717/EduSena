package Models;


public class Persona {
    
    private int id;
    private String codigo;
    private String nombres;
    private String apellidos;
    private String nid;
    private int grado;
    private int edad;
    private String email;
    private String telefono;
    private String direccion;
    private String genero;
    private String fecha_nacimiento;
    

    public Persona() {
    }

    public Persona(int id, String codigo, String nombres, String apellidos, String nid, int grado, int edad, String email, String telefono, String direccion, String genero, String fecha_nacimiento) {
        this.id = id;
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nid = nid;
        this.grado = grado;
        this.edad = edad;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.genero = genero;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
   
}