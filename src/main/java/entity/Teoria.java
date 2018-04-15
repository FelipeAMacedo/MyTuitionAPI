package entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Teoria extends Conteudo implements Serializable {

	private static final long serialVersionUID = -7468463719652771860L;

	private String texto;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
