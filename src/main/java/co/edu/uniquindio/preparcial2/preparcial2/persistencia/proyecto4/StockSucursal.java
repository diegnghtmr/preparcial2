package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto4;

import java.io.Serializable;

public class StockSucursal implements Serializable {
    private String idProveedor;
    private String nombreSucursal;
    private String nombreProducto;
    private int cantidadStock;
    private double precioProducto;
    private static final long serialVersionUID = 1L;

    public StockSucursal(String idProveedor, String nombreSucursal, String nombreProducto, int cantidadStock, double precioProducto) {
        this.idProveedor = idProveedor;
        this.nombreSucursal = nombreSucursal;
        this.nombreProducto = nombreProducto;
        this.cantidadStock = cantidadStock;
        this.precioProducto = precioProducto;
    }

    public StockSucursal() {
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }
}
