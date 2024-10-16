package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto3;

import java.io.IOException;
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

        cargarRecursosXML();
        cargarRecursosBinario();

        if(universidad == null){
            cargarDatosArchivos();
            PersistenciaUtil.inicializarArchivoXML(universidad);
            PersistenciaUtil.inicializarArchivoBinario(universidad);
            cargarRecursosXML();
        }
        guardarRecursosXML();
        guardarRecursosBinario();
    }

    private void cargarRecursosXML() {
        universidad = PersistenciaUtil.cargarRecursoUniversidadXML();
    }

    private void guardarRecursosXML() {
        PersistenciaUtil.guardarRecursoUniversidadXML(universidad);
    }

    private void cargarRecursosBinario() {
        universidad = PersistenciaUtil.cargarRecursoUniversidadBinario();
    }

    private void guardarRecursosBinario() {
        PersistenciaUtil.guardarRecursoUniversidadBinario(universidad);
    }

    private void cargarDatosArchivos() {
        universidad = new Universidad();
        try {
            PersistenciaUtil.cargarDatosArchivos(universidad);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<RegistroCovid> obtenerRegistroCovid() {
        return universidad.getListaRegistroCovid();
    }




}
