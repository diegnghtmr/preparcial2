package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2.controller;

import co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2.model.*;
import co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2.utils.PersistenciaUtil;

import java.util.List;

public class ModelFactory {
    Universidad universidad;

    private static class SingletonHolder {

        private static final ModelFactory eINSTANCE = new ModelFactory();




    }
    public static ModelFactory getInstance() {
        return SingletonHolder.eINSTANCE;
    }
    public ModelFactory() {
        cargarDatosArchivos();
    }
    private void cargarDatosArchivos() {
        universidad = new Universidad();
        try {
            PersistenciaUtil.cargarDatosArchivos(universidad);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<Asignacion> obtenerAsignaciones() {
        return universidad.getListaAsignaciones();
    }
    public List<Docente> obtenerDocentes() {
        return universidad.getListaDocentes();
    }

    public List<Materia> obtenerMaterias() {
        return universidad.getListaMaterias();
    }

    public List<Estudiante> obtenerEstudiantes() {
        return universidad.getListaEstudiantes();
    }

    public boolean guardarAsignacion(Asignacion asignacion) {
        try {
            universidad.agregarAsignacion(asignacion);
            PersistenciaUtil.guardarAsignacionArchivo(asignacion, PersistenciaUtil.RUTA_ARCHIVO_ASIGNACIONES);
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

}
