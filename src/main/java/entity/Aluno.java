package entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Aluno implements Serializable {

	private static final long serialVersionUID = 2749373371537870295L;

	@Id
	@GeneratedValue
	private Long id;

	private String nome;
	private Integer cpf;
	private Integer ra;

	@Temporal(TemporalType.DATE)
	private LocalDate dataNascimento;

	@Temporal(TemporalType.DATE)
	private LocalDate dataEntrada;
	private Boolean trabalhaArea;
	private Boolean sexo;

	@OneToOne
	private Aluno usuario;

	@ManyToOne
	private Curso curso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public Integer getRa() {
		return ra;
	}

	public void setRa(Integer ra) {
		this.ra = ra;
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

	public Boolean getSexo() {
		return sexo;
	}

	public void setSexo(Boolean sexo) {
		this.sexo = sexo;
	}

	public Aluno getUsuario() {
		return usuario;
	}

	public void setUsuario(Aluno usuario) {
		this.usuario = usuario;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
