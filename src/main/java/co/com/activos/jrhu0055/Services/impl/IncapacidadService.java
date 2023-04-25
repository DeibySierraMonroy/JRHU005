package co.com.activos.jrhu0055.Services.impl;


import co.com.activos.jrhu0055.DTO.ContratoDTO;
import co.com.activos.jrhu0055.DTO.RadicadoDTO;
import co.com.activos.jrhu0055.model.*;
import co.com.activos.jrhu0055.repo.IincapacidaesRepo;
import co.com.activos.jrhu0055.utiliti.RespuestaGenerica;
import co.com.activos.jrhu0055.utiliti.TipoAccion;
import co.com.activos.jrhu0055.utiliti.TipoRespuesta;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

import static co.com.activos.jrhu0055.utiliti.ServicioRest.crearTaxonomiaIncapacidades;

public class IncapacidadService {

    private static final String _FLUJO = "DOCUMENTOS INCAPACIDADES";

    @Inject
    private IincapacidaesRepo iincapacidaesRepo;

    public List<Incapacidad> listaIncapacidades(){
        return iincapacidaesRepo.incapacidades();
    }
    public List<TipoIncapacidad> listaTipoIncapacidades(){
        return iincapacidaesRepo.listarTipoIncapacidades();
    }

    public List<SubTipoIncapacidad> listaSubTipoIncapacidades(Integer codigoTipoIncapacidad){
        return iincapacidaesRepo.listarSubTipoIncapacidades(codigoTipoIncapacidad);
    }

    public List<Contrato> listaContratos(ContratoDTO contratoDTO){
        return iincapacidaesRepo.listarContratos(contratoDTO);
    }

    public List<DocumentoPorSubtipoIncapacidad> listarDocumentos(Integer codigoSubTipoIncapacidad){
         return iincapacidaesRepo.listarDocumentos(codigoSubTipoIncapacidad);
    }

    public List<TipoEnfermedad> listarTipoEnfermedades(){
        return iincapacidaesRepo.listarEnfermedadesPorGrupos();
    }
    public List<SubTipoEnfermedad> listarSubTiposEnfermedades(Integer codigGrupo){
        return iincapacidaesRepo.listarSubtipoEnfermedadesPorGrupo(codigGrupo);
    }
    public RespuestaGenerica<InformacionTaxonomia> crearOEditarRadicado(RadicadoDTO radicadoDTO){
        try {
            if (Objects.nonNull(radicadoDTO)) {
                return validarTaxonomia(radicadoDTO);
            }
            return new RespuestaGenerica<>(TipoRespuesta.ERROR,
                    "No se puede procesar el radicado , revise la informacion a radicar.");
        } catch (RuntimeException e) {
            return new RespuestaGenerica<>(TipoRespuesta.ERROR,
                    "No se puede procesar el radicado debido a " + e.getMessage());
        }
    }
    public RespuestaGenerica<InformacionTaxonomia> validarTaxonomia(RadicadoDTO radicadoDTO){
        InformacionTaxonomia informacionTaxonomia;
       try {
           if (Objects.nonNull(radicadoDTO.getDeaCodigo()) && (Objects.nonNull(radicadoDTO.getContrato())|| Objects.nonNull(radicadoDTO.getNumeroRadicado())) ){
               informacionTaxonomia = iincapacidaesRepo.obtenerInformacionTaxonomia(
                       radicadoDTO.getDeaCodigo(),
                       radicadoDTO.getNumeroRadicado() != null
                               ? radicadoDTO.getNumeroRadicado()
                               : radicadoDTO.getContrato());
               if (informacionTaxonomia.isEstado()){
                   return new RespuestaGenerica<>(TipoRespuesta.SUCCESS,"Taxonomia Encontrada" , informacionTaxonomia);
               }
               return crearTaxonomia(radicadoDTO);
           }
           return new RespuestaGenerica<>(TipoRespuesta.ERROR,
                   "No se puede validar la taxonomia debido a que hay campos necesarios sin informacion");

       }catch (RuntimeException e){
           return new RespuestaGenerica<>(TipoRespuesta.ERROR,
                   "Error en IncapacidadService:validarTaxonomia " +
                           "No se puedo validar la taxonomia debido  a " + e.getMessage());
       }
    }
    public RespuestaGenerica<InformacionTaxonomia> crearTaxonomia (RadicadoDTO radicadoDTO){
        Taxonomia taxonomia;
        try{
         taxonomia = new Taxonomia(radicadoDTO.getTipoACargar(),radicadoDTO.getAzCodigo(),
                 radicadoDTO.getNumeroRadicado() != null
                         ? radicadoDTO.getNumeroRadicado()
                         : radicadoDTO.getContrato(),radicadoDTO.getNumeroDocumentoEmpleado(),_FLUJO,radicadoDTO.getDeaCodigo());
         RespuestaGenerica<InformacionTaxonomia> respuestaGenerica = crearTaxonomiaIncapacidades(taxonomia);
         if (respuestaGenerica.getObjeto().isEstado()){
             return new RespuestaGenerica<>(TipoRespuesta.SUCCESS,"Taxonomia Creada",respuestaGenerica.getObjeto());
         }
         return new RespuestaGenerica(TipoRespuesta.ERROR,respuestaGenerica.getMensaje());
        } catch (Exception e) {
            return new RespuestaGenerica(TipoRespuesta.ERROR,"Error al Crear la taxonomia en : IncapacidadService:crearTaxonomia " + e.getMessage());
        }
    }
}
