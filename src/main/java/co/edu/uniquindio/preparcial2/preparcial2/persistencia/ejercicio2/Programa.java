package co.edu.uniquindio.preparcial2.preparcial2.persistencia.ejercicio2;

import java.io.Serializable;

public class Programa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String codigo;
    private String nombre;
    private String modalidad;

    public Programa(String codigo, String nombre, String modalidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.modalidad = modalidad;
    }

    public Programa() {
    }

    // Getters and Setters
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModalidad() {
        return modalidad;
    }
    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }
}
