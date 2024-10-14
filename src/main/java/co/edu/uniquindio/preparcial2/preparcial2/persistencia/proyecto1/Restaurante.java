package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Restaurante implements Serializable {
    private final String nombre = "Oscar Gourmet";
    private List<Producto> listaProducto = new ArrayList<>();
    private List<Cliente> listaCliente = new ArrayList<>();
    private List<Pedido> listaPedido = new ArrayList<>();
    private static final long serialVersionUID = 1L;

    public Restaurante(List<Producto> listaProducto, List<Cliente> listaCliente, List<Pedido> listaPedido) {
        this.listaProducto = listaProducto;
        this.listaCliente = listaCliente;
        this.listaPedido = listaPedido;
    }

    public Restaurante() {
    }

    public String getNombre() {
        return nombre;
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public List<Pedido> getListaPedido() {
        return listaPedido;
    }

    public void setListaPedido(List<Pedido> listaPedido) {
        this.listaPedido = listaPedido;
    }

    public boolean verificarClienteExistente(String documento) throws Exception {
        for (Cliente cliente : listaCliente) {
            if (cliente.getDocumento().equals(documento)) {
                throw new Exception("El cliente ya existe");
            }
        }
        return false;
    }

    public void agregarCliente(Cliente cliente) {
        listaCliente.add(cliente);
    }

    public boolean verificarProductoExistente(String codigo) throws Exception {
        for (Producto producto : listaProducto) {
            if (producto.getCodigo().equals(codigo)) {
                throw new Exception("El producto ya existe");
            }
        }
        return false;
    }

    public void agregarProducto(Producto producto) {
        listaProducto.add(producto);
    }

    public void agregarPedido(Pedido pedido) {
        listaPedido.add(pedido);
    }
}
