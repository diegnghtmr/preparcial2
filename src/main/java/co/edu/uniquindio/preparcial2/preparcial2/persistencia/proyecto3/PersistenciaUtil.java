package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto3;

import co.edu.uniquindio.preparcial2.preparcial2.persistencia.utils.ArchivoUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class PersistenciaUtil {
    public static final String RUTA_ARCHIVO_REGISTROS_COVID = "src/main/resources/persistencia/proyecto3/registro-covid.txt";

    public static final String RUTA_XML_UNIVERSIDAD = "src/main/resources/persistencia/proyecto3/universidad-model.xml";
    public static final String RUTA_BINARIO_UNIVERSIDAD = "src/main/resources/persistencia/proyecto3/universidad-model.dat";

    public static void cargarDatosArchivos(Universidad universidad) throws FileNotFoundException, IOException {
        ArrayList<RegistroCovid> registrosCovidCargados = cargarRegistrosCovid();
        if (registrosCovidCargados.size() > 0) {
            universidad.setListaRegistroCovid(registrosCovidCargados);
        }


    }




    private static ArrayList<RegistroCovid> cargarRegistrosCovid() throws FileNotFoundException, IOException {
        ArrayList<RegistroCovid> RegistroCovids = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_REGISTROS_COVID);
        String linea;

        for (String s : contenido) {
            linea = s;
            String[] atributos = linea.split("##");
            String codigo = atributos[0];
            String nombreComuna = atributos[1];
            String sector = atributos[2];
            int numeroHabitantes = Integer.parseInt(atributos[3]);
            int numeroHabitantesConCovid = Integer.parseInt(atributos[4]);
            String porcentajeCovid = atributos[5];
            String fechaRegistro = atributos[6];
            String fechaEntrega = atributos[7];

            RegistroCovid registroCovid = new RegistroCovid(codigo, nombreComuna, sector,
                    numeroHabitantes, numeroHabitantesConCovid,
                    porcentajeCovid, fechaRegistro, fechaEntrega);

            RegistroCovids.add(registroCovid);
        }

        return RegistroCovids;
    }

//    public static void guardarClientesArchivos(ArrayList<RegistroCovid> listaRegistroCovid, String path) throws IOException {
//        String content = "";
//        for (RegistroCovid registroCovidAux : listaRegistroCovid) {
//            content += registroCovidAux.getCodigo() + "@@" + registroCovidAux.getNombreComuna() + "@@"
//                    + registroCovidAux.getSector() + "@@" + registroCovidAux.getNumeroHabitantes() + "@@"
//                    + registroCovidAux.getNumeroHabitantesCovid() + "@@" + registroCovidAux.getPorcentajeCovid() + "\n";
//        }
//        ArchivoUtil.guardarArchivo(path, content, true);
//    }
//
//    public static void guardarClienteArchivo(RegistroCovid registroCovid, String path) throws IOException {
//        String content = registroCovid.getCodigo() + "@@" + registroCovid.getNombreComuna() + "@@"
//                + registroCovid.getSector() + "@@" + registroCovid.getNumeroHabitantes() + "@@"
//                + registroCovid.getNumeroHabitantesCovid() + "@@" + registroCovid.getPorcentajeCovid() + "\n";
//        ArchivoUtil.guardarArchivo(path, content, true);
//    }

    // XML

    public static Universidad cargarRecursoUniversidadXML() {
        Universidad universidad = null;
        try {
            universidad = (Universidad) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_XML_UNIVERSIDAD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return universidad;
    }

    public static void guardarRecursoUniversidadXML(Universidad universidad) {
        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_XML_UNIVERSIDAD, universidad);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void inicializarArchivoXML(Universidad universidad) {
        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_XML_UNIVERSIDAD, universidad);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // BINARIO

    public static void inicializarArchivoBinario(Universidad universidad) {
        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_BINARIO_UNIVERSIDAD, universidad);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Universidad cargarRecursoUniversidadBinario() {
        Universidad universidad = null;
        try {
            universidad = (Universidad) ArchivoUtil.cargarRecursoSerializado(RUTA_BINARIO_UNIVERSIDAD);
        } catch (Exception e) {
            e.printStackTrace();
        } return universidad;
    }

    public static void guardarRecursoUniversidadBinario(Universidad universidad) {
        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_BINARIO_UNIVERSIDAD, universidad);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
