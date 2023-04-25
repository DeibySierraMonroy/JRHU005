package co.com.activos.jrhu0055.model;

import java.io.Serializable;

public class Contrato implements Serializable {
    private Integer numeroContrato;
    private String nombreEmpresaFilial;
    private String fechaInicio;
    private String fechaRetiro;
    private String fechaFinalizacionContrato;

    private String nombreEmpresaPrincipal;

    private String estadoDelContrato;

    public Contrato() {
    }

    public Integer getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(Integer numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public String getNombreEmpresaFilial() {
        return nombreEmpresaFilial;
    }

    public void setNombreEmpresaFilial(String nombreEmpresaFilial) {
        this.nombreEmpresaFilial = nombreEmpresaFilial;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(String fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public String getFechaFinalizacionContrato() {
        return fechaFinalizacionContrato;
    }

    public void setFechaFinalizacionContrato(String fechaFinalizacionContrato) {
        this.fechaFinalizacionContrato = fechaFinalizacionContrato;
    }

    public String getNombreEmpresaPrincipal() {
        return nombreEmpresaPrincipal;
    }

    public void setNombreEmpresaPrincipal(String nombreEmpresaPrincipal) {
        this.nombreEmpresaPrincipal = nombreEmpresaPrincipal;
    }

    public String getEstadoDelContrato() {
        return estadoDelContrato;
    }

    public void setEstadoDelContrato(String estadoDelContrato) {
        this.estadoDelContrato = estadoDelContrato;
    }
}
