/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofx.modelo.pojos;
import java.util.Date;
import java.util.List;
/**
 *
 * @author afs30
 */
public class VentasRemates {
    
    private Integer idVenta;
    private String subtotal;
    private String ivaVenta;
    private String totalVenta;
    private Integer idContrato;
    private String estatusVenta;
    private Integer idCliente;
    private Integer idCreador;
    private String fechaCreacion;
    private Integer totalArticulos;
    private String fechaCancelacion;
    private Integer idUsuario;
    private String tipoVenta;


    public VentasRemates() {
    }

    public VentasRemates(Integer idVenta, String subtotal, String ivaVenta, String totalVenta, Integer idContrato, String estatusVenta, Integer idCliente, Integer idCreador, String fechaCreacion, Integer totalArticulos, String fechaCancelacion, Integer idUsuario, String tipoVenta) {
        this.idVenta = idVenta;
        this.subtotal = subtotal;
        this.ivaVenta = ivaVenta;
        this.totalVenta = totalVenta;
        this.idContrato = idContrato;
        this.estatusVenta = estatusVenta;
        this.idCliente = idCliente;
        this.idCreador = idCreador;
        this.fechaCreacion = fechaCreacion;
        this.totalArticulos = totalArticulos;
        this.fechaCancelacion = fechaCancelacion;
        this.idUsuario = idUsuario;
        this.tipoVenta = tipoVenta;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getIvaVenta() {
        return ivaVenta;
    }

    public void setIvaVenta(String ivaVenta) {
        this.ivaVenta = ivaVenta;
    }

    public String getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(String totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public String getEstatusVenta() {
        return estatusVenta;
    }

    public void setEstatusVenta(String estatusVenta) {
        this.estatusVenta = estatusVenta;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdCreador() {
        return idCreador;
    }

    public void setIdCreador(Integer idCreador) {
        this.idCreador = idCreador;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getTotalArticulos() {
        return totalArticulos;
    }

    public void setTotalArticulos(Integer totalArticulos) {
        this.totalArticulos = totalArticulos;
    }

    public String getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(String fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

}
