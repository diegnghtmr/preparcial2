package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto4;

import java.util.List;

public class ModelFactory {
    GestionLogistica gestionLogistica;

    private static class SingletonHolder {

        private static final ModelFactory eINSTANCE = new ModelFactory();

    }

    public static ModelFactory getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactory() {

        cargarRecursosXML();

        if(gestionLogistica == null){
            cargarDatosArchivos();
            PersistenciaUtil.inicializarArchivoXML(gestionLogistica);
            cargarRecursosXML();
        }
        guardarRecursosXML();
    }
    private void cargarRecursosXML() {
        gestionLogistica = PersistenciaUtil.cargarRecursoGestionLogisticaXML();
    }
    private void guardarRecursosXML() {
        PersistenciaUtil.guardarRecursoGestionLogisticaXML(gestionLogistica);
    }
    private void cargarDatosArchivos() {
        gestionLogistica = new GestionLogistica();
        try {
            PersistenciaUtil.cargarDatosArchivos(gestionLogistica);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Producto> obtenerProductos() {
        return gestionLogistica.getListaProducto();
    }

    public List<StockSucursal> obtenerStockSucursal() {
        return gestionLogistica.getListaStockSucursal();
    }

    public List<Proveedor> obtenerProveedores() {
        return gestionLogistica.getListaProveedor();
    }

    public List<Inventario> obtenerInventarios() {
        return gestionLogistica.getListaInventario();
    }

    public boolean agregarStockSucursal(StockSucursal stockSucursal) {
        try {
            gestionLogistica.agregarStockSucursal(stockSucursal);
            PersistenciaUtil.guardarStockSucursalArchivo(stockSucursal, PersistenciaUtil.RUTA_ARCHIVO_STOCK_SUCURSAL);
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

}
