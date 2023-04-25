package co.com.activos.jrhu0055.controller;

import co.com.activos.jrhu0055.DTO.ContratoDTO;
import co.com.activos.jrhu0055.DTO.RadicadoDTO;
import co.com.activos.jrhu0055.Services.impl.IncapacidadService;
import co.com.activos.jrhu0055.eliminar.ReqEliminar;
import co.com.activos.jrhu0055.eliminar.ServicioEliminar;
import co.com.activos.jrhu0055.eliminar.ServicioEliminarImpl;
import co.com.activos.jrhu0055.model.*;
import co.com.activos.jrhu0055.utiliti.RespuestaGenerica;
import co.com.activos.jrhu0055.utiliti.TipoRespuesta;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Path("/")
public class IncapacidadController {

    @Inject

    private IncapacidadService service;

    @GET
    @Path("/listarIncapacidades")
    public Response listarIncapacidades() {
        List<Incapacidad> listarIncapacidades
                = service.listaIncapacidades().stream()
                        .sorted(Comparator.comparing(Incapacidad::getEstado))
                        .collect(Collectors.toList());
        GenericEntity<List<Incapacidad>> incapacidades = new GenericEntity<List<Incapacidad>>(listarIncapacidades) {
        };
        return Response
                .ok(incapacidades)
                .status(Response.Status.OK)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

    @GET
    @Path("/eliminar")
    public Response eliminarDirectorio() {
        ServicioEliminar servicioEliminar = new ServicioEliminarImpl();
        ReqEliminar eliminar = new ReqEliminar();
        eliminar.setTipoElemento("Directorio");
        eliminar.setIdElemento("1152823");
        Response response = servicioEliminar.eliminar(eliminar);

        return Response.ok(response.getStatus()).type(MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/listarTiposIncapacidad")
    public Response listarTiposIncapacidad() {
        try {
            List<TipoIncapacidad> tipoIncapacidades
                    = service.listaTipoIncapacidades()
                            .stream()
                            .sorted(Comparator.comparing(TipoIncapacidad::getCodigoTipoIncapacidad))
                            .collect(Collectors.toList());
            GenericEntity<List<TipoIncapacidad>> incapacidades = new GenericEntity<List<TipoIncapacidad>>(tipoIncapacidades) {
            };
            return Response
                    .ok(incapacidades)
                    .status(Response.Status.OK)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();

        } catch (Throwable throwable) {
            return Response
                    .noContent()
                    .entity(throwable)
                    .build();

        }
    }

    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/listarSubTiposIncapacidad/{idTipoIncapacidad}")
    public Response listarSubtipoIncapacidad(@PathParam("idTipoIncapacidad") Integer idTipoIncapacidad) {
        try {

            List<SubTipoIncapacidad> subTipoIncapacidades
                    = service.listaSubTipoIncapacidades(idTipoIncapacidad)
                            .stream()
                            .sorted(Comparator.comparing(SubTipoIncapacidad::getCodigoSubTipoIncapacidad))
                            .collect(Collectors.toList());
            GenericEntity<List<SubTipoIncapacidad>> subTipoIncapacidad
                    = new GenericEntity<List<SubTipoIncapacidad>>(subTipoIncapacidades) {
            };
            return Response.ok()
                    .entity(subTipoIncapacidad)
                    .status(Response.Status.OK)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        } catch (Throwable throwable) {
            return Response
                    .noContent()
                    .entity(throwable)
                    .build();
        }

    }

    @POST
    @Path("/ListarContratos/")
    public Response ListarContratos(ContratoDTO contratoDTO) {
        try {
            List<Contrato> listarContratos
                    = service.listaContratos(contratoDTO)
                            .stream()
                            .sorted(Comparator.comparing(Contrato::getFechaFinalizacionContrato).reversed())
                            .collect(Collectors.toList());
            GenericEntity<List<Contrato>> contratos
                    = new GenericEntity<List<Contrato>>(listarContratos) {
            };
            return Response.ok().entity(contratos).build();
        } catch (Throwable throwable) {
            return Response
                    .noContent()
                    .entity(throwable)
                    .build();
        }
    }

    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/documentos/{idSubtipoIncapacidad}")
    public Response listarDocumentos(@PathParam("idSubtipoIncapacidad") Integer idSubtipoIncapacidad) {
        try {
            List<DocumentoPorSubtipoIncapacidad> documentoPorSubtipoIncapacidads
                    = service.listarDocumentos(idSubtipoIncapacidad)
                            .stream()
                            .sorted(Comparator.comparing(DocumentoPorSubtipoIncapacidad::getRequerido))
                            .collect(Collectors.toList());
            GenericEntity<List<DocumentoPorSubtipoIncapacidad>> documentos
                    = new GenericEntity<List<DocumentoPorSubtipoIncapacidad>>(documentoPorSubtipoIncapacidads) {
            };
            return Response.ok()
                    .entity(documentos)
                    .status(Response.Status.OK)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        } catch (Throwable throwable) {
            return Response
                    .noContent()
                    .entity(throwable)
                    .build();
        }
    }

    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/TiposDeEnfermedades/")
    public Response listarTiposEnfermedades() {
        try {
            List<TipoEnfermedad> tiposEnfermedades
                    = service.listarTipoEnfermedades()
                            .stream().sorted(Comparator
                                    .comparing(TipoEnfermedad::getNombreTipoEnfermedad))
                            .collect(Collectors.toList());
            GenericEntity<List<TipoEnfermedad>> documentos
                    = new GenericEntity<List<TipoEnfermedad>>(tiposEnfermedades) {
            };
            return Response.ok()
                    .entity(documentos)
                    .status(Response.Status.OK)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        } catch (Exception e) {
            return Response
                    .noContent()
                    .entity(e)
                    .build();
        }
    }

    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/SubTiposDeEnfermedades/{codigoGrupo}")
    public Response listarSubTiposEnfermedades(@PathParam("codigoGrupo") Integer codigoGrupo) {
        try {
            List<SubTipoEnfermedad> SubtiposEnfermedades
                    = service.listarSubTiposEnfermedades(codigoGrupo)
                            .stream().sorted(Comparator
                                    .comparing(SubTipoEnfermedad::getNombreSubTipoEnfermedad))
                            .collect(Collectors.toList());
            GenericEntity<List<SubTipoEnfermedad>> documentos
                    = new GenericEntity<List<SubTipoEnfermedad>>(SubtiposEnfermedades) {
            };
            return Response.ok()
                    .entity(documentos)
                    .status(Response.Status.OK)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        } catch (Exception e) {
            return Response
                    .noContent()
                    .entity(e)
                    .build();
        }
    }

    @POST
    @Path("/radicado/")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response crearRadicado(RadicadoDTO radicadoDTO) {
        RespuestaGenerica<InformacionTaxonomia> respuestaCreacionCarpetaHija = null;
        try {
            RespuestaGenerica<InformacionTaxonomia> respuestaCreacionCarpetaPadre = service.crearOEditarRadicado(radicadoDTO);
            if (respuestaCreacionCarpetaPadre.getObjeto().isEstado()) {
                //TODO : CREAR LA LOGICA PARA GENERAR EL RADICO Y RETORNAR EL CONSECUTIVO
                String numeroRadicado = "8349206";
                respuestaCreacionCarpetaHija
                        = service.crearTaxonomia(new RadicadoDTO(numeroRadicado, respuestaCreacionCarpetaPadre.getObjeto().getIdAzDigital(),
                                respuestaCreacionCarpetaPadre.getObjeto().getIdDeaCodigo(), radicadoDTO.getNumeroDocumentoEmpleado(), radicadoDTO.getTipoACargar()));
                return Response.ok().
                        entity(new RespuestaGenerica<>(TipoRespuesta.SUCCESS, 
                                respuestaCreacionCarpetaHija.getMensaje(),numeroRadicado.intern())).build(); 
            }
           
            return Response.noContent().entity(new RespuestaGenerica<>(TipoRespuesta.ERROR, "Error al Crear el Radicado")).build();
        } catch (Exception e) {
            return Response.noContent().entity(new RespuestaGenerica<>(TipoRespuesta.ERROR, "Error No contralado",e)).build();
        }

    }

}
