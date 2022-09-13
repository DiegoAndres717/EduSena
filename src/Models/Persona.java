package Models;


public class Persona {
    
    private int id;
    private int codigo;
    private String nombres;
    private String apellidos;
    private String nid;
    private String grado;
    private String contraseña;
    private String email;
    private String telefono;
    private String direccion;
    private String genero;
    private String fecha_nacimiento;
    

    public Persona() {
    }

    public Persona(int id, int codigo, String nombres, String apellidos, String nid, 
            String grado, String contraseña, String email, String telefono, String direccion, String genero, String fecha_nacimiento) {
        this.id = id;
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nid = nid;
        this.grado = grado;
        this.contraseña = contraseña;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String edad) {
        this.contraseña = contraseña;
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