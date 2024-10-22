package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto4;

import java.io.Serializable;

public class Inventario implements Serializable {
    private String idSucursal;
    private String nombreSucursal;
    private String idProducto;
    private int cantidadStock;
    private static final long serialVersionUID = 1L;

    public Inventario(String idSucursal, String nombreSucursal, String idProducto, int cantidadStock) {
        this.idSucursal = idSucursal;
        this.nombreSucursal = nombreSucursal;
        this.idProducto = idProducto;
        this.cantidadStock = cantidadStock;
    }

    public Inventario() {
    }

    public String getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }
}
