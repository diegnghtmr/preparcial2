package co.edu.uniquindio.preparcial2.preparcial2.persistencia.ejercicio2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UniQuindio implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Programa> programas;

    public UniQuindio() {
        this.programas = new ArrayList<>();
    }

    public List<Programa> getProgramas() {
        return programas;
    }

    public void setProgramas(List<Programa> programas) {
        this.programas = programas;
    }

    public void agregarPrograma(Programa programa) {
        this.programas.add(programa);
    }
}