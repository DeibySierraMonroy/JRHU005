package co.com.activos.jrhu0055.repo;

import co.com.activos.jrhu0055.DTO.ContratoDTO;
import co.com.activos.jrhu0055.Services.IincapacidadService;
import co.com.activos.jrhu0055.model.*;
import co.com.activos.jrhu0055.utiliti.Conexion;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class IincapacidaesRepo implements IincapacidadService {


    @Override
    public List<Incapacidad> incapacidades() {
        List<Incapacidad> listaIncapacidades = new ArrayList<>();
        try (Connection connection = Conexion.getConnection()){
            String consulta = "call RHU.QB_APLICATION_JRHU0055.PL_OBTENER_TODAS_INCAPACIDADES(?,?,?)";
            try(CallableStatement callableStatement = connection.prepareCall(consulta)){
                callableStatement.registerOutParameter("RCINC", OracleTypes.CURSOR);
                callableStatement.registerOutParameter("VCESTADO_PROCESO", OracleTypes.VARCHAR);
                callableStatement.registerOutParameter("VCMENSAJE_PROCESO", OracleTypes.VARCHAR);
                callableStatement.execute();

                ResultSet resultSet = (ResultSet) callableStatement.getObject("RCINC");
                while (resultSet.next()){
                    Incapacidad incapacidad = new Incapacidad();
                    incapacidad.setEstado(resultSet.getString("INC_ESTADO"));
                    incapacidad.setNitEmpresa(resultSet.getInt("EMP_ND"));
                    incapacidad.setNumeroContrato(resultSet.getInt("CTO_NUMERO"));
                    incapacidad.setSigla(resultSet.getString("TEN_SIGLA"));
                    incapacidad.setTipoDocumentoEmpresa(resultSet.getString("TDC_TD"));
                    incapacidad.setTipoDocumentoEmpleado(resultSet.getString("TDC_TD_EPL"));
                    incapacidad.setNumeroDocumentoEmpleado(resultSet.getInt("EPL_ND"));
                    listaIncapacidades.add(incapacidad);
                }
                callableStatement.close();
                return listaIncapacidades;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }

    @Override
    public List<TipoIncapacidad> listarTipoIncapacidades() {
        List<TipoIncapacidad> tipoIncapacidades = new ArrayList<>();
        try (Connection connection = Conexion.getConnection()) {
            String consulta = "call RHU.QB_APLICATION_JRHU0055.PL_OBTENER_TIP_INCAPACIDAD(?,?,?)";
            try (CallableStatement callableStatement = connection.prepareCall(consulta)) {
                callableStatement.registerOutParameter("RTIPINCAPACIDAD", OracleTypes.CURSOR);
                callableStatement.registerOutParameter("VCESTADO_PROCESO", OracleTypes.VARCHAR);
                callableStatement.registerOutParameter("VCMENSAJE_PROCESO", OracleTypes.VARCHAR);
                callableStatement.execute();
                ResultSet resultSet = (ResultSet) callableStatement.getObject("RTIPINCAPACIDAD");
                if (Objects.nonNull(resultSet)) {
                    while (resultSet.next()) {
                        TipoIncapacidad tipoIncapacidad = new TipoIncapacidad();
                        tipoIncapacidad.setCodigoTipoIncapacidad(resultSet.getInt("TIPOINC_CODIGO"));
                        tipoIncapacidad.setNombreTipoIncapacidad(resultSet.getString("TIPOINC_NOMBRE"));
                        tipoIncapacidad.setEstado(resultSet.getString("TIPOINC_ESTADO"));
                        tipoIncapacidades.add(tipoIncapacidad);
                    }
                }
                callableStatement.close();
                return tipoIncapacidades;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<SubTipoIncapacidad> listarSubTipoIncapacidades(Integer codigoTipoIncapacidad) {
        List<SubTipoIncapacidad> subtipoIncapacidades = new ArrayList<>();
        try (Connection connection = Conexion.getConnection()) {
            String consulta = "call RHU.QB_APLICATION_JRHU0055.PL_OBTENER_SUBTIP_INCAPACIDAD(?,?,?,?)";
            try (CallableStatement callableStatement = connection.prepareCall(consulta)) {
                callableStatement.setInt("NTIPOINC", codigoTipoIncapacidad);
                callableStatement.registerOutParameter("RSUBINCAPACIDAD", OracleTypes.CURSOR);
                callableStatement.registerOutParameter("VCESTADO_PROCESO", OracleTypes.VARCHAR);
                callableStatement.registerOutParameter("VCMENSAJE_PROCESO", OracleTypes.VARCHAR);
                callableStatement.execute();
                ResultSet resultSet = (ResultSet) callableStatement.getObject("RSUBINCAPACIDAD");
                if (Objects.nonNull(resultSet)) {
                    while (resultSet.next()) {
                        SubTipoIncapacidad subTipoIncapacidad = new SubTipoIncapacidad();
                        subTipoIncapacidad.setCodigoSubTipoIncapacidad(resultSet.getInt("SUBTIPOINC_CODIGO"));
                        subTipoIncapacidad.setNombreSubTipoIncapacidad(resultSet.getString("SUBTIPOINC_NOMBRE"));
                        subTipoIncapacidad.setEstado(resultSet.getString("SUBTIPOINC_ESTADO"));
                        subtipoIncapacidades.add(subTipoIncapacidad);
                    }
                }
                callableStatement.close();
                return subtipoIncapacidades;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Contrato> listarContratos(ContratoDTO contratoDTO) {
        List<Contrato> contratos = new ArrayList<>();
        try (Connection connection = Conexion.getConnection()) {
            String consulta = "call RHU.QB_APLICATION_JRHU0055.PL_OBTENER_CONTRATOS(?,?,?,?,?,?,?)";
            try (CallableStatement callableStatement = connection.prepareCall(consulta)) {
                callableStatement.setString("VTDC_TD_EPL",contratoDTO.getTipoDocumentoEmpleado());
                callableStatement.setInt("NEPL_ND",contratoDTO.getDocumentoEmpleado());
                callableStatement.setInt("NEMP_ND",contratoDTO.getDocumentoEmpresa());
                callableStatement.setString("VTDC_TD",contratoDTO.getTipoDocumentoEmpresa());

                callableStatement.registerOutParameter("RCONTRATOS", OracleTypes.CURSOR);
                callableStatement.registerOutParameter("VCESTADO_PROCESO", OracleTypes.VARCHAR);
                callableStatement.registerOutParameter("VCMENSAJE_PROCESO", OracleTypes.VARCHAR);
                callableStatement.execute();
                ResultSet resultSet = (ResultSet) callableStatement.getObject("RCONTRATOS");
                if (Objects.nonNull(resultSet)) {
                    while (resultSet.next()) {
                        Contrato contrato = new Contrato();
                        contrato.setNumeroContrato(resultSet.getInt("CTO_NUMERO"));
                        contrato.setFechaRetiro(resultSet.getString("CTO_FECRET"));
                        contrato.setFechaFinalizacionContrato(resultSet.getString("CTO_FECTERM"));
                        contrato.setNombreEmpresaFilial(resultSet.getString("NOMBRE_EMPRESA_USUARIA"));
                        contrato.setNombreEmpresaPrincipal(resultSet.getString("NOMBRE_EMPRESA_PRINCIPAL"));
                        contrato.setEstadoDelContrato(resultSet.getString("ESTADO_CONTRATO"));
                        contratos.add(contrato);
                    }
                }
                callableStatement.close();
                return contratos;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DocumentoPorSubtipoIncapacidad> listarDocumentos(Integer codigoSubTipoIncapacidad) {
        List<DocumentoPorSubtipoIncapacidad> documentoPorSubtipoIncapacidades = new ArrayList<>();
        try (Connection connection = Conexion.getConnection()){
            String consulta = "call RHU.QB_APLICATION_JRHU0055.PL_OBTENER_DOCUM_SUBTIP(?,?,?,?)";
            try(CallableStatement callableStatement = connection.prepareCall(consulta)){
               callableStatement.setInt("NSUBTIPOINC" , codigoSubTipoIncapacidad);
               callableStatement.registerOutParameter("RDOCUMENSUBTIPO" ,OracleTypes.CURSOR);
               callableStatement.registerOutParameter("VCESTADO_PROCESO" ,OracleTypes.VARCHAR);
               callableStatement.registerOutParameter("VCMENSAJE_PROCESO" ,OracleTypes.VARCHAR);
               callableStatement.execute();
               ResultSet resultSet = (ResultSet) callableStatement.getObject("RDOCUMENSUBTIPO");
                if (Objects.nonNull(resultSet)) {
                    while (resultSet.next()) {
                        DocumentoPorSubtipoIncapacidad documentoPorSubtipoIncapacidad = new DocumentoPorSubtipoIncapacidad();
                        documentoPorSubtipoIncapacidad.setIdDocumento(resultSet.getInt("TPD_CODIGO"));
                        documentoPorSubtipoIncapacidad.setDescripcionDelDocumento(resultSet.getString("TPD_DESCRIPCION"));
                        documentoPorSubtipoIncapacidad.setRequerido(
                                documentoPorSubtipoIncapacidad.
                                        validarSiElDocumentoEsrequerido(resultSet.getString("SUDO_REQUERIDO"))
                        );
                        documentoPorSubtipoIncapacidades.add(documentoPorSubtipoIncapacidad);
                    }
                }
                callableStatement.close();
                return documentoPorSubtipoIncapacidades;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<TipoEnfermedad> listarEnfermedadesPorGrupos() {
        List<TipoEnfermedad> tiposEnfermedades = new ArrayList<>();
        try(Connection connection = Conexion.getConnection()){
            String consulta = "call RHU.QB_APLICATION_JRHU0055.PL_GRUP_ENFERMEDAD(?,?,?)";
            try(CallableStatement callableStatement = connection.prepareCall(consulta)){
                callableStatement.registerOutParameter("RGPENFER",OracleTypes.CURSOR);
                callableStatement.registerOutParameter("VCESTADO_PROCESO",OracleTypes.VARCHAR);
                callableStatement.registerOutParameter("VCMENSAJE_PROCESO",OracleTypes.VARCHAR);
                callableStatement.execute();
                ResultSet resultSet = (ResultSet) callableStatement.getObject("RGPENFER");
                if(Objects.nonNull(resultSet)){
                    while (resultSet.next()){
                        TipoEnfermedad tipoEnfermedad = new TipoEnfermedad();
                        tipoEnfermedad.setCodigoTipoEnfermedad(resultSet.getString("GEN_COD"));
                        tipoEnfermedad.setNombreTipoEnfermedad(resultSet.getString("GEN_NOMBRE"));
                        tiposEnfermedades.add(tipoEnfermedad);
                    }
                }
                callableStatement.close();
                return tiposEnfermedades;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<SubTipoEnfermedad> listarSubtipoEnfermedadesPorGrupo(Integer codigoGrupo) {
        List<SubTipoEnfermedad> subTipoEnfermedads = new ArrayList<>();
        try(Connection connection = Conexion.getConnection()){
            String consulta = "call RHU.QB_APLICATION_JRHU0055.PL_SUB_GRUP_ENFERMEDAD(?,?,?,?)";
            try(CallableStatement callableStatement = connection.prepareCall(consulta)){
                callableStatement.setInt("NMGPENFER",codigoGrupo);
                callableStatement.registerOutParameter("RSGPENFER",OracleTypes.CURSOR);
                callableStatement.registerOutParameter("VCESTADO_PROCESO",OracleTypes.VARCHAR);
                callableStatement.registerOutParameter("VCMENSAJE_PROCESO",OracleTypes.VARCHAR);
                callableStatement.execute();
                ResultSet resultSet = (ResultSet) callableStatement.getObject("RSGPENFER");
                if(Objects.nonNull(resultSet)){
                    while(resultSet.next()){
                        SubTipoEnfermedad subTipoEnfermedad = new SubTipoEnfermedad();
                        subTipoEnfermedad.setCodigoSubTipoEnfermedad(resultSet.getString("SEN_COD"));
                        subTipoEnfermedad.setNombreSubTipoEnfermedad(resultSet.getString("SEN_NOMBRE"));
                        subTipoEnfermedads.add(subTipoEnfermedad);
                    }
                }
                callableStatement.close();
                return subTipoEnfermedads;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public InformacionTaxonomia obtenerInformacionTaxonomia(String deaCodigo, String nombreCarpeta) {
        InformacionTaxonomia informacionTaxonomia = new InformacionTaxonomia();
        try (Connection conexion = Conexion.getConnection()) {
            String consulta = "{ call RHU.QB_APLICATION_JRHU0055.PL_BUSCAR_TAX_INCA_INTER(?,?,?,?,?,?)}";
            try (CallableStatement call = conexion.prepareCall(consulta)) {
                call.setString("NDESCRIP", nombreCarpeta);
                call.setLong("NMDEACODIGO", Long.parseLong(deaCodigo));
                call.registerOutParameter("NMDEAPADRE", OracleTypes.NUMBER);
                call.registerOutParameter("NMAZCODIGO", OracleTypes.NUMBER);
                call.registerOutParameter("VCESTADO_PROCESO", OracleTypes.VARCHAR);
                call.registerOutParameter("VCMENSAJE_PROCESO", OracleTypes.VARCHAR);
                call.execute();
                informacionTaxonomia.setIdAzDigital(call.getNString("NMAZCODIGO"));
                informacionTaxonomia.setIdDeaCodigo(call.getNString("NMDEAPADRE"));
                if (Objects.nonNull(informacionTaxonomia.getIdAzDigital()) &&
                        Objects.nonNull(informacionTaxonomia.getIdDeaCodigo())) {
                    informacionTaxonomia.setEstado(true);
                } else {
                    informacionTaxonomia.setEstado(false);
                }
            }
        } catch (SQLException exception) {
            return new InformacionTaxonomia(InformacionTaxonomia.RespuestaGenerica.ERROR.getEstado() + exception.getLocalizedMessage());
        }
        return informacionTaxonomia;
    }
}
