package co.com.activos.jrhu0055.eliminar;




import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ReqEliminar", namespace = "http://activos.com.co")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReqEliminar {

    @XmlElement(name = "tipoElemento", required = true)
    private String tipoElemento;

    @XmlElement(name = "idElemento", required = true)
    private String idElemento;

    public String getTipoElemento() {
        return tipoElemento;
    }

    public void setTipoElemento(String tipoElemento) {
        this.tipoElemento = tipoElemento;
    }

    public String getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(String idElemento) {
        this.idElemento = idElemento;
    }
}
