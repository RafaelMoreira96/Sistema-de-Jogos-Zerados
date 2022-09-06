package com.funtech.jogoszerados.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.funtech.jogoszerados.domain.Jogo;
import com.funtech.jogoszerados.domain.Player;
import com.funtech.jogoszerados.domain.enums.Status;

public class JogoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	@Column(unique = true)
	@NotNull(message = "O campo JOGO deve ser inserido")
	private String jogo;

	@Column(unique = true)
	@NotNull(message = "O campo PLATAFORMA deve ser inserido")
	private String plataforma;

	@Column(unique = true)
	@NotNull(message = "O campo STATUS deve ser inserido")
	private Status status;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataTermino = LocalDate.now();
	
	private Integer player;

	public JogoDTO() {
		super();
	}

	public JogoDTO(Jogo obj) {
		super();
		this.id = obj.getId();
		this.jogo = obj.getJogo();
		this.plataforma = obj.getPlataforma();
		this.status = obj.getStatus();
		this.dataTermino = obj.getDataTermino();
		this.player = obj.getPlayer().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJogo() {
		return jogo;
	}

	public Integer getPlayer() {
		return player;
	}

	public void setPlayer(Integer player) {
		this.player = player;
	}

	public void setJogo(String jogo) {
		this.jogo = jogo;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}
}
