package com.funtech.jogoszerados.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.funtech.jogoszerados.domain.Player;

public class PlayerDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Integer id;

	@NotNull(message = "O campo NOME deve ser inserido")
	protected String nome;

	@NotNull(message = "O campo EMAIL deve ser inserido")
	protected String email;

	@NotNull(message = "O campo SENHA deve ser inserido")
	protected String senha;
	protected Boolean isActive;

	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCadastro = LocalDate.now();

	public PlayerDTO() {
		super();
	}

	public PlayerDTO(Player obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.isActive = obj.getIsActive();
		this.dataCadastro = obj.getDataCadastro();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
