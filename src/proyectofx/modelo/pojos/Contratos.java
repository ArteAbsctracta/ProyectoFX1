/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofx.modelo.pojos;

/**
 *
 * @author otreb
 */
public class Contratos {

    private Integer idContrato;
    private Integer idEmpeno;
    private Integer idEspera;
    private Integer idFiniquito;
    private Integer idRefrendo;
    private Integer idUsuario;
    private Integer importePrestamo;
    private String observaciones;
    private String fechaLimite;
    private String fechaCreacion;
    private String fechaComercializacion;
    private String fechaCancelacion;
    private String fechaActualizacion;
    private String estatusContrato;
    private String contratoSiguiente;
    private String contratoAnterior;
    private String nombreUsuario;

    public Contratos() {
    }

    public Contratos(Integer idContrato, Integer idEmpeno, Integer idEspera, Integer idFiniquito, Integer idRefrendo, Integer idUsuario, Integer importePrestamo, String observaciones, String fechaLimite, String fechaCreacion, String fechaComercializacion, String fechaCancelacion, String fechaActualizacion, String estatusContrato, String contratoSiguiente, String contratoAnterior, String nombreUsuario) {
        this.idContrato = idContrato;
        this.idEmpeno = idEmpeno;
        this.idEspera = idEspera;
        this.idFiniquito = idFiniquito;
        this.idRefrendo = idRefrendo;
        this.idUsuario = idUsuario;
        this.importePrestamo = importePrestamo;
        this.observaciones = observaciones;
        this.fechaLimite = fechaLimite;
        this.fechaCreacion = fechaCreacion;
        this.fechaComercializacion = fechaComercializacion;
        this.fechaCancelacion = fechaCancelacion;
        this.fechaActualizacion = fechaActualizacion;
        this.estatusContrato = estatusContrato;
        this.contratoSiguiente = contratoSiguiente;
        this.contratoAnterior = contratoAnterior;
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    

    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public Integer getIdEmpeno() {
        return idEmpeno;
    }

    public void setIdEmpeno(Integer idEmpeno) {
        this.idEmpeno = idEmpeno;
    }

    public Integer getIdEspera() {
        return idEspera;
    }

    public void setIdEspera(Integer idEspera) {
        this.idEspera = idEspera;
    }

    public Integer getIdFiniquito() {
        return idFiniquito;
    }

    public void setIdFiniquito(Integer idFiniquito) {
        this.idFiniquito = idFiniquito;
    }

    public Integer getIdRefrendo() {
        return idRefrendo;
    }

    public void setIdRefrendo(Integer idRefrendo) {
        this.idRefrendo = idRefrendo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getImportePrestamo() {
        return importePrestamo;
    }

    public void setImportePrestamo(Integer importePrestamo) {
        this.importePrestamo = importePrestamo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaComercializacion() {
        return fechaComercializacion;
    }

    public void setFechaComercializacion(String fechaComercializacion) {
        this.fechaComercializacion = fechaComercializacion;
    }

    public String getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(String fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getEstatusContrato() {
        return estatusContrato;
    }

    public void setEstatusContrato(String estatusContrato) {
        this.estatusContrato = estatusContrato;
    }

    public String getContratoSiguiente() {
        return contratoSiguiente;
    }

    public void setContratoSiguiente(String contratoSiguiente) {
        this.contratoSiguiente = contratoSiguiente;
    }

    public String getContratoAnterior() {
        return contratoAnterior;
    }

    public void setContratoAnterior(String contratoAnterior) {
        this.contratoAnterior = contratoAnterior;
    }

}
