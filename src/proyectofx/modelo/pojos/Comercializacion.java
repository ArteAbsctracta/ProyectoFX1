/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofx.modelo.pojos;

/**
 *
 * @author afs30
 */
public class Comercializacion {
    private Integer idComercializacion;
    private String fechaCreacion;
    private String idUsuario;
    private String fechaInicioBusqueda;
    private String fechaFinalBusqueda;
    private String observaciones;
    private String tipoComercializacion;

    public Comercializacion() {
    }

    public Comercializacion(Integer idComercializacion, String fechaCreacion, String creador, String fechaInicioBusqueda, String fechaFinalBusqueda, String observaciones, String tipoComercializacion) {
        this.idComercializacion = idComercializacion;
        this.fechaCreacion = fechaCreacion;
        this.idUsuario = creador;
        this.fechaInicioBusqueda = fechaInicioBusqueda;
        this.fechaFinalBusqueda = fechaFinalBusqueda;
        this.observaciones = observaciones;
        this.tipoComercializacion = tipoComercializacion;
    }

    public Integer getIdComercializacion() {
        return idComercializacion;
    }

    public void setIdComercializacion(Integer idComercializacion) {
        this.idComercializacion = idComercializacion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getCreador() {
        return idUsuario;
    }

    public void setCreador(String creador) {
        this.idUsuario = creador;
    }

    public String getFechaInicioBusqueda() {
        return fechaInicioBusqueda;
    }

    public void setFechaInicioBusqueda(String fechaInicioBusqueda) {
        this.fechaInicioBusqueda = fechaInicioBusqueda;
    }

    public String getFechaFinalBusqueda() {
        return fechaFinalBusqueda;
    }

    public void setFechaFinalBusqueda(String fechaFinalBusqueda) {
        this.fechaFinalBusqueda = fechaFinalBusqueda;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getTipoComercializacion() {
        return tipoComercializacion;
    }

    public void setTipoComercializacion(String tipoComercializacion) {
        this.tipoComercializacion = tipoComercializacion;
    }
 
}
