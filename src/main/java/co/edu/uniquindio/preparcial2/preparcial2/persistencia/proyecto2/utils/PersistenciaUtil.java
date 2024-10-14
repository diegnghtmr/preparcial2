package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2.utils;

import co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2.model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaUtil {
    public static final String RUTA_ARCHIVO_ESTUDIANTES = "src/main/resources/persistencia/proyecto2/files/estudiantes.txt";
    public static final String RUTA_ARCHIVO_DOCENTES = "src/main/resources/persistencia/proyecto2/files/docentes.txt";
    public static final String RUTA_ARCHIVO_MATERIAS = "src/main/resources/persistencia/proyecto2/files/materias.txt";
    public static final String RUTA_ARCHIVO_ASIGNACIONES = "src/main/resources/persistencia/proyecto2/files/asignaciones.txt";

    public static void cargarDatosArchivos(Universidad universidad) throws FileNotFoundException, IOException {
        ArrayList<Estudiante> estudiantesCargados = cargarEstudiantes();
        if (estudiantesCargados.size() > 0) {
            universidad.setListaEstudiantes(estudiantesCargados);
        }
        ArrayList<Docente> docentesCargados = cargarDocentes();
        if (docentesCargados.size() > 0) {
            universidad.setListaDocentes(docentesCargados);
        }
        ArrayList<Materia> materiasCargadas = cargarMaterias();
        if (materiasCargadas.size() > 0) {
            universidad.setListaMaterias(materiasCargadas);
        }
        ArrayList<Asignacion> asignacionesCargadas = cargarAsignaciones();
        if (asignacionesCargadas.size() > 0) {
            universidad.setListaAsignaciones(asignacionesCargadas);
        }
    }

    private static ArrayList<Estudiante> cargarEstudiantes()  throws FileNotFoundException, IOException {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_ESTUDIANTES);
        String linea;

        for (String s : contenido) {
            linea = s;
            String[] atributos = linea.split(";");
            String codigo = atributos[0];
            String nombre = atributos[1];
            String apellido = atributos[2];
            String sexo = atributos[3];
            int edad = Integer.parseInt(atributos[4]);
            String correo = atributos[5];
            String telefono = atributos[6];

            Estudiante estudiante = new Estudiante(nombre, apellido, sexo, edad, codigo, correo, telefono);

            estudiantes.add(estudiante);
        }
        return estudiantes;
    }

    private static ArrayList<Docente> cargarDocentes() throws FileNotFoundException, IOException {
        ArrayList<Docente> docentes = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_DOCENTES);
        String linea;

        for (String s : contenido) {
            linea = s;
            String[] atributos = linea.split(";");
            String codigo = atributos[0];
            String nombre = atributos[1];
            String apellido = atributos[2];
            String sexo = atributos[3];
            int edad = Integer.parseInt(atributos[4]);
            String correo = atributos[5];
            String telefono = atributos[6];
            String programaAdscrito = atributos[7];
            String profesion = atributos[8];

            Docente docente = new Docente(nombre, apellido, sexo, edad, codigo, correo, telefono, programaAdscrito, profesion);

            docentes.add(docente);
        }
        return docentes;
    }

    private static ArrayList<Materia> cargarMaterias() throws FileNotFoundException, IOException {
        ArrayList<Materia> materias = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_MATERIAS);
        String linea;

        for (String s : contenido) {
            linea = s;
            String[] atributos = linea.split("@@");
            String codigo = atributos[0];
            String nombre = atributos[1];
            int intensidadHoraria = Integer.parseInt(atributos[2]);
            String tipo = atributos[3];

            Materia materia = new Materia(codigo, nombre, intensidadHoraria, tipo);

            materias.add(materia);
        }
        return materias;
    }

    private static ArrayList<Asignacion> cargarAsignaciones() throws FileNotFoundException, IOException {
        ArrayList<Asignacion> asignaciones = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_ASIGNACIONES);
        String linea;

        for (String s : contenido) {
            linea = s;
            String[] atributos = linea.split("@@");
            String codigoAsignacion = atributos[0];
            String codigoMateria = atributos[1];
            String nombreMateria = atributos[2];
            String codigoDocente = atributos[3];
            List<String> codigoEstudiantes = new ArrayList<>();
            for (int i = 4; i < atributos.length; i++) {
                codigoEstudiantes.add(atributos[i]);
            }

            Asignacion asignacion = new Asignacion(codigoAsignacion, codigoMateria, nombreMateria, codigoDocente, codigoEstudiantes);

            asignaciones.add(asignacion);
        }
        return asignaciones;
    }

    public static void guardarAsignacionArchivo(Asignacion asignacion, String rutaArchivoAsignaciones) throws IOException {
        String content = asignacion.getCodigoAsignacion() + "@@" + asignacion.getCodigoMateria() +
                "@@" + asignacion.getNombreMateria() + "@@" + asignacion.getCodigoDocente();
        for (String codigoEstudiante : asignacion.getCodigoEstudiantes()) {
            content += "@@" + codigoEstudiante;
        }
        content += "\n";
        ArchivoUtil.guardarArchivo(rutaArchivoAsignaciones, content, true);
    }
}
