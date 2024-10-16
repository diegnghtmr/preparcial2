package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto3;

import java.io.Serializable;

public class RegistroCovid implements Serializable {
    private String codigo;
    private String nombreComuna;
    private String sector;
    private int numeroHabitantes;
    private int numeroHabitantesCovid;
    private String porcentajeCovid;
    private String fechaRegistro;
    private String fechaEntrega;
    private static final long serialVersionUID = 1L;

    public RegistroCovid(String codigo, String nombreComuna, String sector,
                         int numeroHabitantes, int numeroHabitantesCovid, String porcentajeCovid,
                         String fechaRegistro, String fechaEntrega) {
        this.codigo = codigo;
        this.nombreComuna = nombreComuna;
        this.sector = sector;
        this.numeroHabitantes = numeroHabitantes;
        this.numeroHabitantesCovid = numeroHabitantesCovid;
        this.porcentajeCovid = porcentajeCovid;
        this.fechaRegistro = fechaRegistro;
        this.fechaEntrega = fechaEntrega;
    }

    public RegistroCovid() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreComuna() {
        return nombreComuna;
    }

    public void setNombreComuna(String nombreComuna) {
        this.nombreComuna = nombreComuna;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public int getNumeroHabitantes() {
        return numeroHabitantes;
    }

    public void setNumeroHabitantes(int numeroHabitantes) {
        this.numeroHabitantes = numeroHabitantes;
    }

    public int getNumeroHabitantesCovid() {
        return numeroHabitantesCovid;
    }

    public void setNumeroHabitantesCovid(int numeroHabitantesCovid) {
        this.numeroHabitantesCovid = numeroHabitantesCovid;
    }

    public String getPorcentajeCovid() {
        return porcentajeCovid;
    }

    public void setPorcentajeCovid(String porcentajeCovid) {
        this.porcentajeCovid = porcentajeCovid;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
}
