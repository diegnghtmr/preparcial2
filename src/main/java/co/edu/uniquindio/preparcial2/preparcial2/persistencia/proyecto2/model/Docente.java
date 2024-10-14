package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2.model;

public class Docente {
    private String nombre;
    private String apellido;
    private String sexo;
    private int edad;
    private String codigo;
    private String correoElectronico;
    private String telefono;
    private String programaAdscrito;
    private String profesion;

    public Docente(String nombre, String apellido, String sexo, int edad, String codigo,
                   String correoElectronico, String telefono, String programaAdscrito, String profesion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.edad = edad;
        this.codigo = codigo;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.programaAdscrito = programaAdscrito;
        this.profesion = profesion;
    }

    public Docente() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getProgramaAdscrito() {
        return programaAdscrito;
    }

    public void setProgramaAdscrito(String programaAdscrito) {
        this.programaAdscrito = programaAdscrito;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
}
