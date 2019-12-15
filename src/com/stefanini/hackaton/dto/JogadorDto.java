package com.stefanini.hackaton.dto;

import java.io.Serializable;

public class JogadorDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nickname;
	private String senha;
	private Integer idPersonagem;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getIdPersonagem() {
		return idPersonagem;
	}

	public void setIdPersonagem(Integer idPersonagem) {
		this.idPersonagem = idPersonagem;
	}

}
