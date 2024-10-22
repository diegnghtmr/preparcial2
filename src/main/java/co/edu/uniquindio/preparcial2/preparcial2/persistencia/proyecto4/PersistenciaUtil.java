package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto4;

import co.edu.uniquindio.preparcial2.preparcial2.persistencia.utils.ArchivoUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class PersistenciaUtil {
    public static final String RUTA_ARCHIVO_PROVEEDOR = "src/main/resources/persistencia/proyecto4/proveedores.txt";
    public static final String RUTA_ARCHIVO_PRODUCTO = "src/main/resources/persistencia/proyecto4/productos.txt";
    public static final String RUTA_ARCHIVO_INVENTARIO = "src/main/resources/persistencia/proyecto4/inventarios.txt";
    public static final String RUTA_ARCHIVO_STOCK_SUCURSAL = "src/main/resources/persistencia/proyecto4/stock_sucursales.txt";
    public static final String RUTA_XML_GESTION_LOGISTICA = "src/main/resources/persistencia/proyecto4/gestion-logistica-model.xml";

    public static void cargarDatosArchivos(GestionLogistica gestionLogistica) throws FileNotFoundException, IOException{
        ArrayList<Proveedor> proveedoresCargados = cargarProveedores();
        if (proveedoresCargados.size() > 0) {
            gestionLogistica.setListaProveedor(proveedoresCargados);
        }

        ArrayList<Producto> productosCargados = cargarProductos();
        if (productosCargados.size() > 0) {
            gestionLogistica.setListaProducto(productosCargados);
        }

        ArrayList<Inventario> inventariosCargados = cargarInventarios();
        if (inventariosCargados.size() > 0) {
            gestionLogistica.setListaInventario(inventariosCargados);
        }

        ArrayList<StockSucursal> stockSucursalesCargados = cargarStockSucursales();
        if (stockSucursalesCargados.size() > 0) {
            gestionLogistica.setListaStockSucursal(stockSucursalesCargados);
        }

    }

    private static ArrayList<Proveedor> cargarProveedores() throws FileNotFoundException, IOException {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PROVEEDOR);
        String linea;

        for (String s : contenido) {
            linea = s;
            String[] atributos = linea.split("@@");
            String idProveedor = atributos[0];
            String nombre = atributos[1];
            String direccion = atributos[2];
            String telefono = atributos[3];

            Proveedor proveedor = new Proveedor(idProveedor, nombre, direccion, telefono);

            proveedores.add(proveedor);
        }
        return proveedores;
    }

    private static ArrayList<Producto> cargarProductos() throws FileNotFoundException, IOException {
        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PRODUCTO);
        String linea;

        for (String s : contenido) {
            linea = s;
            String[] atributos = linea.split("@@");
            String idProducto = atributos[0];
            String nombreProducto = atributos[1];
            String idProveedor = atributos[2];
            double precio = Double.parseDouble(atributos[3]);

            Producto producto = new Producto(idProducto, nombreProducto, idProveedor, precio);

            productos.add(producto);
        }
        return productos;
    }

    private static ArrayList<Inventario> cargarInventarios() throws FileNotFoundException, IOException {
        ArrayList<Inventario> inventarios = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_INVENTARIO);
        String linea;

        for (String s : contenido) {
            linea = s;
            String[] atributos = linea.split("@@");
            String idSucursal = atributos[0];
            String nombreSucursal = atributos[1];
            String idProducto = atributos[2];
            int cantidadStock = Integer.parseInt(atributos[3]);

            Inventario inventario = new Inventario(idSucursal, nombreSucursal, idProducto, cantidadStock);

            inventarios.add(inventario);
        }
        return inventarios;
    }


    private static ArrayList<StockSucursal> cargarStockSucursales() throws FileNotFoundException, IOException {
        ArrayList<StockSucursal> stockSucursales = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_STOCK_SUCURSAL);
        String linea;

        for (String s : contenido) {
            linea = s;
            String[] atributos = linea.split("##");
            String idProveedor = atributos[0];
            String nombreSucursal = atributos[1];
            String nombreProducto = atributos[2];
            int cantidadStock = Integer.parseInt(atributos[3]);
            double precioProducto = Double.parseDouble(atributos[4]);

            StockSucursal stockSucursal = new StockSucursal(idProveedor, nombreSucursal, nombreProducto, cantidadStock, precioProducto);

            stockSucursales.add(stockSucursal);
        }
        return stockSucursales;
    }

    public static void guardarStockSucursalArchivo(StockSucursal stockSucursal, String rutaArchivoStockSucursales) throws IOException {
        String content = stockSucursal.getIdProveedor() + "##" +
                stockSucursal.getNombreSucursal() + "##" + stockSucursal.getNombreProducto() +
                "##" + stockSucursal.getCantidadStock() + "##" + stockSucursal.getPrecioProducto() + "\n";
        ArchivoUtil.guardarArchivo(rutaArchivoStockSucursales, content, true);
    }


    // XML
    public static GestionLogistica cargarRecursoGestionLogisticaXML() {
        GestionLogistica gestionLogistica = null;
        try {
            gestionLogistica = (GestionLogistica) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_XML_GESTION_LOGISTICA);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gestionLogistica;
    }

    public static void guardarRecursoGestionLogisticaXML(GestionLogistica gestionLogistica) {
        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_XML_GESTION_LOGISTICA, gestionLogistica);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void inicializarArchivoXML(GestionLogistica gestionLogistica) {
        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_XML_GESTION_LOGISTICA, gestionLogistica);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
