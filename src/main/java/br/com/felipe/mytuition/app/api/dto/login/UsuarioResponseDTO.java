package br.com.felipe.mytuition.app.api.dto.login;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.felipe.mytuition.app.enumerations.Perfil;

public class UsuarioResponseDTO implements Serializable {

	private static final long serialVersionUID = 7700278570593873759L;

	@JsonProperty(value = "email")
	private String email;

	@JsonProperty(value = "senha")
	private String senha;

	@JsonProperty(value = "perfil")
	private Perfil perfil;

	@JsonProperty(value = "heroi")
	private HeroiResponseDTO heroiResponseDTO;

	@JsonProperty(value = "ataque")
	private AtaqueResponseDTO ataqueResponseDTO;

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

	public HeroiResponseDTO getHeroiResponseDTO() {
		return heroiResponseDTO;
	}

	public void setHeroiResponseDTO(HeroiResponseDTO heroiResponseDTO) {
		this.heroiResponseDTO = heroiResponseDTO;
	}

	public AtaqueResponseDTO getAtaqueResponseDTO() {
		return ataqueResponseDTO;
	}

	public void setAtaqueResponseDTO(AtaqueResponseDTO ataqueResponseDTO) {
		this.ataqueResponseDTO = ataqueResponseDTO;
	}

}
