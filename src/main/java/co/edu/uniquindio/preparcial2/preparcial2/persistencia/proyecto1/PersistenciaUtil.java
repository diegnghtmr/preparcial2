package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto1;

import co.edu.uniquindio.preparcial2.preparcial2.persistencia.utils.ArchivoUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class PersistenciaUtil {
    public static final String RUTA_ARCHIVO_PRODUCTOS = "src/main/resources/persistencia/proyecto3/producto.txt";
    public static final String RUTA_ARCHIVO_CLIENTES = "src/main/resources/persistencia/proyecto3/registro-covid.txt";

    public static final String RUTA_XML_RESTAURANTE = "src/main/resources/persistencia/proyecto3/universidad-model.xml";

    public static void cargarDatosArchivos(Restaurante restaurante) throws FileNotFoundException, IOException {
        ArrayList<Producto> productosCargados = cargarProductos();
        if (productosCargados.size() > 0) {
            restaurante.setListaProducto(productosCargados);
        }
        ArrayList<Cliente> clientesCargados = cargarClientes();
        if (clientesCargados.size() > 0) {
            restaurante.setListaCliente(clientesCargados);
        }


    }

    private static ArrayList<Producto> cargarProductos() throws FileNotFoundException, IOException {
        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PRODUCTOS);
        String linea;

        for (String s : contenido) {
            linea = s;
            String[] atributos = linea.split("#");
            String codigo = atributos[0];
            String nombre = atributos[1];
            double precio = Double.parseDouble(atributos[2]);

            Producto producto = new Producto(codigo, nombre, precio);

            productos.add(producto);
        }
        return productos;
    }

    public static void guardarProductosArchivos(ArrayList<Producto> listaProducto, String path) throws IOException {
        String content = "";
        for (Producto productoAux : listaProducto) {
            content += productoAux.getCodigo() + "#" + productoAux.getNombre() + "#" + productoAux.getPrecio() + "\n";
        }
        ArchivoUtil.guardarArchivo(path, content, true);
    }

    public static void guardarProductoArchivo(Producto producto, String rutaArchivoProductos) throws IOException {
        String content = producto.getCodigo() + "#" + producto.getNombre() + "#" + producto.getPrecio() + "\n";
        ArchivoUtil.guardarArchivo(rutaArchivoProductos, content, true);
    }

    private static ArrayList<Cliente> cargarClientes() throws FileNotFoundException, IOException {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_CLIENTES);
        String linea;

        for (String s : contenido) {
            linea = s;
            String[] atributos = linea.split("@@");
            String codigo = atributos[0];
            String documento = atributos[1];
            String tipoDocumento = atributos[2];
            String nombre = atributos[3];
            String apellido = atributos[4];
            String telefono = atributos[5];

            Cliente cliente = new Cliente(codigo, documento, tipoDocumento, nombre, apellido, telefono);

            clientes.add(cliente);
        }

        return clientes;
    }

    public static void guardarClientesArchivos(ArrayList<Cliente> listaCliente, String path) throws IOException {
        String content = "";
        for (Cliente clienteAux : listaCliente) {
            content += clienteAux.getCodigo() + "@@" + clienteAux.getDocumento() + "@@"
                    + clienteAux.getTipoIdentificacion() + "@@" + clienteAux.getNombre() + "@@"
                    + clienteAux.getApellido() + "@@" + clienteAux.getTelefono() + "\n";
        }
        ArchivoUtil.guardarArchivo(path, content, true);
    }

    public static void guardarClienteArchivo(Cliente cliente, String path) throws IOException {
        String content = cliente.getCodigo() + "@@" + cliente.getDocumento() + "@@"
                + cliente.getTipoIdentificacion() + "@@" + cliente.getNombre() + "@@"
                + cliente.getApellido() + "@@" + cliente.getTelefono() + "\n";
        ArchivoUtil.guardarArchivo(path, content, true);
    }

    public static Restaurante cargarRecursoRestauranteXML() {
        Restaurante restaurante = null;
        try {
            restaurante = (Restaurante) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_XML_RESTAURANTE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restaurante;
    }

    public static void guardarRecursoRestauranteXML(Restaurante restaurante) {
        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_XML_RESTAURANTE, restaurante);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void inicializarArchivoXML(Restaurante restaurante) {
        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_XML_RESTAURANTE, restaurante);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
