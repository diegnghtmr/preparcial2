package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Pedido implements Serializable {
    private LocalDate fecha;
    private double total;
    private Cliente cliente;
    private List<Producto> listaProducto;
    private static final long serialVersionUID = 1L;

    public Pedido(LocalDate fecha, double total, Cliente cliente, List<Producto> listaProducto) {
        this.fecha = fecha;
        this.total = total;
        this.cliente = cliente;
        this.listaProducto = listaProducto;
    }

    public Pedido() {
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }
}
