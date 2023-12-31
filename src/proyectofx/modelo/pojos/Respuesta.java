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
public class Respuesta <T> {
    private String mensaje;
	private T contenido;
	private Boolean isError;

    public Boolean getIsError() {
		return isError;
	}

	public void setIsError(Boolean isError) {
		this.isError = isError;
	}

	public Respuesta(T contenido) {
		this.contenido = contenido;
	}

	public T getContenido() {
		return contenido;
	}

	public void setContenido(T contenido) {
		this.contenido = contenido;
	}

	public Respuesta() {
    }

    public Respuesta(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}

