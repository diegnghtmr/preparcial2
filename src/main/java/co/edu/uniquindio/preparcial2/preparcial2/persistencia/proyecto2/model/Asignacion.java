package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2.model;

import java.util.List;

public class Asignacion {
    private String codigoAsignacion;
    private String codigoMateria;
    private String nombreMateria;
    private String codigoDocente;
    private List<String> codigoEstudiantes;

    public Asignacion(String codigoAsignacion, String codigoMateria, String nombreMateria,
                      String codigoDocente, List<String> codigoEstudiantes) {
        this.codigoAsignacion = codigoAsignacion;
        this.codigoMateria = codigoMateria;
        this.nombreMateria = nombreMateria;
        this.codigoDocente = codigoDocente;
        this.codigoEstudiantes = codigoEstudiantes;
    }

    public Asignacion() {
    }

    public String getCodigoAsignacion() {
        return codigoAsignacion;
    }

    public void setCodigoAsignacion(String codigoAsignacion) {
        this.codigoAsignacion = codigoAsignacion;
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(String codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getCodigoDocente() {
        return codigoDocente;
    }

    public void setCodigoDocente(String codigoDocente) {
        this.codigoDocente = codigoDocente;
    }

    public List<String> getCodigoEstudiantes() {
        return codigoEstudiantes;
    }

    public void setCodigoEstudiantes(List<String> codigoEstudiantes) {
        this.codigoEstudiantes = codigoEstudiantes;
    }
}
