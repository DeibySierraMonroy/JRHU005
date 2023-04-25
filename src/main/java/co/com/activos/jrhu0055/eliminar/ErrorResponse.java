package co.com.activos.jrhu0055.eliminar;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Fault", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorResponse {

    @XmlElement(name = "faultcode")
    private String faultCode;

    @XmlElement(name = "faultstring")
    private String faultString;

    @XmlElement(name = "detail")
    private ErrorDetail detail;

    public String getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode;
    }

    public String getFaultString() {
        return faultString;
    }

    public void setFaultString(String faultString) {
        this.faultString = faultString;
    }

    public ErrorDetail getDetail() {
        return detail;
    }

    public void setDetail(ErrorDetail detail) {
        this.detail = detail;
    }
}


