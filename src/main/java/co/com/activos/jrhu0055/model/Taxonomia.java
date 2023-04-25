package co.com.activos.jrhu0055.model;

import java.io.Serializable;

public class Taxonomia implements Serializable {

    private String tipo;
    private String azCodigoCliPadre;
    private String nombre;
    private String usuario;
    private String tipoFlujo;
    private String deaCodigoPadre;

    public Taxonomia(String tipo, String azCodigoCliPadre, String nombre, String usuario, String tipoFlujo, String deaCodigoPadre) {
        this.tipo = tipo;
        this.azCodigoCliPadre = azCodigoCliPadre;
        this.nombre = nombre;
        this.usuario = usuario;
        this.tipoFlujo = tipoFlujo;
        this.deaCodigoPadre = deaCodigoPadre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAzCodigoCliPadre() {
        return azCodigoCliPadre;
    }

    public void setAzCodigoCliPadre(String azCodigoCliPadre) {
        this.azCodigoCliPadre = azCodigoCliPadre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTipoFlujo() {
        return tipoFlujo;
    }

    public void setTipoFlujo(String tipoFlujo) {
        this.tipoFlujo = tipoFlujo;
    }

    public String getDeaCodigoPadre() {
        return deaCodigoPadre;
    }

    public void setDeaCodigoPadre(String deaCodigoPadre) {
        this.deaCodigoPadre = deaCodigoPadre;
    }
}
