package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GestionLogistica implements Serializable {
    private final String nombre = "Oscar SA";
    private List<Proveedor> listaProveedor = new ArrayList<>();
    private List<Producto> listaProducto = new ArrayList<>();
    private List<Inventario> listaInventario = new ArrayList<>();
    private List<StockSucursal> listaStockSucursal = new ArrayList<>();
    private static final long serialVersionUID = 1L;

    public GestionLogistica(List<Proveedor> listaProveedor, List<Producto> listaProducto,
                            List<Inventario> listaInventario, List<StockSucursal> listaStockSucursal) {
        this.listaProveedor = listaProveedor;
        this.listaProducto = listaProducto;
        this.listaInventario = listaInventario;
        this.listaStockSucursal = listaStockSucursal;
    }

    public GestionLogistica() {
    }

    public String getNombre() {
        return nombre;
    }

    public List<Proveedor> getListaProveedor() {
        return listaProveedor;
    }

    public void setListaProveedor(List<Proveedor> listaProveedor) {
        this.listaProveedor = listaProveedor;
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public List<Inventario> getListaInventario() {
        return listaInventario;
    }

    public void setListaInventario(List<Inventario> listaInventario) {
        this.listaInventario = listaInventario;
    }

    public List<StockSucursal> getListaStockSucursal() {
        return listaStockSucursal;
    }

    public void setListaStockSucursal(List<StockSucursal> listaStockSucursal) {
        this.listaStockSucursal = listaStockSucursal;
    }

    public void agregarStockSucursal(StockSucursal stockSucursal) {
        listaStockSucursal.add(stockSucursal);
    }
}
