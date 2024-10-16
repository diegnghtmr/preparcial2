package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Universidad implements Serializable {
    private final String nombre = "uniquindio";
    private List<RegistroCovid> listaRegistroCovid = new ArrayList<>();
    private static final long serialVersionUID = 1L;

    public Universidad(List<RegistroCovid> listaRegistroCovid) {
        this.listaRegistroCovid = listaRegistroCovid;
    }

    public Universidad() {
    }

    public String getNombre() {
        return nombre;
    }

    public List<RegistroCovid> getListaRegistroCovid() {
        return listaRegistroCovid;
    }

    public void setListaRegistroCovid(List<RegistroCovid> listaRegistroCovid) {
        this.listaRegistroCovid = listaRegistroCovid;
    }


//    public boolean verificarClienteExistente(String documento) throws Exception {
//        for (RegistroCovid registroCovid : listaRegistroCovid) {
//            if (registroCovid.getNombreComuna().equals(documento)) {
//                throw new Exception("El RegistroCovid ya existe");
//            }
//        }
//        return false;
//    }
//
//    public void agregarCliente(RegistroCovid registroCovid) {
//        listaRegistroCovid.add(registroCovid);
//    }



}
