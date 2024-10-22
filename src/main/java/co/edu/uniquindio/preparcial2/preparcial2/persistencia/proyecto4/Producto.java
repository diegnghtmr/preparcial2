package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto4;

import java.io.Serializable;

public class Producto implements Serializable {
    private String idProducto;
    private String nombreProducto;
    private String idProveedor;
    private double precio;
    private static final long serialVersionUID = 1L;

    public Producto(String idProducto, String nombreProducto, String idProveedor, double precio) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.idProveedor = idProveedor;
        this.precio = precio;
    }

    public Producto() {
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
