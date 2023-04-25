
package co.com.activos.jrhu0055.carpeta_ms;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "carpeta_msSOAP_HTTP_Service", targetNamespace = "http://tempuri.org/carpeta_ms", wsdlLocation = "http://192.168.21.15:7801/carpeta/crear_carpeta?wsdl")
public class CarpetaMsSOAPHTTPService
    extends Service
{

    private final static URL CARPETAMSSOAPHTTPSERVICE_WSDL_LOCATION;
    private final static WebServiceException CARPETAMSSOAPHTTPSERVICE_EXCEPTION;
    private final static QName CARPETAMSSOAPHTTPSERVICE_QNAME = new QName("http://tempuri.org/carpeta_ms", "carpeta_msSOAP_HTTP_Service");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.21.15:7801/carpeta/crear_carpeta?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CARPETAMSSOAPHTTPSERVICE_WSDL_LOCATION = url;
        CARPETAMSSOAPHTTPSERVICE_EXCEPTION = e;
    }

    public CarpetaMsSOAPHTTPService() {
        super(__getWsdlLocation(), CARPETAMSSOAPHTTPSERVICE_QNAME);
    }

    public CarpetaMsSOAPHTTPService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CARPETAMSSOAPHTTPSERVICE_QNAME, features);
    }

    public CarpetaMsSOAPHTTPService(URL wsdlLocation) {
        super(wsdlLocation, CARPETAMSSOAPHTTPSERVICE_QNAME);
    }

    public CarpetaMsSOAPHTTPService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CARPETAMSSOAPHTTPSERVICE_QNAME, features);
    }

    public CarpetaMsSOAPHTTPService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CarpetaMsSOAPHTTPService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CarpetaMsPortType
     */
    @WebEndpoint(name = "carpeta_msSOAP_HTTP_Port")
    public CarpetaMsPortType getCarpetaMsSOAPHTTPPort() {
        return super.getPort(new QName("http://tempuri.org/carpeta_ms", "carpeta_msSOAP_HTTP_Port"), CarpetaMsPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CarpetaMsPortType
     */
    @WebEndpoint(name = "carpeta_msSOAP_HTTP_Port")
    public CarpetaMsPortType getCarpetaMsSOAPHTTPPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/carpeta_ms", "carpeta_msSOAP_HTTP_Port"), CarpetaMsPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CARPETAMSSOAPHTTPSERVICE_EXCEPTION!= null) {
            throw CARPETAMSSOAPHTTPSERVICE_EXCEPTION;
        }
        return CARPETAMSSOAPHTTPSERVICE_WSDL_LOCATION;
    }

}
