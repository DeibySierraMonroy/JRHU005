/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.activos.jrhu0055.DTO;

import co.com.activos.jrhu0055.utiliti.TipoAccion;
import java.io.Serializable;

/**
 *
 * @author desierra
 */
public class RadicadoDTO implements Serializable {

    private String numeroRadicado;
    private String azCodigo;
    private String deaCodigo;
    private String contrato;
    private String fecha;
    private String numeroDocumentoEmpleado;
    private String tipoACargar;
    private TipoAccion tipoAccion;

    public RadicadoDTO() {
    }

    public RadicadoDTO(String numeroRadicado, String azCodigo, String deaCodigo, String numeroDocumentoEmpleado, String tipoACargar) {
        this.numeroRadicado = numeroRadicado;
        this.azCodigo = azCodigo;
        this.deaCodigo = deaCodigo;
        this.numeroDocumentoEmpleado = numeroDocumentoEmpleado;
        this.tipoACargar = tipoACargar;
    }

    public String getNumeroRadicado() {
        return numeroRadicado;
    }

    public void setNumeroRadicado(String numeroRadicado) {
        this.numeroRadicado = numeroRadicado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNumeroDocumentoEmpleado() {
        return numeroDocumentoEmpleado;
    }

    public void setNumeroDocumentoEmpleado(String numeroDocumentoEmpleado) {
        this.numeroDocumentoEmpleado = numeroDocumentoEmpleado;
    }

    public String getTipoACargar() {
        return tipoACargar;
    }

    public void setTipoACargar(String tipoACargar) {
        this.tipoACargar = tipoACargar;
    }

    public TipoAccion getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(TipoAccion tipoAccion) {
        this.tipoAccion = tipoAccion;
    }
    
    

    public String getAzCodigo() {
        return azCodigo;
    }

    public void setAzCodigo(String azCodigo) {
        this.azCodigo = azCodigo;
    }

    public String getDeaCodigo() {
        return deaCodigo;
    }

    public void setDeaCodigo(String deaCodigo) {
        this.deaCodigo = deaCodigo;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }
    
    

}
