package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2.model;

import java.util.List;
import java.util.ArrayList;

public class Universidad {
    private final String nombre = "Universidad del Quindio";
    private List<Estudiante> listaEstudiantes = new ArrayList<>();
    private List<Docente> listaDocentes = new ArrayList<>();
    private List<Materia> listaMaterias = new ArrayList<>();
    private List<Asignacion> listaAsignaciones = new ArrayList<>();

    public Universidad(List<Estudiante> listaEstudiantes, List<Docente> listaDocentes, List<Materia> listaMaterias, List<Asignacion> listaAsignaciones) {
        this.listaEstudiantes = listaEstudiantes;
        this.listaDocentes = listaDocentes;
        this.listaMaterias = listaMaterias;
        this.listaAsignaciones = listaAsignaciones;
    }

    public Universidad() {
    }

    public String getNombre() {
        return nombre;
    }

    public List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(List<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public List<Docente> getListaDocentes() {
        return listaDocentes;
    }

    public void setListaDocentes(List<Docente> listaDocentes) {
        this.listaDocentes = listaDocentes;
    }

    public List<Materia> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(List<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    public List<Asignacion> getListaAsignaciones() {
        return listaAsignaciones;
    }

    public void setListaAsignaciones(List<Asignacion> listaAsignaciones) {
        this.listaAsignaciones = listaAsignaciones;
    }

    public void agregarAsignacion(Asignacion asignacion) {
        listaAsignaciones.add(asignacion);
    }
}
