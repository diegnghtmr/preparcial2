package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2.model;

public class Materia {
    private String codigo;
    private String nombre;
    private int intensidadHoraria;
    private String tipo;

    public Materia(String codigo, String nombre, int intensidadHoraria, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.intensidadHoraria = intensidadHoraria;
        this.tipo = tipo;
    }

    public Materia() {
    }

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

    public int getIntensidadHoraria() {
        return intensidadHoraria;
    }

    public void setIntensidadHoraria(int intensidadHoraria) {
        this.intensidadHoraria = intensidadHoraria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
