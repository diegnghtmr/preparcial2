package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto1;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String codigo;
    private String documento;
    private String tipoIdentificacion;
    private String nombre;
    private String apellido;
    private String telefono;
    private static final long serialVersionUID = 1L;

    public Cliente(String codigo, String documento, String tipoIdentificacion, String nombre, String apellido, String telefono) {
        this.codigo = codigo;
        this.documento = documento;
        this.tipoIdentificacion = tipoIdentificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public Cliente() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
