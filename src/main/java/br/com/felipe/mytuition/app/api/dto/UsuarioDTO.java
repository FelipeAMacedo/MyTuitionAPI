package br.com.felipe.mytuition.app.api.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.felipe.mytuition.app.enumerations.Perfil;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 7700278570593873759L;

	@JsonProperty(value = "email")
	private String email;

	@JsonProperty(value = "senha")
	private String senha;

	@JsonProperty(value = "perfil")
	private Perfil perfil;

	@JsonProperty(value = "informacoesPessoais")
	private AlunoDTO alunoDTO;

	@JsonProperty(value = "heroi")
	private HeroiDTO heroiDTO;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public AlunoDTO getAlunoDTO() {
		return alunoDTO;
	}

	public void setAlunoDTO(AlunoDTO alunoDTO) {
		this.alunoDTO = alunoDTO;
	}

	public HeroiDTO getHeroiDTO() {
		return heroiDTO;
	}

	public void setHeroiDTO(HeroiDTO heroiDTO) {
		this.heroiDTO = heroiDTO;
	}

}
