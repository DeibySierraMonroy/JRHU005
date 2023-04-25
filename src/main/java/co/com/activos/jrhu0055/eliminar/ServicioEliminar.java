package co.com.activos.jrhu0055.eliminar;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;

import javax.ws.rs.core.Response;


public interface ServicioEliminar {

    @POST
    Response eliminar(ReqEliminar eliminar);
}