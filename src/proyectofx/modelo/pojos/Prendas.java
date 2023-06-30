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
public class Prendas {
    
    private Integer idPrenda;
    private Integer idEmpeño ;
    private String categoria;
    private Integer numPiezas;
    private String serie;
    private String modelo;
    private String subcategoria;
    private String descripcionPrenda;
    private String esMetal;
    private String peso;
    private String kilataje;
    private String prestamo;
    private String modeloPrenda;
    private String precioComercializacion;
    private String precioVenta;
    private String estatusPrenda;
    private String comercializacionAsociada;
    private Date fechaCreacion;
    private Date fechaComercializacion;
    private Date fechaVenta;
    private Integer idUsuario;
    private String nombreUsuario;
    public Prendas() {
    }

    public Prendas(Integer idPrenda, Integer idEmpeño, String categoria, Integer numPiezas, String serie, String modelo, String subcategoria, String descripcionPrenda, String esMetal, String peso, String kilataje, String prestamo, String modeloPrenda, String precioComercializacion, String precioVenta, String estatusPrenda, String comercializacionAsociada, Date fechaCreacion, Date fechaComercializacion, Date fechaVenta, Integer idUsuario, String nombreUsuario) {
        this.idPrenda = idPrenda;
        this.idEmpeño = idEmpeño;
        this.categoria = categoria;
        this.numPiezas = numPiezas;
        this.serie = serie;
        this.modelo = modelo;
        this.subcategoria = subcategoria;
        this.descripcionPrenda = descripcionPrenda;
        this.esMetal = esMetal;
        this.peso = peso;
        this.kilataje = kilataje;
        this.prestamo = prestamo;
        this.modeloPrenda = modeloPrenda;
        this.precioComercializacion = precioComercializacion;
        this.precioVenta = precioVenta;
        this.estatusPrenda = estatusPrenda;
        this.comercializacionAsociada = comercializacionAsociada;
        this.fechaCreacion = fechaCreacion;
        this.fechaComercializacion = fechaComercializacion;
        this.fechaVenta = fechaVenta;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Integer getIdPrenda() {
        return idPrenda;
    }

    public void setIdPrenda(Integer idPrenda) {
        this.idPrenda = idPrenda;
    }

    public Integer getIdEmpeño() {
        return idEmpeño;
    }

    public void setIdEmpeño(Integer idEmpeño) {
        this.idEmpeño = idEmpeño;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getNumPiezas() {
        return numPiezas;
    }

    public void setNumPiezas(Integer numPiezas) {
        this.numPiezas = numPiezas;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getDescripcionPrenda() {
        return descripcionPrenda;
    }

    public void setDescripcionPrenda(String descripcionPrenda) {
        this.descripcionPrenda = descripcionPrenda;
    }

    public String isEsMetal() {
        return esMetal;
    }

    public void setEsMetal(String esMetal) {
        this.esMetal = esMetal;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getKilataje() {
        return kilataje;
    }

    public void setKilataje(String kilataje) {
        this.kilataje = kilataje;
    }

    public String getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(String prestamo) {
        this.prestamo = prestamo;
    }

    public String getModeloPrenda() {
        return modeloPrenda;
    }

    public void setModeloPrenda(String modeloPrenda) {
        this.modeloPrenda = modeloPrenda;
    }

    public String getPrecioComercializacion() {
        return precioComercializacion;
    }

    public void setPrecioComercializacion(String precioComercializacion) {
        this.precioComercializacion = precioComercializacion;
    }

    public String getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(String precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getEstatusPrenda() {
        return estatusPrenda;
    }

    public void setEstatusPrenda(String estatusPrenda) {
        this.estatusPrenda = estatusPrenda;
    }

    public String getComercializacionAsociada() {
        return comercializacionAsociada;
    }

    public void setComercializacionAsociada(String comercializacionAsociada) {
        this.comercializacionAsociada = comercializacionAsociada;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaComercializacion() {
        return fechaComercializacion;
    }

    public void setFechaComercializacion(Date fechaComercializacion) {
        this.fechaComercializacion = fechaComercializacion;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Prendas{" + "idPrenda=" + idPrenda + ", idEmpe\u00f1o=" + idEmpeño + ", categoria=" + categoria + ", numPiezas=" + numPiezas + ", serie=" + serie + ", modelo=" + modelo + ", subcategoria=" + subcategoria + ", descripcionPrenda=" + descripcionPrenda + ", esMetal=" + esMetal + ", peso=" + peso + ", kilataje=" + kilataje + ", prestamo=" + prestamo + ", modeloPrenda=" + modeloPrenda + ", precioComercializacion=" + precioComercializacion + ", precioVenta=" + precioVenta + ", estatusPrenda=" + estatusPrenda + ", comercializacionAsociada=" + comercializacionAsociada + ", fechaCreacion=" + fechaCreacion + ", fechaComercializacion=" + fechaComercializacion + ", fechaVenta=" + fechaVenta + ", idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + '}';
    }
    
    
    
}
