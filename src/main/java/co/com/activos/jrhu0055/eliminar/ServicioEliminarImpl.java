package co.com.activos.jrhu0055.eliminar;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ServicioEliminarImpl implements ServicioEliminar {

    private static final String ENDPOINT = "http://192.168.21.15:7801/carpeta/eliminar";

    @Override
    public Response eliminar(ReqEliminar eliminar) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(ENDPOINT);
        Entity<ReqEliminar> entity = Entity.entity(eliminar, MediaType.APPLICATION_JSON);
        Response response = target.request(MediaType.APPLICATION_JSON).post(entity);
        ErrorResponse errorResponse = response.readEntity(ErrorResponse.class);
        return response;
    }
}
