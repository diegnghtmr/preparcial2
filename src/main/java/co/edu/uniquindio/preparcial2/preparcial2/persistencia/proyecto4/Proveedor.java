package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto4;

import java.io.Serializable;

public class Proveedor implements Serializable {
    private String idProveedor;
    private String nombre;
    private String direccion;
    private String telefono;
    private static final long serialVersionUID = 1L;

    public Proveedor(String idProveedor, String nombre, String direccion, String telefono) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Proveedor() {
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
