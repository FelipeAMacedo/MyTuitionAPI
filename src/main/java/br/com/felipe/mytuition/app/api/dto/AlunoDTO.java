package br.com.felipe.mytuition.app.api.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.felipe.mytuition.app.utils.LocalDateDeserializer;
import br.com.felipe.mytuition.app.utils.LocalDateSerializer;

public class AlunoDTO implements Serializable {

	private static final long serialVersionUID = 5598598162297350726L;

	@JsonProperty(value = "nome")
	private String nome;

	@JsonProperty(value = "cpf")
	private String cpf;

	@JsonProperty(value = "ra")
	private String ra;

	@JsonProperty(value = "sexo")
	private Boolean sexo;

	@JsonProperty(value = "dataNascimento")
	@JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate dataNascimento;

	@JsonProperty(value = "dataEntrada")
	@JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate dataEntrada;
	
	@JsonProperty(value = "curso")
	private Long curso;
	
	@JsonProperty(value = "trabalhaArea")
	private Boolean trabalhaArea;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public Boolean getSexo() {
		return sexo;
	}

	public void setSexo(Boolean sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Boolean getTrabalhaArea() {
		return trabalhaArea;
	}

	public void setTrabalhaArea(Boolean trabalhaArea) {
		this.trabalhaArea = trabalhaArea;
	}

}
