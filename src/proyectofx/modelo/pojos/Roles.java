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
public class Roles {
    private Integer idRol;
    private String nombreRol;
    private String estatus;
    private String descripcion;

    public Roles() {
    }

    public Roles(Integer idRol, String nombreRol, String estatus, String descripcion) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.estatus = estatus;
        this.descripcion = descripcion;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



}
