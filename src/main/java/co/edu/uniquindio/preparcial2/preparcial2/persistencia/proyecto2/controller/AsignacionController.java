package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2.controller;

import co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2.model.Asignacion;
import co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2.model.Docente;
import co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2.model.Estudiante;
import co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2.model.Materia;

import java.util.List;

public class AsignacionController {
    ModelFactory modelFactory;

    public AsignacionController() {
        modelFactory = ModelFactory.getInstance();
    }

    public List<Asignacion> obtenerAsignaciones() {
        return modelFactory.obtenerAsignaciones();
    }

    public List<Docente> obtenerDocentes() {
        return modelFactory.obtenerDocentes();
    }

    public List<Materia> obtenerMaterias() {
        return modelFactory.obtenerMaterias();
    }

    public List<Estudiante> obtenerEstudiantes() {
        return modelFactory.obtenerEstudiantes();
    }

    public boolean guardarAsignacion(Asignacion asignacion) {
        return modelFactory.guardarAsignacion(asignacion);
    }
}
