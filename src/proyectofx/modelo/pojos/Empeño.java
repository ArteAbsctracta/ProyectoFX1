/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofx.modelo.pojos;
import java.util.Date;
/**
 *
 * @author afs30
 */
public class Empeño {
    private Integer idEmpeño;
    private Integer idCliente;
    private Date fechaCreacion;
    private String observaciones;
    private Integer idUsuario;
    private String contratoActual;
    private Date fechaActualizacion;
    private double interesPorcentaje;
    private double almacenajePorcentaje;
    private int numPeriodos;
    private int diasPeriodo;
    private double ivaEmpeño;
    private double tasaComercializacion;
    private String nombreUsuario;

    public Empeño() {
    }

    public Empeño(Integer idEmpeño, Integer idCliente, Date fechaCreacion, String observaciones, Integer idUsuario, String contratoActual, Date fechaActualizacion, double interesPorcentaje, double almacenajePorcentaje, int numPeriodos, int diasPeriodo, double ivaEmpeño, double tasaComercializacion, String nombreUsuario) {
        this.idEmpeño = idEmpeño;
        this.idCliente = idCliente;
        this.fechaCreacion = fechaCreacion;
        this.observaciones = observaciones;
        this.idUsuario = idUsuario;
        this.contratoActual = contratoActual;
        this.fechaActualizacion = fechaActualizacion;
        this.interesPorcentaje = interesPorcentaje;
        this.almacenajePorcentaje = almacenajePorcentaje;
        this.numPeriodos = numPeriodos;
        this.diasPeriodo = diasPeriodo;
        this.ivaEmpeño = ivaEmpeño;
        this.tasaComercializacion = tasaComercializacion;
        this.nombreUsuario = nombreUsuario;
    }

    public Integer getIdEmpeño() {
        return idEmpeño;
    }

    public void setIdEmpeño(Integer idEmpeño) {
        this.idEmpeño = idEmpeño;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContratoActual() {
        return contratoActual;
    }

    public void setContratoActual(String contratoActual) {
        this.contratoActual = contratoActual;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public double getInteresPorcentaje() {
        return interesPorcentaje;
    }

    public void setInteresPorcentaje(double interesPorcentaje) {
        this.interesPorcentaje = interesPorcentaje;
    }

    public double getAlmacenajePorcentaje() {
        return almacenajePorcentaje;
    }

    public void setAlmacenajePorcentaje(double almacenajePorcentaje) {
        this.almacenajePorcentaje = almacenajePorcentaje;
    }

    public int getNumPeriodos() {
        return numPeriodos;
    }

    public void setNumPeriodos(int numPeriodos) {
        this.numPeriodos = numPeriodos;
    }

    public int getDiasPeriodo() {
        return diasPeriodo;
    }

    public void setDiasPeriodo(int diasPeriodo) {
        this.diasPeriodo = diasPeriodo;
    }

    public double getIvaEmpeño() {
        return ivaEmpeño;
    }

    public void setIvaEmpeño(double ivaEmpeño) {
        this.ivaEmpeño = ivaEmpeño;
    }

    public double getTasaComercializacion() {
        return tasaComercializacion;
    }

    public void setTasaComercializacion(double tasaComercializacion) {
        this.tasaComercializacion = tasaComercializacion;
    }
    
    
}
