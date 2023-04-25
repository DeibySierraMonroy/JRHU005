package co.com.activos.jrhu0055.Services;

import co.com.activos.jrhu0055.DTO.ContratoDTO;
import co.com.activos.jrhu0055.model.*;

import java.util.List;

public interface IincapacidadService {

    List<Incapacidad> incapacidades();

    List<TipoIncapacidad> listarTipoIncapacidades();

    List<SubTipoIncapacidad> listarSubTipoIncapacidades(Integer codigoTipoIncapacidad);

    List<Contrato> listarContratos(ContratoDTO contratoDTO);

    List<DocumentoPorSubtipoIncapacidad> listarDocumentos (Integer codigoSubTipoIncapacidad);


    List<TipoEnfermedad> listarEnfermedadesPorGrupos();

    List<SubTipoEnfermedad> listarSubtipoEnfermedadesPorGrupo(Integer codigoGrupo);

    InformacionTaxonomia obtenerInformacionTaxonomia(String deaCodigo,String nombreCarpeta);








}
