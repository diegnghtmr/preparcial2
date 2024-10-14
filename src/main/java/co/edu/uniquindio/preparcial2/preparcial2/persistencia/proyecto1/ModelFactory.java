package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto1;

import java.io.IOException;
import java.util.List;

public class ModelFactory {
    Restaurante restaurante;

    private static class SingletonHolder {

        private static final ModelFactory eINSTANCE = new ModelFactory();





    }
    public static ModelFactory getInstance() {
        return SingletonHolder.eINSTANCE;
    }
    public ModelFactory() {

        cargarRecursosXML();

        if(restaurante == null){
            cargarDatosArchivos();
            PersistenciaUtil.inicializarArchivoXML(restaurante);
            cargarRecursosXML();
        }
        guardarRecursosXML();
    }
    private void cargarRecursosXML() {
        restaurante = PersistenciaUtil.cargarRecursoRestauranteXML();
    }
    private void guardarRecursosXML() {
        PersistenciaUtil.guardarRecursoRestauranteXML(restaurante);
    }
    private void cargarDatosArchivos() {
        restaurante = new Restaurante();
        try {
            PersistenciaUtil.cargarDatosArchivos(restaurante);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> obtenerClientes() {
        return restaurante.getListaCliente();
    }

    public boolean agregarCliente(Cliente cliente) {
        try {
            if (!restaurante.verificarClienteExistente(cliente.getDocumento())) {
                restaurante.agregarCliente(cliente);
                guardarRecursosXML();
                PersistenciaUtil.guardarClienteArchivo(cliente, PersistenciaUtil.RUTA_ARCHIVO_CLIENTES);
            }
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    public List<Producto> obtenerProductos() {
        return restaurante.getListaProducto();
    }

    public boolean agregarProducto(Producto producto) {
        try {
            if (!restaurante.verificarProductoExistente(producto.getCodigo())) {
                restaurante.agregarProducto(producto);
                guardarRecursosXML();
                PersistenciaUtil.guardarProductoArchivo(producto, PersistenciaUtil.RUTA_ARCHIVO_PRODUCTOS);
            }
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    public List<Pedido> obtenerPedidos() {
        return restaurante.getListaPedido();
    }

    public boolean agregarPedido(Pedido pedido) {
        try {
            restaurante.agregarPedido(pedido);
            guardarRecursosXML();
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }

    }
}
